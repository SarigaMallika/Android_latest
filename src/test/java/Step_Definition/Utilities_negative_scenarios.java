package Step_Definition;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Reusable_Functions.Generic_functions;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Utilities_negative_scenarios extends Generic_functions {
	static boolean value;
	static String balance,text,ere,str;
	static WebElement ele;

	/*Validate that the user is navigated to Welcome page*/
	@Given("User is on home page")
	public static void launch_url() {
		try {
			app_launch();
			page_wait(5000);
			click("welcome_login");
			page_wait(5000);
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("signup_phone_number",3));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("signup_password",0));
			page_wait(2000);
			click("login");	
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/* TC_001 -Navigate to Utilities screen*/
	@When("Clicks on Utilities tab")
	public static void utilities_negative_tc_001() throws Exception {
		try {
			page_explicit_wait("utilities", 9000);
			click("utilities");
			page_explicit_wait("utilities_wallet", 1000);
			click("utilities_wallet");
			page_explicit_wait("utilities_add_payment_method", 1000);
			stale_click("utilities_add_payment_method");
			click("utilities_add_debit_credit_card");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_tc_001");
		}
	}

	/* TC_002 -Verify the scenario when 'Add Card' fields is blank*/
	@When("Leave Add card field as blank")
	public static void utilities_negative_tc_002() throws IOException {
		try{
			page_explicit_wait("utilities_add_debit_credit_card", 1000);
			click("utilities_add_debit_credit_card");
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_tc_002");
		}	
	}

	@Then("Verify the message on leaving Add Card fields as blank")
	public static void blank_field_validation() throws Exception {
		try{
			page_wait(5000);
			String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Save\").instance(0))";
			driver.findElementByAndroidUIAutomator(scrollElement).click();
			String scroll = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Save as\").instance(0))";
			driver.findElementByAndroidUIAutomator(scroll).click();
//			str= driver.findElement(By.xpath(OR_reader("utilities_add_line_one_valid_msg"))).getText();
//			Assert.assertEquals(str,td_reader("add_line_one_valid_msg"));
			str= driver.findElement(By.xpath(OR_reader("utilities_state_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("state_valid_msg"));
			str= driver.findElement(By.xpath(OR_reader("utilities_city_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("city_valid_msg"));
			str= driver.findElement(By.xpath(OR_reader("phone_no_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("phone_no_valid_msg"));
			str= driver.findElement(By.xpath(OR_reader("utilities_save_as_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("save_as_valid_msg"));
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_blank_field_validation");
		}	
	}

	/* TC_003 -Verify the message on entering invalid details in the Add Card page*/
	@When("Enter invalid card details")
	public static void utilities_negative_tc_003() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("utilities_card_no"))).sendKeys(td_reader("card_no",0));
			driver.findElement(By.xpath(OR_reader("utilities_expiration_date"))).sendKeys(td_reader("expiration_date",0));
			driver.findElement(By.xpath(OR_reader("utilities_cvc"))).sendKeys(td_reader("cvc",0));
			driver.findElement(By.xpath(OR_reader("utilities_postal_code"))).sendKeys(td_reader("postal_code",0));
			click("utilities_phone_number");
			driver.findElement(By.xpath(OR_reader("utilities_phone_number"))).sendKeys(td_reader("phone_no",1));
			page_wait(5000);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_tc_003");
		}	
	}

	/*TC_004- Verify the scenario when 'Add Bank' fields is blank*/
	@When("Leave Add Bank field as blank")
	public static void utilities_negative_tc_004() throws Exception {
		try {
			click("utilities_back_btn");
			click("utilities_add_payment_method");
			page_wait(5000);
			click("utilities_add_bank_account");
			click("utilities_save_as");
			click("utilities_account_holder_name");
			click("utilities_routing_no");
			click("utilities_account_no");
			String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Save\").instance(0))";
			driver.findElementByAndroidUIAutomator(scrollElement).click();
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_tc_004");
		}	
	}

	@Then("Verify the message on leaving Add Bank fields as blank")
	public static void blank_bank_details() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("utilities_save_as_valid_msg_two"))).getText();
			Assert.assertEquals(str,td_reader("save_as_valid_msg_two"));
			str= driver.findElement(By.xpath(OR_reader("utilities_account_holder_name_valid_msg_two"))).getText();
			Assert.assertEquals(str,td_reader("account_holder_name_valid_msg_two"));
			str= driver.findElement(By.xpath(OR_reader("utilities_routing_no_valid_msg_two"))).getText();
			Assert.assertEquals(str,td_reader("routing_no_valid_msg_two"));
			str= driver.findElement(By.xpath(OR_reader("utilities_account_no_valid_msg_two"))).getText();
			Assert.assertEquals(str,td_reader("account_no_valid_msg_two"));
			page_wait(5000);
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_blank_bank_details");
		}	
	}

	/* TC_005 - Verify the message on entering invalid details in the 'Add Bank' page*/
	@When("Enter invalid bank details")
	public static void utilities_negative_tc_005() throws Exception {
		try {
			page_wait(5000);
			driver.findElement(By.xpath(OR_reader("utilities_save_as"))).sendKeys(td_reader("save_as",0));
			driver.findElement(By.xpath(OR_reader("utilities_account_holder_name"))).sendKeys(td_reader("account_holder_name",0));
			click("routing_no");
			driver.findElement(By.xpath(OR_reader("utilities_routing_no"))).sendKeys(td_reader("routing_no",0));
			AndroidElement spinner = driver.findElement(By.xpath(OR_reader("utilities_account_holder_type")));
			spinner.click();
			page_wait(5000);
			AndroidElement spinner_choose = driver.findElement(By.xpath(OR_reader("utilities_holder_type_name")));
			spinner_choose.click();
			click("utilities_account_no");
			driver.findElement(By.xpath(OR_reader("account_no"))).sendKeys(td_reader("account_no",0));
			page_wait(5000);
			String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Save\").instance(0))";
			driver.findElementByAndroidUIAutomator(scrollElement).click();
			page_wait(5000);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_tc_005");
		}	
	}

	@Then("Verify the message on entering invalid bank details")
	public static void invalid_bank_details() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("utilities_account_holder_name_valid_msg_two"))).getText();
			Assert.assertEquals(str,td_reader("account_holder_name_valid_msg_two"));
			str= driver.findElement(By.xpath(OR_reader("utilities_routing_no_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("routing_no_valid_msg"));
			str= driver.findElement(By.xpath(OR_reader("utilities_account_no_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("account_no_valid_msg"));
			page_wait(5000);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_invalid_bank_details");
		}	
	}

	/* TC_006 - Verify the redeem button when the balance is less than 2000 */
	@When ("Verify the redeem button is disabled")
	public static void utilities_positive_tc_006() throws Exception{
		try {
			click("utilities_back_btn");
			click("utilities_manage_back");
			click("utilities_award_points");
			click("utilities_redeem_points_button");
			page_wait(5000);
			click("home");
			page_wait(4000);
			click("hamburger");
			page_wait(1000);  
			click("logout");
			close();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_negative_tc_006");
		}	
	}

}