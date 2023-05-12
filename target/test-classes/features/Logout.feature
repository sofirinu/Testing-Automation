@successfullogout
Feature: Logout functionality of Loblaws website

Scenario Outline:
Given user launches Loblaws website
When user clicks on SIGN IN link
Then user navigated to Sign in with PC™id page
When user enters "<email>" and "<password>" 
And user clicks on Sign In button
Then user is able to login successfully
And user navigated to my account page
When user clicks on myaccount menu
Then user able to see the options
And user clicks on Sign Out menu
Then user signedout of the website
Examples:
|email|password|
|casacsmsc11@gmail.com|casacsmsc@11|
    