Feature: Home page


  Background: User opens the app
    * User makes driver adjustments
  @1

  Scenario: Verify that the SignIn module works with the correct data
    * User confirms to be on the homepage
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * User enters "phoneNumber" and "password" and clicks on the “Sign In” button.
    * User should see an "Success" message on the popup page.
    * Driver turns off

  Scenario: Verify that the user cannot login with wrong phone number and wrong password
    * User confirms to be on the homepage
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * User enters "wrongPhoneNumber" and "wrongPassword" and clicks on the “Sign In” button.
    * User should see an "Error" message on the popup page.
    * Driver turns off

  Scenario: Verify that the user cannot login with correct phone number and wrong password
    * User confirms to be on the homepage
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * User enters "phoneNumber" and "wrongPassword" and clicks on the “Sign In” button.
    * User should see an "Error" message on the popup page.
    * Driver turns off

  Scenario: Verify that the user cannot login with correct password and wrong phone number
    * User confirms to be on the homepage
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * User enters "wrongPhoneNumber" and "password" and clicks on the “Sign In” button.
    * User should see an "Error" message on the popup page.
    * Driver turns off



