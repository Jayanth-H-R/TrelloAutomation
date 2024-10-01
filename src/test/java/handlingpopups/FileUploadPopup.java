package handlingpopups;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadPopup {
	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.foundit.in/seeker/registration");
		WebElement uploadResumeButton = driver.findElement(By.className("uploadResume"));
		uploadResumeButton.click();

		// Copy the file path to the system clipboard

		StringSelection stringPath = new StringSelection("file:///C:/Users/JAYANTH/Downloads/Jayanth%20Resume23.pdf");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipBoard = toolkit.getSystemClipboard();
		clipBoard.setContents(stringPath, null);

		// create a instance of Robot class
		Robot robot = new Robot();

		// simulate the key events to handle file upload pop-up
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2500);
		driver.manage().window().minimize();
		driver.quit();

	}
}
