package com.maven.UIAutomation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationPageTest {

	
	public static void main(String[] args) {
		//invoke the selenium driver
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		//We are creating object of webdriver
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		RegistrationPage obj1=new RegistrationPage(driver);
		obj1.regstration().sendKeys("Tom");
		obj1.lastnm().sendKeys("Lee");
		obj1.lastnm().clear();
		
		
	}
}
