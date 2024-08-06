package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.utilities.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage extends PageActions {

//	private WebDriver driver;
	
	public LeadPage(WebDriver driver, ExtentTest logger) {

		//this.driver = driver;
		super(driver,logger);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="New Lead")
	WebElement lnk_newlead;
	
	@FindBy(name="lastname")
	WebElement tb_lastname;
	
	@FindBy(name="company")
	WebElement tb_company;
	
	@FindBy(name="button234")
	WebElement tb_save;
	
	public void clicknewlead() {

		//lnk_newlead.click();
		//by using common-utilitise functions/methods used
		clickElement(lnk_newlead , " New lead is clickable");

	}
	
    public void createlead(String lname,String comp) {
	/*	lnk_newlead.click();
    	tb_lastname.sendKeys(lname);
    	tb_company.sendKeys(comp);
    	tb_save.click();
    	*/
	//here code is without logger file --its by using xommon utlities
	/*	clickElement(lnk_newlead);
		setInput(tb_lastname,lname);
		setInput(tb_company,comp);
		clickElement(tb_save);
*/
		setInput(tb_lastname,lname,lname+" has been entered into lastname field");
		setInput(tb_company,comp,comp+" has been entered into company field");
		clickElement(tb_save,"Save button clicked");

	}

	/*
    public void validate_logout() {
		lnk_logout.isDisplayed();
		
	}
	public void validate_home() {
		lnk_Home.isDisplayed();
		
	}*/

}
