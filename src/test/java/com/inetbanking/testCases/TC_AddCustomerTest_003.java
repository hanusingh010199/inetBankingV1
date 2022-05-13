package com.inetbanking.testCases;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{
	
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		logger.info("Clicked on Login button");
		
		Thread.sleep(4000);
	
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		Thread.sleep(4000);
		
		logger.info("providing customer details");
		
		addcust.custName("Hanu");
		logger.info("Entered name");
		addcust.custGender();
		logger.info("Selected Gender");
		addcust.custDOB("01","01" ,"1999");
		logger.info("Entered DOB");
		Thread.sleep(3000);
		addcust.custAddress("Bareilly");
		logger.info("Entered Address");
		addcust.custCity("Bareilly");
		logger.info("Entered City");
		addcust.custState("UP");
		logger.info("Entered State");
		addcust.custPin("243001");
		logger.info("Entered PIN");
		addcust.custMobileno("8126505692");
		logger.info("Entered Mobilenumber");
		String email=randomString()+"@gmail.com";
		addcust.custEmailId(email);
		logger.info("Entered Email");
		addcust.custPassword("ddasgsdgs");
		logger.info("Entered Password");
		addcust.custSubmit();
		logger.info("Clicked on submit button");
		Thread.sleep(3000);
		
		logger.info("validation started");
		
		if(driver.getPageSource().contains("Customer Registered Successfully!!!")) {
			logger.info("test case passed");
			Assert.assertTrue(true);
			
		}else {
			captureScreen(driver, "addNewCustomer"+randomString());
			logger.info("test case failed");
			Assert.assertTrue(false);
			
			
		}
		}
		
	
	public static void hideElement(String xpath)
	{
	    WebElement element = driver.findElement(By.xpath(xpath));
	    ((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", element);
	}

	
	
	

}
