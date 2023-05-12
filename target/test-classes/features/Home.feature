
Feature: Home page functionalities of Loblaws 

#-------------------Search-----------------

@searchfromoptions
  Scenario Outline: Test for Search a product by choosing from the below options
   Given user launches Loblaws website
   When user enter a "<product>" in the searchbar
   Then user is able to see all the related options in searchbar
   And user clicks on "<productOption>"
   Then user able to see all the products in the page
    Examples: 
      | product | productOption|
    
      |Egg|Dairy & Eggs|
     
      
@typeandclicksearchbutton
Scenario Outline: Test for Search a product by type the product and click search button
   Given user launches Loblaws website
   When user enter a "<product>" in the searchbar
   And user clicks on search button
   Then user able to see all the products in the page
    Examples: 
      | product | 
      |Egg|

@typeandhitenter
Scenario Outline: Test for Search a product by type the product and press enter
   Given user launches Loblaws website
   When user types the "<product>" in the searchbar and hit enter
   Then user able to see all the products in the page
    Examples: 
      | product | 
      |Egg|

#Add a product to cart
@Addtocartsingle
Scenario: To test Add to cart functionality
Given User launches Loblaws url
When user searched for "Milk" in search bar
Then search results are displayed
Then user add "Partly Skimmed Milk 2% MF" to the cart

@Addtocart2
Scenario Outline: To test Add to cart functionality
Given User launches Loblaws url
When user enters "<productToSearch>" in search bar
Then search results are displayed
Then user add "<product>" to the cart

Examples:
|productToSearch|product|
|Milk|Partly Skimmed Milk 2% MF|

#Sort products by relevance after search
@sortproducts
Scenario Outline: To test sort products by relevance functionality
Given User launches Loblaws url
When user searched for "Milk" in search bar
Then search results are displayed
When user clicks on sortby relevance dropdown to validate all values in dropdown are displayed
Then user able to see some options
And user selects an "<option>" from dropdown
Then user able to see the sorted products
Examples:
|option|
|Relevance|
#|Price (Low to High)|
#|Price (High to Low)|
|A-Z (alphabetical)|
#|Newest to Oldest Products|


# Click on dropdown 
#select filters
@SelectFilters
Scenario: To test Filter functionality by selecting dropdowns
Given User launches Loblaws url
When user searched "milk" in search for product bar
Then user select "Aisle" on the page
Then user select "Deals" on the page
#Then user select "Sellers" on the page
#Then user select "Price" on the page
#Then user select "Brand" on the page
#Then user select "Dietary" on the page

@SelectFilters1
Scenario Outline: To test Filter functionality by selecting dropdowns
Given User launches Loblaws url
When user searched "milk" in search for product bar
Then user select "<filter>" on the page

Examples:
|filter|
|Aisle|
|Deals|
|Sellers|
|Price|
|Brand|
|Dietary|



# select filter and check the values from the filter
#Click on options in filter 
@SelectFiltersWithCheckBox
Scenario: To test Filter functionality by selecting checkbox
Given User launches Loblaws url
When user searched "milk" in search for product bar
Then user select "Aisle" on the page
Then user select "Deals" on the page
Then user selects "Multi-Buy" option from the filter
Then user selects "Price Reduction" option from the filter
Then user selects "$1,$2,$3,$4,$5" option from the filter


@SelectFiltersWithCheckBox1
Scenario Outline: To test Filter functionality by selecting checkbox
Given User launches Loblaws url
When user searched "milk" in search for product bar
Then user select "<filter>" on the page
Then user selects "<filterOption>" option from the filter
Examples:
|filter|filterOption|
|Deals|Multi-Buy|
#|Deals|Price Reduction|
#|Deals|$1,$2,$3,$4,$5|
|Price|$5 and under|
#|Price|$20-$30|
#|Price|$50-$100|
#|Price|$200 and above|



# to search for a specific brand under brand filter and check.
# test for searchable field
@SelectFiltersWithSearchableCheckBox
Scenario: To test Filter functionality by selecting checkbox
Given User launches Loblaws url
When user searched "milk" in search for product bar
Then user select "Aisle" on the page
Then user select "Brand" on the page
Then user search for "Activia" brand in the filter
Then user search for "Nestle" brand in the filter


# to test forward,backward, refresh for a page
@TestNavigation
Scenario: To test page navigation
Given User launches Loblaws url for page navigation    


#-------------------Mouse Actions-----------------

#hover on category, select a subcategory and select the item under subcategory and click on it
@testMouseActionsforHover
Scenario: To test mouse actions and hover
Given User launches Loblaws url
When user selects one category Grocery and SubCategory International Foods


#hover on category, select a subcategory and select the item under subcategory and click on it
@testMouseActionsforHover1
Scenario Outline: To test mouse actions and hover
Given User launches Loblaws url
When user selects one "<category>" and "<subCategory>" and "<subCategoryItem>"

Examples:
|category|subCategory|subCategoryItem|
|Grocery|International Foods|East Asian Foods|
#|Home, Beauty & Baby|Pet Supplies|Cats|



#Test mouse hover and validate  the no of subcategories and items under subcategories
#16&43 are expected inputs
@testMouseActions
Scenario Outline: To test mouse actions
Given User launches Loblaws url
When user selects "<Category>" and "<SubCategory>"
Then user validates number of subcategories under a category is "<NumberOfSubcategories>"
Then user validates number of items under a subcategory is "<NumberOfItemsInSubcategories>"

Examples:
|Category|SubCategory|NumberOfSubcategories|NumberOfItemsInSubcategories|
|Grocery|International Foods|16|43|



#Test Drag and drop an item
#eg website:https://jqueryui.com/droppable/
@testMouseActionsforDrag&Drop
Scenario: To test mouse actions and hover
Given User launches url to test drag and drop


#-------------------Pop ups-----------------

#Test Alerts/Popups
#https://www.rediff.com/-signin-click signin btn
@TestBrowserPopups
Scenario: To test Javascript popup
Given User tests Javascript popup


#when website ask to upload a file from desktop
#https://html.com/input-type-file/
@TestWindowsPopups
Scenario Outline: To test windows popup
When User tests windows popup for "<fileName>"

Examples:
|fileName|
|TestDocumentForFileUpload.docx|
|TEST.pdf|


#-------------------tabs&windows handling-----------------


#Open new window
@testsinglewindowHandles
Scenario: To test single window handles
Given User wanted to test new windowhandles

#Open new tab-loblaws
#loblaws-flyers&deals-digital coupons
@testwindowHandles
Scenario: To test window handles
Given user wanted to test windowhandles for loblaws

#Open new tab
@testsingletabHandles
Scenario: To test single tab handles
Given User wanted to test new tabhandles

#Open new windows
@testwindowHandles1
Scenario: To test window handles
Given User wanted to test windowhandles

#Open new tabs
@testtabsHandles
Scenario: To test tabs handles
Given User wanted to test tabshandles



#Test traverse through table
@testWebTable  
Scenario: To test Web table
Given user wanted to test web table