package com.acti.testcase;

import org.testng.annotations.Test;

public class TC03_DeleteCustomer extends BaseTest{

	@Test
	public void testDeleteCustomer(){
		loginPage.loginToApplication("admin", "manager");
		enterTimePage.clickTaskMenu();
		taskListPage.entersearchText("Muthu");
		taskListPage.clickSelectCustomerLink();
		taskListPage.clickCustomerSettings();
		taskListPage.ClickActionsButton();
		taskListPage.ClickDeleteCustomerButton();
	}
}
