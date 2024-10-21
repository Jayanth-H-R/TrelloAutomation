package com.trello.qspiders.pomrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloUserCreatedBoardPage {
	WebDriver driver;

	public TrelloUserCreatedBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getExceptionsList() {
		return exceptionsList;
	}

	public WebElement getSeleniumList() {
		return seleniumList;
	}

	public WebElement getJavaList() {
		return javaList;
	}

	@FindBy(css = "button[aria-label='Show menu']")
	private WebElement showMenuOption;

	@FindBy(xpath = "//a[contains(.,'More')]")
	private WebElement moreOption;

	@FindBy(xpath = "//div[text()='Close board']/..")
	private WebElement closeBoardOption;

	@FindBy(css = "input[value='Close']")
	private WebElement closeButton;

	@FindBy(xpath = "//button[text()='Permanently delete board']")
	private WebElement permanentDeleteBoard;

	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deleteButton;

	@FindBy(xpath = "//a[.='Add a list']")
	private WebElement addListOption;

	@FindBy(xpath = "//a[.='Add another list']")
	private WebElement addAnotherListOption;

	@FindBy(css = "input[value='Add list']")
	private WebElement addThisList;

	@FindBy(xpath = "//h2[text()='Exceptions']/../..//span[text()='Add a card']")
	private WebElement exceptionsAddCard;

	@FindBy(className = "board-canvas")
	private WebElement boardBody;

	@FindBy(xpath = "//h2[text()='Exceptions']/..")
	private WebElement exceptionsList;

	@FindBy(xpath = "//h2[text()='Selenium']/..")
	private WebElement seleniumList;

	@FindBy(xpath = "//h2[text()='Java']/..")
	private WebElement javaList;

	@FindBy(xpath = "//a[@data-testid='card-name']")
	private List<WebElement> exceptionsCards;

	@FindBy(xpath = "//a[text()='NoSuchElementException-Selenium']/..")
	private WebElement noSuchElementCard;

	@FindBy(css = "a[aria-label='Close dialog']")
	private WebElement cardCloseDialog;

	@FindBy(xpath = "//a[text()='Add a more detailed description…']")
	private WebElement addDescriptionBox;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButtonDesccription;

	@FindBy(css = "a[title='Labels']")
	private WebElement labelsOption;

	@FindBy(xpath = "//span[@data-color='green']")
	private WebElement labelGreenColorCB;

	@FindBy(xpath = "//button[@data-testid='popover-close']")
	private WebElement labelCloseButton;
	
	@FindBy(xpath = "//button[text()='Try it free']")
	private WebElement jiraPopupEle;
	
	@FindBy(xpath = "//button[@title='Minimize']")
	private WebElement minimizePopupButton;
	

	public WebElement getJiraPopupEle() {
		return jiraPopupEle;
	}

	public WebElement getMinimizePopupButton() {
		return minimizePopupButton;
	}

	public WebElement getCardCloseDialog() {
		return cardCloseDialog;
	}

	public WebElement getLabelCloseButton() {
		return labelCloseButton;
	}

	public WebElement getLabelGreenColorCB() {
		return labelGreenColorCB;
	}

	public WebElement getLabelsOption() {
		return labelsOption;
	}

	public WebElement getAddDescriptionBox() {
		return addDescriptionBox;
	}

	public WebElement getNoSuchElementCard() {
		return noSuchElementCard;
	}

	public List<WebElement> getExceptionsCards() {
		return exceptionsCards;
	}

	public WebElement getBoardBody() {
		return boardBody;
	}

	public WebElement getAddThisList() {
		return addThisList;
	}

	public WebElement getExceptionsAddCard() {
		return exceptionsAddCard;
	}

	public WebElement getAddListOption() {
		return addListOption;
	}

	public WebElement getAddAnotherListOption() {
		return addAnotherListOption;
	}

	public WebElement getShowMenuOption() {
		return showMenuOption;
	}

	public WebElement getMoreOption() {
		return moreOption;
	}

	public WebElement getCloseBoardOption() {
		return closeBoardOption;
	}

	public WebElement getCloseButton() {
		return closeButton;
	}

	public WebElement getPermanentDeleteBoard() {
		return permanentDeleteBoard;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getSaveButtonDesccription() {
		return saveButtonDesccription;
	}

}
