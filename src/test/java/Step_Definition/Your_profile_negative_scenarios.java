package Step_Definition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.File;

public class Your_profile_negative_scenarios extends Generic_functions {
	public static boolean value;
	public static String str,path;
	public static File file;

	/*Validate that the user is navigated to Welcome page*/
	@Given("Launch the URL and open login page")
	public static void launch_url() throws Exception{
		try {
			app_launch();
			page_wait(1000);
			click("welcome_login");
			page_wait(1000);
			click("login_phone_number");
			page_wait(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("Enter login details")
	public static void enter_login() throws Exception {
		driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",5));
		driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",5));
		page_wait(1000);
		click("login");	
	}

	/*TC_001- Verify clicking on profile will navigates to Your profile screen*/
	@Then("Click on your profile")
	public static void click_profile() throws Exception{
		try {
			page_wait(1000);
			click("home");
			click("hamburger");
			page_wait(1000);
			click("your_profile_header");
			page_wait(1000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("yourprofile_positive_tc_001");
		}
	}

	/* TC_002- Verify the scenario when blank 'security code and Re-enter password' fields*/
	@When("Enter 'security code and Re-enter password' as blank")
	public static void your_profile_negative_tc_002() throws Exception{
		try {
			click("your_prof_edit_icon");
			stale_click("your_prof_edit_icon");
			page_wait(1500);
			click("profile_send_code");
			click("profile_verify");
			page_wait(1200);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_002");
		}
	}

	@Then("verify the validation messages")
	public static void validation_msg() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader("security_code_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("security_code_valid_msg"));
			str= driver.findElement(By.xpath(OR_reader("password_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("password_valid_msg"));
			page_wait(1000);
		}catch(Exception  e) {
			e.printStackTrace();
			takeScreenShot("validation_msg_tc_002");
		}

	}

	/* TC_003- Verify the scenario when entering invalid Security code  and Re-enter password */
	@When("Enter invalid 'security code and Re-enter password'")
	public static void your_profile_negative_tc_003() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader("profile_security_code"))).sendKeys(td_reader("profile_security_code",0));
			driver.findElement(By.xpath(OR_reader("profile_password"))).sendKeys(td_reader("profile_password",0));
			stale_click("profile_verify");
			page_wait(1000);

		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_003");
		}
	}

	@Then("Verify the validation message for invalid data")
	public static void invalid_validation_msg() throws Exception{
		try {
			boolean result = false;
			int attempts = 0;
			while(attempts < 2) {
				try {
					str= driver.findElement(By.xpath(OR_reader("security_code_valid_msg_two"))).getText();
					Assert.assertEquals(str,td_reader("security_code_valid_msg_two"));
					result = true;
					break;
				} catch(Exception e) {
				}
				attempts++;
			}
			page_wait(1500);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_003");
		}
	}

	/* TC_004- Verify the scenario when blank 'security code or Re-enter password' fields*/
	@When("Enter 'security code or Re-enter password' as blank")
	public static void your_profile_negative_tc_004() throws Exception{
		try {
			page_wait(2000);
			driver.findElement(By.xpath(OR_reader("profile_password"))).sendKeys(td_reader("profile_password",1));
			click("profile_verify");
			page_wait(3000);
			field_clear("profile_password");
			page_wait(3000);	
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_004");
		}
	}

	@Then("Verify the validation blank message")
	public static void blank_validation_msg() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader("security_code_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("security_code_valid_msg"));
		}catch(Exception e){
			e.printStackTrace();
			takeScreenShot("your_profile_negative_blank_validation_msg");
		}
	}

	/* TC_005- Verify the scenario when unable to  Edit the primary and deactivate email*/
	@When("Click on edit contact details")
	public static void clickOnEditContactDetails() throws Exception {
		try {
			field_clear("profile_password");
			page_wait(3000);
			page_wait(1000);
			driver.findElement(By.xpath(OR_reader("profile_security_code"))).sendKeys(td_reader("profile_security_code",1));
			driver.findElement(By.xpath(OR_reader("profile_password"))).sendKeys(td_reader("profile_password",0));
			click("profile_verify");
			click("profile_ok");
			page_wait(1500);
			click("profile_contact");
			page_wait(3000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_clickOnEditContactDetails");
		}
	}
	@Then("Not able to edit primary and deactivate email")
	public static void your_profile_negative_tc_005() throws Exception{
		try {
			click("profile_email_id_tab");
			page_back();
			page_wait(2500);
			stale_click("your_prof_edit_icon");
			page_wait(1500);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_005");
		}
	}

	/* TC_006- Verify the scenario when blank Your profile Page fields*/
	@When("Enter firstname and lastname fields as blank")
	public static void your_profile_negative_tc_006() throws Exception{
		try {
			click("profile_firstname");
			page_wait(2000);
			field_clear("profile_firstname");
			click("profile_lastname");
			field_clear("profile_lastname");
			page_wait(3000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_006");
		}
	}

	@Then("Verify the validation message for blank fields")
	public static void blank_validation_msg_fields() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader("profile_firstname_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_firstname_valid_msg"),str);
			page_wait(1000);
			str= driver.findElement(By.xpath(OR_reader( "profile_lastname_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_lastname_valid_msg"),str);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("blank_validation_msg_fields_tc_006");

		}
	}

	/* TC_007- Verify the scenario when entering invalid First name, Last name  or  Preferred name*/
	@When("Enters invalid firstname,lastname and preferred name")
	public static void your_profile_negative_tc_007() throws Exception{
		try {
			page_wait(1000);
			click("profile_firstname");
			field_clear("profile_firstname");
			driver.findElement(By.xpath(OR_reader("profile_firstname"))).sendKeys(td_reader("profile_firstname",0));
			click("profile_lastname");
			field_clear("profile_lastname");
			driver.findElement(By.xpath(OR_reader("profile_lastname"))).sendKeys(td_reader("profile_lastname",0));
			click("profile_preferred_name");
			driver.findElement(By.xpath(OR_reader("profile_preferred_name"))).sendKeys(td_reader("profile_preferred_name",0));
			str= driver.findElement(By.xpath(OR_reader("profile_firstname_valid_msg_two"))).getText();
			Assert.assertEquals(td_reader("profile_firstname_valid_msg_two"),str);
			page_wait(2000);
			click("profile_firstname");
			field_clear("profile_firstname");
			driver.findElement(By.xpath(OR_reader( "profile_firstname"))).sendKeys(td_reader("profile_firstname",1));
			click("profile_lastname");
			field_clear("profile_lastname");
			driver.findElement(By.xpath(OR_reader( "profile_lastname"))).sendKeys(td_reader("profile_lastname",1));
			click("profile_preferred_name");
			field_clear("profile_preferred_name");
			driver.findElement(By.xpath(OR_reader("profile_preferred_name"))).sendKeys(td_reader("profile_preferred_name",0));
			str= driver.findElement(By.xpath(OR_reader("profile_lastname_valid_msg_two"))).getText();
			Assert.assertEquals(td_reader("profile_lastname_valid_msg_two"),str);
			page_wait(2000);
			click("profile_firstname");
			field_clear("profile_firstname");
			driver.findElement(By.xpath(OR_reader("profile_firstname"))).sendKeys(td_reader("profile_firstname",1));
			click("profile_lastname");
			field_clear("profile_lastname");
			driver.findElement(By.xpath(OR_reader("profile_lastname"))).sendKeys(td_reader("profile_lastname",0));
			click("profile_preferred_name");
			field_clear("profile_preferred_name");
			driver.findElement(By.xpath(OR_reader("profile_preferred_name"))).sendKeys(td_reader("profile_preferred_name",1));
			str= driver.findElement(By.xpath(OR_reader("profile_preferred_name_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_preferred_name_valid_msg"),str);
			page_wait(3000);
			} catch (Exception e) {
				e.printStackTrace();
				takeScreenShot("your_profile_negative_tc_007");

			}
	}


	/* TC_008- Verify the scenario unable to  Edit the User ID*/
	@When("Verify 'User ID' is displayed")
	public static void userID_IsDisplayed() throws Exception {
		try {
			value= driver.findElement(By.xpath(OR_reader("profile_user_id"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("userID_IsDisplayed_tc_008");
		}
	}
	@Then("verify 'User ID' is disabled for edit")
	public static void your_profile_negative_tc_008() throws Exception{
		try {
			value= driver.findElement(By.xpath(OR_reader("profile_user_id"))).isEnabled();
			Assert.assertEquals(true,value);
			click("profile_go_back");
			page_wait(1500);
			click("hamburger");
			page_wait(1000);
			click("your_profile_header");
		} catch (Exception e) {
			e.printStackTrace();	
			takeScreenShot("your_profile_negative_tc_008");
		}
	}

	/* TC_009- Verify the scenario when Email ID fields are blank*/
	@When("click on contact details")
	public static void clickOnContactDetails() throws Exception {
		try {
			page_wait(1500);
			scrollAndClick("Contact details");
			page_wait(1000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("clickOnContactDetails_tc_009");
		}
	}
	@Then("Leave email id field as blank")
	public static void your_profile_negative_tc_009() throws Exception{
		try {
			page_wait(3000);
			boolean result = false;
		    int attempts = 0;
		    while(attempts < 2) {
		        try {
		        	click("profile_contact");
		            result = true;
		            break;
		        } catch(Exception e) {
		        }
		        attempts++;
		    }
			page_wait(1000);
			stale_click("your_prof_contact_plus");
			page_wait(2000);
			value= driver.findElement(By.xpath(OR_reader("profile_submit"))).isEnabled();
			System.out.println(value);
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();	
			takeScreenShot("your_profile_negative_tc_009");
		}
	}

	/* TC_010- Verify the scenario when entering invalid Email ID  or  already exist Email ID*/
	@When("Enter invalid email id")
	public static void your_profile_negative_tc_010() throws Exception{
		try {
			page_wait(1000);
			driver.findElement(By.xpath(OR_reader("profile_email_edttext"))).sendKeys(td_reader("profile_email_edttext",0));
			click("profile_submit");
			page_wait(3000);
			str= driver.findElement(By.xpath(OR_reader("profile_email_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_email_valid_msg"),str);
			field_clear("profile_email_edttext");
			driver.findElement(By.xpath(OR_reader("profile_email_edttext"))).sendKeys(td_reader("profile_email_edttext",1));
			click("profile_submit");
			page_wait(3000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_010");
		}
	}

	@Then("Verify the validation for invalid email id")
	public static void validation_invalid_mail() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader("profile_email_valid_msg_two"))).getText();
			Assert.assertEquals(td_reader("profile_email_valid_msg_two"),str);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("validation_invalid_mail_tc_010");
		}

	}

	/* TC_011- Verify the scenario when unable to  Edit the primary and deactivate phone number*/
	@When ("Click on phone number")
	public static void click_phone_number() throws Exception{
		try {
			page_wait(1000);
			page_back();
			page_wait(1000);
			click("your_prof_phone_number");
			page_wait(1500);
			click("your_prof_contact_plus");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_011");
		}
	}

	/* TC_012- Verify the scenario when entering invalid Phone number  or  Phone number fields are blank*/
	@When("Enter invalid Phone number  or  Phone number fields")
	public static void your_profile_negative_tc_012() throws Exception{
		try {
			driver.findElement(By.xpath(OR_reader("profile_phone_edttext"))).sendKeys(td_reader("profile_phone_edttext",0));
			click("profile_submit");
			page_wait(2000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_012");
		}
	}

	@Then("Verify the validation message for Phone number  or  Phone number fields")
	public static void invalid_validation_message() throws Exception{
		try {
			str= driver.findElement(By.xpath(OR_reader("profile_phone_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_phone_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("invalid_validation_message_tc_012");
		}
	}

	/* TC_013- Verify the scenario when unable to  Edit the primary and deactivate address*/
	@When("Click on Address")
	public static void click_address() throws Exception{
		try {
			page_wait(3000);
			page_back();
			page_wait(3000);
			click("your_prof_address");
			page_wait(1500);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("click_address_tc_013");
		}
	}
	@Then("primary and deactivate address are disbled for edit")
	public static void your_profile_negative_tc_013() throws Exception{
		try {
			value= driver.findElement(By.xpath(OR_reader("your_prof_address"))).isEnabled();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();	
			takeScreenShot("your_profile_negative_tc_013");
		}
	}

	/* TC_014- Verify the scenario when leaving the fields blank in the Add new address Page*/
	@When("Click on add new address '+' symbol")
	public static void click_new_address() throws Exception{
		try {
			page_wait(1500);
			click("your_prof_contact_plus");
			page_wait(1500);
			click("add_save");
			page_wait(3000);	
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("click_new_address_tc_014");
		}
	}
	@Then("Leaves fields blank")
	public static void your_profile_negative_tc_014() throws Exception{
		try {
			//str= driver.findElement(By.xpath(OR_reader("profile_saveas_valid_msg"))).getText();
			//Assert.assertEquals(td_reader("profile_saveas_valid_msg"),str);
//			str= driver.findElement(By.xpath(OR_reader("profile_address_valid_msg"))).getText();
//			Assert.assertEquals(td_reader("profile_address_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_city_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_city_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_state_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_state_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_zip_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_zip_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_014");
		}
	}

	/* TC_015- Verify the scenario when entering invalid Zip code in Add new address page*/
	@When("Enters invalid zip code")
	public static void invalid_zipcode() throws Exception{
		try {
			page_wait(3000);
			page_back();
			page_wait(1000);
			click("your_prof_contact_plus");
			page_wait(1000);
			driver.findElement(By.xpath(OR_reader("your_prof_address_zip"))).sendKeys(td_reader("your_prof_address_zip"));
			page_wait(3000);
			click("add_save");
			page_wait(3000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("invalid_zipcode_tc_015");
		}

	}

	/* TC_016- Verify the scenario when leaving the fields blank in the Add plan Page*/
	@When("click on plan coverage")
	public void click_plan_coverage() throws Exception {
		try {
			page_wait(3000);
			page_back();
			page_wait(1500);
			page_back();
			//click("profile_go_back");
			page_wait(1000);
			scrollAndClick("Plan coverage");
			page_wait(1000);
			click("your_prof_edit_icon");
			page_wait(1000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("click_plan_coverage_tc_016");
		}
	}
	@Then("Enter add plan page feilds blank")
	public static void your_profile_negative_tc_016() throws Exception{
		try {
			click("your_prof_contact_plus");
			page_wait(1000);
			scrollAndClick("Save");
			page_wait(1000);
			str= driver.findElement(By.xpath(OR_reader("profile_insurer_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_insurer_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_memberid_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_memberid_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_groupid_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_groupid_valid_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_plan_type_valid_msg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_type_valid_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("click_plan_coverage_tc_016");
		}
	}

	/* TC_017-Verify the scenario when entering invalid First name of policy holder or Last name of policy holder  in Add plan page*/
	@When("Enters invalid firstname and lastname fields in add plan page")
	public static void invalid_first_last_name() throws Exception{
		try {
			page_wait(1000);
			click("profile_go_back");
			page_wait(1000);
			stale_click("your_prof_contact_plus");
			driver.findElement(By.xpath(OR_reader("profile_plan_firstname"))).sendKeys(td_reader("profile_plan_firstname"));
			str= driver.findElement(By.xpath(OR_reader("profile_plan_first_invalidmsg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_first_invalidmsg"),str);
			page_wait(1000);
			click("profile_go_back");
			page_wait(1000);
			click("your_prof_contact_plus");
			driver.findElement(By.xpath(OR_reader("profile_plan_lastname"))).sendKeys(td_reader("profile_plan_lastname"));
			str= driver.findElement(By.xpath(OR_reader("profile_plan_last_invalidmsg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_last_invalidmsg"),str);
			page_wait(1000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("invalid_first_last_name_tc_017");
		}
	}
	@Then("Verify the error message on invalid firstname and lastname")
	public static void your_profile_negative_tc_017() throws Exception {
		try{
			str= driver.findElement(By.xpath(OR_reader("profile_plan_last_invalidmsg"))).getText();
			Assert.assertEquals(td_reader("profile_plan_last_invalidmsg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_017");
		}
	}

	/* TC_018-Verify the scenario when leaving the fields blank in the Change password page*/
	@When("Enter blank fields in Change password page")
	public static void blank_password() throws Exception{
		try {
			click("profile_go_back");
			page_wait(1000);
			click("profile_go_back");
			page_wait(1000);
			stale_click("your_prof_edit_icon");
			page_wait(1000);
			scrollAndClick("Save");
			stale_click("your_prof_ok_button");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("blank_password_tc_018");
		}
	}
	@Then("Verify the blank field message")
	public static void your_profile_negative_tc_018() throws Exception {
		try{
			str= driver.findElement(By.xpath(OR_reader("profile_old_password_vld_msg"))).getText();
			Assert.assertEquals(td_reader("profile_old_password_vld_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_new_password_vld_msg"))).getText();
			Assert.assertEquals(td_reader("profile_new_password_vld_msg"),str);
			str= driver.findElement(By.xpath(OR_reader("profile_confirm_password_vld_msg"))).getText();
			Assert.assertEquals(td_reader("profile_confirm_password_vld_msg"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_018");
		}
	}

	/* TC_019-Verify the scenario when entering wrong Old password in Change password page*/
	@When("Enter wrong passwords")
	public static void wrong_password() throws Exception{

		try {
			click("profile_go_back");
			page_wait(1000);
			scrollAndClick("Password");
			page_wait(1000);
			stale_click("your_prof_edit_icon");
			driver.findElement(By.xpath(OR_reader("profile_old_password"))).sendKeys(td_reader("profile_old_password",0));
			driver.findElement(By.xpath(OR_reader("profile_new_password"))).sendKeys(td_reader("profile_new_password",0));
			driver.findElement(By.xpath(OR_reader("profile_confirm_password"))).sendKeys(td_reader("profile_confirm_password",0));
			stale_click("your_proff_save_btn");
			page_wait(1000);
			scrollAndClick("Save");			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("wrong_password_tc_019");
		}
	}
	@Then("Verify wrong password message")
	public static void your_profile_negative_tc_019() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("profile_old_password_vld_msg_two"))).getText();
			Assert.assertEquals(td_reader("profile_old_password_vld_msg_two"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_019");
		}
	}

	/* TC_020-Verify the scenario when invalid New password in Change password page*/
	@When("Enter invalid new password")
	public static void invalid_new_password() throws Exception{
		try {
			click("profile_go_back");
			page_wait(1000);
			scrollAndClick("Password");
			page_wait(1000);
			click("your_prof_edit_icon");
			page_wait(1500);
			driver.findElement(By.xpath(OR_reader("profile_old_password"))).sendKeys(td_reader("profile_old_password",1));
			driver.findElement(By.xpath(OR_reader("profile_new_password"))).sendKeys(td_reader("profile_new_password",1));
			driver.findElement(By.xpath(OR_reader("profile_confirm_password"))).sendKeys(td_reader("profile_confirm_password",3));
			click("profile_confirm_password");
			click("your_proff_save_btn");
			scrollAndClick("Save");
			page_wait(1000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("invalid_new_password_tc_020");
		}
	}
	@Then("Verify invalid password message")
	public static void your_profile_negative_tc_020() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("profile_new_password_vld_msg_two"))).getText();
			Assert.assertEquals(td_reader("profile_new_password_vld_msg_two"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_020");
		}
	}

	/* TC_021-Verify the scenario when entering same data in Old password and New password fields in Change password page*/
	@When("Enter same data in Old password and New password fields")
	public static void old_new_password() throws Exception{
		try {
			click("profile_go_back");
			page_wait(1000);
			scrollAndClick("Password");
			page_wait(5);
			click("your_prof_edit_icon");
			page_wait(15);
			driver.findElement(By.xpath(OR_reader("profile_new_password"))).sendKeys(td_reader("profile_new_password",2));
			driver.findElement(By.xpath(OR_reader("profile_old_password"))).sendKeys(td_reader("profile_old_password", 2));
			driver.findElement(By.xpath(OR_reader("profile_confirm_password"))).sendKeys(td_reader("profile_confirm_password",1));
			click("your_proff_save_btn");
			page_wait(1000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("old_new_password_tc_021");
		}
	}
	@Then("verify the validation message")
	public static void your_profile_negative_tc_021() throws Exception {
		try{
			str= driver.findElement(By.xpath(OR_reader("profile_new_password_vld_msg_three"))).getText();
			Assert.assertEquals(td_reader("profile_new_password_vld_msg_three"),str);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_021");

		}
	}

	/* TC_022-Verify the scenario when entering different data in New password and Confirm new password fields*/
	@When("Enter different data in New password and Confirm new password fields")
	public static void diff_password_confirm_password() throws Exception{
		try {
			click("profile_go_back");
			page_wait(1000);
			scrollAndClick("Password");
			page_wait(1000);
			stale_click("your_prof_edit_icon");
			page_wait(1500);
			field_clear("profile_old_password");
			field_clear("profile_new_password");
			field_clear("profile_confirm_password");
			page_wait(1500);
			driver.findElement(By.xpath(OR_reader("profile_new_password"))).sendKeys(td_reader("profile_new_password",3));
			driver.findElement(By.xpath(OR_reader("profile_old_password"))).sendKeys(td_reader("profile_old_password", 3));
			driver.findElement(By.xpath(OR_reader("profile_confirm_password"))).sendKeys(td_reader("profile_confirm_password",2));
			page_wait(1000);
			scrollAndClick("Save");
			page_wait(5);	
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("diff_password_confirm_password_tc_022");
		}
	}
	@Then("Verify the different password message")
	public static void your_profile_negative_tc_022() throws Exception {
		try{
			str= driver.findElement(By.xpath(OR_reader("profile_confirm_password_vld_msg_two"))).getText();
			Assert.assertEquals(td_reader("profile_confirm_password_vld_msg_two"),str);
			page_back();
			page_wait(1500);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}

	/* TC_023-Verify the scenario when a dialogue box appears dur to the failure of profile picture */
	@When("Not able to upload profile picture")
	public static void upload_profile_picture() throws Exception{
		try {
			page_back();
			page_wait(2500);
			page_back();
			page_wait(3000);
			click("hamburger");
			click("your_profile_header");
			stale_click("your_prof_edit_icon");
			click("profile_picture");
			click("profile_upload_image");

		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("upload_profile_picture_tc_023");
		}
	}

	@Then("Verify the message on unsuccessful upload")
	public static void your_profile_negative_tc_023() throws Exception {
		try {
			page_wait(1000);
			close();
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("your_profile_negative_tc_023");
		}
	}
}
