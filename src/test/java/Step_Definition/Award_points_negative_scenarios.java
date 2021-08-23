package Step_Definition;

import java.io.IOException;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Award_points_negative_scenarios extends Generic_functions{
	public static boolean value;
	static WebElement ele;
	String ere;
	public static WebElement fr;
	static String str,text;
	static List<WebElement> grid_elements,drp_list;

	/* TC 001 - Validate navigation to award points page*/
	@Given("Launch App")
	public void app_launching() throws Exception {
		try {
			app_launch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("Login into app")
	public void login_into_app() throws Exception {
		try {
			app_login(9,0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("Click on Utilities tab")
	public void Award_points_negative_tc_001() throws Exception {
		try {
			page_wait(12);
			click("utilities");
			page_wait(20);
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_001");
		}
	}

	// TC 002 - Verify the validation message on entering amount more than the available amount in "Redeem Award Points" page
	@When("Click on 'redeem' points")
	public void click_redeem_points() throws Exception {
		try {
			click("awardpoints_redeem_button");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_002");
		}
	}
	
	@Then("Enter the amount more than available amount")
	public void greater_amount() throws Exception, InterruptedException {
		try{
			click("redeem_points_giftcard");

			text = td_reader("redeem_points_giftcard");
			scrolldown(text);
			click("redeem_points_amount");
			driver.findElement(By.xpath(OR_reader("redeem_points_amount"))).sendKeys(td_reader("redeem_points_amount",0));
			click("redeem_points_to_redeem");
			str= driver.findElement(By.xpath(OR_reader("amount_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("amount_exceed_valid_msg"));
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("greater_amount");
		}
	}

	@And("Validate the message on award points page")
	public void Award_point_negative() throws Exception {
		try{
			click("redeem_points_to_redeem");
			str= driver.findElement(By.xpath(OR_reader("amount_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("amount_exceed_valid_msg"));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_002");
		}
	}


	//TC 003 - Validate the validation message on entering amount less than the available amount in "Redeem Award Points" page
	@When("Enter the amount less than the available amount")
	public void lesser_Amount() throws Exception {
		try{
			field_clear("redeem_points_amount");
			click("redeem_points_amount");
			driver.findElement(By.xpath(OR_reader("redeem_points_amount"))).sendKeys(td_reader("redeem_points_amount",1));
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_003");
		}
	}

	@Then("Validate the message on award points page on less amount")
	public void Award_point_negative_tc_002() throws Exception {
		try {
			click("redeem_points_to_redeem");
			str= driver.findElement(By.xpath(OR_reader("amount_valid_msg"))).getText();
			Assert.assertEquals(str,td_reader("amount_less_valid_msg"));
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_003");
		}
	}


	/*TC 004 -  Validate that user is not able to click on the 'Redeem' button on leaving the field 'Select a gift card' blank" */
	@When("Click the Redeem button on leaving the field Select a gift card blank")
	public void redeemButton_giftcardblank() throws Exception {
		try{
			click("utilities");
			click("utilities_award_points");
			click("awardpoints_redeem_button");
			value=driver.findElement(By.xpath(OR_reader("redeem_points"))).isEnabled();
			Assert.assertEquals(value,true);
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_004");
		}
	}
	@Then("Validate the error message displayed")
	public static void Award_point_negative_tc_003() throws Exception, InterruptedException {
		try {
			value=driver.findElement(By.xpath(OR_reader( "redeem_points"))).isEnabled();
			Assert.assertEquals(value,false);
			page_wait(1000);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_004");
		}
	}


	/*TC 005 -  Validate that user is not able to click on the 'Redeem' button on leaving the field 'Enter Amount' blank on "Redeem Award Points" page */
	@When("Click on the Redeem button on leaving the field Enter Amount blank")
	public static void blank_amount_redeem_button() throws Exception{
		try {
			click("utilities");
			click("utilities_award_points");
			click("awardpoints_redeem_button");
			value=driver.findElement(By.xpath(OR_reader("redeem_points"))).isEnabled();
			Assert.assertEquals(value,true);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_005");
		}
	}

	@Then("Validate the message displayed")
	public void Award_point_negative_tc_004() throws Exception {
		try{
			click("redeem_points_giftcard");
			text = td_reader("redeem_points_giftcard");
			scrolldown(text);
			value=driver.findElement(By.xpath(OR_reader("redeem_points"))).isEnabled();
			Assert.assertEquals(value,true);
			click("home");
			page_wait(5);
			click("hamburger");
			click("logout");
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("Award_point_negative_tc_005");
		}
		close();
	}
}
