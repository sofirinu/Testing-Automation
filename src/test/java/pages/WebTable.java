package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

import net.serenitybdd.core.pages.PageObject;

public class WebTable extends PageObject {
	
	
	public void testWebTables() {
		
		
		String path = System.getProperty("user.dir");
		String filepath = path +"//data//countries_with_link.html";
		System.out.println(filepath);

		getDriver().get(filepath);
		getDriver().manage().window().maximize();
		waitABit(3000);
		
		
		String TableTitle = getDriver().findElement(By.xpath("//h2")).getText();
		System.out.println("Table title is " + TableTitle);
		
		// tr - row; th(header)/td(body) - column
		
		//no.of columns
		List <WebElement> noOfCols = getDriver().findElements(By.xpath("//thead/tr/th"));
		System.out.println("No. of columns in the table " + noOfCols.size());
		
		//no. of rows
		List <WebElement> noOfRows = getDriver().findElements(By.xpath("//tbody/tr"));
		System.out.println("No. of rows in the table excluding header " + noOfRows.size());
		
		// get the header details
		System.out.println("Header Details---- ");
		for(int i=0; i<noOfCols.size(); i++) {
			System.out.println(noOfCols.get(i).getText());
		}
		
		// get the row details
		
		
		// get the column details
		//countries - //tbody/tr/td[1]
		//capital - //tbody/tr/td[2]
		//currency - //tbody/tr/td[3]
		//language - //tbody/tr/td[4]
		//tbody/tr[3]/td[1]
		
		System.out.println("List of countries---- ");
		for (int i=1; i<=noOfRows.size(); i++) {
			
			String beforexpath = "//tbody/tr[";
			String afterxpath = "]//td[1]";
			
			WebElement countryName = getDriver().findElement(By.xpath(beforexpath + i+afterxpath));
			String country = countryName.getText();
			System.out.println(country);
			// finding the country and clicking on the Wikipedia link which is in the 5th column
			if (country.equals("India")) {
				
				String after = "]//td[5]//a";		
																		//tbody/tr[1]/td[5]/a
				WebElement Wikipedia = getDriver().findElement(By.xpath(beforexpath + i+after));
				Wikipedia.click();
				waitABit(4000);

				System.out.println(getDriver().getCurrentUrl());
				System.out.println(getDriver().getTitle());
			}	
		}
		
		
//		System.out.println("List of capital---- ");
//		for (int i=1; i<=noOfRows.size(); i++) {
//			
//			String beforexpath = "//tbody/tr[";
//			String afterxpath = "]//td[2]";
//			
//			WebElement capitalName = getDriver().findElement(By.xpath(beforexpath + i+afterxpath));
//			String capital = capitalName.getText();
//			System.out.println(capital);
//		}
		
	}

}
