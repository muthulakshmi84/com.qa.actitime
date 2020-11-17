package com.acti.testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.acti.utils.ExcelLib;
import com.acti.utils.Generic;

public class TC01_LoginTest extends BaseTest {
	
	@Test
	public void TestLoginFunction(){
		loginPage.loginToApplication("admin", "manager");
		Generic.fn_sleep();
	}
	
	@Test
	public void testVerifyLogo(){
		loginPage.verifyActiLogo();
		Generic.fn_sleep();
	}
	
	@Test(dataProvider="actiData")
	public void testLoginWithMultipleUsers(String username, String password){
		loginPage.loginToApplication("admin", "manager");
		Generic.fn_sleep();
	}
	
	@DataProvider(name="actiData")
	public Object[][] testData(){
		ExcelLib xl=new ExcelLib();
		int row=xl.getRowCount(0);
		Object[][] data=new Object[row][2];
		for(int i=0; i<row; i++){
			data[i][0]=xl.getData(0, i, 0);
			data[i][1]=xl.getData(0, i, 1);
		}
		return data;		
	}
	

}
