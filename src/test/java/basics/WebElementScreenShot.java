package basics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementScreenShot {

	public static void main(String[] args) throws IOException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		WebElement element = driver.findElement(By.id("Form_submitForm_EmailHomePage"));
		File tempSs = element.getScreenshotAs(OutputType.FILE);
		String path = tempSs.getAbsolutePath();
		File PermSs = new File("./Errorshots"+"/OrangeHRM.png");
		FileUtils.copyFile(tempSs, PermSs);
		driver.manage().window().minimize();
		driver.quit();
		
		
	}
}
