@onur @US13
Feature: Men Categories on Homepage Body


  As a registered user, I would like to be able to see the categories and products of the Men menu on the home page.


  Background: User opens the app
    * User makes driver adjustments
    * User confirms to be on the homepage


  Scenario: Viewing Men category and its subcategories on the homepage
    * User should see the following categories in the categories window in the body section
      | Men               |
      | Men Clothing      |
      | Men T-Shirt       |
      | Men Shorts        |
      | Men Coat          |
      | Men Suit          |
      | Men Shoes         |
      | Men Sneakers      |
      | Men Classic Shoes |
      | Men Boots         |
      | Men Casual Shoes  |
      | Men Accessories   |
      | Men Bags          |
      | Men Socks         |
      | Men Watch         |


  Scenario: Performing actions on products in the Men category
    #Login steps
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * User enters "phoneNumber" and "password" and clicks on the “Sign In” button.
    #Scenario
    Given User finds and opens the "Men" category page in the Categories Bar in the Homepage body
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

  Scenario: Filtering products in the Men category
    Given User opens the Categories section
    Then User clicks the button with description "Men"
    When User clicks the filter
    Then the filter icons should be displayed properly
    And User sets the "size" filter option to S
    Then User navigates back to the product list via X button
    And User verifies that the filter works properly
    And Driver turns off