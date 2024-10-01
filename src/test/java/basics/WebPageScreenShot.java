package basics;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebPageScreenShot {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		String dateStamp = LocalDateTime.now().toString().replace(':', '-');
		driver.get("https://www.youtube.com/");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temproryScreenshot = ts.getScreenshotAs(OutputType.FILE);
		String path = temproryScreenshot.getAbsolutePath();
		File permanentSs = new File("./Errorshots" + dateStamp + "/youtube.png");
		FileUtils.copyFile(temproryScreenshot, permanentSs);
		driver.manage().window().minimize();
		driver.quit();

	}

}
