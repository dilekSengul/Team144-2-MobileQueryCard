
@serpil
Feature:  Manage Address Information

  As a registered user,
  I want to have a page on the site where I can manage my address information,
  so that I can easily add, edit, or delete my addresses.

  Background: User opens the app
    * User makes driver adjustments

  Scenario: Verifying that the SignUp form fields cannot be left blank
    Given User confirms to be on the homepage
    Then User verifies that "Profile" button is visible and clicks the button.
    When User verifies that "Sign In" button is visible and clicks the button.
    When User enters the mandatory fields (Email and Password) and clicks Sign In button.
    And Close the page

  Scenario: Verify registered addresses are displayed, editable, and deletable
    Given User confirms to be on the homepage
    Then User verifies that "Profile" button is visible and clicks the button.
    When User verifies that "Sign In" button is visible and clicks the button.
    When User enters the mandatory fields (Email and Password) and clicks Sign In button.
    And User navigates to the "Address" page
    Then User verifies that all registered addresses are visible
    And User verifies that registered addresses are editable
    And User verifies that registered addresses are deletable
    And Close the page


  Scenario: Add a new addressVerify the visibility and activity of the "Add New Address" button
    Given User confirms to be on the homepage
    Then User verifies that "Profile" button is visible and clicks the button.
    When User verifies that "Sign In" button is visible and clicks the button.
    And User enters the mandatory fields (Email and Password) and clicks Sign In button.
    Then User navigates to the "Address" page
    And User verifies that the "Add New Address" button is visible and active
    When User clicks on the "Add New Address" button
    And User fills in the new address details
    And User clicks on the "Add Address" button
    Then User verifies that the new address is added successfully
