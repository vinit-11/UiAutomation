package com.orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.TestBase;

public class HomePage extends TestBase {
	
	
	
	@FindBy(xpath="//b[contains(text(),'My Info')]")
	WebElement myinfo;
	
	
	
	@FindBy(xpath="//*[@id=\"menu_recruitment_viewRecruitmentModule\"]/b")
	WebElement recrutement;
	
	
	//Initializing the page object 
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyMyInfoTitle() {
		return driver.getTitle();
	}
	

	public MyInfoPage clickMyInfo() throws Exception {
		Thread.sleep(500);
		myinfo.click();
		return new MyInfoPage();
	}
	
	
}
