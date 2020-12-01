package com.acti.testcase;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class TC02_CreateCustomer extends BaseTest{
	

	@Test
	public void testCreateCustomer(){
		logger=extent.createTest("Validate Create Customer Test");
		loginPage.loginToApplication("admin", "manager");
		logger.log(Status.PASS, "Login Successful");
		enterTimePage.clickTaskMenu();
		logger.log(Status.PASS, "Clicked on Task Menu");
		taskListPage.clickAddNewButton();
		logger.log(Status.PASS, "Clicked on Add New Button");
		taskListPage.clickNewCustomerItem();
		logger.log(Status.PASS, "Selected New Customer Option");
		taskListPage.enterCustomerName("Muthu");
		logger.log(Status.PASS, "Entered Customer Name");
		taskListPage.enterDescription("Muthu is a new customer");
		logger.log(Status.PASS, "Entered Customer Description");
		taskListPage.clickSelectCustomerMenu();
		logger.log(Status.PASS, "Clicked Select Customer Dropdown");
		taskListPage.selectGalaxyCorporationOption();
		logger.log(Status.PASS, "Selected Galaxy Corporation Option");
		taskListPage.clickCreateCustomerButton();
		logger.log(Status.PASS, "Clicked Create Customer Button");
	}
	

}
