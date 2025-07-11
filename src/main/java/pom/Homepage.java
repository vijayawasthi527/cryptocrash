package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {
	
	 private WebDriver driver;
	  private WebDriverWait wait;
	
	@FindBy (xpath = "//*[contains(text(),'Sign In') and @type='button']")
	private WebElement signInButton;
	
	public Homepage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void click_SigninButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signInButton));
		signInButton.click();
	}

}
