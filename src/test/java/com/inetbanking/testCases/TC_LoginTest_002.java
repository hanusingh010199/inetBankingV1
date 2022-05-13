package com.inetbanking.testCases;

import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;


public class TC_LoginTest_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String username, String password) throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		lp.clickSubmit();
		logger.info("Clicked on Login button");
		
		Thread.sleep(4000);
		
		/*
		 * if(isAlertPresent()==true) { logger.warn("login failed");
		 * captureScreen(driver, "LoginTest"+randomString());
		 * driver.switchTo().alert().accept(); Assert.assertTrue(true);
		 * driver.switchTo().defaultContent(); }
		 * 
		 * else { Assert.assertTrue(true); logger.warn("login passed");
		 * lp.logoutOfApplication(); Thread.sleep(4000);
		 * driver.switchTo().alert().accept(); driver.switchTo().defaultContent();
		 * 
		 * }
		 */
		
		 if(isAlertPresent()==false){
			 Assert.assertTrue(true); 
			 logger.warn("login passed");
		     lp.logoutOfApplication(); 
		     Thread.sleep(4000);
		     driver.switchTo().alert().accept(); 
		     driver.switchTo().defaultContent();
		 }
		     
		  else { 
			 logger.warn("login failed");
			 String value=driver.switchTo().alert().getText();
			 logger.info("Alert value " + value);
			 Thread.sleep(4000);
			 Assert.assertEquals(value,"User or Password is not valid");
			 driver.switchTo().alert().accept(); 
			 captureScreen(driver, "LoginTest"+randomString());
			 driver.switchTo().defaultContent(); 
			 
			 }
		 
		 }
	
	
	public boolean isAlertPresent() { //user defined method to check alert is present or not
		try {
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException e) {
		return false;
			
			
		}
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		
		String path = System.getProperty("user.dir") +"/src/test/java/com/inetbanking/testData/Login.xlsx";
		 int rowcount     = XLUtils.getRowCount(path, "Sheet1");
		 int coloumncount = XLUtils.getCellCount(path, "Sheet1", 1);
		 
		 String logindata[][]=new String[rowcount][coloumncount];
		 
		 for(int i=1;i<=rowcount;i++) {
			 for(int j=0;j<coloumncount;j++) {
				 logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				 
			 }
		 }
		 return logindata;
		
	}
	
	

}
