Feature: As a registered user,
  I would like to have a dedicated dashboard page on the site to check my actions and settings on the site.

  Background: User opens the app
    * User makes driver adjustments


  Scenario: TC01 Click the profile icon on the homepage and go to the dashboard page
    Given User clicks the button with description "Profile"
    When User clicks the button with description "Sign In"
    Then User clicks the button with itemName use email instead
    Then As a user must be "registeredEmailDamla" email and "registeredPassword" password Login
    Then Click on the profile icon
    Then Verify that the Dashboard page has been opened


    Scenario: TC02
      Given User clicks the button with description "Profile"
      When User clicks the button with description "Sign In"
      Then User clicks the button with itemName use email instead
      Then As a user must be "registeredEmailDamla" email and "registeredPassword" password Login
      Then Click on the profile icon
      Then My Account header should be visible and clickable
      Then Total orders should be visible
      Then Total completed should be visible
      Then Total returnd should be visible
      Then Wallet Ballance should be visible

      Scenario: TC03
        Given User clicks the button with description "Profile"
        When User clicks the button with description "Sign In"
        Then User clicks the button with itemName use email instead
        Then As a user must be "registeredEmailDamla" email and "registeredPassword" password Login
        Then Click on the profile icon
        Then My Account header should be visible and clickable
        Then Order history is displayed



