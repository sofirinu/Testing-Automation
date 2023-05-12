package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import setup.Init;
import utils.CommonMethods;
import utils.ReportLog;

//We will use selenium drivers&some predefined methods 
//to use those,we will use pageobject class,so extends that class


public class HomePage extends PageObject{

	// create object for class to access method here from class
	@Steps
	Init init;
	@Steps
	ReportLog report;
	@Steps
	CommonMethods cm;

	/*one way of element identification- using WebElement -another way - using WebElement Facade

	WebElement cookies = getDriver().findElement(By.className("Ids__privacy-policy__btnClose"));
	cookies.click();*/

	// using Web Element Facade
	@FindBy(className = "lds__privacy-policy__btnClose")
	WebElementFacade clearCookiesPopUp;

	// find element by-xpath- //-for search whole document then tag[@attribute="value"] 
	//a[@data-auid="account-login-button"]
	//a[@class="sign-in account__login-link"]
	@FindBy(xpath = "//a[@class='sign-in account__login-link']")
	WebElementFacade clickSignInOnHome;

	@FindBy(xpath="//input[@class=\"search-input__input\"]")
	WebElementFacade searchBar;
    
	
	@FindBy(xpath="//button[@title=\"Submit Search\"]")
	WebElementFacade searchButton;


	//Elements of Sort by option after search for products

	@FindBy(xpath="//button[@data-sort-code='recommended' and text()='Relevance']") 
	WebElementFacade firstRelevanceButton;

	@FindBy(xpath= "//button[@data-option-value= 'recommended']") 
	WebElementFacade sortByRelevance;

	@FindBy(xpath= "//button[text()= 'Price (Low to High)']") 
	WebElementFacade sortByPriceLowToHigh;

	@FindBy(xpath= "//button[text()= 'Price (High to Low)']") 
	WebElementFacade sortByPriceHighToLow;

	@FindBy(xpath= "//button[text()= 'A-Z (alphabetical)']") 
	WebElementFacade sortByAlphabetical;

	@FindBy(xpath= "//button[text()= 'Newest to Oldest Products']") 
	WebElementFacade sortByNewToOld;

	//  Elements for add to cart

	//ArrayList of products(web elements)	
	List <WebElementFacade> productDetails;

	//Pickup/Delivery option elements
	@FindBy(xpath = "//button[@aria-label='pickup']")
	WebElementFacade pickUpButton;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElementFacade confirmLocation;

	//img[@alt='PICKUP'] - imglink
	//button[@data-cruller='confirm-nearby-location-button' and text()='Yes'] - confirm location
	//a[@data-cruller='store-locator-link'] -change location

	//img[@alt='COURIER'] -
	//postalCode - //input[@id='postalCode']  //button[@type='submit' and text()='Save'] findBy(name="switch-to-pickup-postal-code-modal")

	// cart element
	@FindBy(xpath ="//span[@class = 'cart-item-count__text']")
	WebElementFacade noOfItemsInCart;		

	// Launch Loblaws

	public void openApplication()
	{

		//open the url in  browser specified in the file
		getDriver().get("https://www.loblaws.ca/");
		//getDriver().navigate().to("https://www.loblaws.ca/");

		// from Properties file
		//getDriver().get(init.getAppUrl());
		getDriver().manage().window().maximize();
		//report.LOG("Loblaws Url is opened");
		waitABit(4000);

		//Check whether the popup is currently visible and clear

		if (clearCookiesPopUp.isCurrentlyVisible()) {
			clearCookies();
		}

	}

	public void clearCookies() 
	{

		clearCookiesPopUp.click();
		//report.LOG("Cookies are cleared");
		waitABit(2000);

	}


	// Sign in menu to login page
	public void clickSignIn()
	{

		clickSignInOnHome.click();
		waitABit(3000);

		// Validate the Url and Page title for login page
		System.out.println("Login page Title:"+getDriver().getTitle());
		System.out.println("Login page Url:"+getDriver().getCurrentUrl());

		Assert.assertEquals("Sign In | PC™id", getDriver().getTitle());
		Assert.assertEquals("https://accounts.pcid.ca/login", getDriver().getCurrentUrl());

	}
    
	// type product name in searchbar
	public void enterProduct(String product)

	{
		searchBar.sendKeys(product);
		waitABit(2000);

	}
	// click search button
	public void clickSearchButton()

	{
		searchButton.click();
		waitABit(2000);
		
	}
	// type and choose from below options

	public void clickProductOptions(String productOption)

	{
		//Find search option
		String preXpath = "//span[@aria-label='";
		String postXpath = "']";
		
		String fullXpath = preXpath+productOption+postXpath;  //span[@aria-label='Egg & Egg Substitutes'] ////span[@aria-label='Dairy & Eggs']
		getDriver().findElement(By.xpath(fullXpath)).click();

		waitABit(2000);
		
	}

	
	
    //type product name and press enter
	public void typeAndHitEnter(String product)
	{
		searchBar.typeAndEnter(product);
		waitABit(2000);
		
	}
	
	// Search for Adding product to cart
	public void enterProductClickSearchButton(String product)
	{
		// to clear data in the search bar
		searchBar.clear();

		searchBar.sendKeys(product);
		waitABit(2000);
		searchButton.click();
		waitABit(10000);

		//cm.closebrowser();

	}

	//Sort products by relevance - line 175 -237

	public void sortByDropdown() 
	{
		firstRelevanceButton.click();
		//report.LOG("Sort by dropdown is clicked");
	}

