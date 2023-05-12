
Feature: Login functionality of Loblaws website

@successfullogin
Scenario Outline: 
Given user launches Loblaws website
When user clicks on SIGN IN link
Then user navigated to Sign in with PC™id page
When user enters "<email>" and "<password>"
And user clicks on Sign In button
Then user is able to login successfully
And user navigated to my account page

Examples: 
| email                 | password     |
| casacsmsc11@gmail.com | casacsmsc@11 |


#Login with - correct mail& incorrect pwd, incorrect mail&correct pwd,incorrect mail&pwd
@invalidcredentialslogin
Scenario Outline: Test unsuccesfull login with wrong credentials
Given user launches Loblaws website
When user clicks on SIGN IN link
Then user navigated to Sign in with PC™id page
When user enters "<email>" in the EMAIL textbox
And user enters "<password>" in the PASSWORD textbox
And user clicks the Sign In button
Then user gets the error message Your email or password was incorrect


 Examples: 
|email|password|
|sofiyaraju2@gmail.com|sofi|
# | casacsmsc@gmail.com   | casacsmsc@11 |
# | casacsmsc@gmail.com   | casa         |


#Unsuccessful login with no credentials
@unsuccessnulllogin
Scenario: Test unsuccessful login for a user with null entries
Given user launches Loblaws website
When user clicks on sign in link
Then user navigated to Sign in with PC™id page
When user clicks the Sign In button
Then user gets the validation error messages to the fields


@invalidemaillogin
Scenario Outline: Test the email Id field does not accept invalid email IDs
Given user launches Loblaws website
When user clicks on sign in link
Then user navigated to Sign in with PC™id page
When user enters "<email>" in the EMAIL textbox
Then user gets the validation error message right below the textfield
And a red exclamation mark enclosed in circle is displayed to the right most of the email textfield

Examples: 
|email|
|ca|
|1|
|casacsmsc@11|
|casacsmsc@gmail|

