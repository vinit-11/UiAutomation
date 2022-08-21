package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.orangehrm.base.TestBase;

public class MyInfoPage extends TestBase {

	
	@FindBy(xpath="//h1[contains(text(),'Personal Details')]")
	WebElement perDtail;
	
	@FindBy(css="#btnSave")
	WebElement editbtn;
	
	@FindBy(xpath="//input[@id='personal_txtEmpFirstName']")
	WebElement fName;
	
	@FindBy(xpath="//input[@id='personal_txtEmpLastName']")
	WebElement lName;
	
	@FindBy(xpath="//input[@id='personal_DOB']")
	WebElement dobpicker;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	WebElement dobmonth;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	WebElement dobyear;
	
	@FindBy(xpath="//a[contains(@class,'ui-state-default')]")
	List<WebElement> dobday;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement savebtn;
	
	@FindBy(xpath="//input[@id='personal_optGender_2']")
	WebElement genderbtn;

	@FindBy(xpath="//input[@id='personal_txtEmployeeId']")
	WebElement empidbtn;
	
	@FindBy(xpath="//select[@id='personal_cmbMarital']")
	WebElement marystatus;
	
	@FindBy(xpath="//input[@id='btnEditCustom']")
	WebElement customeeditbtn;
	
	@FindBy(xpath="//select[@name='custom1']")
	WebElement customefield;
	
	@FindBy(xpath="//select[@id='personal_cmbNation']")
	WebElement nationality;
	
	@FindBy(css="#btnEditCustom")
	WebElement customsave;
	
	//Initializing the page object 
	public  MyInfoPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyPersonalDetailTitle() {
		return perDtail.isDisplayed();
		
	}
	
	public void clkEditPersonalDetail(String fNM,String lNM,String Emp) throws Exception {
		
		editbtn.click();
		Thread.sleep(500);
		fName.clear();
		Thread.sleep(500);
		fName.sendKeys(fNM);
		Thread.sleep(500);;
		lName.clear();
		Thread.sleep(500);
		lName.sendKeys(lNM);
		Thread.sleep(500);
		genderbtn.click();
		Thread.sleep(500);
		empidbtn.clear();
		empidbtn.sendKeys(Emp);
		Thread.sleep(1000);
		Select sel=new Select(nationality);
		sel.selectByValue("11");
		
		savebtn.click();
		
	}
	
	public void selectDOB() throws Exception{
		
		editbtn.click();
		
		marystatus.click();
		
		Select sel=new Select(marystatus);
		sel.selectByValue("Single");
		
		dobpicker.click();
	
		Select sel1=new Select(dobmonth);
		sel1.selectByValue("5");
		
		Select sel2=new Select(dobyear);
		sel2.selectByValue("2000");
		
		
		for(int i=0; i<dobday.size();i++) {
		String s=dobday.get(i).getText();
		if(s.equalsIgnoreCase("12")) {
			dobday.get(i).click();
			break;
		}
	}
		savebtn.click();
	}
	
	public void customField(){
		customeeditbtn.click();
		customefield.click();
		Select pic=new Select(customefield);
		pic.selectByValue("AB+");
		customsave.click();
	}
		
	public void clickSaveButton() {
		
	}
	
}
