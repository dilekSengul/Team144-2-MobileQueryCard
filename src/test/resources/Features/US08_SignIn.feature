


Feature: Home page
  Background: User opens the app
    * User makes driver adjustments
  @1
  Scenario: Sign In
    * User confirms to be on the homepage
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * User clicks the button "phoneTextBox" and sendKeys "6505551212"
    * User clicks the button "signInLoginButton"
    * User clicks the button with description "Profile"
    * Verifies username "oske" in dashboard
    * Driver turns off




