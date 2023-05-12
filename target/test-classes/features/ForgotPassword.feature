
Feature: Forgot Password feature of Loblaws website

  Background: 
    Given user launches Loblaws website
    When user clicks on SIGN IN link
    Then user navigated to Sign in with PC™id page
    When user clicks on Forgot Password link
    Then user navigated to Forgot Password page

  @forgotpasswordsuccess
  Scenario: Test succesfull attempt with registered emailid
    When user enters "abcdemsc11@gmail.com" in the EMAIL textbox
    And user clicks on Send Email button
    Then user is able to see a message We have emailed a link to abcdemsc11@gmail.com. If you do not receive an email, please verify that the email entered is associated with a valid PC™idID account and resubmit. with a greentick mark
    And a Reset Password link sent to the email
    And Send Email button is disabled

  @nonregisteredemail
  Scenario: Test unsuccesfull attempt with non-registered emailid
    When user enters "casacsmsc1@gmail.com" in the EMAIL textbox
    And user clicks on Send Email button
    Then user is able to see a message We have emailed a link to sofiyaraju2@gmail.com. If you do not receive an email, please verify that the email entered is associated with a valid PC™idID account and resubmit. with a greentick mark
    But no Reset Password link sent to "casacsmsc1@gmail.com"
    And Send Email button is disabled
    But user is able to re-enter an email address

  @emptyemail
  Scenario: Test unsuccesfull attempt with no emailid
    When user clicks on Send Email button
    Then user is able to see a message Please enter an email address.
    And a red exclamation mark enclosed in circle is displayed to the right most of the textfield
    But user is able to re-enter an email address

  @invalidemail
  Scenario Outline: Test unsuccesfull attempt with invalid email IDs
    When user enters "<email>" in the EMAIL textbox
    Then user gets the validation error message Please enter a valid email address
    And a red exclamation mark enclosed in circle is displayed to the right most of the textfield
    But user is able to re-enter a valid email

    Examples: 
      | email           |
      |                 |
      | ca11            |
      | casacsmsc@11    |
      | casacsmsc@gmail |
      | casacsmsc11.com |

