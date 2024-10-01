package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloHomePage {
	WebDriver driver;

// creating one parameterised constructor
	public TrelloHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Get Trello for free']/preceding-sibling::a[text()='Log in']")
	private WebElement loginOption;

	public WebElement getLoginOption() {
		return loginOption;

	}

}
