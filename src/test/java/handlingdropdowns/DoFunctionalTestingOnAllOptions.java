package handlingdropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class DoFunctionalTestingOnAllOptions {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/signup");
		List<WebElement> allDropdowns = driver.findElements(By.tagName("select"));
		for (WebElement dropdown : allDropdowns) {
			if (dropdown.isDisplayed()) {
				Select dropdownSelect = new Select(dropdown);
				List<WebElement> allOptions = dropdownSelect.getOptions();
				for (WebElement option : allOptions) {
					String visibleText = option.getText();
					dropdownSelect.selectByVisibleText(visibleText);
					if (option.isSelected()) {
						System.out.println(visibleText + " is Selected");
					} else {
						System.out.println(visibleText + " is not Selected.");
					}

				}

			}
		}
		driver.manage().window().minimize();
		driver.quit();
	}

}
