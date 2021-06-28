package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ForgotPassPageObjects
{
	public WebDriver driver;
	
	
	public ForgotPassPageObjects(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		//PageFactory.initElements(driver, this);
	}


	// here we achieve oops concept-Encapsulation: make the variables as private and access the variables through public methods.
	private By forgotPassEmail= By.xpath("//*[@id=\"user_email\"]");
	private By sendMeInstrBtn= By.xpath("//*[@id=\"hero\"]/div/form/div[2]/input");
	
	public WebElement sendForgotPassEmail() // normal page object methods
	{
		return driver.findElement(forgotPassEmail);
	}
	
	public WebElement clikOnSendMeInstrBtn()
	{
		return driver.findElement(sendMeInstrBtn);
	}
	
}
