package Step_Definition;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.io.IOException;

public class Circles_negative_scenarios extends Generic_functions{
	public static boolean value;
	public static String str;

	/*TC 001 - Validate that Proceed button is disabled and do not select a provider from the drop down */
	@Given("User is on landing page")
	public void browser_launching() throws Exception {
		try {
			app_launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	@When("Drop down list is clicked and No selection is made")
	public static void click_dropdown() throws Exception {
		try {
			app_login(9,0);
			page_wait(5000);
			click("circles");
			page_wait(5000);
		}
		catch (Exception e){
			e.printStackTrace();
			takeScreenShot("circle_negative_click_dropdown");
		}
	}
	@Then("Proceed to next page")
	public static void proceed_to_next_page() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("circles_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(5000);
			click("circles_add_partner_button");
			page_wait(5000);
			value = driver.findElement(By.xpath(OR_reader("circles_add_patner_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			Assert.assertEquals(driver.findElement(By.xpath(OR_reader("circles_proceed_button"))).isEnabled(),true);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_negative_proceed_to_next_page");
		}
	}

	/*TC 002 - Validate login when Username and Password fields are blank*/
	@When("Enter Username and password blank")
	public static void Username_Password() throws IOException {
		page_wait(2000);
		click("circles_add_partner_dropdown");
		page_wait(2000);
		click("circles_mymedicare_option");
		page_wait(2000);
		click("circles_proceed_button");
		page_wait(2000);
		click("circles_mymedicare_username");
		click("circles_mymedicare_password");
		click("circles_mymedicare_login_button");
	}
	@Then("Validate the error message on text fields")
	public static void validate_the_error_msg() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("mymed_username_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_username_valid_msg"));
			str= driver.findElement(By.xpath(OR_reader("mymed_password_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_password_valid_msg"));
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/*TC 003 - Validate invalid Username  and Password in the Login Page*/
	@When("Enter incorrect Username and Password")
	public static void incorrect_username_password() throws IOException {
		driver.findElement(By.xpath(OR_reader("circles_mymedicare_username"))).sendKeys(td_reader("circles_mymedicare_username",0));
		driver.findElement(By.xpath(OR_reader("circles_mymedicare_password"))).sendKeys(td_reader("circles_mymedicare_password",0));
		click("circle_login");
	}
	@Then("verify error message for incorrect username and password")
	public static void verify_error_msg() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("mymed_incorrect_cred_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_incorrect_cred_msg"));
			field_clear("circles_mymedicare_username");
			field_clear("circles_mymedicare_password");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_negative_verify_error_msg");
		}	
	}

	/*TC 004 - Validate when Username field is blank*/
	@When("Enter Username field as blank and valid password")
	public static void incorrect_username() throws IOException {
		click("circles_mymedicare_password");
		driver.findElement(By.xpath(OR_reader("mymed_password"))).sendKeys(td_reader("mymed_password",0));
		click("circles_mymedicare_login_button");
	}
	@Then("Validate the error message when username is blank")
	public static void validate_error_msg() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("mymed_password_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_password_valid_msg"));
			field_clear("circles_mymedicare_username");
			field_clear("circles_mymedicare_password");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_negative_validate_error_msg");
		}	
	}

	/*TC 005 -Validate when Password field is blank*/
	@When("Enter the password as blank")
	public static void enter_password() throws Exception {
		driver.findElement(By.xpath(OR_reader("mymed_username"))).sendKeys(td_reader("mymed_username",0));
		click("circles_mymedicare_login_button");
	}
	@Then("Validate message when Password field is blank")
	public static void validate_msg() throws Exception {
		try {
			field_clear("circles_mymedicare_username");
			field_clear("circles_mymedicare_password");
			str= driver.findElement(By.xpath(OR_reader("mymed_blank_credential_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_blank_credential_msg"));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_negative_validate_msg");
		}	
	}

	/*TC 006 - Validate the login with valid Usename and invalid Password */
	@When("login with valid Username and invalid Password")
	public static void login_username_invalid_password() throws IOException {
		driver.findElement(By.xpath(OR_reader("circles_mymedicare_username"))).sendKeys(td_reader("mymed_username",1));
		driver.findElement(By.xpath(OR_reader("circles_mymedicare_password"))).sendKeys(td_reader("mymed_password",0));
		click("circles_mymedicare_login_button");
	}
	@Then("Validation message invalid password")
	public static void validation_msg_on_invalid_username() throws Exception {
		try {
			field_clear("circles_mymedicare_username");
			field_clear("circles_mymedicare_password");
			str= driver.findElement(By.xpath(OR_reader("mymed_blank_credential_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_blank_credential_msg"));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_negative_validation_msg_on_invalid_username");
		}	
	}

	/*TC 007 -Validate that the user is not allowed to login with invalid Usename and valid Password*/
	@When("login with invalid Username and valid Password")
	public static void login_invalid_username() throws IOException {
		driver.findElement(By.xpath(OR_reader("circles_mymedicare_login_button"))).sendKeys(td_reader("mymed_username",0));
		driver.findElement(By.xpath(OR_reader("circles_mymedicare_password"))).sendKeys(td_reader("mymed_password",1));
		click("circles_mymedicare_login_button");
	}
	@Then("Validation message invalid username")
	public static void validation_msg() throws Exception {
		try {
			field_clear("circles_mymedicare_login_button");
			field_clear("circles_mymedicare_password");
			str= driver.findElement(By.xpath(OR_reader("mymed_blank_credential_msg"))).getText();
			Assert.assertEquals(str,td_reader("mymed_blank_credential_msg"));
			click("home");
			click("hamburger");
			click("logout");
			close();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("circle_negative_validation_msg");
		}	
	}
}
