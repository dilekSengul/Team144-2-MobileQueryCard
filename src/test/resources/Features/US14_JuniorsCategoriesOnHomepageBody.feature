@onur @US14
Feature: Juniors Categories on Homepage Body


  As a registered user, I would like to be able to see the categories and products of the Juniors menu on the home page.


  Background: User opens the app
    * User makes driver adjustments
    * User confirms to be on the homepage


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
    #Login steps
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * User clicks the button "phoneTextBox" and sendKeys "6505551212"
    * User clicks the button "signInLoginButton"
    #Scenario
    Given User finds and opens the "Juniors" category page in the Categories Bar in the Homepage body
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


  Scenario: Filtering products in the Juniors category
    Given User opens the Categories section
    Then User clicks the button with description "Juniors"
    When User clicks the filter
    Then the filter icons should be displayed properly
    And User sets the "size" filter option to S
    Then User navigates back to the product list via X button
    And User verifies that the filter works properly
