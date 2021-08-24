package Step_Definition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Your_profile_positive_scenarios extends Generic_functions{
	public static boolean value;
	public static String text; 

	/*Application launch*/
	@Given("App is open")
	public void app_launching() throws Exception {
		try {
			app_launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("Enter login data")
	public void enter_login_data() throws Exception {
		try {
			app_login(9,0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*TC 001 - Validate that the  Your Profile  title  should be present in  Your Profile screen */
	@Then("check Your Profile  title  should be present in  Your Profile screen")
	public void yourprofile_positive_tc_001() throws Exception  {
		try {
			click("home");
			click("hamburger");
			System.out.println("1.2");
			click("profile");
			value = driver.findElement(By.xpath(OR_reader("prof_img_icon"))).isDisplayed();
			Assert.assertEquals(true,value);
			System.out.println("1.3");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_001");
		}

	}

	/*TC 002 - Verify the scenario when dialogue box will appear, when click on edit icon*/
	@Given("Click on edit icon")
	public void yourprofile_positive_tc_002() throws Exception {
		try {
			stale_click("prof_edit_icon");
			page_wait(30);	
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_002");
		}	
	}

	@When("Verify the dialogue box")
	public void verify_dialogue_box() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("prof_dialouge_box"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Verify_dialogue_box");
		}
	}

	@Then("Add OTP and password")
	public void add_otp_password() throws Exception {
		try {
			stale_click("prof_send_code_button");
			page_wait(30);
			driver.findElement(By.xpath(OR_reader("prof_security_code"))).sendKeys(td_reader("prof_otp"));
			driver.findElement(By.xpath(OR_reader("prof_password"))).sendKeys(td_reader("login_password",0));
			page_wait(30);
			stale_click("prof_verify_button");
			stale_click("prof_ok_button");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("add_otp_password");
		}
	}

	/*TC 003 - Verify the scenario when edit  the profile details*/
	@Then("Edit  the profile details")
	public void yourprofile_positive_tc_003() throws Exception {
		try {
			stale_click("prof_edit_icon");
			page_wait(20);
			field_clear("prof_fname");
			field_clear("prof_lname");
			field_clear("prof_pname");
			driver.findElement(By.xpath(OR_reader("prof_fname"))).sendKeys(td_reader("prof_fname"));
			driver.findElement(By.xpath(OR_reader("prof_lname"))).sendKeys(td_reader("prof_lname"));
			driver.findElement(By.xpath(OR_reader("prof_pname"))).sendKeys(td_reader("prof_pname"));
			page_wait(20);
			stale_click("prof_gender_drop_down");
			page_wait(10);
			text = td_reader("prof_gender");
			drop_down(OR_reader("prof_gender_drop_list"),text); 
			stale_click("prof_blood_drop_down");		
			page_wait(10);
			text = td_reader("prof_blood_group");
			drop_down(OR_reader("prof_gender_drop_list"),text); 
			stale_click("prof_calendar_icon");
			page_wait(10);
			stale_click("prof_save_button");
			stale_click("prof_save_ok_button");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_003");
		}
	}

	/*TC 004 - Verify the scenario when add Email ID in contact details*/
	@And("Add Email ID in contact details")
	public void yourprofile_positive_tc_004() throws Exception  {
		try {
			page_wait(10);
			stale_click("prof_contact_details");
			value = driver.findElement(By.xpath(OR_reader("prof_contact_details_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(10);
			stale_click("prof_contact_plus");
			value = driver.findElement(By.xpath(OR_reader("prof_email_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(10);
			driver.findElement(By.xpath(OR_reader("prof_email_field"))).sendKeys(td_reader("prof_email_field"));
			stale_click("prof_email_submit_button");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_004");
		}
	}

	/*TC 005 - Verify the scenario when Activate , Edit and  Deactivate the Email ID  */
	@When("Activate , Edit and  Deactivate the Email ID")
	public void yourprofile_positive_tc_005() throws Exception {
		try {
			stale_click("prof_contact_edit_icon");
			stale_click("prof_email_activate");
			stale_click("prof_active_mail_yes_button");
			stale_click("prof_mail_activated_ok");
			stale_click("prof_email_three_dot");
			page_wait(10);
			text = td_reader("prof_deactivate");
			drop_down(OR_reader("prof_deactivate_list"),text); 
			stale_click("prof_deactivate_list");
			stale_click("deactivate_mail_yes");
			stale_click("prof_email_deactivate_ok");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_005");
		}
	}

	/*TC 006 - Verify the scenario when Activate , Edit and  Deactivate Email ID*/
	@Then("Add Phone Number in contact details")
	public void yourprofile_positive_tc_006() throws Exception {

		try {
			stale_click("prof_phone_number");
			stale_click("prof_contact_plus");
			value = driver.findElement(By.xpath(OR_reader("prof_add_number_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			driver.findElement(By.xpath(OR_reader("prof_add_phone_number_field"))).sendKeys(td_reader("prof_add_phone_number_field"));
			click("prof_add_phone_number_submit");
			stale_click("prof_enter_code_field");
			driver.findElement(By.xpath(OR_reader("prof_enter_code_field"))).sendKeys(td_reader("prof_otp"));
			stale_click("prof_enter_code_verify_button");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_006");
		}
	}

	/*TC 007 - Verify the scenario when Activate , Edit and  Deactivate the Phone Number */
	@Then("Activate , Edit and  Deactivate the Phone Number")
	public void yourprofile_positive_tc_007() throws Exception {
		try {
			page_wait(10);
			stale_click("prof_phone_number");
			value = driver.findElement(By.xpath(OR_reader("profile_contact_assert"))).isDisplayed();
			Assert.assertEquals(true,value);
			stale_click("prof_email_activate");
			stale_click("prof_active_mail_yes_button");
			stale_click("prof_phone_activated_ok");
			stale_click("prof_phone_three_dot");
			page_wait(10);
			text = td_reader("prof_deactivate");
			drop_down(OR_reader("prof_deactivate_list"),text); 
			stale_click("prof_deactivate_list");
			stale_click("deactivate_mail_yes");
			stale_click("prof_mail_deactivated_ok");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_007");
		}

	}

	/*TC 008 - VVerify the scenario when add Address in contact details. */
	@Then("Add Address in contact details.")
	public void yourprofile_positive_tc_008() throws Exception {
		try {
			page_wait(60);
			stale_click("prof_address");
			stale_click("prof_contact_plus");
			value = driver.findElement(By.xpath(OR_reader("prof_address"))).isDisplayed();
			Assert.assertEquals(true,value);
			stale_click("your_prof_save_as");
			driver.findElement(By.xpath(OR_reader("prof_save_as"))).sendKeys(td_reader("prof_save_as"));
			stale_click("your_prof_add1");
			driver.findElement(By.xpath(OR_reader("prof_add1"))).sendKeys(td_reader("prof_add1"));
			stale_click("your_prof_add2");
			driver.findElement(By.xpath(OR_reader("prof_add2"))).sendKeys(td_reader("prof_add2"));
			stale_click("your_prof_city");
			driver.findElement(By.xpath(OR_reader("prof_city"))).sendKeys(td_reader("prof_city"));
			stale_click("prof_state");
			text = td_reader("prof_state");
			drop_down("profile_state",text);
			stale_click("prof_zip");
			driver.findElement(By.xpath(OR_reader("prof_zip"))).sendKeys(td_reader("prof_zip"));
			click("prof_save_address_button");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_008");
		}
	}

	/*TC 009 - Verify the scenario when Activate , Edit , Primary and  Deactivate the Address */
	@Then("Activate , Edit , Primary and  Deactivate the Address")
	public void yourprofile_positive_tc_009() throws Exception {
		try {
			page_wait(10);
			value = driver.findElement(By.xpath(OR_reader("prof_address"))).isDisplayed();
			Assert.assertEquals(true,value);
			stale_click("prof_address_activate");
			stale_click("prof_active_mail_yes_button");
			stale_click("prof_phone_activated_ok");
			stale_click("prof_address_three_dot");
			page_wait(10);
			text = td_reader("prof_deactivate");
			drop_down(OR_reader("prof_deactivate_list"),text); 
			stale_click("prof_address_deactivate");
			stale_click("deactivate_mail_yes");
			stale_click("prof_mail_deactivated_ok");			
			stale_click("prof_address_activate");
			stale_click("prof_active_mail_yes_button");
			stale_click("prof_phone_activated_ok");
			stale_click("prof_address_three_dot");
			page_wait(10);
			text = td_reader("prof_deactivate");
			drop_down(OR_reader("prof_deactivate_list"),text); 
			stale_click("prof_address_primary");
			stale_click("deactivate_mail_yes");
			stale_click("prof_mail_deactivated_ok");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_009");
		}
	}

	/*TC 010 - Verify the scenario when add Plan coverage*/
	@Then("Add Plan coverage")
	public void yourprofile_positive_tc_010() throws Exception {
		try {
			page_back();
			page_wait(10);
			stale_click("prof_plan_coverage");
			value = driver.findElement(By.xpath(OR_reader("prof_plan_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			stale_click("prof_contact_plus");
			value = driver.findElement(By.xpath(OR_reader("prof_plan_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			driver.findElement(By.xpath(OR_reader("prof_plan_insurer_name"))).sendKeys(td_reader("your_prof_plan_insurer_name"));
			driver.findElement(By.xpath(OR_reader("prof_plan_fn_policy_holder"))).sendKeys(td_reader("your_prof_plan_fn_policy_holder"));
			driver.findElement(By.xpath(OR_reader("prof_plan_ln_policy_holder"))).sendKeys(td_reader("your_prof_plan_ln_policy_holder"));
			stale_click("prof_plan_relationship");
			page_wait(10); 
			//scroll_click("self");
			driver.findElement(By.xpath(OR_reader("prof_plan_mid"))).sendKeys(td_reader("your_prof_plan_mid"));
			driver.findElement(By.xpath(OR_reader("prof_plan_gid"))).sendKeys(td_reader("your_prof_plan_gid"));
			driver.findElement(By.xpath(OR_reader("prof_plan_type"))).sendKeys(td_reader("your_prof_plan_type"));
			stale_click("prof_plan_save");
			stale_click("prof_mail_deactivated_ok");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_010");
		}
	}

	/*TC 011 - Verify the scenario when Activate , Edit , Make primary and  Deactivate the Plan coverage*/
	@Then("Activate , Edit , Make primary and  Deactivate the Plan coverage")
	public void yourprofile_positive_tc_011() throws Exception {
		try {
			stale_click("prof_plan_coverage");
			page_wait(10);
			stale_click("prof_plan_edit_icon");
			stale_click("prof_plan_three_dot");
			stale_click("prof_address_primary");
			stale_click("prof_active_mail_yes_button");
			stale_click("prof_plan_three_dot");
			stale_click("prof_deactivate_list");
			stale_click("deactivate_mail_yes");
			stale_click("prof_email_deactivate_ok");
			page_wait(10);
			text = td_reader("profile_dot");
			drop_down(OR_reader("your_prof_address_primary"),text);		        
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_011");
		}
	} 

	/*TC 012 - Verify the scenario when changing the password*/
	@Then("Change the password")
	public void yourprofile_positive_tc_012() throws Exception {
		try {
			page_wait(10);
			//browser_back();
			stale_click("prof_edit_password");
			value = driver.findElement(By.xpath(OR_reader("prof_password_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			stale_click("prof_old_password");
			driver.findElement(By.xpath(OR_reader("prof_old_password"))).sendKeys(td_reader("your_prof_old_password"));
			stale_click("prof_new_password");
			driver.findElement(By.xpath(OR_reader("prof_new_password"))).sendKeys(td_reader("your_prof_new_password"));
			stale_click("prof_confirm_password");
			driver.findElement(By.xpath(OR_reader("prof_confirm_password"))).sendKeys(td_reader("your_prof_confirm_password"));
			stale_click("prof_pass_save_button");
			stale_click("prof_phone_activated_ok");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_012");
		}

	}

	/*TC 013 - Verify the scenario when password should be displayed on clicking the eye and user can able to save the details*/
	@Then("The password should be displayed on clicking the eye")
	public void yourprofile_positive_tc_013() throws Exception {
		try {
			stale_click("prof_edit_password");
			stale_click("prof_old_password");
			driver.findElement(By.xpath(OR_reader("prof_old_password"))).sendKeys(td_reader("your_prof_old_password"));
			stale_click("prof_old_pass_eye");
			stale_click("prof_new_password");
			driver.findElement(By.xpath(OR_reader("prof_new_password"))).sendKeys(td_reader("your_prof_new_password"));
			stale_click("prof_new_pass_eye");
			stale_click("prof_confirm_password");
			driver.findElement(By.xpath(OR_reader("your_prof_confirm_password"))).sendKeys(td_reader("your_prof_confirm_password"));
			stale_click("prof_confirm_pass_eye");
			stale_click("prof_pass_save_button");
			stale_click("prof_phone_activated_ok");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_013");
		}	
	}
}

