package handlingpopups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPopup {
	/*
	 * 𝐓𝐞𝐬𝐭 𝐒𝐜𝐞𝐧𝐚𝐫𝐢𝐨: Develop an automation script that bypasses the
	 * Basic Browser Authentication Popup. Link: https://lnkd.in/dB3ZAGi7
	 * 
	 * 𝐔𝐬𝐞𝐫𝐧𝐚𝐦𝐞: admin 𝐏𝐚𝐬𝐬𝐰𝐨𝐫𝐝: admin
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(8));
		// appending user credentials through Main URL["https://username:password@URL"]
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		WebElement signinMsg = driver.findElement(By.xpath("//p[contains(.,'Congratulations! You must have the proper credentials.')]"));
		waits.until(ExpectedConditions.visibilityOf(signinMsg));
		driver.manage().window().minimize();
		driver.quit();

	}
}
