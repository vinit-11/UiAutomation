package Listener;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListenerOrangeHRM  implements ITestListener {

	WebDriver driver;

	@Override
	public void onTestFailure(ITestResult result) {
	
		Date currentDate = new Date();
		String screenshotfileName = currentDate.toString().replace(" ","-").replace(":","-");
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File("E:\\eclipse\\UIAutomation\\ScreenShot\\"+result.getMethod().getMethodName()+" "+screenshotfileName+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}


}
