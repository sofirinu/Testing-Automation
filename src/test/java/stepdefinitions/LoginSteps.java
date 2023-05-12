package stepdefinitions;

import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import pages.*;

public class LoginSteps {
	@Steps
	HomePage home;
	@Steps
	LoginPage login;
	
	
	// Successful Login
	@When("user clicks on SIGN IN link")
	public void user_clicks_on_sign_in_link()
	{
		home.clickSignIn();
		
	}
	
	@When("user enters {string} and {string}")
	public void user_enters_and(String email, String password) 
	{
		login.enterEmail(email);
		login.enterPassword(password);
	    login.showHidePassword();
	}
	
	@When("user clicks on Sign In button")
	public void user_clicks_on_sign_in_button() 
	{
	    login.clickSignInButton();
	}
	
	@Then("user is able to login successfully")
	public void user_is_able_to_login_successfully()
	{
		
    }
	
	@Then("user navigated to my account page")
	public void user_navigated_to_my_account_page()
	{
	    
	}

	//Unsuccessful Login with invalid credentials
	
	@When("user enters {string} in the PASSWORD textbox")
	public void user_enters_in_the_password_textbox(String password) {
	    login.enterPassword(password);
	    }
	@When("user clicks the Sign In button")
	public void user_clicks_the_sign_in_button() 
	{   
	   
		
	}
	@Then("user gets the error message Your email or password was incorrect")
	public void user_gets_the_error_message_your_email_or_password_was_incorrect() {
		login.checkInvalidLogin();
	}

    // Null field login
	
	@Then("user gets the validation error messages to the fields")
	public void user_gets_the_validation_error_messages_to_the_fields() {
		login.checkNullErrors();
	
	}
	
	// Invalid email error validation - same as register page invalid email test 
	
	




}
