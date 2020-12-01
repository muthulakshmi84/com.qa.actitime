package com.acti.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.acti.base.DriverScript;
import com.acti.pages.EnterTimePage;
import com.acti.pages.LoginPage;
import com.acti.pages.TaskListPage;
import com.acti.utils.Generic;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BaseTest extends DriverScript{
	
	LoginPage loginPage;
	EnterTimePage enterTimePage;
	TaskListPage taskListPage;
	
	ExtentHtmlReporter htmlReport;
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeClass
	public void preTest(){
	htmlReport=new ExtentHtmlReporter("./report/AutomationActiReport.html");
	extent=new ExtentReports();
	extent.attachReporter(htmlReport);
	}
	
	
	@BeforeMethod
	public void preCondition(){
		initBrowser();
		launchApplication();	
		loginPage = new LoginPage();
		enterTimePage=new EnterTimePage();
		taskListPage=new TaskListPage();
	}
	
	@AfterMethod
	public void postCondition(ITestResult result){
		if(result.getStatus()==ITestResult.FAILURE){
			Generic.makeScreenshot(driver);
		}
		closeApplication();
	}
	
	@AfterClass
	public void tearDown(){
		extent.flush();
	}
	
	
}
