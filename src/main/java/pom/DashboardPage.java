package pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage {
	
	 private WebDriver driver;
	  private WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id='dropdown-basic' and contains(text(),'Games') and @aria-expanded='false']")
	private WebElement gamesDropdown;
	
	@FindBy(xpath = "//*[@class='dropdown-item' and @href='/Mines']")
	private WebElement selectMinesGameDropdown;
	
	@FindBy(xpath = "//*[@class='dropdown-item' and @href='/Dice']")
	private WebElement selectDiceGameDropdown;
	
	@FindBy(xpath = "//*[@class='dropdown-item' and @href='/OpenCase']")
	private WebElement selectOpenCaseGameDropdown;
	
	
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void click_GamesDropdown() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(gamesDropdown));
		Thread.sleep(2000);
		gamesDropdown.click();
	}
	
	public void click_MinesGame()
	{
		wait.until(ExpectedConditions.elementToBeClickable(selectMinesGameDropdown));
		selectMinesGameDropdown.click();
	}
	
	public String verify_MinesPage()
	{
		String minesURL=driver.getCurrentUrl();
		return minesURL;
	}
	
	public void click_DiceGame()
	{
		wait.until(ExpectedConditions.elementToBeClickable(selectDiceGameDropdown));
		selectDiceGameDropdown.click();
	}
	
	public void click_OpenCaseGame()
	{
		wait.until(ExpectedConditions.elementToBeClickable(selectOpenCaseGameDropdown));
		selectOpenCaseGameDropdown.click();
	}
	
	public boolean verify_DashBoard()
	{
		boolean result;
		String actualDashBoardURL=driver.getCurrentUrl();
		String expectedDashboardURL="https://cryptocrash.aistechnolabs.info/";
		if(actualDashBoardURL.equalsIgnoreCase(expectedDashboardURL))
		{
			result=true;
		}
		else
		{
			result=false;
		}
		
		return result;
	}

}
