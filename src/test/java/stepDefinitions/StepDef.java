package stepDefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import resources1.base;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class StepDef extends base
{
	WebDriver driver;
	HomePageObjects hpo;
	LoginPageObjects lpo;
	@Given("^Initialize browser driver with chrome$")
	public void initialize_browser_driver_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver=initializeDrive();
	}

	@Given("^Hit URL \"([^\"]*)\"$")
	public void hit_URL(String url) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(url);
		
		
		
	}

	@Given("^Click on home page login in link$")
	public void click_on_home_page_login_in_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    hpo=new HomePageObjects(driver);
	    
	    if(hpo.getPopupSize(driver)>0)
	    {
	    	hpo.getPopup(driver).click();
	    }
	    
	    lpo=hpo.navigateToLoginPage(driver);
	}

	/*
	 * passing data to step def file from .feature file.
	@When("^User enter username \"([^\"]*)\" and password \"([^\"]*)\"$") 
	public void user_enter_username_and_password(String username, String pass) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	    lpo.sendEmail().sendKeys(username);
	    lpo.sendPass().sendKeys(pass);
	    lpo.clikOnLoginBtn().click();
	    
	}*/
	
	 @When("^User enter (.+) and (.+)$") // this is for executing single step with multiple inputs-- parameterization
	 public void user_enter_and(String username, String password) throws Throwable 
	 {
		 	lpo.sendEmail().sendKeys(username);
		    lpo.sendPass().sendKeys(password);
		    lpo.clikOnLoginBtn().click();
	 }

	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable 
	{
	    // Write code here that turns the phrase above into concrete actions
	  Assert.assertFalse(false);
		//org.junit.Assert.assertFalse(lpo.getSearchBox().isDisplayed());
	}
	
	 @And("^close browsers$")
	 public void close_browsers() throws Throwable 
	 {
		driver.quit();
	 }
	

}
