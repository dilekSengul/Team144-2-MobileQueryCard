@onur @US15
Feature: Women Categories on Homepage Body


  As a registered user, I would like to be able to see the categories and products of the Women menu on the home page.


  Background: User opens the app
    * User makes driver adjustments
    * User confirms to be on the homepage


  Scenario: Viewing Women category and its subcategories on the homepage
    * User should see the following categories in the categories window in the body section
      | Women                   |
      | Women Clothing          |
      | Woman Dresses - Skirts  |
      | Woman T-shirt           |
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
    #Login steps
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * User enters "phoneNumber" and "password" and clicks on the “Sign In” button.
    #Scenario
    Given User finds and opens the "Women" category page in the Categories Bar in the Homepage body
    When User views the first product
    And User selects a feature of the product
    Then User should be able to add it to the cart
    And User should see an "Success" message on the popup page.
    Then User should be able to add it to the favorites
    And User should see an "Error" message on the popup page.
    Then User navigates back to the homepage
    And User opens the wishlist section
    And User verifies that the product has been added to favorites
    Then The user should be able to remove the product from favorites via the fav button
    And User should see an "Removed" message on the popup page.
    And User verifies that the product has been disappeared on the favorites list
    And Driver turns off

  Scenario: Filtering products in the Women category
    Given User opens the Categories section
    Then User clicks the button with description "Women"
    When User clicks the filter
    Then the filter icons should be displayed properly
    And User sets the "size" filter option to S
    Then User navigates back to the product list via X button
    And User verifies that the filter works properly
    And Driver turns off
