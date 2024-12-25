

Feature: As a registered user, I want to have a favorite products page on the site and I want to be able to manage this page.
  Background: User opens the app
    * User makes driver adjustments

    Scenario: Wishlist button should be visible and active on the homepage navbar after scrolling.

      Given User clicks the button with description "Profile"
      When User clicks the button with description "Sign In"
      Then User clicks the button with itemName " *Use Email Instead"
      Then As a user must be "registeredEmail" email and "registeredPassword" password Login
      Then The user verifies favorite icons before and after scrolling.
      And Driver turns off


     Scenario: Test to select favorite products, add them to the wishlist, and verify.
        Given User clicks the button with description "Profile"
        When User clicks the button with description "Sign In"
        Then User clicks the button with itemName " *Use Email Instead"
        Then As a user must be "registeredEmail" email and "registeredPassword" password Login
        Then User clicks the button with itemName "Flower Print Foil T-shirt" and "0 (0  Reviews)" and "$65.00" added WishList
       Then Toaster is displayed
       Then  User clicks the button with itemName "Floral Print Midi Dress" and "0 (0 Reviews)" and "$100.00" added WishList.
       Then Toaster is displayed
       Then User clicks the button with description "Wishlist"
       Then Verifies that the products added to the Wishlist page are displayed correctly.
       And Driver turns off
  @Us26
  Scenario: Test to Removing a product from the wishlist page.
    Given User clicks the button with description "Profile"
    When User clicks the button with description "Sign In"
    Then User clicks the button with itemName " *Use Email Instead"
    Then As a user must be "registeredEmail" email and "registeredPassword" password Login
    Then User clicks the button with description "Wishlist"
    Then User clicks the button with itemName "Flower Print Foil T-shirt" and "0 (0  Reviews)" and "$65.00" removed WishList
    Then Remove toaster is displayed
    And Driver turns off


