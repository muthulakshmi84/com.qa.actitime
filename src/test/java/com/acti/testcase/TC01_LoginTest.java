package com.acti.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.acti.base.DriverScript;
import com.acti.pages.LoginPage;

public class TC01_LoginTest extends DriverScript {
	
	@BeforeMethod
	public void preCondition(){
		initBrowser();
		launchApplication();		
	}
	
	@Test
	public void TestLoginFunction() throws Exception{
		LoginPage loginPage = new LoginPage();
		loginPage.loginToApplication("admin", "manager");
		Thread.sleep(3000);
	}
	
	@Test
	public void testVerifyLogo() throws Exception{
		LoginPage loginPage = new LoginPage();
		loginPage.verifyActiLogo();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void postCondition(){
		closeApplication();
	}
}
