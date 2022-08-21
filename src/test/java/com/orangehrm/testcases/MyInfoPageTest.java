package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.base.TestBase;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.MyInfoPage;
import com.orangehrm.util.TestUtil;

	public class MyInfoPageTest extends TestBase{

		HomePage homepage;
		LoginPage loginpage;
		TestUtil testutil;
		MyInfoPage myinfopage;
		String sheetName ="PersonalDetail";
		
		public MyInfoPageTest() {
			super();
			
		}
		
		
		@BeforeMethod
		public void setUp() throws Exception {
			//Initialization driver and launch url
			
			initialization();					 
			testutil=new TestUtil();
			myinfopage=new MyInfoPage();
			
			//login to app 
			loginpage=new LoginPage();        
			homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			myinfopage=homepage.clickMyInfo();			//return myinfopage object
		}
		
		@Test(priority=1)
		public void validatePersonalInfoTitle() {
		Assert.assertTrue(myinfopage.verifyPersonalDetailTitle(), "Contact lable is missing on page");
	
		}
	
		
		@DataProvider
		public Object[][] getTestDataEXCEL()  {
			
			Object data[][]=TestUtil.getTestData(sheetName);
			
			return data;
		}
		
		@Test(priority=2,dataProvider="getTestDataEXCEL")
		public void clikonEditBtnTest(String Fname,String Lname,String Empid) throws Exception {
			homepage.clickMyInfo();
			Thread.sleep(500);
			//myinfopage.clkEditPersonalDetail("King", "John");
			myinfopage.clkEditPersonalDetail(Fname, Lname,Empid);
		}
		
		
		
		@Test(priority=3)
		public void datepic() throws Exception {
			homepage.clickMyInfo();
			myinfopage.selectDOB();
		}
		
		@Test(priority=4)
		public void customFieldValidate() throws Exception{
			homepage.clickMyInfo();
			myinfopage.customField();
		}
		
		
		
		
		
		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
		
		
		
		
		
}
