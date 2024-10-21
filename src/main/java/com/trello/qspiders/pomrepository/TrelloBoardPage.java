package com.trello.qspiders.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardPage {
	WebDriver driver;

	public TrelloBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Create new board']/../..")
	private WebElement createBoardNewOption;

	@FindBy(css = "input[data-testid='create-board-title-input']")
	private WebElement boardTitleTextfield;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createBoardbutton;

	@FindBy(css = "button[data-testid='header-member-menu-button']")
	private WebElement userProfileIcon;

	@FindBy(xpath = "//button[.='Log out']")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//div[@title='qcsa19']/../..")
	private WebElement userCreatedBoard;

	public WebElement getCreateBoardNewOption() {
		return createBoardNewOption;
	}

	public WebElement getUserCreatedBoard() {
		return userCreatedBoard;
	}

	public WebElement getBoardTitleTextfield() {
		return boardTitleTextfield;
	}

	public WebElement getCreateBoardbutton() {
		return createBoardbutton;
	}

	public WebElement getUserProfileIcon() {
		return userProfileIcon;
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

}
