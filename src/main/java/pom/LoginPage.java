package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	 private WebDriver driver;
	  private WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id='controlled-tab-example-tab-Login']")
	private WebElement signInTab;
	
	@FindBy(id = "controlled-tab-example-tab-Signup")
	private WebElement signUPTab;
	
	@FindBy(xpath = "//div[@id='controlled-tab-example-tabpane-Login']//input[@name='email']")
	private WebElement emailAddress;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = "//*[@type='submit' and contains(text(),'Sign In')]")
	private WebElement signInButton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public boolean status_SignINButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signInTab));
		return signInTab.getAttribute("aria-selected").equals("true");
	}
	
	public void click_SignInButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signInTab));
		signInTab.click();
	}
	
	public boolean status_SignUPButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signUPTab));
		return signInTab.getAttribute("aria-selected").equals("false");
	}
	
		
	public void login(String username, String passwd) {
		wait.until(ExpectedConditions.visibilityOf(emailAddress));
		emailAddress.sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(passwd);
		wait.until(ExpectedConditions.visibilityOf(signInButton));
		signInButton.click();
    }
	
//	public void enter_Emailadress() 
//	{
//		wait.until(ExpectedConditions.visibilityOf(emailAddress));
//		emailAddress.sendKeys("vinton@aistechnolabs.com");
//	}
//	
//	public void enter_Password()
//	{
//		wait.until(ExpectedConditions.visibilityOf(emailAddress));
//		password.sendKeys("Test@1234");
//	}
//	
//	public void click_SignINButton()
//	{
//		wait.until(ExpectedConditions.visibilityOf(signInButton));
//		signInButton.click();
//		
//	}

}
