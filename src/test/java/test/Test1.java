package test;



import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.Base;
import pom.DashboardPage;
import pom.DiceGamePage;
import pom.Homepage;
import pom.LoginPage;
import pom.MinesGamePage;
import pom.OpenCaseGamePage;

@Listeners(listners.Listenercryptocrash.class)
public class Test1 extends Base
{
	Homepage homepage;	
	LoginPage loginpage;
	DashboardPage dashboardpage;
	MinesGamePage minesgamepage;
	DiceGamePage dicegamepage;
	OpenCaseGamePage opencasegamepage;
	
	@BeforeMethod
	public void initPageObjects()
	{
		homepage=new Homepage(driver);
		loginpage=new LoginPage(driver);
		dashboardpage=new DashboardPage(driver);
		minesgamepage=new MinesGamePage(driver);
		dicegamepage=new DiceGamePage(driver);
		opencasegamepage=new OpenCaseGamePage(driver);
	}
	
	@Test(priority = 1, enabled = false)
	public void signIN() throws InterruptedException
	{
		homepage.click_SigninButton();
		
		boolean statusSignInButton = loginpage.status_SignINButton();
		if(!(statusSignInButton))
		{
			loginpage.click_SignInButton();
		}
		boolean status1 = loginpage.status_SignUPButton();
		System.out.println(status1);
		boolean result=dashboardpage.verify_DashBoard();
		Assert.assertEquals(result,true,"Login Failed!!!!");
		Reporter.log("Player Logged in Successfully,SignIn TestCase Passed !!!!",true);
	}
	
	@Test(priority = 2)
	public void game_dropdown() throws InterruptedException
	{
		dashboardpage.click_GamesDropdown();
		dashboardpage.click_MinesGame();
		Thread.sleep(4000);
		System.out.println(dashboardpage.verify_MinesPage());
		Assert.assertEquals(dashboardpage.verify_MinesPage(),"https://cryptocrash.aistechnolabs.info/Mines");
		Reporter.log("Dropdown Working Properly & Player landed on Mines Game Page",true);
		System.out.println("Landed on Mines Game page Successfully");
	}
	
	@Test(priority = 3)
	public void play_MinesManualGame() throws InterruptedException
	{
		dashboardpage.click_GamesDropdown();
		dashboardpage.click_MinesGame();
		//minesgamepage.enterBetAmount();
		minesgamepage.clickBetAmountDoubleButton();
		//minesgamepage.BetAmountSliderHandle();
		minesgamepage.ClickbetButton();
		minesgamepage.clickMinesCard();
		try {
			minesgamepage.clickMinesCashoutButton();
			Reporter.log("Mines Game Played Successfully",true);
			String multiplierValue=minesgamepage.getResultMultiplierValue();
			String profitAmount=minesgamepage.getResultWinAmount();
			Assert.assertEquals(multiplierValue,"0.99x","Multiplier Value is 0.99X, Test Case Passed for Multiplier Value");
			Assert.assertEquals(profitAmount,"1.97","Profit Amount is 1.97,Test Case Passed for Profit Amount");
			minesgamepage.click_MyBetsButton();
			
			
		}
		
		catch (Exception e) {
			System.out.println("Cashout Button is not visible");
		}
		 // Get data from first row
        List<String> firstRowData = minesgamepage.getFirstRowData();
        //List<String> expectedData = Arrays.asList("Mines", "48", "User 445", "1.21", "0.99", "1.20");
        List<String> expectedData = Arrays.asList("Mines", "48\nUser 445", "2.00", "0.99", "1.98");
        // Print each column value
        System.out.println("First row data:");
        System.out.println(String.join(" ", firstRowData));
        for (int i = 0; i < expectedData.size(); i++) {
            Assert.assertEquals(firstRowData.get(i), expectedData.get(i), "Mismatch at column " + (i + 1));
        }
		
	}
	
	
	@Test(priority = 4)
	public void play_MinesAutoGame() throws InterruptedException
	{
		dashboardpage.click_GamesDropdown();
		dashboardpage.click_MinesGame();
		System.out.println("Clicked Mines Games");
		minesgamepage=new MinesGamePage(driver);
		minesgamepage.click_AutoBetTab();
		System.out.println("Clicked Mines AutoTab");
		minesgamepage.click_AutoBet10Button();
		minesgamepage.enter_OnWinPercent();
		minesgamepage.enter_OnLossPercent();
		minesgamepage.clickMinesCard();
		minesgamepage.click_StartAutoBetButton();
		
		Thread.sleep(2000);
		String actualTotalRounds = minesgamepage.get_TextOfTotalRoundCompletePOPUP();
		String expectedTotalRounds="Total completed rounds: 10";
		
		//Verify the total Number of Rounds
		Assert.assertEquals(actualTotalRounds,expectedTotalRounds,"Total Number of Rounds didn't Matched TC Failed!!!!");
		
		
	}
	
	@Test(priority = 5,dependsOnMethods = {"game_dropdown"},enabled = false)
	public void play_DiceGame() throws InterruptedException
	{

		dashboardpage.click_GamesDropdown();
		dashboardpage.click_DiceGame();
		dicegamepage.clickBetAmountDoubleButton();
		dicegamepage.click_RollDiceButton();
		Reporter.log("Dice Game Played Sucessfully",true);
		
	}
	
	
	@Test(priority = 6,dependsOnMethods = {"game_dropdown"},enabled = false)
	public void play_OpenCaseGame() throws InterruptedException
	{

		dashboardpage.click_GamesDropdown();
		dashboardpage.click_OpenCaseGame();
		opencasegamepage.click_NewCaseCategory();
		opencasegamepage.click_FirstCaseInNewCategory();
		opencasegamepage.click_OpenCasebutton();
		Reporter.log("OpenCase Game Played Successfully",true);
	}
	
	

}
