package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.orangehrm.base.TestBase;

public class LoginPage extends TestBase{

	
	//PageFactory-OR
	@FindBy(id="txtUsername")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginbtn;
	
	@FindBy(xpath="//*[@id=\"divLogo\"]/img")
	WebElement hrmlogo;
	
	//Initialize webelement with the help of p.f
	
	public LoginPage() {
		PageFactory.initElements(driver, this);  //LoginPage.class
	}
	
	//Action
	public String validateLoginPageTitle() {
	
		return driver.getTitle();
	}
	
	public boolean validateHRMLogo() {
		return hrmlogo.isDisplayed();
		
	}
	
	public HomePage login(String un, String pwd) throws Exception {           //return type=HomePage
		
	
		Thread.sleep(500);
		username.sendKeys(un);
		Thread.sleep(500);
		password.sendKeys(pwd);
		Thread.sleep(500);
		loginbtn.click();
		return new HomePage();
		
	}
	
	
}
