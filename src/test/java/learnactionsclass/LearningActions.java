package learnactionsclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.trello.qspiders.genericutility.BaseClass;

public class LearningActions extends BaseClass{
	WebDriver driver;
	
	@Test
	public void scrollElementToViewPortArea() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		WebElement careersOption = driver.findElement(By.linkText("Careers"));
		//create an Actions Class Object.
		Actions actions = new Actions(driver);
		actions.scrollToElement(careersOption).perform();
		driver.manage().window().minimize();
		driver.quit();
	}
	
	@Test
	public void rightClick() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
		//create an Actions Class Object.
		Actions actions = new Actions(driver);
		actions.contextClick().pause(2000).release().perform();
		driver.manage().window().minimize();
		driver.quit();
	
	}
	

}
