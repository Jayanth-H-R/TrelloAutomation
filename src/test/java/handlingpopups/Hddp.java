package handlingpopups;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hddp {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		// identify the close button in the popup and click on it.
		WebElement closeButton = driver.findElement(By.xpath("//button[text()='✕']"));
		closeButton.click();

	}
}
