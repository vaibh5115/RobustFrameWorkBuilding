package FrameworkBuilding.E2E_Project;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import resources1.base;


public class LoginPageTestCases extends base
{
	public WebDriver driver;
	public static Logger log= LogManager.getLogger(base.class.getName());
	LoginPageObjects lpo;
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver=initializeDrive();
		log.info("WebDriver is initialized"); 
	}
	
	@Test(dataProvider="getData") // here we need to give priority because same driver object passed to multiple @test methods otherwise will get nullpointer exception
	public void LoginPageUnautorizedAccessTest(String Uname,String pwd) throws IOException // login page validation with valid and invalid credentials
	{
		driver.get(prop.getProperty("Url"));
		log.info("hited qaclick acadamy url successfully");
		HomePageObjects hpo=new HomePageObjects(driver);
		lpo=hpo.navigateToLoginPage(driver); //framework optimization done here by creating object of LoginPageObjects class in HomePageObjects class.
		//driver.findElement(By.cssSelector("a[href*='sign_in']")).click();
		log.info("clicked on home page login button successfully");
		//LoginPageObjects loginPageObj=new LoginPageObjects(driver);
		lpo.sendEmail().sendKeys(Uname);
		log.info("User name: "+Uname+" entered successfully");
		lpo.sendPass().sendKeys(pwd);
		log.info("password: "+pwd+" entered successfully");
		lpo.clikOnLoginBtn().click();
		log.info("clicked on Login page login button successfully");
		
		ForgotPassPageObjects fppo=lpo.clikOnForgotPassLink(); //framework optimization done here by creating object of ForgotPassPageObjects class in LoginPageObjectsClass
		log.info("clicked on login page-> forgot password link successfully");
		fppo.sendForgotPassEmail().sendKeys("xyz@qaclick.com");
		log.info("forgot password email id entered successfully");
		fppo.clikOnSendMeInstrBtn().click();
		log.info("clicked on Send Me Instruction button successfully");
	}
	
	@DataProvider 
	public Object[][] getData()
	{
		
		//[2][2] means array of size 2 but index start from 0,1
		//1st represent row and second represents column
		//1st [2] means script executed twice and 2nd [2] means script executed twice with 2 data like username and pass.
		Object[][] data=new Object[2][2];
		
		data[0][0]="restricteduser@qaclick.com"; 
		data[0][1]="pass@123";
		
		data[1][0]="unrestricteduser@qaclick.com";
		data[1][1]="unrestricted";
		
		return data;
		
	}
	
	@AfterTest
	public void closeBrowser() throws IOException
	{
		driver.close();
		log.info("browser closed successfully");
	}

}
