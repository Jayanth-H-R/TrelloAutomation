package handlingpopups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleDivisionPopupInAmazon {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.amazon.com/");
		Thread.sleep(5000);
		// click on dont change button
		driver.findElement(By.xpath("//span[contains(text(),\"Don't Change\")]/preceding-sibling::input")).click();

	}

}
