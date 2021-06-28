package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPageObjects
{
	public WebDriver driver;
	
	
	public LoginPageObjects(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		//PageFactory.initElements(driver, this);
	}

	
	/*
	@FindBy(xpath="//*[@id=\"user_email\"]")
	WebElement email;
	
	@FindBy(id="user_password")
	WebElement pass;
	
	@FindBy(name="commit")
	WebElement loginBtn1;
	*/
	
	// here we achieve oops concept-Encapsulation: make the variables as private and access the variables through public methods.
	private By email = By.id("user_email");   // normal page object pattern
	private By pass = By.id("user_password");
	private By loginBtn = By.xpath("//*[@id=\"hero\"]/div/form/div[3]/input");
	private By searchBox = By.id("search-courses");
	private By forgotPass= By.linkText("Forgot Password?");
	
	

	public WebElement sendEmail()  // normal page object methods
	{
		return driver.findElement(email);
	}
	
	public WebElement sendPass()
	{
		return driver.findElement(pass);
	}
	
	public WebElement clikOnLoginBtn()
	{
		return driver.findElement(loginBtn);
	}
	
	public WebElement getSearchBox()
	{
		return driver.findElement(searchBox);
	}
	
	public ForgotPassPageObjects clikOnForgotPassLink()
	{
		 driver.findElement(forgotPass).click();
		 ForgotPassPageObjects fppo=new ForgotPassPageObjects(driver);
		 return fppo;
	}
	
	/*
	public WebElement sendEmail()  //  page object methods using PageFactory
	{
		return email;
	}
	
	public WebElement sendPass()
	{
		return pass;
	}
	
	public WebElement clikOnLoginBtn()
	{
		return loginBtn1;
	}
	*/

}
