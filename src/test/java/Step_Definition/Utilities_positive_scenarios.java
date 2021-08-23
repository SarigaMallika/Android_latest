package Step_Definition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Utilities_positive_scenarios extends Generic_functions {
	public static boolean value;
	public static String exacttext,str,text;
	static WebElement ele;
	public static Signup_positive_scenario sp = new Signup_positive_scenario();
	public static Login_positive_scenario lp = new Login_positive_scenario();


	/*Validate that the user is navigated to Welcome page*/
	@Given("user is on home page")
	public static void launch_url() throws Exception{
		try {
			sp.signup_positive_tc_001();
			sp.signup_positive_tc_006();
			sp.verify_OTP_page();
			sp.signup_positive_tc_007();
			sp.click_verify();
			lp.login();
			lp.login_positive_tc_005();
			lp.loginhome();
			click("home_skip");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}


	/* TC_001 -Navigate to Utilities screen*/
	@When("clicks on Utilities tab")
	public static void click_utilities() throws Exception {
		try {
//			click("welcome_login");
//			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",9));
//			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",0));
//			page_wait(10);
//			click("login");
			click("utilities");

		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_001");
		}	
	}

	@Then("Navigate to Utilities Dashboard")
	public static void utilities_positive_tc_001() throws Exception {
		try {
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("utilities_wallet"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_001");
		}	
	}

	/* TC_002-Click options provided in left side navigator*/
	@When("Click on left side navigator options")
	public static void click_navigator_options() throws Exception {
		try {  page_wait(20);
		click("home");
		value = driver.findElement(By.xpath(OR_reader("home_assert"))).isDisplayed();
		Assert.assertEquals(true,value);
		click("services");
		value = driver.findElement(By.xpath(OR_reader("services_assert"))).isDisplayed();
		Assert.assertEquals(true,value);
		click("circles");
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_002");
		}
	}
	@Then("Verify the navigator options")
	public void utilities_positive_tc_002() throws Exception {
		try{
			value = driver.findElement(By.xpath(OR_reader("utilities_walletassert"))).isDisplayed();
			Assert.assertEquals(true,value);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_002");
		}
	}

	/* TC_003 - Verify that click on all the Tiles in the Utilities dashboard*/
	@And("Click all tiles in utilities dashboard")
	public static void utilities_positive_tc_003() throws Exception {
		try {
			click("utilities");
			click("utilities_wallet");
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("utilities_add_payment_method"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("utilities_back");
			click("utilities_awardspoints");
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("award_points_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("utilities_back");
			stale_click("utilities_idcard");
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("utilities_idcard_ok"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(20);
			click("utilities_idcard_ok");
			page_wait(20);
			click("utilities_settings");
			page_wait(20);
			//			 value = driver.findElement(By.xpath(OR_reader("utilities_settingsassert"))).isDisplayed();
			//			 Assert.assertEquals(true,value);
			page_back();
			click("utilities_upload");
			page_wait(20);
			value = driver.findElement(By.xpath(OR_reader("utilities_upload_ok"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(20);
			click("utilities_upload_ok");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_003");
		}	
	}

	/* TC_004 - Add card details  in the Wallet dashboard*/
	@When("Enter card details in wallet dashboard")
	public static void utilities_positive_tc_004() throws Exception {
		try {
			//			click("utilities");
			//			click("utilities_wallet");
			//			page_wait(10);
			//			click("utilities_add_payment_method");
			//			page_wait(10);
			//			click("utilities_add_debit_credit_card");
			//			driver.findElement(By.xpath(OR_reader("utilities_addcardsaveas"))).sendKeys(td_reader("utilities_addcardsaveas"));
			//			driver.findElement(By.xpath(OR_reader("utilities_addcardname"))).sendKeys(td_reader("utilities_addcardname"));
			//			page_wait(10);
			//			driver.findElement(By.xpath(OR_reader( "utilities_addcardnum"))).sendKeys(td_reader("utilities_addcardnum"));
			//			driver.findElement(By.xpath(OR_reader( "utilities_addcardexpiry"))).sendKeys(td_reader("utilities_addcardexpiry"));
			//			page_wait(10);
			//			driver.findElement(By.xpath(OR_reader("utilities_addcardcvc"))).sendKeys(td_reader("utilities_addcardcvc"));
			//			driver.findElement(By.xpath(OR_reader("utilities_addcardpost"))).sendKeys(td_reader("utilities_addcardpost"));
			//			page_wait(10);
			//			driver.findElement(By.xpath(OR_reader("utilities_addcardphonenumber"))).sendKeys(td_reader("utilities_addcardphonenumber"));
			//			driver.findElement(By.xpath(OR_reader( "utilities_addcardaddress1"))).sendKeys(td_reader("utilities_addcardaddress1"));
			//			driver.findElement(By.xpath(OR_reader("utilities_addcardaddress2"))).sendKeys(td_reader("utilities_addcardaddress2"));
			//			page_wait(10);
			//			click("utilities_addcardscountry");
			//			exacttext = td_reader("utilities_addcardscountry");
			//			scrolldown(exacttext);
			//			click("utilities_addcardsstate");
			//			exacttext = td_reader("utilities_addcardsstate");
			//			scrolldown(exacttext);
			//			page_wait(10);
			//			driver.findElement(By.xpath(OR_reader("Object Locator", "utilities_addcardcity"))).sendKeys(td_reader("utilities_addcardcity"));

		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_004");
		}	
	}

	@Then("Verify card details is saved")
	public static void card_details_save() throws Exception {
		try {
			//			click("utilities_addcardsave");
			//			waitelement("utilities_addcardok");
			//			click("utilities_addcardok");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_004");
		}
	}


	/* TC_005 - Add bank details  in the Wallet dashboard*/
	@When("Enter bank details in wallet dashboard")
	public void bank_details() throws Exception {
		try {
			//			click("utilities_add_payment_method");
			//			click("utilities_addbank");
			//			value = driver.findElement(By.xpath(OR_reader("utilities_addbankassert"))).isDisplayed();
			//			Assert.assertEquals(true,value);
			//			driver.findElement(By.xpath(OR_reader("utilities_addbanksaveas"))).sendKeys(td_reader("utilities_addbanksaveas"));
			//			driver.findElement(By.xpath(OR_reader("utilities_addbankname"))).sendKeys(td_reader("utilities_addbankname"));
			//			page_wait(10);
			//			driver.findElement(By.xpath(OR_reader("utilities_addbankrouting"))).sendKeys(td_reader("utilities_addbankrouting"));
			//			click("utilities_addbankholdertype");
			//			exacttext = td_reader("utilities_addbankholdertype");
			//			scrolldown(exacttext);
			//			driver.findElement(By.xpath(OR_reader("utilities_addbankaccountno"))).sendKeys(td_reader("utilities_addbankaccountno"));
			//			page_wait(10);
			//			click("utilities_addbankcheckbox");
			//			browser_back();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_005");
		}
	}

	@Then("User should able to click on Deactivate tile")
	public static void utilities_positive_tc_005() throws Exception {
		try {
			page_wait(20);
			//click("utilities_back");
			click("utilities_settings");
			click("utilities_settingsdeactivate");
			value = driver.findElement(By.xpath(OR_reader("deactivate_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("cancel_deactivation_button");
			click("home");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("utilities_positive_tc_005");
		}	
	}

	/*TC_006 - Validate user can click on Award points and able to view Balance and Your award point history.*/
	@Given("Click Award Points")
	public void click_awardpoints() throws Exception {
		try {
			page_wait(20);
			click("utilities");
			page_wait(20);
			click("utilities_awardspoints");
			page_wait(20);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_click_awardpoints");
		}
	}
	@When("Navigate to Award Points screen")
	public static void validate_award_points() throws Exception {
		try {
			str = driver.findElement(By.xpath(OR_reader("award_points_title"))).getText();
			Assert.assertEquals(str,td_reader("award_points_title"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_validate_award_points");
		}
	}

	@Then("view the Balance, award points history and Welcome bonus text.")
	public static void validate_balance_history_bonus() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("award_point_balance_text"))).getText();
			Assert.assertEquals(str,td_reader("award_point_balance_text"));
			str= driver.findElement(By.xpath(OR_reader("award_point_balance_amount"))).getText();
			Assert.assertEquals(str,td_reader("award_point_balance_amount"));
			str= driver.findElement(By.xpath(OR_reader("award_point_history_text"))).getText();
			Assert.assertEquals(str,td_reader("award_point_history_text"));
			str= driver.findElement(By.xpath(OR_reader("award_point_welcome_bonus_text"))).getText();
			Assert.assertEquals(str,td_reader("award_point_welcome_bonus_text"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_validate_balance_history_bonus");
		}
	}

	/*TC 007 - Validate that user is able to view Award points dashboard details. */
	@Given("Redeem button enabled")
	public static void redeem_button_enabled() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("utilities_redeem_points_button"))).isEnabled();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_redeem_button_enabled");
		}
	}

	@When("Click on Award Redeem button")
	public void click_redeem_points_button() throws Exception {
		try {			
			page_wait(20);
//			Actions builder=new Actions(driver);
//			builder.moveToElement(driver.findElement(By.xpath(OR_reader("award_points_redeem_button"))));
//			builder.click(driver.findElement(By.xpath(OR_reader("award_points_redeem_button"))));
//			Action action= builder.build();
//			action.perform();
			click("utilities_redeem_points_button");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_click_redeem_points_button");
		}
	}

	@Then("view the Available award points, Award points to reedem, and email id.")
	public void validate_redeem_point_dashboard() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("redeem_award_points_title"))).getText();
			Assert.assertEquals(str,td_reader("redeem_award_points_title"));
			str= driver.findElement(By.xpath(OR_reader("award_point_available_point_text"))).getText();
			Assert.assertEquals(str,td_reader("award_point_available_point_text"));
			str= driver.findElement(By.xpath(OR_reader("available_award_points_value"))).getText();
			Assert.assertEquals(str,td_reader("available_award_points_value"));
			str= driver.findElement(By.xpath(OR_reader("award_points_to_redeem_text"))).getText();
			Assert.assertEquals(str,td_reader("award_points_to_redeem_text"));
			str= driver.findElement(By.xpath(OR_reader("award_point_to_redeem_value"))).getText();
			Assert.assertEquals(str,td_reader("award_point_to_redeem_value"));
			str= driver.findElement(By.xpath(OR_reader("award_point_email_label"))).getText();
			Assert.assertEquals(str,td_reader("award_point_email_label"));
			str= driver.findElement(By.xpath(OR_reader("award_point_email_value"))).getText();
			Assert.assertEquals(str,td_reader("award_point_email_value"));
			value = driver.findElement(By.xpath(OR_reader("award_point_merchant_help_text"))).isDisplayed();
			Assert.assertEquals(true,value);	
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_validate_redeem_point_dashboard");
		}
	}

	/*TC 008 - Validate that user is able to redeem points  in the Award points dashboard.*/
	@Given("Select Amazon gift card")
	public void select_gift_card() throws Exception {
		try {
			click("award_point_gift_card_drop_down");
//			text = td_reader("gift_card");
//			drop_down("award_point_gift_drop_list",text);
			click("award_point_gift_card");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_validate_select_gift_card");
		}
	}

	@And("Enter Amount 20")
	public void enter_amount() throws Exception {
		try {
			driver.findElement(By.xpath(OR_reader("award_point_amount_field"))).sendKeys(td_reader("award_point_amount_field",0));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_validate_enter_amount");
		}
	}

	@When("Click on 'More information about the gift card' link")
	public void click_more_info() throws Exception {
		try {
			click("more_info_about_gift_card_link");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_validate_click_more_info");
		}
	}

	@Then("A pop up will appear with title 'Reward description'. Validate the text and click OK button")
	public void reward_description_popup() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("award_point_popup_title"))).getText();
			Assert.assertEquals(str,td_reader("award_point_popup_title"));
			click("award_point_popup_ok_button");
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_validate_reward_description_popup");
		}
	}

	@And("Click on 'Redeem' button, Navigate to the redeem page and validate the page title.")
	public void click_redeem_button() throws Exception {
		try {
			click("award_point_email_value");
			click("award_point_amount_field");
			stale_click("redeem_button");
			str= driver.findElement(By.xpath(OR_reader("redeemed_page_title"))).getText();
			Assert.assertEquals(str,td_reader("redeemed_page_title"));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_validate_click_redeem_button");
		}
	}

	/*TC 009 - Validate that the user is able to navigate to the Redeemed page*/
	@Given("view the You have redeemed 2000 points and You have availed this gift card text.")
	public void redeem_point_gift_card_text() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("redeem_page_img"))).isDisplayed();
			Assert.assertEquals(true,value);
			str= driver.findElement(By.xpath(OR_reader("redeem_page_text"))).getText();
			Assert.assertEquals(str,td_reader("redeem_page_text"));
			str= driver.findElement(By.xpath(OR_reader("redeem_page_giftcard_text"))).getText();
			Assert.assertEquals(str,td_reader("redeem_page_giftcard_text"));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_validate_redeem_point_gift_card_tex");
		}
	}

	@When("Click on Redeem More Points button. Navigated to Redeem award points dashboard.")
	public void click_redeem_more_points() throws Exception {
		try {
//			click("redeem_more_points_button");
//			str= driver.findElement(By.xpath(OR_reader("redeem_award_points_title"))).getText();
//			Assert.assertEquals(str,td_reader("redeem_award_points_title"));			
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_validate_click_redeem_more_points");
		}
	}

	@Then("Click on Go to Award Points Dashboard button. Navigated to Award points dasboard.")
	public void click_goto_award_points_dashboard() throws Exception {
		try {
			click("goto_award_points_button");
			str = driver.findElement(By.xpath(OR_reader("award_points_title"))).getText();
			Assert.assertEquals(str,td_reader("award_points_title"));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_validate_click_goto_award_points_dashboard");
		}
	}

	@And("Verify Your award Points history and balance.")
	public void your_award_point_history() throws Exception {
		try {
			str= driver.findElement(By.xpath(OR_reader("redeemed_gift_card_text"))).getText();
			Assert.assertEquals(str,td_reader("redeemed_gift_card_text"));
			close();
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_positive_validate_your_award_point_history");
		}
	} 
}
