package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import utils.ReportLog;
import utils.CommonMethods;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;

public class RegisterPage extends PageObject {

	@Steps
	ReportLog report;
	@Steps
	CommonMethods commonmeth;

	// Identification of web elements
	// Registration

	@FindBy(id = "email")
	WebElementFacade emailIdTextbox;

	@FindBy(id = "newPassword")
	WebElementFacade passwordTextbox;

	@FindBy(name = "confirmPassword")
	WebElementFacade confirmPasswordTextbox;

	@FindBy(className = "checkbox-group__input-wrapper")
	WebElementFacade agreeCheckBox;

	@FindBy(xpath = "//button[@type='submit']") 	//@FindBy(css = "button[type='submit']")
	WebElementFacade createPCIdButton;

	//Existing email id error element
	@FindBy(xpath = "//div[@class='form-message__content']")
	WebElementFacade existEmailIdError;

	@FindBy(xpath ="//input[@id='termsAndConditions']")
	WebElementFacade agreeCheckBoxExistEmail;

	// Elements of required field validation error message
	@FindBy(xpath = "//label[text()=\"Please enter an email address.\"]")
	WebElementFacade nullEmailIdError;

	@FindBy(xpath = "//label[text()=\"Please enter a password.\"]")
	WebElementFacade nullPasswordError;

	@FindBy(xpath = "//label[text()=\"Please confirm your password.\"]")
	WebElementFacade nullConfirmPasswordError;

	@FindBy(id="termsAndConditions__error")
	WebElementFacade agreeCheckBoxError;

	//Pattern/format match validation
	@FindBy(xpath = "//label[text()='Please enter a valid email address.']")
	WebElementFacade invalidEmailIdError;

	//@FindBy(xpath = "//label[text()='Minimum 10 characters']")
	@FindBy(id ="newPassword__error")
	WebElementFacade invalidPasswordError1;

	@FindBy(xpath = "//label[text()='Password does not meet requirements.']")
	WebElementFacade invalidPasswordError2;

	//Password mismatch error element
	@FindBy(id = "confirmPassword__error")
	WebElementFacade confirmPasswordError;

	//Registration
	public void enterEmail(String email) 
	{

		emailIdTextbox.sendKeys(email); // entering values
		report.LOG("Entered the email");
		waitABit(2000);
	}

	public void enterPassword(String passwrd) 
	{
		passwordTextbox.sendKeys(passwrd);
		//report.LOG("Entered the password");
		waitABit(2000);	
	}

	public void enterConfirmPassword(String confPassword)
	{
		confirmPasswordTextbox.sendKeys(confPassword);
		//report.LOG("Entered the confirm password");
		waitABit(2000);	
	}

	public void clickTcCheckbox(){
		agreeCheckBox.click();
		//report.LOG("Clicked on checkbox");
		waitABit(2000);

	}

	public void clickCreatePcId() {
		createPCIdButton.click();
		//report.LOG("Clicked on PC ID button");
		waitABit(2000);
		//commonmeth.closebrowser();
	}


	// Validate existing email id error 
	//Actual result is compared with expected result with the help of Assertion. 
	//It means verification is done to check if the state of the application is the same to what we are expecting or not.
	//Assertions can be handled with the help of the predefined method of JUnit library

	public void checkExistEmailError()
	{
		String actualExistEmailErrorFull = existEmailIdError.getText();
		String actualExistEmailError = actualExistEmailErrorFull.substring(0,114);
		String expectedExistEmailError = "Looks like you already have an account with casacsmsc11@gmail.com, please sign in or choose another email address.";
		//System.out.println(expectedExistEmailError.length());
		Assert.assertEquals(actualExistEmailError, expectedExistEmailError);
		System.out.println("Already registered Email Id error shown as expected..!");
		waitABit(2000);	
	}

	public void checkFieldStatus()
	{
		//System.out.println("Password Textbox Disabled?: "+ passwordTextbox.isDisabled());
		//System.out.println("Confirm Password Textbox Disabled?: "+ confirmPasswordTextbox.isDisabled());
		//System.out.println("T&C Checkbox Disabled?: "+ agreeCheckBoxExistEmail.isDisabled());
		System.out.println("Create PcId button Disabled?: "+ createPCIdButton.isDisabled());	
	}


	// Validate required field error messages
	public void checkNullErrors()
	{
		String actualEmailError = nullEmailIdError.getText();
		String expectedEmailError = "Please enter an email address.";
		Assert.assertEquals(expectedEmailError, actualEmailError); 
		System.out.println("Displayed Email ID as a mandatory field");

		String nullPasswordActualError = nullPasswordError.getText();
		String nullPasswordexpectedError = "Please enter a password.";
		Assert.assertEquals(nullPasswordActualError, nullPasswordexpectedError);
		System.out.println("Displayed Password as a mandatory field");

		String confirmPasswordActualError = nullConfirmPasswordError.getText();
		String confirmPasswordexpectedError = "Please confirm your password.";
		Assert.assertEquals(confirmPasswordActualError, confirmPasswordexpectedError);
		System.out.println("Displayed Confirm Password as a mandatory field");

		String actualCheckboxError = agreeCheckBoxError.getText();
		String expectedCheckboxError = "You must agree to the Privacy Policy and Terms to continue.";
		Assert.assertEquals(actualCheckboxError, expectedCheckboxError);
		System.out.println("Displayed Checkbox as mandatory");	   	
	}

	//Validate email invalid format error message
	public void checkEmailError()
	{	  
		String actualInvalidEmailError = invalidEmailIdError.getText();
		String expectedInvalidEmailError ="Please enter a valid email address.";
		Assert.assertEquals(actualInvalidEmailError, expectedInvalidEmailError);
		System.out.println("Expected error message on invalid email is displayed");   
	}
	
	//Validate password invalid format error messages
	public void checkPasswordError()
	{		
		String invalidPasswordActualError = invalidPasswordError1.getText();
		String invalidPasswordExpectedError1 = "Minimum 10 characters";
	    String invalidPasswordExpectedError2 = "Password does not meet requirements.";
		
	    assertThat(invalidPasswordActualError).isIn(invalidPasswordExpectedError1, invalidPasswordExpectedError2);
		System.out.println("Expected error message for invalid password displayed:"+invalidPasswordActualError);
		waitABit(3000);			
	}


	//Validate password mismatch error
	public void checkPasswordMisMatchError()
		{
			String actualPasswordError = confirmPasswordError.getText();
			String expectedError = "The passwords above don't match.";
			//Positive Scenario
			Assert.assertEquals(actualPasswordError, expectedError);
			System.out.println("Password Mismatch error shown as expected..!");
			waitABit(2000);
			//Negative Scenario
			//Assert.assertEquals("The passwordss above don't match", confirmPasswordError.getText());
			//waitABit(2000);	
		}

}