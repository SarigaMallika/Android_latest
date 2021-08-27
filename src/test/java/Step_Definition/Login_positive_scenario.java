package Step_Definition;

import org.junit.Assert;
import org.openqa.selenium.By;

import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_positive_scenario extends Generic_functions {
	public static boolean value;

	@Given("Launch the URL")
	/*Browser launch*/
	public static void browser_launching() throws Exception  {
		try {
			app_launch();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("browser_launching");
		}
	}	
	@When("Clicks on 'Login' button")
	public void login() throws Exception {
		try {
			page_wait(5000);
			click("welcome_login");			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login");
		}
	}
	
	/*TC 001 - Validate that the'Phone number' field is prefixed with '+1' country code*/
	@Then("check  the  'Phone number' field is prefixed with country code")	
	public static void login_positive_tc_001() throws Exception   {
		try {
			page_wait(3000);
			value = driver.findElement(By.xpath(OR_reader("plus_one"))).isDisplayed();
			Assert.assertEquals(true,value);
		} 
		catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login_positive_tc_001");
		}
	}
	
	/*TC 002 - Validate that the user is able to click on the 'Forgot password?' link*/
	@When("clicks on 'Forgot password'")
	public static void login_positive_tc_002() throws Exception  {
		//		try {
//		page_wait(1000);
//		click("forgot_password_link");
		
		//			} catch (Exception e) {
		//e.printStackTrace();
		//takeScreenShot("login_positive_tc_002");
		//		}
	}
	@Then("navigated to Forgot password page")
	public void navigated_to_forgot_password_page() {
		//	try {
//		value = driver.findElement(By.xpath(OR_reader("Object Locator", "send_resend_link"))).isDisplayed();
//		Assert.assertEquals(true,value);
		//	} catch (Exception e) {
	//	e.printStackTrace();
		//takeScreenShot("login_positive_tc_002");
		//}

	}
	
	/*TC 003 - Validate that the user is able click on the 'Sign up' link*/
	@When("clicks on 'Sign up'")	
	public static void login_positive_tc_003() throws Exception  {
		//       try {
//		page_wait(2000);
//		click("forgot_signup_link");


		//			}  catch (Exception e) {
	//	e.printStackTrace();
		//takeScreenShot("login_positive_tc_003");
		//				
		//		}
	}
	
	@Then("navigated to Sign up page")
	public void sign_up_page()  throws Exception {
		//       try {
//		page_wait(1000);
//		value = driver.findElement(By.xpath(OR_reader("Object Locator", "signup_first_name"))).isDisplayed();
//		Assert.assertEquals(true,value);
		//		} catch (Exception e) {
	//	e.printStackTrace();
	//	takeScreenShot("login_positive_tc_003");
				}


	@Then("enters the Password")
	/*TC 004 -  Validate that the user is able to enter  the Password in the Password field*/
	public static void login_positive_tc_004() throws Exception {
		try {
//			page_wait(1000);
//			click("login_link");
//			page_wait(1000);
//			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("login_password",1));		
	//		page_wait(1000);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login_positive_tc_004");
		}
	}

	/*TC 005 - Validate that the user is able to Login with valid data*/
	@When("enters valid phonenumber and password")	
	public static void login_positive_tc_005() throws Exception  {
		try {
			//field_clear("login_password");
			page_wait(5000);
			driver.findElement(By.xpath(OR_reader("login_phone_number"))).sendKeys(td_reader("signup_phone_number",3));
			driver.findElement(By.xpath(OR_reader("login_password"))).sendKeys(td_reader("signup_password",0));
			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login_positive_tc_005");
		}
	}
	@Then("clicks on 'login'")
	public static void loginhome() throws Exception {
		try {
			click("login");
			page_wait(5000);
			} catch (Exception e) {
				e.printStackTrace();
				takeScreenShot("login_positive_tc_005");
			}
	}

	/*TC 006 - Validate that the user is navigated to 'Landing page' on clicking the 'Log out' option*/
	@When("clicks on Logout")	
	public static void login_positive_tc_006() throws Exception {
		try {
			page_wait(3000);
			click("home");			
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login_positive_tc_006");
		}
	}
	
	@Then("navigated to Landing page")
	public static void landingpage() throws Exception {
		try {		
			value = driver.findElement(By.xpath(OR_reader("hamburger"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(3000);
			click("hamburger");
			click("logout");
			page_back();
			close();
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login_positive_tc_006");	
		}		
	}
}
