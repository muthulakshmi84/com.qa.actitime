package com.acti.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;
import com.acti.utils.Generic;

public class TaskListPage extends DriverScript {
	// Create customer elements
	@FindBy(xpath = "//div[@class='title ellipsis']")
	WebElement addNewButton;
	@FindBy(xpath = "//div[@class='item createNewCustomer']")
	WebElement newCustomerItem;
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	WebElement customerNameTextBox;
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	WebElement descriptionTextArea;
	@FindBy(xpath = "//div[@class='emptySelection']")
	WebElement selectCustomerMenu;
	@FindBy(xpath = "//div[@class='searchItemList']//div[normalize-space()='Galaxy Corporation']")
	WebElement galaxyCorporationOption;
	@FindBy(xpath = "//div[text()='Create Customer']")
	WebElement createCustomerButton;

	// Delete customer elements
	@FindBy(xpath = "/html[1]/body[1]/div[18]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/input[1]")
	WebElement searchTextBox;
	// @FindBy(xpath="(//div[@class='icon'])[3]") WebElement searchButton;
	@FindBy(xpath = "//span[@class='highlightToken']")
	WebElement selectCustomerLink;
	@FindBy(xpath = "//div[@class='titleEditButtonContainer']//div[@class='editButton']")
	WebElement customerSettings;
	@FindBy(xpath = "//div[@class='editCustomerPanelHeader']//div[@class='action']")
	WebElement actionsButton;
	@FindBy(xpath = "//div[@class='taskManagement_customerPanel']//div[@class='sendCommentLine']")
	WebElement commentTextBox;
	@FindBy(xpath = "//div[contains(@class,'taskManagement_customerPanel')]//div[contains(@class,'title')][normalize-space()='Delete']")
	WebElement deleteCustomerButton;
	@FindBy(xpath = "//span[text()='Delete permanently']")
	WebElement deletePermanentlyButton;
	@FindBy(xpath = "//div[@class='toastsContainer']")
	WebElement toastContainer;

	// Javascript Executor
	JavascriptExecutor js = (JavascriptExecutor) driver;

	// Create customer methods
	public TaskListPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickAddNewButton() {
		addNewButton.click();
	}

	public void clickNewCustomerItem() {
		newCustomerItem.click();
	}

	public void enterCustomerName(String customerName) {
		customerNameTextBox.sendKeys(customerName);
	}

	public void enterDescription(String description) {
		descriptionTextArea.sendKeys(description);
	}

	public void clickSelectCustomerMenu() {
		selectCustomerMenu.click();
	}

	public void selectGalaxyCorporationOption() {
		galaxyCorporationOption.click();
	}

	public void clickCreateCustomerButton() {
		createCustomerButton.click();
	}

	// Delete customer method
	public void entersearchText(String searchText) {
		searchTextBox.sendKeys(searchText);
		js.executeScript("arguments[0].setAttribute('syle','background:yellow;border:2px solid red;')", searchTextBox);
	}

	public void clickSelectCustomerLink() {
		selectCustomerLink.click();
	}

	public void clickCustomerSettings() {
		customerSettings.click();
	}

	public void ClickActionsButton() {

		Actions action = new Actions(driver);
		action.moveToElement(actionsButton).build().perform();
		Generic.fn_sleep();
		action.click(actionsButton).build().perform();
		Generic.fn_sleep();

		/*
		 * commentTextBox.sendKeys("Writing test comment");
		 * actionsButton.click();
		 */
	}

	public void ClickDeleteCustomerButton() {
		deleteCustomerButton.click();
		deletePermanentlyButton.click();
		Generic.fn_sleep();
		System.out.println("Toast container displayed: "+toastContainer.isDisplayed());
		System.out.println("Toast container text: "+toastContainer.getText());
	}

}
