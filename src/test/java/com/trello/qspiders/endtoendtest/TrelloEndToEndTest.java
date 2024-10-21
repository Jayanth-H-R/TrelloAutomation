package com.trello.qspiders.endtoendtest;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.trello.qspiders.genericutility.BaseClass;
import com.trello.qspiders.pomrepository.TrelloBoardPage;
import com.trello.qspiders.pomrepository.TrelloHomePage;
import com.trello.qspiders.pomrepository.TrelloLoginPage;
import com.trello.qspiders.pomrepository.TrelloUserCreatedBoardPage;

public class TrelloEndToEndTest extends BaseClass {
	@Test(priority = 1)
	public void loginToTrello() {

	}
	
	
	@Test(priority = 2)
	public void createAndDeleteBoard() throws IOException, InterruptedException {
		TrelloHomePage homePage = new TrelloHomePage(driver);
		Actions actions = new Actions(driver);
		webDriverUtils.implicitWaitInSeconds(driver);
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		TrelloBoardPage boardPage = new TrelloBoardPage(driver);
		boardPage.getCreateBoardNewOption().click();
		boardPage.getBoardTitleTextfield().sendKeys(fileUtils.toReadData("boardtitle"));
		actions.moveToElement(boardPage.getCreateBoardbutton()).pause(1000)
				.clickAndHold(boardPage.getCreateBoardbutton()).build().perform();
		boardPage.getCreateBoardbutton().click();
		Assert.assertEquals(true, webDriverUtils.partialUrl(driver, "qcsa19"));
		TrelloUserCreatedBoardPage userCreatedBoardPage = new TrelloUserCreatedBoardPage(driver);
		if(userCreatedBoardPage.getJiraPopupEle().isDisplayed()) {
			userCreatedBoardPage.getMinimizePopupButton().click();
		}
		webDriverUtils.elementToBeClickable(driver, userCreatedBoardPage.getShowMenuOption());
		userCreatedBoardPage.getShowMenuOption().click();
		//userCreatedBoardPage.getMoreOption().click();
		Thread.sleep(5000);
		actions.scrollToElement(userCreatedBoardPage.getCloseBoardOption()).pause(3000).click().build().perform();
		userCreatedBoardPage.getCloseButton().click();
		actions.scrollToElement(userCreatedBoardPage.getPermanentDeleteBoard()).pause(3000).click().build().perform();
		userCreatedBoardPage.getDeleteButton().click();
		System.out.println("Board Successfully Deleted");
	}

	@Test(priority = 3)
	public void addListsToBoard() throws IOException, InterruptedException {
		webDriverUtils.implicitWaitInMillis(driver);
		Actions actions = new Actions(driver);
		TrelloBoardPage boardPage = new TrelloBoardPage(driver);
		// actions.pause(8000).perform();
		Thread.sleep(6000);
		boardPage.getUserCreatedBoard().click();
		actions.pause(2000).perform();
		TrelloUserCreatedBoardPage userCreatedBoardsPage = new TrelloUserCreatedBoardPage(driver);
		actions.click(userCreatedBoardsPage.getAddListOption()).pause(2000).sendKeys(fileUtils.toReadData("list1"))
				.pause(2000).build().perform();
		actions.click(userCreatedBoardsPage.getAddThisList()).pause(2000).perform();
		actions.pause(2000).perform();
		actions.sendKeys(fileUtils.toReadData("list2")).pause(2000).build().perform();
		actions.click(userCreatedBoardsPage.getAddThisList()).pause(2000).perform();
		actions.pause(2000).perform();
		actions.sendKeys(fileUtils.toReadData("list3")).pause(2000).build().perform();
		actions.click(userCreatedBoardsPage.getAddThisList()).pause(2000).perform();
		actions.click(userCreatedBoardsPage.getExceptionsAddCard()).pause(1000).sendKeys(fileUtils.toReadData("card1"))
				.sendKeys(Keys.ENTER).build().perform();
		actions.sendKeys(fileUtils.toReadData("card2")).pause(1500).sendKeys(Keys.ENTER).build().perform();
		actions.sendKeys(fileUtils.toReadData("card3")).pause(1500).sendKeys(Keys.ENTER).build().perform();
		actions.sendKeys(fileUtils.toReadData("card4")).pause(1500).sendKeys(Keys.ENTER).build().perform();
		actions.sendKeys(fileUtils.toReadData("card5")).pause(1500).sendKeys(Keys.ENTER).build().perform();
		actions.sendKeys(fileUtils.toReadData("card6")).pause(1500).sendKeys(Keys.ENTER).build().perform();
		actions.sendKeys(fileUtils.toReadData("card7")).pause(1500).sendKeys(Keys.ENTER).build().perform();
		actions.sendKeys(fileUtils.toReadData("card8")).pause(1500).sendKeys(Keys.ENTER).build().perform();

	}

