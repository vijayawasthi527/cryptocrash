package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenCaseGamePage {
	
	  private WebDriver driver;
	  private WebDriverWait wait;
	  Actions act;
	
	
	@FindBy(xpath = "//*[@type='button' and @value='new' and contains(text(),'NEW')]")
	private WebElement orderByNew;
	
	@FindBy(xpath = "(//*[contains(@class,'freeCaseItem-col')])[1]")
	private WebElement firstCaseInNewSection;
	
	@FindBy(xpath = "(//*[contains(@class,'btn-openFor')])[1]")
	private WebElement openCaseButton;

	
	
	public OpenCaseGamePage(WebDriver driver)
	  {
		  this.driver=driver;
		  PageFactory.initElements(driver,this);
		  wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		  act=new Actions(driver);
	  }
	
	
	public void click_NewCaseCategory()
	{
		wait.until(ExpectedConditions.elementToBeClickable(orderByNew));
		orderByNew.click();
	}
	
	public void click_FirstCaseInNewCategory()
	{
		wait.until(ExpectedConditions.elementToBeClickable(firstCaseInNewSection));
		firstCaseInNewSection.click();
	}
	
	public void click_OpenCasebutton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(openCaseButton));
		openCaseButton.click();
	}
}
