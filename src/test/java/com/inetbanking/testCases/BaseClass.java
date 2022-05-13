package com.inetbanking.testCases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

public class BaseClass {  
	
     ReadConfig readconfig = new ReadConfig();
     
     public String baseURL =  readconfig.getApplicationURL();
     public String username = readconfig.getApplicationusername();
     public String password = readconfig.getApplicationpassword();
     
     

	public static WebDriver driver;
	public static Logger logger;
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {

		if(browser.equals("msedge")) {
		EdgeOptions options = new EdgeOptions();
		options.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.edge.driver",readconfig.mesedgepath());
		driver= new EdgeDriver(options);
		}
		
		else if(browser.equals("chrome")) {
		ChromeOptions options  = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver",readconfig.chromepath());
		driver= new ChromeDriver(options);
		}
		
		else if(browser.equals("firefox")) {
		FirefoxOptions options  = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.gecko.driver",readconfig.firefoxpath());
		driver= new FirefoxDriver(options);
		}
		
		else {
		ChromeOptions options  = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver",readconfig.chromepath());
		driver= new ChromeDriver(options);
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		
		logger=Logger.getLogger("inetBankingV1");
		PropertyConfigurator.configure("log4j.properties");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
	
	public String randomString() {
		String generatedstring =RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	
	
	public String randomNumber() {
		String generatednumber =RandomStringUtils.randomAlphanumeric(6);
		return generatednumber;
	}
	
	public String randString() {
		String generatedstring =RandomStringUtils.randomAlphabetic(2);
		return generatedstring;
	}
	
  
	
}
      
   

