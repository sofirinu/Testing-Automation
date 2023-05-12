package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MyAccountPage extends PageObject{
	
	@FindBy(xpath="//button[text()=\"My Account\"]")
	WebElementFacade myAccountButton;
	
	@FindBy(xpath="//button[@data-track=\"headerSignOutLink\"]")
	WebElementFacade signOutButton;
	
    
	public void clickMyAccountButton()
	{
		myAccountButton.click();
		waitABit(3000);
	}
	
	public void clickSignOutButton()
	{
		signOutButton.click();
		waitABit(3000);
	}
	
	
}
