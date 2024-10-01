package handlingpopups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPopups {
	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		driver.get("https://pib.gov.in/");
		// print the alert message
		actions.pause(2500).perform();
		String alertString = driver.switchTo().alert().getText();
		System.out.println(alertString);
		// handle the alert popup
		driver.switchTo().alert().accept();
		// identify the Ministry of Defence
		WebElement minOfDefence = driver.findElement(By.linkText("Ministry of Defence"));
		actions.scrollToElement(minOfDefence).pause(3000).click(minOfDefence).build().perform();
		// Capture the confirmation popup message
		String confirmationPopup = driver.switchTo().alert().getText();
		System.out.println(confirmationPopup);
		// Click on Cancel button
//		driver.switchTo().alert().dismiss();
		// click on OK button
		driver.switchTo().alert().accept();
		for (String wid : driver.getWindowHandles()) {
			String windowUrl = driver.switchTo().window(wid).getCurrentUrl();
			if (windowUrl.contains("https://pib.gov.in/")) {

			} else if (windowUrl.contains("https://mod.gov.in/")) {
				driver.close();

			}

		}
		driver.quit();

	}

}
