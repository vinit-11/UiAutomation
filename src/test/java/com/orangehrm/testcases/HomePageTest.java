package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.orangehrm.base.TestBase;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.MyInfoPage;
import com.orangehrm.util.TestUtil;

public class HomePageTest extends TestBase{

	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	MyInfoPage myinfopage;
	
	public HomePageTest() {
		super();
		
	}
	
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();					 //Initialization driver and launch url
		testutil=new TestUtil();
		myinfopage=new MyInfoPage();
		 //login to app 
		loginpage=new LoginPage();        
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	
	public void verifyTitleTest() {
		String titleinfo=homepage.verifyMyInfoTitle();
		Assert.assertEquals(titleinfo, "OrangeHRM","Title is incorrect");
	}
	
	@Test(priority=2)
	public void clickMyInfoTest() throws Exception  {
		Thread.sleep(500);
		//testutil.switchtoframe();
		myinfopage =homepage.clickMyInfo();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
