package org.apache.maven.archetypes.nopcommerceApp;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.ReadConfig;
public class TestBase {
	
	public static WebDriver driver;
	public String baseUrl;
	public String username;
	public String password;
	public ReadConfig readConfig;
	public OperaOptions operaOptions;
	
	
	public static Logger logger;
	
	

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	{
		readConfig = new ReadConfig();
		baseUrl = readConfig.getApplicationURL();
		username = readConfig.getUsername();
		password = readConfig.getPassword();
		
		logger= Logger.getLogger("nopcommerceApp");
		PropertyConfigurator.configure("log4j.properties");
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		else if(browser.equals("opera"))
		{
			operaOptions = new OperaOptions();
			operaOptions.setBinary("C:\\Users\\edisa\\AppData\\Local\\Programs\\Opera\\73.0.3856.264\\opera.exe");
			System.setProperty("webdriver.opera.driver", readConfig.getOperaPath());
			driver = new OperaDriver();
		}
			
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String testName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + testName + ".png");
	    FileHandler.copy(source, target);
	    System.out.println("Screenshot taken");
	}
}
