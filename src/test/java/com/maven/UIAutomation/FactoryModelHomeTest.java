package com.maven.UIAutomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;




public class FactoryModelHomeTest {

	ExtentReports ex;
	@BeforeTest
	public void configuration()
	{
		//We create directry to save te report in html format
		String path = System.getProperty("user.dir")+"\\report\\index.html";
		ExtentSparkReporter rep=new ExtentSparkReporter(path);
		
	
		//We configure the html file
		rep.config().setReportName("Web Automation Report");
		rep.config().setDocumentTitle("Test Result");
		
		 ex=new ExtentReports();
		 ex.attachReporter(rep);
		 ex.setSystemInfo("Tester","Vinit");
		 
	}
	@Test
	public void testcase() {
		//invoke the selenium driver
				System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver_win32\\chromedriver.exe");
				
				//We are creating object of webdriver
				WebDriver driver=new ChromeDriver();
				
				//Report generation starts
				ex.createTest("Create acc test case");
				
				
				driver.get("http://www.rediff.com/");
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				WebElement createacc=driver.findElement(By.xpath("//a[contains(text(),'Create a Rediffmail account')]"));
				createacc.click();
				ex.createTest("Send keys test case");
				WebElement Fullname=driver.findElement(By.xpath("//tbody/tr[3]/td[3]/input[1]"));
				Fullname.sendKeys("Tom");
				driver.close();
				ex.flush();
	}
	
	
}
