package handlingpopups;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumDownLoad {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.selenium.dev/downloads/");
		driver.findElement(By.linkText("4.9.0")).click();
		// file down load popup as arrived
		// go downloads page of the chrome browser
		Thread.sleep(5000);
		driver.get("chrome://downloads/");
		// identify the shadow host element
		WebElement shadowHost = driver.findElement(By.tagName("downloads-manager"));
		SearchContext shadowRoot = shadowHost.getShadowRoot();
		Thread.sleep(5000);
		WebElement shadowHost2 = shadowRoot.findElement(By.cssSelector("downloads-item[id='frb0']"));
		SearchContext shadowRoot2 = shadowHost2.getShadowRoot();
		WebElement keepButton = shadowRoot2.findElement(By.cssSelector("cr-button[focus-type='save']"));
		keepButton.click();
		Thread.sleep(5000);
		Robot robot = new Robot();
		// Press and hold the tab button
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(200);
		// release the tab button
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(200);
		// press the enter button
		robot.keyPress(KeyEvent.VK_ENTER);
		// release the enter button
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(200);
        driver.navigate().back();
	}
}
