package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {
	
	protected WebDriver driver;
	
	public static void takeScreenShot(WebDriver driver,String TCID) throws IOException
	{
		Reporter.log("Taking ScreenShot",true);
		String timeStamp=new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(System.getProperty("user.dir")+ "\\screenshots\\cryptoCrash" + TCID + "_" + timeStamp + ".png");
		Reporter.log("Saved ScreenShot at"+dest,true);
		FileHandler.copy(src, dest);
	}
	
	public static String propertyFileData(String key) throws InterruptedException, IOException
	{
		Properties prop=new Properties();
		Thread.sleep(1000);
		
		FileInputStream myFile=new FileInputStream(System.getProperty("user.dir")+"\\cryptocrash.Properties");
		prop.load(myFile);
		Thread.sleep(1000);
		
		String value=prop.getProperty(key);
		return value;
	}
	


}
