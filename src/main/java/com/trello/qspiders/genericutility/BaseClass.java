
package com.trello.qspiders.genericutility;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.trello.qspiders.pomrepository.TrelloBoardPage;
import com.trello.qspiders.pomrepository.TrelloHomePage;
import com.trello.qspiders.pomrepository.TrelloLoginPage;
import com.trello.qspiders.pomrepository.TrelloLoginToContinueWebPage;
import com.trello.qspiders.pomrepository.TrelloLogoutPage;

public class BaseClass {

	public WebDriver driver;
	public FileUtility fileUtils = new FileUtility();

	public WebDriverUtility webDriverUtils = new WebDriverUtility();

	@BeforeClass
	public void configureBeforeClass() throws IOException,NullPointerException {
		String browserName = fileUtils.toReadData("browser");
		String url = fileUtils.toReadData("url");
		if (browserName.equals("chrome")) {
			
			driver = new ChromeDriver();

		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);

	}

	@AfterClass
	public void configureAfterClass() {
		driver.manage().window().minimize();
		driver.quit();

	}

	@BeforeMethod
	public void configureBeforeMethod() throws IOException, InterruptedException {
		TrelloHomePage homePage = new TrelloHomePage(driver);
		Thread.sleep(5000);
		homePage.getLoginOption().click();
		webDriverUtils.implicitWaitInSeconds(driver);
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		//webDriverUtils.partialTitle(driver, "Log in to continue");
		loginPage.getEmailTextfield().sendKeys(fileUtils.toReadData("username"));
		if(loginPage.getLoginContinueButton().isDisplayed())
		loginPage.getLoginContinueButton().submit();
		TrelloLoginToContinueWebPage loginToCon = new TrelloLoginToContinueWebPage(driver);
		webDriverUtils.partialTitle(driver, "Log in with Atlassian account");
		loginToCon.getPasswordTextfield().sendKeys(fileUtils.toReadData("password"));
		loginToCon.getLoginSubmitButton().submit();
		try {
		if(loginToCon.getContinueWithout2StepVerify().isDisplayed()){
		loginToCon.getContinueWithout2StepVerify().click();}
		}catch(NoSuchElementException e) {
			System.out.println("handled exception");
		}
	}

	@AfterMethod
	public void configureAfterMethod() throws InterruptedException {
		TrelloBoardPage boardPage = new TrelloBoardPage(driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(boardPage.getUserProfileIcon())).click();
		boardPage.getLogoutButton().click();
		TrelloLogoutPage logoutPage = new TrelloLogoutPage(driver);
		logoutPage.getLogoutButton().submit();
	}

}
