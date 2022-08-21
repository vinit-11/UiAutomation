package com.maven.UIAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	By createAcc=By.xpath("//*[@id=\"signin_info\"]/a[2]");
	public WebElement createAcc()
	{
		return driver.findElement(createAcc);
		
	}
	
	
	
	
	
	/*@FindBy(xpath="//*[@id=\"signin_info\"]/a[2]")
	WebElement createacc;
	public WebElement createaccMethod()
	{
		return createacc;
		
	}*/
}
