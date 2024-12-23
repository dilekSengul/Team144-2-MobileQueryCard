@Us26
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


     Scenario Outline: Test to select   favorite products and add to wishlist and visible
        Given User clicks the button with description "Profile"
        When User clicks the button with description "Sign In"
        Then User clicks the button with itemName " *Use Email Instead"
        Then As a user must be "registeredEmail" email and "registeredPassword" password Login
      # Then  clicks the button with itemName "<productName>" and "<productReviews>" and "<productPrice>" added WishList
       # Then User clicks the button with itemName "<productName>" and "<productReviews>" and "<productPrice>" added WishList
        Then User clicks the button with itemName "Flower Print Foil T-shirt" and "0 (0  Reviews)" and "$65.00" added WishList
       Then Toaster is displayed
       Then  User clicks the button with itemName "Floral Print Midi Dress" and "0 (0 Reviews)" and "$100.00" added WishList
       Then Toaster is displayed
       Then User clicks the button with description "Wishlist"
       Then Verifies that the products added to the Wishlist page are displayed correctly.
         | productName               | productReviews  | productPrice |
         | Flower Print Foil T-shirt | 0 (0 Reviews)  | $65.00      |
         | Floral Print Midi Dress   | 0 (0 Reviews) | $100.00     |
       And Driver turns off

      Examples:
        | productName               | productReviews  | productPrice |
        | Flower Print Foil T-shirt | 0 (0 Reviews)  | $65.00      |
        | Floral Print Midi Dress   | 0 (0 Reviews) | $100.00     |