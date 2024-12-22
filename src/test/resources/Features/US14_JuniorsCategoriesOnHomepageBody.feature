Feature: Juniors Kategori Sayfası

  As a registered user, I would like to be able to see the categories and products of the Juniors menu on the home page.

  Background: User opens the app
    * User makes driver adjustments
    * User confirms to be on the homepage
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * User clicks the button "phoneTextBox" and sendKeys "6505551212"
    * User clicks the button "signInLoginButton"

  Scenario: Viewing Juniors category and its subcategories on the homepage
    * User should see the following categories in the categories window in the body section
      | Juniors                 |
      | Juniors Clothing        |
      | Girl Clothes            |
      | Juniors Sleepwear       |
      | Boy Clothes             |
      | Baby Clothes            |
      | Juniors Shoes           |
      | Girl Shoes              |
      | Boy Shoes               |
      | Juniors Accessories     |
      | Juniors Bags            |
      | Juniors Hat & Beres     |
      | Toys                    |


  Scenario: Performing actions on products in the Juniors category
    Given User opens the "Juniors" category page
    When User views the first product
    And User selects a feature of the product
    Then User should be able to add it to the cart
    And User should see an "Success" message on the popup page.
    Then User should be able to add it to the favorites
    And User should see an "Success" message on the popup page.
    Then User navigates back to the homepage
    And User opens the wishlist section
    And User verifies that the product has been added to favorites
    Then The user should be able to remove the product from favorites via the fav button
    And User should see an "Removed" message on the popup page.
    And User verifies that the product has been disappeared on the favorites list

  Scenario: Filtering products in the Juniors category
    And User am on the Juniors category page
    When User view the filter icons
    Then the filter icons should be visible and active
    And User should be able to filter the products based on the available options
