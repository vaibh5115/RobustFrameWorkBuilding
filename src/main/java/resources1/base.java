package resources1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base 
{
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDrive() throws IOException
	{
		
		prop= new Properties();  //to read data from .propertries file
		//FileInputStream fis=new FileInputStream("E:\\Study\\eclipse_workspace\\Frameworks-Practice\\E2E_Project\\src\\main\\java\\resources1\\data.properties");// need to remove hard coded paths to optimize framework 
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources1\\data.properties"); // removed hard coded paths so that code should be run in any machine.
		prop.load(fis); //load specified file in prop object
		
		String browserName=prop.getProperty("browser"); //used this when need to execute as testNG suite: normal execution by getting browser value from .properties file.
		
		//String browserName=System.getProperty("browser"); //make maven to read browser parameters by making it as Systems file
		// now from cmd execute below command to parameterize build with different browser.
		//mvn test -Dbrowser=chrome 
		
		if(browserName.contains("chrome"))  // this block will allow normal execution.
		{
		//System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe"); //  need to remove hard coded paths to optimize framework
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources1\\chromedriver.exe"); // removed hard coded paths so that code should be run in any machine and also chromedriver.exe placed in same project directory so no need to download chrome driver again in another machine.
		ChromeOptions options =new ChromeOptions();	// for headless execution we need to create object of ChromeOptions class.
		
			if(browserName.contains("headless")) // this method will check in passed parameters>>getting any headless string if yes then it will send headless execution option else execute in normal mode.  
			{
				options.addArguments("headless"); // this will allow browser to perform execution in headless mode.
			}
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		
		else if (browserName.equals("firefox"))
		{
			//firefox browser invocation code  
		}
		else if(browserName.equals("IE"))
		{
			//IE browser invocation code
		}
		else
		{
			System.out.println("Invalid parameters");
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // this will applicable for all test cases.
		
		return driver;
		
	}
	
	public String getScreenShotPath(String failedTestCaseName,WebDriver driver) throws IOException // here we received failed test case name and failed test case object as an argument from onTestFailure() method.
	{
		TakesScreenshot ts=(TakesScreenshot)driver; //  TakesScreenshot is an interface and we have to convert driver type into TakesScreenshot.
		File source=ts.getScreenshotAs(OutputType.FILE); // here we need to add apache commons-io dependency in pom.xml because this method is available under this dependency.
		String destFilePath=System.getProperty("user.dir")+"\\Screenshots\\"+failedTestCaseName+".png"; // copy the screenshot with test case name inside Screenshots folder which is at project directory level.
		FileUtils.copyFile(source, new File(destFilePath)); // copy the screenshot which was stored on virtual path into actual created path.
		return destFilePath;// this variable contains the failed test cases screenshot path.
	}
	

}