	public void sortingdropdown() 
	{

		sortByDropdown();
		// To validate all drop down elements are present or not
		Assert.assertEquals("Relevance", sortByRelevance.getText());
		//report.LOG( sortByRelevance.getText() +" verified successfully");

		Assert.assertEquals("Price (Low to High)", sortByPriceLowToHigh.getText());
		//report.LOG( sortByPriceLowToHigh.getText() +" verified successfully");

		Assert.assertEquals("Price (High to Low)", sortByPriceHighToLow.getText());
		//report.LOG( sortByPriceHighToLow.getText() +" verified successfully");

		Assert.assertEquals("A-Z (alphabetical)", sortByAlphabetical.getText());
		//report.LOG( sortByAlphabetical.getText() +" verified successfully");

		Assert.assertEquals("Newest to Oldest Products", sortByNewToOld.getText());
		//report.LOG( sortByNewToOld.getText() +" verified successfully");
	}




	// Take options from user and check it with the drop down elements whether is equal and click on it
	public void selectSortByOption(String SortOption) 
	{

		waitABit(2000);
		if (SortOption.equalsIgnoreCase(sortByRelevance.getText()))
		{
			sortByRelevance.click();
			//report.LOG(sortByRelevance.getText() +" is selected");
		}
		else if (SortOption.equalsIgnoreCase("Price (Low to High)"))
		{
			sortByPriceLowToHigh.click();
			//report.LOG("Price (Low to High) is selected");
		}
		else if (SortOption.equalsIgnoreCase("Price (High to Low)"))
		{
			sortByPriceHighToLow.click();
			//report.LOG("Price (High to Low) is selected");
		}
		else if (SortOption.equalsIgnoreCase("A-Z (alphabetical)"))
		{
			sortByAlphabetical.click();
			//report.LOG("A-Z (alphabetical) is selected");
		}
		else if (SortOption.equalsIgnoreCase("Newest to Oldest Products"))
		{	
			//js.executeScript("arguments[0].scrollIntoView();", sortByNewToOld);
			//	js.executeScript("window.scrollBy(0,350)", "");
			sortByNewToOld.click();
			//report.LOG("Newest to Oldest Products is selected");
		}
		else report.LOG(SortOption + " is not a valid input");	
		waitABit(5000);

	}

	// Add to Cart - Line 240 -
	//Get the list of names of all products displayed in the page and storing into  list
	public List<WebElementFacade> getListOfProducts() {

		//	product list -  //span[@class= 'product-name product-name--product-tile']
		//parent tag/child tag
		//	product brand list -  //span[@class= 'product-name product-name--product-tile']/span[@class= 'product-name__item product-name__item--brand']
		//	product name list -  //span[@class= 'product-name product-name--product-tile']/span[@class= 'product-name__item product-name__item--name']
		//	product quantity list -  //span[@class= 'product-name product-name--product-tile']/span[@class= 'product-name__item product-name__item--package-size']

		//  xpath of all products on the page
		String productListXpath = "//span[@class= 'product-name product-name--product-tile']/span[@class= 'product-name__item product-name__item--name']";

		// Findall products with the given xpath
		productDetails = findAll(By.xpath(productListXpath)); // productDetails- listname
		System.out.println("Total Products: "+productDetails.size());

		for (int i=0; i<productDetails.size(); i++) {
			//System.out.println(productDetails.get(i)- print xpath of 52 pdts
			System.out.println(productDetails.get(i).getText());// Print all product names
		}

		return productDetails;
	}

	// Add product to Cart

	public void AddToCart(String expectedProduct) {

		// List of names returned from above method 
		List<WebElementFacade> listOfProductName = getListOfProducts();

		//xpath of Add button for each pdt

		//button[@aria-label= 'Add to cart, Partly Skimmed Milk 2% MF']
		//button[@aria-label= 'Add to cart, Partly Skimmed Milk 1% MF']
		//button[@aria-label= 'Add to cart, Homogenized Milk 3.25%']

		// way to create dynamic xpath
		String beforeProduct = "//button[@aria-label= 'Add to cart, ";
		String product;
		String afterProduct = "']";


		for (int i=0; i <listOfProductName.size(); i++) {

			//get the name of product displayed on page
			product = listOfProductName.get(i).getText();

			// add to cart if the product to test is equal to product displayed on page
			if (product.equals(expectedProduct)) {

				String fullxpath = beforeProduct+product+afterProduct; // dynamic xpath (it change very often,so we parameterize the xpath) 
				//System.out.println(fullxpath);
				//find the add button element for pdt to be added to cart and click
				getDriver().findElement(By.xpath(fullxpath)).click();

				//report.LOG(expectedProduct + " product found");
				System.out.println(expectedProduct + " product found");
				break;

			}
			else System.out.println("Requested product not found");
		}



		if (pickUpButton.isDisplayed()) { pickUpButton.click();
		System.out.println("pickup clicked"); waitABit(6000); }

		if (confirmLocation.isDisplayed()) { confirmLocation.click();
		System.out.println("confirm Location clicked"); waitABit(7000); }

		// Validate whether the item added to cart or to validate the no of products in cart
		// We can increment by 1 after adding each product
		Assert.assertEquals("1", noOfItemsInCart.getText());
		//report.LOG("No. of product in cart is " + noOfItemsInCart.getText());

	}


	//Quantity

	//input[@aria-label='Quantity'] 
	//button[@class='quantity-selector__adjust__button quantity-selector__adjust__button--increment']
	//button[@class='quantity-selector__adjust__button quantity-selector__adjust__button--decrement']




}