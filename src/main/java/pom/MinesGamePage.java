package pom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinesGamePage {
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
	  
	  @FindBy(xpath = "(//*[@class='rc-slider-handle'])[1]")
	  private WebElement betAmountSliderHandle;
	  
	  @FindBy(xpath = "(//*[@type='button' and contains(text(),'Bet')])[2]")
	  private WebElement betButton;
	  
	  @FindBy(xpath = "(//*[@class='MineCard_cardWrapper__QAamO'])[5]")
	  private WebElement selectMinesCard;
	  
	  @FindBy(xpath = "(//*[@type='button' and contains(text(),'Cash Out')])[2]")
	  private WebElement minesCashoutButton;
	  
	  @FindBy(xpath = "//*[@class='xValue']")
	  private WebElement winlossTileMultiplierValue;
	  
	  @FindBy(xpath = "//*[@class='winLosseValue']/child::div[2]")
	  private WebElement winlossTileWinAmont;
	  
	  @FindBy(xpath = "(//li[@class='nav-item'])[2]/button")
	  private WebElement minesAutoBetTab;
	  
	  @FindBy(xpath = "(//*[@type='button' and contains(text(),'10')])[3]")
	  private WebElement minesAutoBet10BetsButton;
	  
	  @FindBy(xpath = "(//*[@type='number'])[1]")
	  private WebElement onWinPercent;
	  
	  @FindBy(xpath = "(//*[@type='number'])[2]")
	  private WebElement onLossPercent;
	  
	  @FindBy(xpath = "(//*[@type='button' and contains(text(),'Start Auto Bet')])[2]")
	  private WebElement startAutoBetButton;
	  
	  @FindBy(xpath = "//*[@class='Toastify']/child::div/child::div")
	  private WebElement totalRoundCompletePopUP;
	  
	  @FindBy(xpath = "//*[@class='lastBetsRace-tab']/ul/li[2]/button")
	  private WebElement myBetsButton;
	  
	  @FindBy(xpath = "(//table[@class='customTable'])[2]/tbody/tr[3]/td")
	  private List<WebElement> firstRowCells;
	  
	  public MinesGamePage(WebDriver driver)
	  {
		  this.driver=driver;
		  PageFactory.initElements(driver,this);
		  wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		  act=new Actions(driver);
	  }

	  public void enterBetAmount() throws InterruptedException
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(betAmount));
		  Thread.sleep(2000);
		  betAmount.sendKeys("100");
	  }
	  
	  public void clickBetAmountDoubleButton() throws InterruptedException
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(betAmountDouble));
		  Thread.sleep(2000);
		  betAmountDouble.click();
	  }
	  
	  public void BetAmountSliderHandle() throws InterruptedException
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(betAmountSliderHandle));
		  Thread.sleep(2000);
		  Actions act=new Actions(driver);
		  act.clickAndHold(betAmountSliderHandle).moveByOffset(1,0).release().build().perform();
	  }
	  
	  public void ClickbetButton() throws InterruptedException
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(betButton));
		  Thread.sleep(2000);
		  betButton.click();
	  }
	  
	  public void clickMinesCard() throws InterruptedException
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(selectMinesCard));
		  Thread.sleep(2000);
		  act.moveToElement(selectMinesCard).build().perform();;
		  selectMinesCard.click();
	  }
	  
	  public void clickMinesCashoutButton() throws InterruptedException
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(minesCashoutButton));
		  Thread.sleep(4000);
		  act.moveToElement(minesCashoutButton).build().perform();;
		  minesCashoutButton.click();
		  Thread.sleep(2000);
	  }
	  
	  public String getResultMultiplierValue()
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(winlossTileMultiplierValue));
		  return winlossTileMultiplierValue.getText();
	  }
	  
	  public String getResultWinAmount()
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(winlossTileWinAmont));
		  return winlossTileWinAmont.getText();
	  }
	  
	  public void click_AutoBetTab()
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(minesAutoBetTab));
		  minesAutoBetTab.click();
	  }
	  
	  public void click_AutoBet10Button()
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(minesAutoBet10BetsButton));
		  minesAutoBet10BetsButton.click();
	  }
	  
	  public void enter_OnWinPercent()
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(onWinPercent));
		  onWinPercent.sendKeys("10");
	  }
	  
	  public void enter_OnLossPercent()
	  {
		  wait.until(ExpectedConditions.elementToBeClickable(onLossPercent));
		  onLossPercent.sendKeys("10");
	  }
	  
	  public void click_StartAutoBetButton()
	  {
		  act.moveToElement(startAutoBetButton).build().perform();
		  wait.until(ExpectedConditions.elementToBeClickable(startAutoBetButton));
		  startAutoBetButton.click();
	  }
	  
	  public String get_TextOfTotalRoundCompletePOPUP()
	  {
		  wait.until(ExpectedConditions.visibilityOf(totalRoundCompletePopUP));
		  return totalRoundCompletePopUP.getText();
	  }
	  
	  public void click_MyBetsButton()
	  {
		  act.moveToElement(myBetsButton).build().perform();
		  wait.until(ExpectedConditions.elementToBeClickable(myBetsButton));
		  myBetsButton.click();
	  }
	  
	  public List<String> getFirstRowData() throws InterruptedException {
			    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 400);");
			    Thread.sleep(300);
			
			    List<String> rowData = new ArrayList<>();
			    for (WebElement cell : firstRowCells) {
			        try {
			            WebElement innerDiv = cell.findElement(By.tagName("div"));
			            rowData.add(innerDiv.getText().trim());
			        } catch (NoSuchElementException e) {
			            rowData.add(""); // fallback if no div
			        }
			    }
		    return rowData;
		}
	  
//	  public List<String> getFirstRowData() throws InterruptedException {
//		    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 400);");
//		    Thread.sleep(300);
//
//		    List<String> rowData = new ArrayList<>();
//
//		    // Locate the table and first row
//		    WebElement firstRow = driver.findElement(By.cssSelector("table tr")); // first tr
//
//		    // Get cells (could be <td> or <th> depending on structure)
//		    List<WebElement> firstRowCells = firstRow.findElements(By.xpath("./td | ./th"));
//
//		    for (WebElement cell : firstRowCells) {
//		        try {
//		            WebElement innerDiv = cell.findElement(By.tagName("div"));
//		            rowData.add(innerDiv.getText().trim());
//		        } catch (NoSuchElementException e) {
//		            rowData.add(cell.getText().trim()); // fallback to cell text
//		        }
//		    }
//
//		    return rowData;
//		}
	  
	  
}
