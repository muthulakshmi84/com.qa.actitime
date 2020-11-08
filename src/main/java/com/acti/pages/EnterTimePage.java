package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

public class EnterTimePage extends DriverScript{
	
	@FindBy(id="container_tasks") WebElement taskMenu;
	@FindBy(xpath="//a[@id='logoutLink']") WebElement logoutButton;
	public EnterTimePage(){
		PageFactory.initElements(driver, this);
	}
	public void clickTaskMenu(){
		taskMenu.click();
	}
	public void clickLogoutLink(){
		logoutButton.click();
	}

}
