package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Steps;
import utils.ReportLog;

public class Action extends PageObject{
	
	@Steps
	ReportLog report;
	
	int noOfSubCategories;
	int noOfItemsInSubCategory;
	
	
	// hardcoding the category & subcatrgories name
	public void simpleTestActions() {
		
		// For mouse actions,we use the action class
		// create the object and call methods

		//Actions class is an ability provided by Selenium for handling keyboard and mouse events. 
		//In Selenium WebDriver, handling these events includes operations such as drag and drop in Selenium, clicking on multiple elements with the control key, among others
		
		Actions actions = new Actions(getDriver()); // creating object of action class and use this object for all operations

		// to hover on category
		WebElement categoryName = getDriver().findElement(By.xpath("//span[text()='Grocery']"));
		actions.moveToElement(categoryName).perform(); // Action class is invoked 
		//	actions.moveToElement(categoryName).build().perform(); // same as above-move to category


		// to hover on Subcategory
		WebElement subCategoryName = getDriver().findElement(By.xpath("//span[text()='International Foods']")); //span[text()='subcategory name']
		actions.moveToElement(subCategoryName).perform(); // move to subcategory
        
		// to hover on item in subcategory&click&validate title&url
		//WebElement itemInSubCategory = getDriver().findElement(By.xpath("//span[text()='East Asian Foods']")); //span[text()='subcategory item name']
		//actions.moveToElement(itemInSubCategory).perform(); // move to subcategory item
        
		// click on sub category item
		//itemInSubCategory.click();
		//waitABit(5000);
		
		// title of page when click on item
		//WebElement title = getDriver().findElement(By.xpath("//h1[text()='East Asian Foods']"));

		// System.out.println(getDriver().getCurrentUrl());
		//System.out.println(title.getText());	
        
		//Assert.assertEquals("East-Asian-Foods ", getDriver().getCurrentUrl().contains("East-Asian-Foods"));
        //Assert.assertEquals("East-Asian-Foods ", title.getText().toLowerCase());

		// click on sub category
		subCategoryName.click();
		waitABit(5000);

		// navigated to the new page
		System.out.println(getDriver().getCurrentUrl());
		System.out.println(getDriver().getTitle());

		Assert.assertEquals("International Foods | Loblaws", getDriver().getTitle());

		// clicking on the item on the new page when click on subcategry
		getDriver().findElement(By.xpath("//span[text()='east asian foods']")).click();

		// navigated to a diff page
		System.out.println(getDriver().getCurrentUrl());
		System.out.println(getDriver().getTitle());	


		Assert.assertTrue("Title contains East-Asian-Foods ", getDriver().getCurrentUrl().contains("East-Asian-Foods"));

	}
	
	// getting the data from the feature file. same as simpleTestActions()
		public void testActions(String category, String subCategory) {

			Actions actions = new Actions(getDriver());

			String beforeCategoryXpath = "//span[text()='";
			String afterCategoryXpath = "']";

			// to hover on category
			WebElement categoryName = getDriver().findElement(By.xpath(beforeCategoryXpath+category+afterCategoryXpath));
			//	WebElement categoryName = getDriver().findElement(By.xpath("//span[text()='Grocery']"));
			actions.moveToElement(categoryName).perform();
			//	actions.moveToElement(categoryName).build().perform();


			// to hover on Subcategory
			String beforeSubCategoryXpath = "//span[text()='";
			String afterSubCategoryXpath = "']";
			//	WebElement subCategoryName = getDriver().findElement(By.xpath("//span[text()='International Foods']"));
			WebElement subCategoryName = getDriver().findElement(By.xpath(beforeSubCategoryXpath + subCategory + afterSubCategoryXpath));
			actions.moveToElement(subCategoryName).perform();

			// click on sub category
			subCategoryName.click();
			waitABit(5000);

			// navigated to the new page
			System.out.println(getDriver().getCurrentUrl());
			System.out.println(getDriver().getTitle());

			Assert.assertEquals("International Foods | Loblaws", getDriver().getTitle());

			// clicking on the item on the new page
			getDriver().findElement(By.xpath("//span[text()='east asian foods']")).click();

			// navigated to a diff page
			System.out.println(getDriver().getCurrentUrl());
			System.out.println(getDriver().getTitle());	


			Assert.assertTrue("Title contains East-Asian-Foods ", getDriver().getCurrentUrl().contains("East-Asian-Foods"));

		}


