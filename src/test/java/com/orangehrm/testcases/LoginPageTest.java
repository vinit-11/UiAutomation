package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.TestBase;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage  homepage;
	
	public LoginPageTest() {
		
		super ();                                       //call super class constructor
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();                              //calling initialization method from base class
		
		// create object of LoginPage class
		
		loginpage=new LoginPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title= loginpage.validateLoginPageTitle();
		System.out.println("Title of page is :-" +title);
		Assert.assertEquals(title, "OrangeHRM");
		
	}


	@Test(priority=2)
	public void hrmLogoImageTest() {
		boolean flag= loginpage.validateHRMLogo();
	
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws Exception {
		Thread.sleep(2000);
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
		
	@AfterMethod
	public void tearDown() {
		
	driver.quit();
	}
	
	
	
	
}
