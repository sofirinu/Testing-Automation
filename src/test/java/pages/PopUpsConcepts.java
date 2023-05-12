package pages;

import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import utils.*;

public class PopUpsConcepts extends PageObject{

	@Steps
	ReportLog report;
	@Steps
	CommonMethods common;

    // Javascript alerts
	public void testJavaScriptAlerts() {

		getDriver().get("https://www.rediff.com/"); 
		waitABit(3000);
		getDriver().manage().window().maximize();
		
		// home sign in link click
		getDriver().findElement(By.className("signin")).click();
		waitABit(3000);
		
		//1.sign in button click
		getDriver().findElement(By.name("proceed")).click();
		report.LOG("clicked on login and alert is displayed");
        
		// not able to inspect alert
		// creating alert object and switch to alert
		Alert alert = getDriver().switchTo().alert();
		waitABit(3000);
        
		// getting text from alert
		String alertmessage = alert.getText();
		System.out.println("Alert Message: "+alertmessage);
		// 2. accept the alert
		alert.accept();
		
		// to cancel alert
		//alert.dismiss();

		//to enter data in the alert,if it has textbox
		//	alert.sendKeys("text to enter");
		//	alert.accept();

		Assert.assertEquals("Please enter a valid user name", alertmessage);
		report.LOG("login alert is accepted");
		System.out.println("login alert is accepted");

        //3.enter uname
		getDriver().findElement(By.id("login1")).sendKeys("Test12344");waitABit(3000); //enter username
		//4.click signin btn
		getDriver().findElement(By.name("proceed")).click();
		waitABit(3000);
		
		System.out.println("-----------------------------------------");
		//5.get alert
		String alertmessage2 = alert.getText();
		System.out.println("Alert Message: "+alertmessage2);
		alert.accept();

		Assert.assertEquals("Please enter your password", alertmessage2);
		report.LOG("password alert is accepted");
		System.out.println("password alert is accepted");

	}


	public void testDesktopPopUp(String fileName) {
		
		// to get the folder pathof your project
		String path = System.getProperty("user.dir"); // here till Testing automation
		String filepath = path +"\\data\\";    // folder name - data
		String fullFilePath  = filepath + fileName;
		System.out.println(fullFilePath);
        
		// open application
		getDriver().get("https://html.com/input-type-file/");
		getDriver().manage().window().maximize();
		waitABit(3000);
		common.scrolldown();
		common.scrolldown();

		waitABit(3000);
		// we will not do click on chhose file; becasue a window will open and control will shift to that window popup
		// which Selenium cannot handle
		//So,passing file to choose file btn
		getDriver().findElement(By.id("fileupload")).sendKeys(fullFilePath);
		waitABit(5000);
		report.LOG("uploaded " + fileName);
		System.out.println("uploaded " + fileName);

		getDriver().findElement(By.xpath("//input[@value='submit']")).click();
		waitABit(3000);
		report.LOG("Submit is clicked");
		System.out.println("Submit is clicked");
		common.closebrowser();

	}

}
