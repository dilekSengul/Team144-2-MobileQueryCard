
@us23
Feature: As a user, I want to create a favorite list with the products I like without registering.
  Background: User opens the app
    * User makes driver adjustments


  Scenario:Test to adding a product to the wishlist without being a registered user

    Given The user swipes the screen twice to view the Most Popular section
    When The user clicks the heart icon on the product named "Classic Cotton T-Shirt"
    Then Verifies that they are redirected to the sign-in page with the message Sign in to continue shopping.
    Then Then Clicks the "Sign Up" link
    Then Registers as a new user with "Ceren","5392898699" and "Selam.1234"
    Then User should see an Success message on the popup page.
    Then Logs in as a user with the "5392898699" and "Selam.1234"
    Then The user swipes the screen twice to view the Most Popular section
    Then The user clicks the heart icon on the product named "Classic Cotton T-Shirt"
    Then Sees the notification Added to Wishlist
    And Driver turns off


