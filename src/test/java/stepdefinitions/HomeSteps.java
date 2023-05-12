package stepdefinitions;

import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import utils.*;
import pages.*;

public class HomeSteps {
	
	@Steps
	HomePage hm;
	@Steps
	Product p;
	@Steps
	LoginPage login;
	@Steps
	CommonMethods cm;
	@Steps
	Action action;
	@Steps
	PopUpsConcepts popUp;
	@Steps
	WindowHandles handle;
	@Steps
	WebTable table;
	
	// Enter product and choose from options
	
	@When("user enter a {string} in the searchbar")
	public void user_enter_a_in_the_searchbar(String product) {
		hm.enterProduct(product);
	    	}
	@Then("user is able to see all the related options in searchbar")
	public void user_is_able_to_see_all_the_related_options_in_searchbar() {
	    	}
	@Then("user clicks on {string}")
	public void user_clicks_on(String productOption) {
		hm.clickProductOptions(productOption);
	    	}
	@Then("user able to see all the products in the page")
	public void user_able_to_see_all_the_products_in_the_page() {
	   	}


	// by hit search button
	
	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
		hm.clickSearchButton();
	    }
	
	//by hit enter
	@And("user types the {string} in the searchbar and hit enter")
	public void user_types_the_in_the_searchbar_and_hit_enter(String product) {
		hm.typeAndHitEnter(product);
	    }
	
    // Add to cart steps
	@Given("User launches Loblaws url")
	public void user_launches_loblaws_url() {
	    
	hm.openApplication();
	}
	@When("user searched for {string} in search bar")
	public void user_searched_for_in_search_bar(String product) {
	   
		hm.enterProductClickSearchButton(product);
	}
	@Then("search results are displayed")
	public void search_results_are_displayed() {
	   	}
	
	@Then("user add {string} to the cart")
	public void user_add_to_the_cart(String product) {
	    hm.AddToCart(product);
	    }




   // Sort products by relevance steps

	@When("user clicks on sortby relevance dropdown to validate all values in dropdown are displayed")
	public void user_clicks_on_sortby_relevance_dropdown_to_validate_all_values_in_dropdown_are_displayed() {
	    
	hm.sortingdropdown();
	}
	@Then("user able to see some options")
	public void user_able_to_see_some_options() {
	    	}
	@Then("user selects an {string} from dropdown")
	public void user_selects_an_from_dropdown(String option) {
		hm.selectSortByOption(option);
	   	}
	@Then("user able to see the sorted products")
	public void user_able_to_see_the_sorted_products() {
	   	}


// click product filter dropdowns
	
	
	@When("user searched {string} in search for product bar")
	public void user_searched_in_search_for_product_bar(String product) {
	   hm.enterProductClickSearchButton(product);	
	   }
	@Then("user select {string} on the page")
	public void user_select_on_the_page(String filterName) {
		  p.searchFilter(filterName);    
	}

// select filter and check the values from the filter
	
	@Then("user selects {string} option from the filter")
	public void user_selects_option_from_the_filter(String filterOption) {
	    p.selectFilterOption(filterOption);
	}

// search &check in searchable filter
	
	@Then("user search for {string} brand in the filter")
	public void user_search_for_brand_in_the_filter(String brandToSearch) {
	   p.searchableDropdownforBrands(brandToSearch);
	}

// Navigation
	@Given("User launches Loblaws url for page navigation")
	public void user_launches_loblaws_url_for_page_navigation() {
		
		hm.openApplication();
		hm.clickSignIn();
		cm.navigateBackward();
		cm.navigateForward(); // came back to signIn page
		login.clickCreatePcIdLink();
		cm.navigateBackward(); //came back to signIn page
		cm.navigateForward(); // went back to register page
		cm.refreshPage();
		cm.closebrowser();	
	}


  // Mouse Action - hover-grocery
	@When("user selects one category Grocery and SubCategory International Foods")
	public void user_selects_one_category_Grocery_and_SubCategory_International_Foods()
    {
	action.simpleTestActions();
    }
	
	// Mouse Action - hover
	
	
	@When("user selects one {string} and {string} and {string}")
	public void user_selects_one_and_and(String category, String subcategory, String subCategoryItem)
	{
		
	    		action.testActions(category, subcategory, subCategoryItem);
	}

   //Mouseaction
	
	@When("user selects {string} and {string}")
	public void user_selects_grocery_and(String category, String subcategory) {
		//product.categoryProducts(category, subcategory);
		
		action.listOfSubCategories(category);
		action.listOfItems(subcategory);
		
	}
	
	@Then("user validates number of subcategories under a category is {string}")
	public void user_validates_number_of_subcategories_under_a_category_is(String noOfSubcategoires) {

		action.noOfCategories(Integer.parseInt(noOfSubcategoires));
	}
	
	
	@Then("user validates number of items under a subcategory is {string}")
	public void user_validates_number_of_items_under_a_subcategory_is(String noOfItems) {
	    
		action.noOfItemsInSubCategory(Integer.parseInt(noOfItems));
	}
    
	//**********************Other actions***********************
	
    //Drag and Drop
	@Given("User launches url to test drag and drop")
	public void user_launches_url_to_test_drag_and_drop() {
	    
		action.testDragAndDrop();
	}
	
    // Alerts/Popups
	
	@Given("User tests Javascript popup")
	public void user_tests_javascript_popup() {
		popUp.testJavaScriptAlerts();
	}
	
	
	@When("User tests windows popup for {string}")
	public void user_tests_windows_popup_for(String fileName) {
	    	
		popUp.testDesktopPopUp(fileName);
	}
	
	//Window/tab handles
	
	// new window
	@Given("User wanted to test new windowhandles")
	public void user_wanted_to_test_new_windowhandles() {
		handle.testNewWindowHandles();
		}

	//new tab
	@Given("User wanted to test new tabhandles")
	public void user_wanted_to_test_new_tabhandles() {
		
		handle.testNewTabHandles();
		
	}

    
// new windows

	@Given("User wanted to test windowhandles")
	public void user_wanted_to_test_windowhandles() {
		
		handle.testWindowHandles();
	    
	}
	
	//new tabs
	
	
	@Given("User wanted to test tabshandles")
	public void user_wanted_to_test_tabshandles() {
		
		handle.testTabsHandles();
	}



	@Given("user wanted to test windowhandles for loblaws")
	public void user_wanted_to_test_windowhandles_for_loblaws() {
		
		handle.testWindowHandleForLoblaws();
	    
	}
	
	// Table handle
	@Given("user wanted to test web table")
	public void user_wanted_to_test_web_table() {
		
		table.testWebTables();
	   
	}
	





}
