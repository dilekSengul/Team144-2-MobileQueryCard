@onur @US15
Feature: Women Categories on Homepage Body

  As a registered user, I would like to be able to see the categories and products of the Women menu on the home page.

  Background: User opens the app
    * User makes driver adjustments
    * User confirms to be on the homepage
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * User clicks the button "phoneTextBox" and sendKeys "6505551212"
    * User clicks the button "signInLoginButton"

  Scenario: Viewing Women category and its subcategories on the homepage
    * User should see the following categories in the categories window in the body section
      | Women                   |
      | Women Clothing          |
      | Woman Dresses - Skirts  |
      | Woman T-Shirt           |
      | Woman Trousers          |
      | Woman Coat              |
      | Women Shoes             |
      | Women Casual Shoes      |
      | Women Classic Shoes     |
      | Women's Boots           |
      | Women Sneakers          |
      | Women Accessories       |
      | Women Bags              |
      | Women Watch             |
      | Women Jewelry           |


  Scenario: Performing actions on products in the Women category
    Given User opens the "Women" category page
    When User views the first product
    And User selects a feature of the product
    Then User should be able to add it to the cart
    And User should see an "Success1" message on the popup page.
    Then User should be able to add it to the favorites
    And User should see an "Error1" message on the popup page.
    Then User navigates back to the homepage
    And User opens the wishlist section
    And User verifies that the product has been added to favorites
    Then The user should be able to remove the product from favorites via the fav button
    And User should see an "Error1" message on the popup page.
    And User verifies that the product has been disappeared on the favorites list

  Scenario: Filtering products in the Women category
    And User am on the Women category page
    When User view the filter icons
    Then the filter icons should be visible and active
    And User should be able to filter the products based on the available options
