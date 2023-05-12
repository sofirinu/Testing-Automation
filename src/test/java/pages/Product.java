package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;

public class Product extends PageObject{
	
	String filterName;
	String filterOption;
	
	//Click on dropdown - Ailse, brand, price etc.
		public void searchFilter(String filter) {
			
			//button[text()= 'Aisle']
			//button[text()= 'Brand']
			
			String beforeCategory = "//button[text()= '";
			String afterCategory = "']";
			
			String fullXpathforCategory = beforeCategory + filter+ afterCategory; // //button[text()= 'Aisle']
			//find web element
			WebElement filterCategory = getDriver().findElement(By.xpath(fullXpathforCategory));
			
			//to check status of dropdown by getting the attribute value
			String beforeClick = getDriver().findElement(By.xpath(fullXpathforCategory)).getAttribute("data-cruller");
			System.out.println("beforeClick: " + beforeClick);
			String afterClick = null;
			
			//If collapsed ,then click on it to expand
			if (beforeClick.contains("collapsed")) {
				
				filterCategory.click();
				afterClick = getDriver().findElement(By.xpath(fullXpathforCategory)).getAttribute("data-cruller");
				System.out.println("afterClick: " + afterClick);
			}
			//If expanded,click it to b collapsed
			else filterCategory.click();
			
			waitABit(3000);

		}
		
		
		//Click on options in filter like for Deals - multibuy/price reduction
		
		public void selectFilterOption(String option) {
			
			filterOption=option;
			
			//to get list of all the 4 options in a dropdown like multibuy,price reduction etc
			//other way of wirting this xpath -                          //ul[@aria-label ='Search for product Deals']/li/label
			// get all elements with this xpath
			List <WebElement> list = getDriver().findElements(By.xpath("//ul[contains(@aria-label,'Search for product Deals')]//li//label"));
			
			//System.out.println(list.size());
			
			for (int i=0; i<list.size(); i++) {
				System.out.println(list.get(i).getText());
				
				if (list.get(i).getText().contains(filterOption)) {
					list.get(i).click();
					System.out.println("status of checkbox for " + filterOption + " is " + getDriver().findElement(By.name(filterOption)).getAttribute("value"));
					break;
				}
			}
		}
		
		// for searchable dropdown like brand,sellers etc
		
		public void searchableDropdownforBrands(String search) {
			
			
			String searchBarForBrand = "//input[@placeholder='Search for brands']";
			
			WebElement searchbar = getDriver().findElement(By.xpath(searchBarForBrand));
			searchbar.clear();//clear the searchbar first
			searchbar.sendKeys(search);
			waitABit(2000);
		
			
			//to get list of all the results after searching the brands
			List <WebElement> list = getDriver().findElements(By.xpath("//ul[@aria-label='Search for product Brand']//li//label"));
			
			System.out.println(list.size());
			
			for (int i=0; i<list.size(); i++) {
				System.out.println(list.get(i).getText()); // text visible on page
				
				if (list.get(i).getText().equals(search)) {
					list.get(i).click();
					System.out.println("status of checkbox for is " + getDriver().findElement(By.name(search)).getAttribute("value"));
					//Test checkbox clicked or not
					Assert.assertEquals("true", getDriver().findElement(By.name(search)).getAttribute("value"));
					break;
				}
			}
			
			waitABit(3000);
			System.out.println(getDriver().getCurrentUrl());
			System.out.println(getDriver().getTitle());
			
		}

}
