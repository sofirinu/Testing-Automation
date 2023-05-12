package pages;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import utils.ReportLog;

public class LoginPage extends PageObject{

    @Steps
	ReportLog report;

	   // Elements for Login 

		@FindBy(id="email")
		WebElementFacade emailTextBox;

		@FindBy(name="password")
		WebElementFacade passwordTextBox;

		@FindBy(xpath = "//button[text() = 'Show Password']")
		WebElementFacade showPasswordLink;

		@FindBy(xpath = "//button[text() = 'Hide Password']")
		WebElementFacade hidePasswordLink;

		@FindBy(xpath = "//button[@type=\"submit\"]")
		WebElementFacade signInButton;
        
		// Invalid Login error message element
		
		@FindBy(xpath ="//div[@class='form-message__content']")
		WebElementFacade invalidLoginError;
		
		// Link to registration page
	    
		@FindBy(xpath = "//span[text() = 'Create a ']") //tagname[text() = 'Text of the tag you are referring'] 
		WebElementFacade clickPcID;
        
		// Link to forgot password page
		
		@FindBy(xpath = "//span[text() = 'Forgot Password?']") 
		WebElementFacade forgotPasswordLink;
		
		//Field validation mesaage elements
		
		@FindBy(xpath="//label[text()='Please enter an email address.']")
		WebElementFacade emailNullError;
		
		@FindBy(xpath="//label[text()='Please enter a valid email address.']")
		WebElementFacade emailInvalidError;
		
		@FindBy(id="password__error")
		WebElementFacade passwordNullError;
		
		// CreatePcIdLink of Register page

		public void clickCreatePcIdLink() {

			clickPcID.click();
			//report.LOG("clicked on CreatePD ID link");
			waitABit(3000);

			// Validate the Url and Page title for Register page
			System.out.println("Register page Title:"+getDriver().getTitle());
			System.out.println("Register page Url:"+getDriver().getCurrentUrl());

			Assert.assertEquals("Create a PC™id", getDriver().getTitle());
			Assert.assertEquals("https://accounts.pcid.ca/create-account", getDriver().getCurrentUrl());

		}

		// Successful Login
		
		public void enterEmail(String email)
		{
			emailTextBox.sendKeys(email);
			waitABit(3000);
		}
		
		public void enterPassword(String password)
		{
			passwordTextBox.sendKeys(password);
			waitABit(3000);

		}

		public void showHidePassword()
		{
			showPasswordLink.click();
			waitABit(3000);
			hidePasswordLink.click();
			waitABit(3000);
		}
		
		public void clickSignInButton()
		{
			signInButton.click();
			waitABit(15000);
			getDriver().close();
		}
		
		// Validate error message on login with invalid credentials
		
		public void checkInvalidLogin()
		{
			signInButton.click();
			waitABit(2000);
			String actualError = invalidLoginError.getText();
			String expectedError = "Your email or password was incorrect.";
			Assert.assertEquals(actualError, expectedError);
			System.out.println("Error message on Invalid login displayed:"+actualError);
			waitABit(3000);
			getDriver().close();
		}

		// Validate required field error messages
		
		public void checkNullErrors()
		{
			signInButton.click();
			waitABit(2000);
			
			String actualEmailError = emailNullError.getText();
			String expectedEmailError = "Please enter an email address.";
			Assert.assertEquals(expectedEmailError, actualEmailError); 
			System.out.println("Displayed Email ID as a mandatory field");
            
			String nullPasswordActualError = passwordNullError.getText();
			String nullPasswordexpectedError = "Please enter a password.";
			Assert.assertEquals(nullPasswordActualError, nullPasswordexpectedError);
			System.out.println("Displayed Password as a mandatory field");
		}
		
		// Link to Forgot password page
		
		public void clickForgotPasswordLink()
        {
			forgotPasswordLink.click();
			waitABit(2000);
			
        }
	
		

}