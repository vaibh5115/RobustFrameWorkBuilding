package FrameworkBuilding.E2E_Project;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources1.ExtentReportsConfig;
import resources1.base;

public class Listeners extends base implements ITestListener //listener class will implement all methods of ItestListener interface.
{
	ExtentReports extent=ExtentReportsConfig.getExtentReportObj();// don't want to create object because getExtentReportObj() method is declared as static.
	ExtentTest test;
	ThreadLocal<ExtentTest> tl=new ThreadLocal<ExtentTest>();// in parallel execution we get thread overriden problem hence we make the test object as thread safe with the help of this class.

	@Override
	public void onFinish(ITestContext result) // once all test case execution completed then this block will execute and flush.
	{
		// TODO Auto-generated method stub
		extent.flush(); 
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) 
	{
		// TODO Auto-generated method stub
		
			
	}

	@Override
	public void onTestFailure(ITestResult testResult) 
	{
		tl.get().fail(testResult.getThrowable()); //this will print the failed test cases log in report.
		
		WebDriver driver=null;
		String failedTestMethodName=testResult.getMethod().getMethodName(); // here we should get the test case name which is failed.
		try {
			//here we actually captured the failed test case driver object and store it in local driver object
			driver=(WebDriver)testResult.getTestClass().getRealClass().getDeclaredField("driver").get(testResult.getInstance());
		} catch(Exception e) {
			
		}
		
		try {
			//here we should pass the failed test case method name and driver object of failed test case to screenShotPath method.
			//also addScreenCaptureFromPath method requires 2 parameters 1.path of captured screenshot and failed test case name.
			tl.get().addScreenCaptureFromPath(getScreenShotPath(failedTestMethodName,driver), failedTestMethodName); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) // this block will execute before every test case execution so that for every test extent report entry will be created.
	{
		//here we get the test case name and entry will be created with test case name.
		
		 test=extent.createTest(result.getMethod().getMethodName()); // create entry for every test case before executing test to monitor whether test case pass or fail.
		 tl.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) // this block will print pass status and description in report.
	{
		// TODO Auto-generated method stub
		tl.get().log(Status.PASS, "Test case passed"); // once the test case is passed then it will automatically update in report.
		
	}

}