	@Test(priority = 4)
	public void differentiateTheCards() throws InterruptedException {
		webDriverUtils.implicitWaitInMillis(driver);
		Actions actions = new Actions(driver);
		TrelloBoardPage boardPage = new TrelloBoardPage(driver);
		Thread.sleep(10000);
		boardPage.getUserCreatedBoard().click();
		TrelloUserCreatedBoardPage userCreatedBoardPage = new TrelloUserCreatedBoardPage(driver);
		Thread.sleep(5000);
		// if(userCreatedBoardPage.getExceptionsList().isDisplayed())
		actions.moveToElement(userCreatedBoardPage.getExceptionsList()).pause(2000).perform();
		List<WebElement> cards = userCreatedBoardPage.getExceptionsCards();

		for (WebElement e : cards) {
			String st = e.getAttribute("href");
			System.out.println(st);
			if (st.contains("selenium")) {
				actions.dragAndDrop(e, userCreatedBoardPage.getSeleniumList()).pause(1500).build().perform();
			} else if (st.contains("java")) {
				actions.dragAndDrop(e, userCreatedBoardPage.getJavaList()).pause(1500).build().perform();
			}
		}

	}

	@Test(priority = 5)
	public void moveCardToLast() throws InterruptedException {
		webDriverUtils.implicitWaitInSeconds(driver);
		Actions actions = new Actions(driver);
		TrelloBoardPage boardPage = new TrelloBoardPage(driver);
		boardPage.getUserCreatedBoard().click();
		TrelloUserCreatedBoardPage userCreatedBoardPage = new TrelloUserCreatedBoardPage(driver);
		Thread.sleep(3000);
		actions.moveToElement(userCreatedBoardPage.getJavaList()).pause(1500).moveByOffset(0, 45).clickAndHold()
				.moveByOffset(0, 122).pause(2000).release().build().perform();
		Thread.sleep(3000);
	}

	@Test(priority = 6)
	public void addDescription() throws IOException {
		webDriverUtils.implicitWaitInSeconds(driver);
		Actions actions = new Actions(driver);
		TrelloBoardPage boardPage = new TrelloBoardPage(driver);
		boardPage.getUserCreatedBoard().click();
		TrelloUserCreatedBoardPage userCreatedBoardPage = new TrelloUserCreatedBoardPage(driver);
		userCreatedBoardPage.getNoSuchElementCard().click();
		actions.click(userCreatedBoardPage.getAddDescriptionBox()).pause(2000)
				.sendKeys(fileUtils.toReadData("nosuchelementdescription")).build().perform();
		actions.pause(3000).perform();
		userCreatedBoardPage.getSaveButtonDesccription().click();
		actions.pause(3000).perform();
		userCreatedBoardPage.getCardCloseDialog().click();
	}
	
	@Test(priority = 7)
	public void addLabels() throws InterruptedException {
		webDriverUtils.implicitWaitInSeconds(driver);
		Actions actions=new Actions(driver);
		TrelloBoardPage boardPage = new TrelloBoardPage(driver);
		boardPage.getUserCreatedBoard().click();
		TrelloUserCreatedBoardPage userCreatedBoardPage=new TrelloUserCreatedBoardPage(driver);
		userCreatedBoardPage.getNoSuchElementCard().click();
		Thread.sleep(2500);
		userCreatedBoardPage.getLabelsOption().click();
		Thread.sleep(2000);
		userCreatedBoardPage.getLabelGreenColorCB().click();
		Thread.sleep(2000);
		userCreatedBoardPage.getLabelCloseButton().click();
		Thread.sleep(2000);
		userCreatedBoardPage.getCardCloseDialog().click();
		System.out.println("Green color has been successfully selected");
		
		
		
	}

}
