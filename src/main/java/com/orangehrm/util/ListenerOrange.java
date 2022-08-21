package com.orangehrm.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.orangehrm.base.TestBase;

public class ListenerOrange extends TestBase implements ITestListener {

	
	
	@Override
	public void onTestStart(ITestResult result) {
	
		System.out.println("Test start successfully");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		
		System.out.println("Test run successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		Date currentDate = new Date();
		String screenshotfileName = currentDate.toString().replace(" ","-").replace(":","-");
		
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File("E:\\eclipse\\UIAutomation\\ScreenShot\\"+result.getMethod().getMethodName()+" "+screenshotfileName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test started sucessfully");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test finished successfully");
	
	}
	
	

}
