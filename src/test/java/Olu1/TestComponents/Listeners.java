package Olu1.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import OluLearn.resources.ExtentReportNG;

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;

	ExtentReports extent = ExtentReportNG.extentReportt();
	
	ThreadLocal<ExtentTest> assignID = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		
	test =	extent.createTest(result.getMethod().getMethodName());
	assignID.set(test);
		

	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		assignID.get().log(Status.PASS, "Test Pass");
		

	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		assignID.get().fail(result.getThrowable());
		
		
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String filepath = null;
		try {
			filepath = takeTheScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assignID.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());

	}
	@Override
	public void onTestSkipped(ITestResult result) {
		

	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}