	// getting the data from the feature file. same as simpleTestActions()
	public void testActions(String category, String subCategory, String subCategoryItem) {

		Actions actions = new Actions(getDriver());

		String beforeCategoryXpath = "//span[text()='";
		String afterCategoryXpath = "']";

		// to hover on category
		WebElement categoryName = getDriver().findElement(By.xpath(beforeCategoryXpath+category+afterCategoryXpath));
		//	WebElement categoryName = getDriver().findElement(By.xpath("//span[text()='Grocery']"));
		actions.moveToElement(categoryName).perform();
		//	actions.moveToElement(categoryName).build().perform();
		waitABit(3000);


		// to hover on Subcategory
		String beforeSubCategoryXpath = "//span[text()='";
		String afterSubCategoryXpath = "']";
		//	WebElement subCategoryName = getDriver().findElement(By.xpath("//span[text()='International Foods']"));
		WebElement subCategoryName = getDriver().findElement(By.xpath(beforeSubCategoryXpath + subCategory + afterSubCategoryXpath));
		actions.moveToElement(subCategoryName).perform();
		waitABit(3000);

		// click on sub category
		subCategoryName.click();
		waitABit(5000);
		
		// navigated to the new page
		System.out.println("Current Url from Subcategory:"+getDriver().getCurrentUrl());
		System.out.println("Current page title from Subcategory:"+getDriver().getTitle());
		
		String titleExpected = subCategory+" | Loblaws";
		System.out.println("Expected Page Title from Subcategory:"+ titleExpected);

		//Assert.assertEquals("International Foods | Loblaws", getDriver().getTitle());
		Assert.assertEquals(titleExpected, getDriver().getTitle());
		

		// clicking on the item on the new page
		String beforeSubCategoryItemXpath = "//span[text()='";
		String afterSubCategoryItemXpath = "']";
		
		getDriver().findElement(By.xpath(beforeSubCategoryItemXpath + subCategoryItem + afterSubCategoryItemXpath)).click();

		
		//getDriver().findElement(By.xpath("//span[text()='east asian foods']")).click();

		// navigated to a diff page
		System.out.println("Current Url from Subcategory item:"+getDriver().getCurrentUrl());
		System.out.println("Current page title from Subcategory item:"+getDriver().getTitle());	
        
		Assert.assertEquals("Loblaws", getDriver().getTitle());
		
		//Assert.assertTrue("Title contains "+subCategoryItem+" ", getDriver().getCurrentUrl().contains(subCategoryItem));


		//Assert.assertTrue("Title contains East-Asian-Foods ", getDriver().getCurrentUrl().contains("East-Asian-Foods"));

	}
    
		
	
	// to get subcategories (International Foods) &count of items under a category (Grocery)
	public int listOfSubCategories(String category) {

		Actions actions = new Actions(getDriver());

		String beforeCategoryXpath = "//span[text()='";
		String afterCategoryXpath = "']";

		// to hover subcategory
		WebElement categoryName = getDriver().findElement(By.xpath(beforeCategoryXpath+category+afterCategoryXpath));
		//	WebElement categoryName = getDriver().findElement(By.xpath("//span[text()='Grocery']"));
		actions.moveToElement(categoryName).perform();
		System.out.println("-------Getting details of menu------------------");

		report.LOG("Category Entered is " + category);
        
		// xpath to get all subcategory names
		String beforeSubCategoryListXpath = "//span[text()='";
		String afterSubCategoryListXpath = "']//ancestor::button//following-sibling::ul[@class = 'primary-nav__list primary-nav__list--level-1']/li/a/span";

		//String xpathToGetSubCategories = "//span[text()='Grocery']//ancestor::button//following-sibling::ul[@class = 'primary-nav__list primary-nav__list--level-1']/li/a/span";
		String xpathToGetSubCategories = beforeSubCategoryListXpath + category + afterSubCategoryListXpath;


		// to get list of subcategories under a category
		List<WebElementFacade> listInCategory = findAll(By.xpath(xpathToGetSubCategories));

		noOfSubCategories = listInCategory.size();
		System.out.println("No of Sub categories under menu-"+category+": "+listInCategory.size());

		for (int i=0; i<listInCategory.size(); i++) {
			System.out.println(listInCategory.get(i).getText());	
		}
		return noOfSubCategories;

	}
	
