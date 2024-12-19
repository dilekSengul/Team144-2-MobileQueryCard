@onur @US07
Feature: User Registration
  As a user, I want to be able to register on the site to take advantage of its functions.

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
    Then I should see an error message indicating the password criteria

  Scenario: Phone number validation
    Given User confirms to be on the homepage
    Then User verifies that "Profile" button is visible and clicks the button.
    When User verifies that "Sign Up" button is visible and clicks the button.
    And I enter the appropriate entries in the name and phone fields and enter a phone of less than 7 digits and click Sign Up button.
    Then I should see an error message indicating the phone number criteria

  Scenario: Verify that the SignUp module works with the correct data
    Given User confirms to be on the homepage
    Then User verifies that "Profile" button is visible and clicks the button.
    When User verifies that "Sign Up" button is visible and clicks the button.
    #Then User fills the all fields properly and click Sign Up button.

  #Scenario: Switch from SignUp page to SignIn page
  #  Given I am on the SignUp page
  #  When I click the "SignIn" link or button
  #  Then I should be redirected to the SignIn page