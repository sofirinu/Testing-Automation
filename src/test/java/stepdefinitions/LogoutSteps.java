package stepdefinitions;

import io.cucumber.java.en.*;
import pages.*;

public class LogoutSteps {

	MyAccountPage ma = new MyAccountPage();
	
	@When("user clicks on myaccount menu")
	public void user_clicks_on_myaccount_menu() {
		ma.clickMyAccountButton();
	    	}
	@Then("user able to see the options")
	public void user_able_to_see_the_options() {
	    	}
	@Then("user clicks on Sign Out menu")
	public void user_clicks_on_sign_out_menu() {
		ma.clickSignOutButton();
	   	}
	@Then("user signedout of the website")
	public void user_signedout_of_the_website() {
	    	}



}