	// to get list of items (like East Asian Foods)&count under a sub category (International Foods)
		public int listOfItems(String subCategory) {

			Actions actions = new Actions(getDriver());

			report.LOG("Sub Category Entered is " + subCategory);
			// to hover on subcategory
			String beforeSubCategoryXpath = "//span[text()='";
			String afterSubCategoryXpath = "']";
			//	WebElement subCategoryName = getDriver().findElement(By.xpath("//span[text()='International Foods']"));
			WebElement subCategoryName = getDriver().findElement(By.xpath(beforeSubCategoryXpath + subCategory + afterSubCategoryXpath));
			actions.moveToElement(subCategoryName).perform();
			
			System.out.println("-------Getting details of sub menu------------------");

			String beforeSubCategoryItemListXpath = "//span[text()='";
			String afterSubCategoryItemListXpath = "']//ancestor::a//following-sibling::ul[@class='primary-nav__list primary-nav__list--level-2']//li[@class='primary-nav__list__item']";

			//	String SubCategoryItemList = "//span[text()='International Foods']//ancestor::a//following-sibling::ul[@class='primary-nav__list primary-nav__list--level-2']//li[@class='primary-nav__list__item']";
			String SubCategoryItemList = beforeSubCategoryItemListXpath + subCategory+ afterSubCategoryItemListXpath;

			// to get list of items under a subcategory
			List<WebElementFacade> listInSubCategory = findAll(By.xpath(SubCategoryItemList));

			noOfItemsInSubCategory = listInSubCategory.size();
			System.out.println("No of items under submenu-"+subCategory+": "+listInSubCategory.size());

			for (int i=0; i<listInSubCategory.size(); i++) {
				System.out.println(listInSubCategory.get(i).getText());	

			}

			return noOfItemsInSubCategory;

		}
		
		public void noOfCategories(int ExpectedNumberOfSubCategories) {
			Assert.assertEquals(ExpectedNumberOfSubCategories,noOfSubCategories);

		}

		public void noOfItemsInSubCategory(int ExpectedNumberOfItemsInSubCategories) {
			Assert.assertEquals(ExpectedNumberOfItemsInSubCategories,noOfItemsInSubCategory);
		}

		
// MouseAction drag&drop
	
	public void testDragAndDrop(){
		
		// Get url of the page
		getDriver().get("https://jqueryui.com/droppable/");
		getDriver().manage().window().maximize();
		waitABit(8000);
		
		// the part is a frame-window inside window
		// tag - iframe
		getDriver().switchTo().frame(0); // access the frame,0-coz only 1 frame,1 for next frame at right
		
		String Text =  getDriver().findElement(By.xpath("//div[@id='droppable']/p")).getText(); // webelement with text dropped //outerxpath/innertag
		
		
		WebElement source =  getDriver().findElement(By.id("draggable")); // find the source web element
		WebElement target =  getDriver().findElement(By.id("droppable")); // find the target web element
		
		
		
		
		System.out.println("Text before action: " + Text);
		
		// Do action
		Actions action = new Actions(getDriver());
		action.dragAndDrop(source, target).build().perform();
		waitABit(3000);
	
		
		String Text1 =  getDriver().findElement(By.xpath("//div[@id='droppable']/p")).getText();
		System.out.println("Text after action: " + Text1);
		
		Assert.assertEquals("Dropped!", Text1); // validation
		

	}
	
	
	
	
	
	


	public void testDragAndDrop1(){

		getDriver().get("https://jqueryui.com/droppable/");
		getDriver().manage().window().maximize();
		waitABit(8000);

		getDriver().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		// only to switch to frame if it is present on the page
		getDriver().switchTo().frame(0);

		WebElement sourceElement = getDriver().findElement(By.id("draggable"));
		WebElement destinationElement = getDriver().findElement(By.id("droppable"));

		//	WebElement sourceElement = getDriver().findElement(By.xpath("//*[@id='draggable']"));
		//	WebElement destinationElement = getDriver().findElement(By.xpath("//*[@id='droppable']"));

		Actions action = new Actions(getDriver());
		action.dragAndDrop(sourceElement, destinationElement).build().perform();
		//	action.dragAndDropBy(sourceElement, 580,195).build().perform();
		waitABit(3000);


		String finalText = getDriver().findElement(By.xpath("//div[@id='droppable']/p")).getText();

		System.out.println(finalText);
		//	Assert.assertEquals("Dropped!", finalText);

	}
	
	

}
