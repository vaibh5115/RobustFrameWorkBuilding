package resources1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsConfig 
{
	 static ExtentReports extent;
	
	public static ExtentReports getExtentReportObj()
	{
		String path=System.getProperty("user.dir")+"\\Reports\\index.html"; //create Reports folder path under project directory.
		ExtentSparkReporter reporter=new ExtentSparkReporter(path); // report creation and report configuration class
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("Test Results"); // here we done the report configuration with the help of ExtentSparkReporter class.
		
		extent=new ExtentReports(); // main class to attach created report.
		extent.attachReporter(reporter); //attached configured report
		extent.setSystemInfo("Tester ", "Vaibhav M"); // set tester name.
		
		return extent;
		
	}

}
