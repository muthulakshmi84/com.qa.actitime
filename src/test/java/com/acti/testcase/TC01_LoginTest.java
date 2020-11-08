package com.acti.testcase;

import org.testng.annotations.Test;

public class TC01_LoginTest extends BaseTest {
	
	@Test
	public void TestLoginFunction() throws Exception{
		loginPage.loginToApplication("admin", "manager");
		Thread.sleep(3000);
	}
	
	@Test
	public void testVerifyLogo() throws Exception{
		loginPage.verifyActiLogo();
		Thread.sleep(3000);
	}
	

}
