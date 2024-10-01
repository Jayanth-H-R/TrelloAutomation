package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginPage {
	WebDriver driver;

	public TrelloLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='username']")
	private WebElement emailTextfield;

	@FindBy(xpath = "//button[@id='login-submit']")
	private WebElement loginContinueButton;

	public WebElement getEmailTextfield() {
		return emailTextfield;
	}

	public WebElement getLoginContinueButton() {
		return loginContinueButton;
	}

}
