@onur @US07
Feature: User Registration
  As a user, I want to be able to register on the site to take advantage of its functions.

  Background: User opens the app
    * User makes driver adjustments

  Scenario: SignUp form fields cannot be left blank
    Given User confirms to be on the homepage
    Then User verifies that "Profile" button is visible and clicks the button.
    When User verifies that "Sign Up" button is visible and clicks the button.
    When User leaves any of the mandatory fields (Name, Phone and Password) blank and click Sign Up button.
    Then I should see an error message indicating that mandatory fields cannot be left blank

  Scenario: Valid password entry
    Given User confirms to be on the homepage
    Then User verifies that "Profile" button is visible and clicks the button.
    When User verifies that "Sign Up" button is visible and clicks the button.
    Then I enter the appropriate entries in the name and phone fields and enter a password of less than 6 characters and click Sign Up button.
    Then User should see the "Password is short" error message

  Scenario: Phone number validation
    Given User confirms to be on the homepage
    Then User verifies that "Profile" button is visible and clicks the button.
    When User verifies that "Sign Up" button is visible and clicks the button.
    And I enter the appropriate entries in the name and password fields and enter a phone of less than 7 digits and click Sign Up button.
    Then User should see an "Error" popup message

  Scenario: Verify that the SignUp module works with the correct data
    Given User confirms to be on the homepage
    Then User verifies that "Profile" button is visible and clicks the button.
    When User verifies that "Sign Up" button is visible and clicks the button.
    Then User fills in all fields properly and click Sign Up button.
    And User should see an "Success" popup message

  Scenario: Verify that the SignUp module works with a password of minimum 8 characters
    Given User confirms to be on the homepage
    Then User verifies that "Profile" button is visible and clicks the button.
    When User verifies that "Sign Up" button is visible and clicks the button.
    Then User fills in all fields properly, including the 8-character password, and clicks the Sign Up button
    And User should see an "Success" popup message

  Scenario: Switch from SignUp page to SignIn page
    Given User confirms to be on the homepage
    Then User verifies that "Profile" button is visible and clicks the button.
    When User verifies that "Sign Up" button is visible and clicks the button.
    Then User verifies that "Sign In" button is visible and clicks the button.
    And User verifies that the directed page is "Sign In" page.