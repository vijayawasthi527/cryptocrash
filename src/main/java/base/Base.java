package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pom.Homepage;
import pom.LoginPage;

public class Base {
	
	static protected WebDriver driver;
	Homepage homepage;
	LoginPage loginpage;
	
	@BeforeMethod
	public void launchCryptocrash() throws InterruptedException
	{
		 

        // This is the crucial line
       
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Launching Browser",true);
		driver.get("https://cryptocrash.aistechnolabs.info/");
		Thread.sleep(2000);
		homepage=new Homepage(driver);
		homepage.click_SigninButton();
		loginpage=new LoginPage(driver);
		loginpage.login("vinton@aistechnolabs.com","Test@1234");
	}
	
	//now closing the browser
	
	@AfterMethod
	public void closeCryptocrash() throws InterruptedException
	{
		Reporter.log("Closing the browser",true);
		Thread.sleep(1000);
		driver.quit();
	}

}
