package handletables;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleDynamicTable {
 public static void main(String[] args) {
	  ChromeOptions option = new ChromeOptions();
	  option.addArguments("-disable--notifications");
	  WebDriver driver=new ChromeDriver(option);
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	 driver.get("https://practice.expandtesting.com/dynamic-table");
	 List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
	 
	 for (int i = 1; i <= rows.size(); i++) {
		WebElement nameValue = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]//td[1]"));
		String value = nameValue.getText();
		if(value.equalsIgnoreCase("chrome")) {
			String cpuLoad = driver.findElement(By.xpath("//td[text()='Chrome']//following-sibling::*[contains(text(),'%')]")).getText();
			String chromeLoad = driver.findElement(By.id("chrome-cpu")).getText();
			if(chromeLoad.equals(cpuLoad)) {
				System.out.println("chrome cpu load is matching.");
			}else
				System.out.println("chrome cpu load is not matching.");
			break;
		}
	
		
	}
	 
	 driver.manage().window().minimize();
	 driver.quit();
	
}
}
