package learntestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MethodsAnnotation {
	WebDriver driver;

	@Test
	public void testCase() {
		System.out.println("Test Case Executed");
	}

	@BeforeMethod
	@Parameters({ "username", "password" })
	public void loginActitime(String username, String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// enter user name
		WebElement userNameTextField = driver.findElement(By.id("username"));
		userNameTextField.sendKeys(username);
		// enter the password
		WebElement passwordTextField = driver.findElement(By.name("pwd"));
		passwordTextField.sendKeys(password);
		// click on login
		WebElement loginButton = driver.findElement(By.id("loginButton"));
		loginButton.click();

	}

	@AfterMethod
	public void logoutActitime() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("logoutLink")).click();
		driver.manage().window().minimize();
		driver.quit();

	}
@BeforeClass
@Parameters({"browserName","mainUrl"})
	public void launchBrowser(String browserName, String mainUrl) {
	if (browserName.equals("chrome")) {
		driver=new ChromeDriver();	
	}else if (browserName.equals("edge")) {
		driver=new EdgeDriver();
		
	}else if (browserName.equals("firefox")) {
      driver=new FirefoxDriver();		
	}
	driver.manage().window().maximize();
	driver.get(mainUrl);
		
	}

}
