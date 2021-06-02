package FrameworkBuilding.E2E_Project;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import resources1.base;

public class HomePageTestCases extends base
{
	public WebDriver driver;
	public static Logger log= LogManager.getLogger(base.class.getName());
	HomePageObjects hpo;
	
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver=initializeDrive();
		log.info("WebDriver is initialized and browser is opened");
		
	}
	
	/*@Test(priority=1)
	public void checkQaClickHomePageOpened() throws IOException // open home page
	{
		initializeDrive();
		driver.get(prop.getProperty("Url"));
	}*/
	
	// if all the test cases belongs to same web page then no need to open browser for each test case hence commenting url hitting code from all @test methods
	//with the help of above mechanism we will optimize our framework.
	
	@Test (priority=1)
	public void checkTitleOfPageIsCorrect() // click on login button and navigate to login page
	{
		driver.get(prop.getProperty("Url"));
		log.info("hited qaclick acadamy url successfully");
		hpo=new HomePageObjects(driver);
		String actTitleName=hpo.getTitleOfHomePage().getText();
		String expectedTitle="FEATURED Courses"; //"Featured Courses"; //COURSES
		Assert.assertEquals(actTitleName, expectedTitle);
		log.info("titleName is verified successfully and it is not as per expectaion");
	}
	
	@Test (priority=2)
	public void checkHeaderTitleIsCorrect() // click on login button and navigate to login page
	{
		//driver.get(prop.getProperty("Url"));
		//log.info("hited qaclick acadamy url successfully");
		//hpo=new HomePageObjects(driver);
		String actHeaderTitleName=hpo.checkHeaderTitleIsCorrect().getText();
		String expectedHeaderTitle="AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING"; //"Featured Courses"; //COURSES
		Assert.assertEquals(actHeaderTitleName, expectedHeaderTitle);
		log.info("Header title Name is verified successfully and it is as per expectaion");
	}
	
	@Test(priority=3)
	public void checkNavBarAvailable()
	{
		Assert.assertTrue(hpo.homePageNavBar().isDisplayed()); // assertTrue method requires parameters output as true other wise it gets failed 
		log.info("Navigation Bar is available on home page");
		Assert.assertFalse(false);// assertFalse method requires parameters output as false other wise it gets failed.
	}
	
	@Test (priority=4)
	public void checkLoginBtnWorking() throws InterruptedException // click on login button and navigate to login page
	{
		//driver.get(prop.getProperty("Url"));
		//log.info("hited qaclick acadamy url successfully");
		//hpo=new HomePageObjects(driver);
		hpo.navigateToLoginPage(driver);
		//hpo.navigateToLoginPage();
		log.info("clicked on home page login in button successfully");
		//driver.wait(20000);
		
	}
	
	@AfterTest
	public void closeBrowser() throws IOException
	{
		driver.close();
		log.info("browser closed successfully");
	}
	
	/* merged code of unauthorized login test case
	@Test(dataProvider="getData",priority=4) // here we need to give priority because same driver object passed to multiple @test methods otherwise will get nullpointer exception
	public void LoginPageValidationTest(String Uname,String pwd) // login page validation with valid and invalid credentials
	{
		LoginPageObjects loginPageObj=new LoginPageObjects(driver);
		loginPageObj.sendEmail().sendKeys(Uname);
		loginPageObj.sendPass().sendKeys(pwd);
		loginPageObj.clikOnLoginBtn().click();
		
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
		
	}*/
	
}
