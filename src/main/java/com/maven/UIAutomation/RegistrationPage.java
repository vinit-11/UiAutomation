package com.maven.UIAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {


	WebDriver driver;

	public RegistrationPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	By regstration=By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input");

	public WebElement regstration()
	{
		return driver.findElement(regstration);

	}

	By lastnm=By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]");

	public WebElement lastnm()
	{
		return driver.findElement(lastnm);

	}










}
