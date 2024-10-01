
package basics;

import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class GetWindowHandles {
	public static void main(String[] args) throws InterruptedException,Throwable {
		//instantiate the browser specific class 
		WebDriver driver= new EdgeDriver();
		//maximize the browser window
		driver.manage().window().maximize();
		//pass the main url of the application
		driver.get("https://www.youtube.com/");
		//Launch the new window with current driver reference
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.facebook.com/");
		//capture all windows id
		Thread.sleep(5000);
		Set<String> allWindowsId = driver.getWindowHandles();
		System.out.println(allWindowsId);
		
		for(String wid:allWindowsId)
		{
			 String windowTitle=driver.switchTo().window(wid).getTitle();
			 if(windowTitle.contains("Facebook - log in or sign up"))
			 {
				driver.close(); 
			 }
			 else if(windowTitle.contains("YouTube"))
			 {
				Dimension youtubeTargetSize = new Dimension(500,500);
				driver.manage().window().setSize(youtubeTargetSize);
				driver.close();
			 }
			 
			
		}
		
	}

}
