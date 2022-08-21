package com.orangehrm.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.orangehrm.base.TestBase;

public class ExtentsReportListener extends TestBase implements ITestListener {
	
	public static ExtentReports ex;
	public  ExtentTest test;
	
	
	public  ExtentsReportListener() {

	//We create directory to save the report in html format
			String path = System.getProperty("user.dir")+"\\report\\index.html";
			ExtentSparkReporter rep=new ExtentSparkReporter(path);
			
		
	//We configure the html file
			rep.config().setReportName("Web Automation Report");
			rep.config().setDocumentTitle("Test Result");
			
			 ex=new ExtentReports();
			 ex.attachReporter(rep);
			 ex.setSystemInfo("Tester","Vinit");

}
	
	public void onTestStart(ITestResult result) {
	    test=ex.createTest(result.getMethod().getMethodName());
	  }
	
	public void onFinish(ITestContext context) {
	
	  ex.flush();
	  }
	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test is Pass");
		
		
	}
	public void onTestFailure(ITestResult result) {
	    test.log(Status.FAIL, "Test is Fail");
	 
	  //test.fail(result.getThrowable());
	 //test.addScreenCaptureFromPath("path");
	   
	}

}
