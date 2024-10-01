package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginToContinueWebPage {
	WebDriver driver;

	public TrelloLoginToContinueWebPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "password")
	private WebElement passwordTextfield;

	@FindBy(id = "login-submit")
	private WebElement loginSubmitButton;
	
	@FindBy(xpath = "//button[contains(.,'Continue without two-step verification')]")
	private WebElement continueWithout2StepVerify;

	public WebElement getContinueWithout2StepVerify() {
		return continueWithout2StepVerify;
	}

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getLoginSubmitButton() {
		return loginSubmitButton;
	}

}
