package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverScript {
	
	public static Properties prop;
	public static WebDriver driver;
	public DriverScript(){
		try{
		File file=new File("./src/test/resources/config/config.properties");
		FileInputStream fis=new FileInputStream(file);
		prop=new Properties();
		prop.load(fis);
		}
		catch(Exception e){
			System.out.println("Unable to load file"+e.getMessage());
		}
	}
	
	public static void initBrowser(){
		//the data in config file is stored as key-value pair. If we pass the key to getProperty() method it will return the value
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/browsers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/browsers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else{
			System.out.println("Unsupported browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		
	}
	public static void launchApplication(){
		driver.get(prop.getProperty("qaurl"));
	}
	public static void closeApplication(){
		driver.close();
	}
}

