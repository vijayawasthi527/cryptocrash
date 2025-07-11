package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DiceGamePage {
	
	  private WebDriver driver;
	  private WebDriverWait wait;
	  Actions act;
	  
	  @FindBy(xpath = "(//*[@placeholder='Enter Bet Amount'])[1]")
	  private WebElement betAmount;
	  
	  @FindBy(xpath = "(//*[@type='button' and contains(text(),'1/2')])[1]")
	  private WebElement betAmountHalfButton;
	  
	  @FindBy(xpath = "(//*[@type='button' and contains(text(),'x2')])[1]")
	  private WebElement betAmountDouble;

	  @FindBy(xpath = "(//*[@type='button' and contains(text(),'Max')])[1]")
	  private WebElement betAmountMax;
	  
	  @FindBy(xpath = "(//*[@type='button' and contains(text(),'Roll Dice')])[2]")
	  private WebElement rollDiceButton;
	  
	  public DiceGamePage(WebDriver driver)
	  {
		  this.driver=driver;
		  PageFactory.initElements(driver,this);
		  wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		  act=new Actions(driver);
	  }
	  
	  public void clickBetAmountDoubleButton() throws InterruptedException
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(betAmountDouble));
		  Thread.sleep(2000);
		  betAmountDouble.click();
	  }
	  
	  public void click_RollDiceButton() throws InterruptedException
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(betAmountDouble));
		  Thread.sleep(2000);
		  rollDiceButton.click();
	  }
	  
	  

}
