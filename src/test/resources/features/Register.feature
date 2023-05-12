#As a user,I want to be able to register with Loblows website, so that I can use the website

@Register
Feature: Register functionality of Loblaws website

#Register with valid user credentials
@successfulregister
Scenario Outline: Test successful registration with valid credentials
Given user launches Loblaws website
When user clicks on sign in link
Then user navigated to Sign in with PC™id page
When user clicks on Create a PC™id link
Then user navigated to Create a PC™id page
And user enters "<email>" ,"<password>" and "<confirmPassword>"
And user checks the agree checkbox
And user clicks on Create a PC™id button
Then user navigated to complete my profile page

Examples:
|email|password|confirmPassword|
|rinumathai07@gmail.com|rinusofiya@10|rinusofiya@10|



#Unsuccessful registration with already registered email address
#Validate the error message on existing email id
@existingemail
Scenario: Test the email Id field does not accept an already registered email address
Given user launches Loblaws website
When user clicks on sign in link
Then user navigated to Sign in with PC™id page
When user clicks on Create a PC™id link
Then user navigated to Create a PC™id page
When user enters "casacsmsc11@gmail.com" in the EMAIL textbox
Then user see an error message Looks like you already have an account with casacsmsc11@gmail.com, please sign in or choose another email address.
And the submit button becomes disabled


#Unsuccessful registration with no credentials
@unsuccessnullregistration
Scenario: Test unsuccessful registration for a user with null entries
Given user launches Loblaws website
When user clicks on sign in link
Then user navigated to Sign in with PC™id page
When user clicks on Create a PC™id link
Then user navigated to Create a PC™id page
When user clicks on Create a PC™id button
Then user gets the validation error messages to all fields


#Validate the error message on invalid format email id
@invalidemailtest
Scenario Outline: Test the email Id field does not accept invalid email IDs
Given user launches Loblaws website
When user clicks on sign in link
Then user navigated to Sign in with PC™id page
When user clicks on Create a PC™id link
Then user navigated to Create a PC™id page
When user enters "<email>" in the EMAIL textbox
Then user gets the validation error message right below the textfield
And a red exclamation mark enclosed in circle is displayed to the right most of the email textfield

Examples: 
|email|
|ca|
|1|
|casacsmsc@11|
|casacsmsc@gmail|


#Validate the error message on invalid password
@invalidpassword
Scenario Outline: Test the Password field does not accept passwords in invalid format
Given user launches Loblaws website
When user clicks on sign in link
Then user navigated to Sign in with PC™id page
When user clicks on Create a PC™id link
Then user navigated to Create a PC™id page
When user enters "<password>" in the  PASSWORD textbox
Then user is able to see a validation error message right below the textfield
And user is able to see a message Password Strength - Weak with a red progress bar at the right below of the errormessage
And a red exclamation mark enclosed in circle is displayed to the right most of the password textfield

Examples: 
|password|
|casa|
#|12345678|
|abcdefghijkl|
#|12345678910|
#|@abcdefghijkl|
#|12345678910@|


#Validate the error message on password mismatch
@passwordmismatch
Scenario Outline: Test the Confirm password field does not accept passwords that does not match with password in the Password field
Given user launches Loblaws website
When user clicks on sign in link
Then user navigated to Sign in with PC™id page
When user clicks on Create a PC™id link
Then user navigated to Create a PC™id page
When user enters "<email>" in the EMAIL textbox
When user enters "<password>" in the  PASSWORD textbox
And user enters "<cpassword>" in the CONFIRM PASSWORD textbox 
Then user gets the validation error message The passwords above do not match. right below the CONFIRM PASSWORD textfield
And a red exclamation mark enclosed in circle is displayed to the right most of the textfield


Examples: 
|email|password|cpassword|
|casacs@gmail.com||casa|
|casacs@gmail.com|casacsmsc@11|casacsmsc|


