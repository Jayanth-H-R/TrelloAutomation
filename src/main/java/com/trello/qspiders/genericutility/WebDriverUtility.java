package com.trello.qspiders.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void implicitWaitInSeconds(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void implicitWaitInMillis(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

	}

	public boolean verifyCompleteTitleIs(WebDriver driver, String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean validation = wait.until(ExpectedConditions.titleIs(expectedTitle));
		return validation;

	}

	public boolean verifyCompleteUrl(WebDriver driver, String expectedUrl) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean validation = wait.until(ExpectedConditions.urlToBe(expectedUrl));
		return validation;
	}
	public boolean partialUrl(WebDriver driver,String partialUrl) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean validation = wait.until(ExpectedConditions.urlContains(partialUrl));
		return validation;
	}
	
	public WebDriver controlTransferToWindow(WebDriver driver,String windowId) {
		WebDriver updatedDriver = driver.switchTo().window(windowId);
		return updatedDriver;
		
	}
	
	public WebElement elementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement	ele=wait.until(ExpectedConditions.elementToBeClickable(element));
		return ele;
	}
	
	public boolean partialTitle(WebDriver driver,String partialTitle) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean validation = wait.until(ExpectedConditions.titleContains(partialTitle));
		return validation;
		
	}

	
	
}
