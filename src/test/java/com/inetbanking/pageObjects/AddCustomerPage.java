package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.XPATH, using="//a[text()='New Customer']")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	
	
	@FindBy(how=How.NAME, using="name")
	@CacheLookup
	WebElement Customer_Name;
	
	@FindBy(how=How.NAME, using="rad1")
	@CacheLookup
	WebElement Gender;
	
	@FindBy(how=How.ID, using="dob")
	@CacheLookup	
	WebElement Date_of_Birth;
	
	@FindBy(how=How.NAME, using="addr")
	@CacheLookup
	WebElement Address;
	
	@FindBy(how=How.NAME, using="city")
	@CacheLookup
	WebElement City;
	
	@FindBy(how=How.NAME, using="state")
	@CacheLookup
	WebElement State;
	
	@FindBy(how=How.NAME, using="pinno")
	@CacheLookup
	WebElement PIN;
	
	@FindBy(how=How.NAME, using="telephoneno")
	@CacheLookup
	WebElement Mobile_Number;
	
	@FindBy(how=How.NAME, using="emailid")
	@CacheLookup
	WebElement Email;
	
	@FindBy(how=How.NAME, using="password")
	@CacheLookup
	WebElement Password;
	
	@FindBy(how=How.XPATH, using="//input[@name='sub']")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	
	public void custName(String cname) {
		Customer_Name.sendKeys(cname);
	}
	
	public void custGender() {
		Gender.click();	
	}
	
	public void custDOB(String mm, String dd, String yyyy) {
		Date_of_Birth.sendKeys(String.valueOf(mm));
		Date_of_Birth.sendKeys(String.valueOf(dd));
		Date_of_Birth.sendKeys(String.valueOf(yyyy));
	}
	
	public void custAddress(String caddress) {
		Address.sendKeys(caddress);
	}
	
	public void custCity(String ccity) {
		City.sendKeys(ccity);
	}
	
	public void custState(String cstate) {
		State.sendKeys(cstate);
	}
	
	public void custPin(String cpin) {
		PIN.sendKeys(String.valueOf(cpin));
	}
	
	
	
	public void custMobileno(String cmobileno) {
		Mobile_Number.sendKeys(String.valueOf(cmobileno));
	}
	
	public void custEmailId(String cemailid) {
		Email.sendKeys(cemailid);
	}
	
	public void custPassword(String cpassword) {
		Password.sendKeys(cpassword);
	}
	
	public void custSubmit() {
		btnSubmit.click();
	}
	
	
	

}
