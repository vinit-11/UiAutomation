package com.maven.UIAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FactoryModelHome {

	WebDriver driver;
	
	FactoryModelHome(WebDriver driver)
	{
		this.driver=driver;
		
	}
	@FindBy(xpath="//*[@id=\"signin_info\"]/a[2]")
	WebElement createacc;
	public WebElement createaccMethod()
	{
		return createacc;
		
	}
	
	@FindBy(xpath="//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")
	WebElement Fullname;
	public WebElement FullnameMethod()
	{
		return Fullname;
		
	}
	
}
