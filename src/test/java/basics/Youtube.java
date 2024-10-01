package basics;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Youtube {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.flipkart.com/");
		Set<String> wid = driver.getWindowHandles();

		for (String id : wid) {
			String title = driver.switchTo().window(id).getCurrentUrl();
			System.out.println(title);
			if (title.contains("flipkart")) {
				System.out.println("flikart window minimize complete");
				driver.manage().window().minimize();

			} else if (title.contains("youtube")) {
				Actions actions = new Actions(driver);
				Action activity = actions.moveByOffset(0, 300).pause(2500).build();
				Thread.sleep(2000);
				activity.perform();
				driver.manage().window().minimize();
				System.out.println("youtube window closed");
				driver.close();

			}
		}
		Thread.sleep(3000);
		driver.quit();
		System.out.println("All  window closed");
	}
}
