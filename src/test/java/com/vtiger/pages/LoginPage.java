package com.vtiger.pages;


import com.aventstack.extentreports.ExtentTest;
import com.vtiger.utilities.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageActions {
	
	private WebDriver driver;
	
	//use constructor 
	public LoginPage(WebDriver driver , ExtentTest logger) {
		
        super(driver,logger);   //child call krega parent class ka methos
		//this.driver= driver ;   abhi jrurt nahi kyu parent ki metho call krna hai toh super use krnge
		PageFactory.initElements(driver, this);
		
	}
	
	//first way to declare the variable
   //private String uid="user_name";
	
	// By uid= By.name("user_name");
	
	//By pwd =By.name("user_password");
	
	
	@FindBy(name="user_name")
	WebElement tb_uid;
	
	@FindBy(name="user_password")
	WebElement tb_pwd;
	
	@FindBy(xpath="//select[@name='login_theme']")
	WebElement dp_theme;
	
	@FindBy(name="Login")
	WebElement btn_login;
	
	@FindBy(xpath="//*[contains(text(),'You must specify a valid username and password')]")
	WebElement err_msg;
	
	//code completely dynamic kela --basestep madhe login page ch obj krycha create
	
	
	public void validate_Error_message() {
		
		err_msg.isDisplayed();
	}
	
    public void login(String userid , String pwd) {
	//	driver.findElement((uid)).sendKeys(userid);
    /*by using Page factory
    	tb_uid.sendKeys(userid);
		 tb_pwd.sendKeys(pwd);
		btn_login.click() --replace by using common methods

     */
		setInput(tb_uid,userid,userid+ "admin has been entered into username field");
		setInput(tb_pwd,pwd,pwd+ " has been entered into password field");
		clickElement(btn_login,"login button clicked");
	}

	public void login(String userid,String pwd , String them) {
	/*tb_uid.sendKeys(userid);
	tb_pwd.sendKeys(pwd);
	dp_theme.sendKeys(them);
	btn_login.click();  */

		//by using common utilise
		//without logger dunctionality
		/*setInput(tb_uid,userid);

		setInput(tb_pwd,pwd);
		selectVisibletext(dp_theme,them);
		clickElement(btn_login); */
		//we can use logger here
		setInput(tb_uid,userid,userid+ "admin has been entered into username field");
		setInput(tb_pwd,pwd,pwd+ " has been entered into password field");
		selectVisibletext(dp_theme,them, them + "blue has been selected from dropdown");
		clickElement(btn_login,"login button clicked");
	}
	
/*	public void login(String userid,String pwd , String them,String Lang) {
		tb_uid.sendKeys(userid);
		tb_pwd.sendKeys(pwd);
		dp_theme.sendKeys(them);
		btn_login.click();
		} */
}
