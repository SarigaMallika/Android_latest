package Step_Definition;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;


public class My_medicare_claims_positive_scenario extends Generic_functions {
	public static boolean value;
	public static String path;
	public static File file;
	static String str,text,left;
	public static int elementX,elementY;
	static WebElement from,to;

	@Given("Launch the app")
	public void launch_the_app() {
		try {
			app_launch();
			page_wait(20);
			click("welcome_login");
			page_wait(30);
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",5));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",5));
			page_wait(20);
			click("login");	
			page_wait(30);
			click("circleone");
			page_wait(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("Clicks on the Circles and select my medicare")
	public static void clicks_on_the_circles_and_select_my_medicare() {
		try {
			page_wait(10);
			click("circle_my_medicare_icon");
			page_wait(40);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//TC_001 Validate that the user is able to navigate
	@Then("Click on Claims from the My Medicare dashbord")
	public static void my_medicare_claims_positive_tc_001() throws IOException {
		try {
			AndroidTouchAction ta = new AndroidTouchAction(driver);
			AndroidElement ele = driver.findElement(By.xpath(OR_reader("claims_tile")));
			ta.tap(ElementOption.element(ele)).perform();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("my_medicare_claims_positive_tc_001");
		}
	}
	//TC_002 Verify the scenario when Claims title and back arrow visible on the page 
	@When("Claims title and back arrow are displayed")
	public static void my_medicare_claims_positive_tc_002() throws IOException {
		try {
			page_wait(10);
			click("claims_title");
			page_wait(15);
			click("claims_back_arrow");
			page_wait(15);
			AndroidTouchAction ta = new AndroidTouchAction(driver);
			AndroidElement ele = driver.findElement(By.xpath(OR_reader("claims_tile")));
			ta.tap(ElementOption.element(ele)).perform();
			page_wait(10);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("my_medicare_claims_positive_tc_002");
		}
	}
	//TC_003 Verify the scenario when select Claim type from the dropdown field
	@Then("select Claim type from the dropdown field")
	public static void my_medicare_claims_positive_tc_003() throws IOException {
		try {
			page_wait(10);
			click("claims_claim_type_dropdown");
			page_wait(15);
			click("claims_professional");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("my_medicare_claims_positive_tc_003");
		}

	}
	//TC_004 Verify the scenario when select Time period from the dropdown field
	@Then("select Time period from the dropdown field")
	public static void my_medicare_claims_positive_tc_004() throws IOException {
		try {
			page_wait(10);
			click("claims_time_period_dropdown");
			page_wait(15);
			click("claims_year");
		} catch (Exception e) {
			e.printStackTrace();
			//takeScreenShot("my_medicare_claims_positive_tc_004");
		}
	}
	//TC_005 Verify the scenario  to view 'Patient portion and Insurer portion' under claims summary
	@When("Patient portion and Insurer portion are displayed")
	public static void my_medicare_claims_positive_tc_005() throws IOException {
		try {
			value = driver.findElement(By.xpath(OR_reader("claims_patient_portion_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_insurer_portion_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(30);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("my_medicare_claims_positive_tc_005");
		}
	}

	//TC_006 Verify the scenario  to view 'Here is the helpful breakdown' text under Claims summary
	@Then("Here is the helpful breakdown text is displayed")
	public static void my_medicare_claims_positive_tc_006() throws IOException {
		try {
			page_wait(10);
			elementX= driver.findElement(By.xpath(OR_reader("claims_grid"))).getLocation().getX();
			elementY= driver.findElement(By.xpath(OR_reader("claims_grid_two"))).getLocation().getY();
			swipe_right_to_left(elementX, elementY,2);
			page_wait(35);
			value = driver.findElement(By.xpath(OR_reader("claims_help_breakdown_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(10);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("my_medicare_claims_positive_tc_006");
		}
	}
	//TC_007 Verify the scenario claims breakdown is visible
	@When("the claims category under Here is the helpful breakdown text")
	public static void my_medicare_claims_positive_tc_007() throws IOException {
		try {
			value = driver.findElement(By.xpath(OR_reader("claims_institutional"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_pharmacy"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_professiona"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_HHA"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_DME"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_vision"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_dental"))).isDisplayed();
			Assert.assertEquals(true,value);

		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("my_medicare_claims_positive_tc_007");
		}
	}
	//TC_008 Verify the scenario to sort claims under 'Claims' tab
	@Then("Click on funnel icon and can able to sort Date created portion")
	public static void my_medicare_claims_positive_tc_008() throws IOException {
		try {
			click("claims_back_arrow");
			page_wait(15);
			AndroidTouchAction ta = new AndroidTouchAction(driver);
			AndroidElement ele = driver.findElement(By.xpath(OR_reader("claims_tile")));
			ta.tap(ElementOption.element(ele)).perform();
			page_wait(10);
			click("claims_claim_type_dropdown");
			page_wait(15);
			click("claims_professional");
			page_wait(10);
			click("claims_time_period_dropdown");
			page_wait(15);
			click("claims_year");
			page_wait(15);
			click("claims_funnel_icon");
			page_wait(25);
			click("claims_oldest_newest_box");
			page_wait(35);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("my_medicare_claims_positive_tc_008");
		}
	}
	//TC_009 Verify the scenario to view total number of claims record found
	@When("total number of claims are displayed")
	public static void my_medicare_claims_positive_tc_009() throws IOException {
		try {
			value = driver.findElement(By.xpath(OR_reader("claims_record_found"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(30);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("my_medicare_claims_positive_tc_009");
		}

	}
	//TC_0010 Verify the scenario to select one claim under the list of claims
	@Then("select one claim under the list of claims")
	public static void my_medicare_claims_positive_tc_0010() throws IOException {
		try {
			click("professional");
			page_wait(30);
			value = driver.findElement(By.xpath(OR_reader("claims_claim_details"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_claim_type_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_claim_type_value"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_claim_provider_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_claim_provider_value"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_claim_insurer_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_claim_patient_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_claim_service_date_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("my_medicare_claims_positive_tc_0010");
		}
	}
	//TC_0011 Verify the scenario when selected claim service details can be visible
	@Then("service details is displayed")
	public void my_medicare_claims_positive_tc_0011() throws IOException {
		try {
			value = driver.findElement(By.xpath(OR_reader("claims_services_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			click("claims_services_down_arrow");
			page_wait(10);
			value = driver.findElement(By.xpath(OR_reader("claims_service_quantity_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_claim_insurer_text"))).isDisplayed();
			Assert.assertEquals(true,value);
			value = driver.findElement(By.xpath(OR_reader("claims_claim_patient_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("my_medicare_claims_positive_tc_0012");
		}
	}
	//TC_0012 Verify the scenario when clicking on related records
	@Then("related records under claims is displayed")
	public static void my_medicare_claims_positive_tc_0012() throws IOException {
		try {
			value = driver.findElement(By.xpath(OR_reader("claims_related_record"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("my_medicare_claims_positive_tc_0013");
		}
	}
	//TC_0013 Verify the sceario when clicking on More icon
	@Then("click on More icon")
	public static void my_medicare_claims_positive_tc_0013() throws IOException {
		try {
			click("claims_more");
			page_wait(20);
			click("claims_immu");
			page_wait(60);
			page_wait(10);
			close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("my_medicare_claims_positive_tc_0014");
		}
	}
	
}
