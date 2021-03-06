package Step_Definition;

import org.junit.Assert;
import org.openqa.selenium.By;
import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class Second_opinion_dashboard_positive_scenarios extends Generic_functions {
	static boolean value;
	static String text;

	/* Browser opens and enter URL*/ 	
	@Given("browser is open")
	public static void browser_open() throws Exception {
		try {
			app_launch();
			page_wait(1000);
			value = driver.findElement(By.xpath(OR_reader("welcome_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("clicks on the 'login' button")
	public static void login() throws Exception {
		try {
			click("welcome_login");
			click("login_phone_number");
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("login_phone_number",9));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",0));
			page_wait(1000);
			click("login");			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login");
		}
	}
	@And("navigated to the login page")
	public static void loginpage() throws Exception {
		try {
			page_wait(2000);
			value = driver.findElement(By.xpath(OR_reader("login_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
		}  catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("loginpage");
		}
	}

	/*  TC_001-Validate that the user is able to click on the Second Opinion tab*/	
	@When("clicks on the second opinion tab")
	public static void second_opinion_positive_dashboard_tc_001() throws Exception {
		try {
			page_wait(2000);
			click("services");
			click("second_opinions");					
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("second_opinion_positive_dashboard_tc_001");
		}
	}

	@Then("navigated to second opinion page")
	public static void second_opinion_page() throws Exception {
		try {
			page_wait(2000);
			text= driver.findElement(By.xpath(OR_reader("second_opinions_title"))).getText();
			Assert.assertEquals(text,td_reader("second_opinions_title"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("second_opinion_positive_dashboard_tc_001");
		}	
	}

	/* TC_002-Validate that the user is able to click on Resume Cases and is navigated to uplaod scans page */
	@When ("clicks on Resume Cases")
	public static void second_opinion_positive_dashboard_tc_002() throws Exception, InterruptedException{
		try{
			page_wait(2000);
			click("so_resume_case");
			page_wait(2000);
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("second_opinion_positive_dashboard_tc_002");
		}
	}
	@Then("navigated to switch to web alert")
	public static void navigate_SwitchToWeb() {
		try{
			text = driver.findElement(By.xpath(OR_reader("so_resume_case_title"))).getText();
			Assert.assertEquals(text,td_reader("so_resume_case_title"));
			text = driver.findElement(By.xpath(OR_reader("so_switch_web_text"))).getText();
			Assert.assertEquals(text,td_reader("so_switch_web_text"));
			click("so_switch_ok_button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/* TC_003 - Validate that User is able to click on Requested tab */
	@When ("clicks on the Requested tab")
	public static void second_opinion_positive_dashboard_tc_007() throws Exception, InterruptedException
	{
		try {
			click("so_requested_tab");		
		}catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("second_opinion_positive_dashboard_tc_003");
		}
	}
	@Then("navigated to Requested page")
	public static void Requestedpage() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("so_requested_icon"))).isDisplayed();
			Assert.assertEquals(true,value);
			text= driver.findElement(By.xpath(OR_reader("so_requested_msg"))).getText();
			Assert.assertEquals(text,td_reader("so_requested_msg"));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("second_opinion_positive_dashboard_tc_003");
		}
	}

	/* TC_004 - Validate that User is able to click on Reviewed tag */
	@When ("clicks on the Reviewed tab")
	public static void second_opinion_positive_dashboard_tc_008() throws Exception
	{ 
		try {
			click("so_reviewed_tab"); 		
		}
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("second_opinion_positive_dashboard_tc_004");
		}
	}
	@Then("navigated to Reviewed  page")
	public static void Reviewedpage() throws Exception {
		try {
			page_wait(3000);
			value = driver.findElement(By.xpath(OR_reader("so_requested_icon"))).isDisplayed();
			Assert.assertEquals(true,value);
			text= driver.findElement(By.xpath(OR_reader("so_reviewed_msg"))).getText();
			Assert.assertEquals(text,td_reader("so_reviewed_msg"));
			close();		
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("second_opinion_positive_dashboard_tc_004");
		}
	}		
}