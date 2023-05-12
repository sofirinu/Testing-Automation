package stepdefinitions;

import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import pages.*;

public class ForgotPasswordSteps {
	
	@Steps
	LoginPage login;
	@Steps
	ForgotPasswordPage fp;
	//RegisterPage reg;
	
	// Successful attempt of forgot password
	
	@When("user clicks on Forgot Password link")
	public void user_clicks_on_forgot_password_link() {
		
		login.clickForgotPasswordLink();
		
	    }
	@Then("user navigated to Forgot Password page")
	public void user_navigated_to_forgot_password_page() {
	    
	}
	@When("user clicks on Send Email button")
	public void user_clicks_on_send_email_button() {
		fp.clickSendEmailButton();
	}
	@Then("user is able to see a message We have emailed a link to abcdemsc11@gmail.com. If you do not receive an email, please verify that the email entered is associated with a valid PC™idID account and resubmit. with a greentick mark")
	public void user_is_able_to_see_a_message_we_have_emailed_a_link_to_abcdemsc11_gmail_com_if_you_do_not_receive_an_email_please_verify_that_the_email_entered_is_associated_with_a_valid_pc_id_id_account_and_resubmit_with_a_greentick_mark() {
		fp.checkError();
	}
	@Then("a Reset Password link sent to the email")
	public void a_reset_password_link_sent_to_the_email() {
	    	}
	@Then("Send Email button is disabled")
	public void send_email_button_is_disabled() {
	fp.checkButtonStatus();
	    
	}
	




}
