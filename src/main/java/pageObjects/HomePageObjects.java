package pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects 
{

	 WebDriver driver;
	 
	private By popup = By.xpath("//button[text()='NO THANKS']");
	 
	 
	 
	 @FindBy(xpath="//*[@id=\"content\"]/div/div/h2")
	private WebElement lable; // here we achieve oops concept-Encapsulation: make the variables as private and access the variables through public methods.
	 
	/* @FindBy(css="a[href*='sign_in']") // page object pattern: using page factory
	 WebElement loginBtn; 
	 
	 @FindBy(xpath="//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a/span") // page object pattern: using page factory
	 WebElement loginBtn; */
	
	 @FindBy(xpath="//*[@id=\"homepage\"]/header/div[2]/div/nav")
	private WebElement navbar;

	 @FindBy(css="a[href*='sign_in']")
	private WebElement loginBtn;
	 
	 @FindBy(xpath="//*[@id=\"myCarousel\"]/div/div/div/div/div[1]/h3")
	 private WebElement headerTitle;

	public HomePageObjects(WebDriver driver) // landing page constructor
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getTitleOfHomePage() // page object methods: using page factory
	 {
		return lable; 
	 }
	
	public WebElement checkHeaderTitleIsCorrect() // page object methods: using page factory
	 {
		return headerTitle; 
	 }

	public LoginPageObjects navigateToLoginPage(WebDriver driver) // page object methods: using page factory
	 {
		 loginBtn.click();
		 LoginPageObjects lpo=new LoginPageObjects(driver);
		 return lpo;
	 }
	 
	public WebElement homePageNavBar() // these are 
	{
		return navbar;
	}
	
	public int getPopupSize(WebDriver driver) // these are 
	{
		return driver.findElements(popup).size();
	}
	
	public WebElement getPopup(WebDriver driver) // these are 
	{
		return driver.findElement(popup);
	}
}
