package com.orangehrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;			//static


	public TestBase() // constructor of class
	{
		try 
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("E:\\eclipse\\UIAutomation\\src\\main\\java\\com\\orangehrm\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}


	public  static void initialization() {				//static
		
		String BrowserName= prop.getProperty("browser");
		if(BrowserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();


			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get(prop.getProperty("url"));
		}
	}
}