package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	static protected WebDriver driver;
	
	@BeforeMethod
	public void launchCryptocrash() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Launching Browser",true);
		driver.get("https://cryptocrash.aistechnolabs.info/");
		Thread.sleep(2000);
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
