package com.vtiger.stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.Homepage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class LoginSteps extends BaseStep {
	
//public WebDriver driver; bcoz it declare into another class and extends parent class

	//cucumber hooks --like testng
	@Before
	public void getScenarioName(Scenario scenario)
	{
		if(extent== null)
		{
		createExtentReport();
		}
      ScenarioName =scenario.getName();
	  logger = extent.createTest(ScenarioName);
	}
@After
public void teardown()
{
	extent.flush();
	driver.quit();
}


	@Given("user should be login page")
	public void user_should_be_login_page() throws Exception {
		//replace the code with after add config prop file
		launchApp();
		logger.info("Application launched");

		//before the config prop
		//driver=new ChromeDriver();
		//driver.get("http://localhost:100/index.php?action=Login&module=Users");
	  //login page obj call krycha--driver invoke krav lgnar
		lp = new LoginPage(driver,logger);
		hp = new Homepage(driver,logger);
		leadpage= new LeadPage(driver,logger);

	}

	@When("user enter the valid credential")
	public void user_enter_the_valid_credential() {
		//lp.login("admin", "admin");
        //by using map we extract the dtaa

		lp.login(dt.get(ScenarioName).get("Userid"),dt.get(ScenarioName).get("Password"));
	}

	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
		hp.validate_home();
	}
	@Then("user can see the logout link")
	public void user_can_see_the_logout_link() {
		hp.validate_logout();

	}	

   @When("user enter the invalid credential")
    public void user_enter_the_invalid_credential()
   {
	   lp.login("admin123", "admin23");
}
   @Then("user can see the error message")
    public void user_can_see_the_error_message()
   {
 //	driver.findElement(By.xpath("//*[contains(text(),'You must specify a valid username and password.')]")).isDisplayed();
   //    lp.validate_Error_message();
//read data from excel by using map
	   lp.login(dt.get(ScenarioName).get("userid"),dt.get(ScenarioName).get("password"));
	}

@When("user enter the invalid userid as {string} and password is {string}")
public void user_enter_the_invalid_userid_as_and_password_is(String user, String pwd) {
	lp.login(user, pwd);
    
}
}
