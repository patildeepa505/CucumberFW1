package com.vtiger.pages;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.utilities.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends PageActions {

private WebDriver driver;
	
	//use constructor 
	public Homepage(WebDriver driver, ExtentTest logger) {

      //  this.driver = driver;
		super(driver,logger);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Logout")
	WebElement lnk_logout;
	
	@FindBy(linkText="Home")
	WebElement lnk_Home;
	
    public void Click_logout() {
		
    //	lnk_logout.click();
		//clickElement(lnk_logout);

		clickElement(lnk_logout,"Link Logout clicked");

	}
	public void validate_logout() {
	//	lnk_logout.isDisplayed();

		//before defining the logger
		//isElementExist(lnk_logout);

		//after logger defined
		isElementExist(lnk_logout,"Link Logout is displayed");


	}
	public void validate_home() {
	//	lnk_Home.isDisplayed();
		//before defining the logger
     //   isElementExist(lnk_Home);

		//after logger defined
		isElementExist(lnk_Home,"Link Home is displayed");

	}
	
}
