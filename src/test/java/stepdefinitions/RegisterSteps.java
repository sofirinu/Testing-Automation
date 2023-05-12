package stepdefinitions;

import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import pages.*;
public class RegisterSteps {

	@Steps
	HomePage home;
	@Steps
	LoginPage login;
	@Steps
	RegisterPage reg;
	
	// Successful Registration
	
	@Given("user launches Loblaws website")
	public void user_launches_loblaws_website() {

      home.openApplication();
	}
	@When("user clicks on sign in link")
	public void user_clicks_on_sign_in_link() {
	   home.clickSignIn();
	}
	@Then("user navigated to Sign in with PC™id page")
	public void user_navigated_to_sign_in_with_pc_id_page() {
	    
	}
	@When("user clicks on Create a PC™id link")
	public void user_clicks_on_create_a_pc_id_link() {
	   login.clickCreatePcIdLink();
	}
	@Then("user navigated to Create a PC™id page")
	public void user_navigated_to_create_a_pc_id_page() {
	}
	
	
	@Then("user enters {string} ,{string} and {string}")
	public void user_enters_and(String email, String password, String confirmPassword) {
		reg.enterEmail(email);
		reg.enterPassword(password);
		reg.enterConfirmPassword(confirmPassword);
		
	}
	
	@Then("user checks the agree checkbox")
	public void user_checks_the_agree_checkbox() {
	   reg.clickTcCheckbox();
	}
	@Then("user clicks on Create a PC™id button")
	public void user_clicks_on_create_a_pc_id_button() {
	   reg.clickCreatePcId();
	}
	@Then("user navigated to complete my profile page")
	public void user_navigated_to_complete_my_profile_page() {
	    
	}
	
	// Validate error message on registration with existing email id
	
	@When("user enters {string} in the EMAIL textbox")
	public void user_enters_in_the_email_textbox(String email) {
	   reg.enterEmail(email);	
	}

	@Then("user see an error message Looks like you already have an account with casacsmsc11@gmail.com, please sign in or choose another email address.")
	public void user_see_an_error_message_looks_like_you_already_have_an_account_with_casacsmsc11_gmail_com_please_sign_in_or_choose_another_email_address() {
	    reg.checkExistEmailError();
	}
	@And("the submit button becomes disabled")
	public void the_submit_button_becomes_disabled() {
		reg.checkFieldStatus();
	    
	}
	
	// Validate error messages on registering with all null entries
		
		@Then("user gets the validation error messages to all fields")
		public void user_gets_the_validation_error_messages_to_all_fields() {
			reg.checkNullErrors();
		}


   // Validate invalid email error messages
	
	@Then("user gets the validation error message right below the textfield")
	public void user_gets_the_validation_error_message_right_below_the_textfield() {
		reg.checkEmailError();
	}
	@And("a red exclamation mark enclosed in circle is displayed to the right most of the email textfield")
	public void a_red_exclamation_mark_enclosed_in_circle_is_displayed_to_the_right_most_of_the_email_textfield() {
		
	}

   // Validate invalid password
		
	@When("user enters {string} in the  PASSWORD textbox")
	public void user_enters_in_the_password_textbox(String password) {
	    reg.enterPassword(password);
	    }
	@Then("user is able to see a validation error message right below the textfield")
	public void user_is_able_to_see_a_validation_error_message_right_below_the_textfield() {
		reg.checkPasswordError();
		}
	@Then("user is able to see a message Password Strength - Weak with a red progress bar at the right below of the errormessage")
	public void user_is_able_to_see_a_message_password_strength_weak_with_a_red_progress_bar_at_the_right_below_of_the_errormessage() {
	   	}
	@Then("a red exclamation mark enclosed in circle is displayed to the right most of the password textfield")
	public void a_red_exclamation_mark_enclosed_in_circle_is_displayed_to_the_right_most_of_the_password_textfield() {	   
	 }

	//Password mismatch error

	@When("user enters {string} in the CONFIRM PASSWORD textbox")
	public void user_enters_in_the_confirm_password_textbox(String conPassword) {	
		reg.enterConfirmPassword(conPassword);
		
	    
	   }
	@Then("user gets the validation error message The passwords above do not match. right below the CONFIRM PASSWORD textfield")
	public void user_gets_the_validation_error_message_the_passwords_above_do_not_match_right_below_the_confirm_password_textfield() {
		reg.checkPasswordMisMatchError();
	}
	@Then("a red exclamation mark enclosed in circle is displayed to the right most of the textfield")
	public void a_red_exclamation_mark_enclosed_in_circle_is_displayed_to_the_right_most_of_the_textfield() {
	   	}




	
	




	




}
