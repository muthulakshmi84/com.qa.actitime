package com.acti.testcase;

import org.testng.annotations.Test;

public class TC02_CreateCustomer extends BaseTest{
	

	@Test
	public void testCreateCustomer(){
		loginPage.loginToApplication("admin", "manager");
		enterTimePage.clickTaskMenu();
		taskListPage.clickAddNewButton();
		taskListPage.clickNewCustomerItem();
		taskListPage.enterCustomerName("Muthu");
		taskListPage.enterDescription("Muthu is a new customer");
		taskListPage.clickCreateCustomerButton();
	}
	

}
