package com.vtiger.stepdefinitions;
import java.util.List;
import org.openqa.selenium.By;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Leads extends BaseStep {
	
	@When("user fill the mandatory fileds as {string} and  {string}")
	public void user_fill_the_mandatory_fileds_as_and(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
		//apn list rows and column cha data ghetoy tr aplyla < list of list> ghyv lagnr
		
	List<List<String>> ls = dataTable.asLists();
	
	for(List<String> s : ls)
	{
		/*
		 * driver.findElement(By.linkText("New Lead")).click();
		 * driver.findElement(By.name("lastname")).sendKeys(s.get(0));
		 * driver.findElement(By.name("company")).sendKeys(s.get(1));
		 * driver.findElement(By.name("button")).click();
		 */
		leadpage.clicknewlead();
       leadpage.createlead(s.get(0), s.get(1));
		
	}
	}
	
	@Then("lead should be created successfully")
	public void lead_should_be_created_successfully() {
		
  
	}
	@Then("click on logout")
	public void click_on_logout() {
	  
     hp.validate_logout();
      
  }
}
