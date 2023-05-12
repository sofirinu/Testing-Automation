package pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import utils.CommonMethods;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WindowHandles extends PageObject {


	@Steps
	HomePage home;
	@Steps
	CommonMethods cm;

	public void testWindowHandleForLoblaws() {

		home.openApplication();

		Actions action = new Actions(getDriver());

		// to hover on category
		WebElement categoryName = getDriver().findElement(By.xpath("//span[text()='Flyers & Deals']"));
		action.moveToElement(categoryName).build().perform();


		// to hover on Subcategory
		WebElement subCategoryName = getDriver().findElement(By.xpath("//span[text()='Digital Coupons']"));
		action.moveToElement(subCategoryName).build().perform();

		// click on sub category
		subCategoryName.click();
		waitABit(5000);

		// take all the windows which are opened and get the IDs - parent windows&child window
		Set<String> allWindowHandles = getDriver().getWindowHandles();
		// give the count of Windows
		System.out.println("Windows count:"+allWindowHandles.size());
		
		for (String handle : allWindowHandles) {
			System.out.println(handle);	
		}


		// iterating and check for windows one by one
		Iterator<String> it = allWindowHandles.iterator();

		String parentWindow = it.next();
		System.out.println("parentWindow:  " +   parentWindow);

		String childWindow = it.next();
		System.out.println("childWindow:  " +   childWindow);

		// to give control to the child window and perform operations
		getDriver().switchTo().window(childWindow);
		waitABit(6000);
		System.out.println("*************Child Window details**************");
		System.out.println(getDriver().getCurrentUrl());
		System.out.println(getDriver().getTitle());

		// close()-this will close the current window where driver has control
		getDriver().close();
		// quit()-this will close all the windows which are opened by the driver
		//getDriver().quit();

		// Switching back to the main window or to another child window
		getDriver().switchTo().window(parentWindow);
		waitABit(6000);
		System.out.println("********Parent Window details**********");
		System.out.println(getDriver().getCurrentUrl());
		System.out.println(getDriver().getTitle());
		getDriver().close();

	}
	
	//Single window
    public void testNewWindowHandles()
    {
    	getDriver().get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		getDriver().manage().window().maximize();
		waitABit(4000);

		//for new window
			getDriver().findElement(By.id("newWindowBtn")).click();

		//for new tabs
	  //getDriver().findElement(By.id("newTabsBtn")).click();

		Set<String> allWindowHandles = getDriver().getWindowHandles();
		System.out.println(allWindowHandles.size());

		for (String handle : allWindowHandles) {
			System.out.println(handle);	
		}

		Iterator<String> it = allWindowHandles.iterator();

		String parentWindow = it.next();
		System.out.println("Parent window: " + parentWindow);

		String childWindow = it.next();
		System.out.println("Child window: " + childWindow);
		
		getDriver().switchTo().window(childWindow);
		waitABit(3000);
		
		System.out.println("TitleOfChildWindow: " + getDriver().getTitle());
		
		
		getDriver().close(); // close current window

		getDriver().switchTo().window(parentWindow);
		waitABit(4000);
		
		System.out.println("TitleOfparentWindow:" + getDriver().getTitle());
		getDriver().quit(); // 


    }
    
    // single tab
    
    public void testNewTabHandles()
    {
    	getDriver().get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		getDriver().manage().window().maximize();
		waitABit(4000);

		//for new tab
			getDriver().findElement(By.id("newTabBtn")).click();

		Set<String> allWindowHandles = getDriver().getWindowHandles();
		System.out.println(allWindowHandles.size());

		for (String handle : allWindowHandles) {
			System.out.println(handle);	
		}

		Iterator<String> it = allWindowHandles.iterator();

		String parentTab = it.next();
		System.out.println("Parent tab: " + parentTab);

		String childTab = it.next();
		System.out.println("Child tab: " + childTab);
		
		getDriver().switchTo().window(childTab);
		waitABit(3000);
		
		System.out.println("TitleOfChildTab: " + getDriver().getTitle());
		
		
		getDriver().close(); // close current window

		getDriver().switchTo().window(parentTab);
		waitABit(4000);
		
		System.out.println("TitleOfparentTab:" + getDriver().getTitle());
		getDriver().quit(); // 

    }
    
    //multiple windows
	public void testWindowHandles() {

		getDriver().get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		getDriver().manage().window().maximize();
		waitABit(4000);

		//for new windows
			getDriver().findElement(By.id("newWindowsBtn")).click();


		Set<String> allWindowHandles = getDriver().getWindowHandles();
		System.out.println(allWindowHandles.size());

		for (String handle : allWindowHandles) {
			System.out.println(handle);	
		}

		Iterator<String> it = allWindowHandles.iterator();

		String parentWindow = it.next();
		System.out.println("Parent window " + parentWindow);

		String childWindow = it.next();
		System.out.println("Child window " + childWindow);
		
		getDriver().switchTo().window(childWindow);
		getDriver().manage().window().maximize();
		waitABit(4000);
		
		cm.scrolldown();
		
		
		System.out.println("TitleOfChildWindow " + getDriver().getTitle());
		// fill first name, last name, etc
		
		getDriver().findElement(By.id("firstName")).sendKeys("Mark");
		getDriver().findElement(By.id("lastName")).sendKeys("John");
		getDriver().findElement(By.id("malerb")).click();
		getDriver().findElement(By.id("englishchbx")).click();
		getDriver().findElement(By.id("hindichbx")).click();
		getDriver().findElement(By.id("email")).sendKeys("abc@gmail.com");
		getDriver().findElement(By.name("psw")).sendKeys("abc@gmail.com");
		waitABit(4000);
		getDriver().findElement(By.id("clearbtn")).click();
		waitABit(6000);
		
		getDriver().close();

		String secondChildWindow = it.next();
		System.out.println("Second Child window " + secondChildWindow);
		
		getDriver().switchTo().window(secondChildWindow);
		waitABit(4000);
		
		System.out.println("TitleOfSecondChildWindow " + getDriver().getTitle());
		// fill first name, last name, etc
		getDriver().close(); // close current window

		getDriver().switchTo().window(parentWindow);
		waitABit(4000);
		
		System.out.println("TitleOfparentWindow" + getDriver().getTitle());
		getDriver().quit(); // 

	}

	
	   //multiple tabs
		public void testTabsHandles() {

			getDriver().get("https://www.hyrtutorials.com/p/window-handles-practice.html");
			getDriver().manage().window().maximize();
			waitABit(4000);

			//for new tabs
				getDriver().findElement(By.id("newTabsBtn")).click();


			Set<String> allWindowHandles = getDriver().getWindowHandles();
			System.out.println(allWindowHandles.size());

			for (String handle : allWindowHandles) {
				System.out.println(handle);	
			}

			Iterator<String> it = allWindowHandles.iterator();

			String parentWindow = it.next();
			System.out.println("Parent tab: " + parentWindow);

			String childWindow = it.next();
			System.out.println("Child tab: " + childWindow);
			
			getDriver().switchTo().window(childWindow);
			
			
			
			System.out.println("TitleOfChildTab: " + getDriver().getTitle());
			
			
			getDriver().close();

			String secondChildTab = it.next();
			System.out.println("Second Child window " + secondChildTab);
			
			getDriver().switchTo().window(secondChildTab);
			waitABit(4000);
			
			System.out.println("TitleOfSecondChildTab: " + getDriver().getTitle());
			// fill first name, last name, etc
			getDriver().close(); // close current window

			getDriver().switchTo().window(parentWindow);
			waitABit(4000);
			
			System.out.println("TitleOfparentTab:" + getDriver().getTitle());
			getDriver().quit(); // 

		}

	
}
