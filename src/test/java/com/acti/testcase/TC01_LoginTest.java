package com.acti.testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.acti.utils.ExcelLib;
import com.acti.utils.Generic;
import com.aventstack.extentreports.Status;

public class TC01_LoginTest extends BaseTest {
	
	
	@Test
	public void TestLoginFunction(){
		logger=extent.createTest("Validate login Functionality");
		loginPage.loginToApplication("admin", "manager");
		Generic.fn_sleep();
		logger.log(Status.PASS, "Verified login functionality");
	}
	
	@Test
	public void testVerifyLogo(){
		logger=extent.createTest("Validate logo");
		loginPage.verifyActiLogo();
		Generic.fn_sleep();
		logger.log(Status.PASS, "Verified presence of logo");
	}
	
	@Test(dataProvider="actiData")
	public void testLoginWithMultipleUsers(String username, String password){
		logger=extent.createTest("Validate login Functionality with multiple users");
		loginPage.loginToApplication("admin", "manager");
		Generic.fn_sleep();
		logger.log(Status.PASS, "Verified login functionality with multiple users");
	}
	
	@DataProvider(name="actiData")
	public Object[][] testData(){
		ExcelLib xl=new ExcelLib();
		int row=xl.getRowCount(0);
		Object[][] data=new Object[row][2];
		for(int i=0; i<row; i++){
			data[i][0]=xl.getData(0, i, 0);
			data[i][1]=xl.getData(0, i, 1);
			System.out.println("Count: "+i);
		}
		return data;		
	}
	

}
