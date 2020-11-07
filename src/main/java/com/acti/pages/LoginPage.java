package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

public class LoginPage extends DriverScript{
	
//***************************************************Page Elements***************************************************************//
	@FindBy(id="username") WebElement usernameTB;
	@FindBy(name="pwd") WebElement passwordTB;
	@FindBy(id="loginButton") WebElement loginButton;
	@FindBy(className="atLogoImg") WebElement actitimeLogo;

//***************************************************Page Initialization***************************************************************//	

	//Page Factory is a class used to initialize current class elements
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

//***************************************************Actions***************************************************************//	
	
	public void loginToApplication(String username, String password){
		usernameTB.sendKeys(username);
		passwordTB.sendKeys(password);
		loginButton.click();
	}
	
	public void verifyActiLogo(){
		System.out.println(actitimeLogo.isDisplayed());
	}
	
	public String verifyPageTitle(){
		return driver.getTitle();
	}
}
