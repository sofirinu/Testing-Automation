package pages;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import junit.runner.*;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import utils.CommonMethods;
import utils.ReportLog;

public class ForgotPasswordPage extends PageObject{
	
	@Steps
	ReportLog report;
	@Steps
	CommonMethods commonmeth;
	
	@FindBy(id="email")
	WebElementFacade emailTextBox;
	
	@FindBy(xpath="//button[text() = 'Send Email']")
	WebElementFacade sendEmailButton;
	
	@FindBy(xpath="//div[@class = 'form-message__content']")
	WebElementFacade message;
	
	
	public void clickSendEmailButton()
	{
		sendEmailButton.click();
		report.LOG("Send Email button clicked");
		waitABit(2000);		
	}
	
	
	public void checkError()
	{  
		String actualErrorFull = message.getText();
	    String preExpected = "We've emailed a link to ";
	    String email = emailTextBox.getValue();
	    String postExpected = ". If you do not receive an email, please verify that the email entered is associated with a valid PC™id";
		String expectedError = preExpected+email+postExpected;
		int l = actualErrorFull.length();
		int last = 25;
		int firstLenghth = l-last;
		String actualError = StringUtils.left(actualErrorFull, firstLenghth);
	    Assert.assertEquals(actualError, expectedError);
	    System.out.println("Error message displayed:"+actualError);	
	}
	
	public void checkButtonStatus()
	{
		System.out.println("Send Email button Disabled?: "+ sendEmailButton.isDisabled());
		report.LOG("Send Email button disabled");
		waitABit(2000);	
    }
}
