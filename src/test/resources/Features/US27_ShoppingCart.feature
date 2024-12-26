Feature: As a registered user, I want to have a cart on the site and I want to be able to manage these cart operations

  Background: User opens the app
    * User makes driver adjustments

  # @Allure
  Scenario: TC06: QueryCart customer should see the basket icon and verify that the ‘Shopping Cart’ menu opens when clicked
    Given QueryCart customer shopping basket must be visible and active
    When QueryCart customer clicks on the shopping basket button
    Then QueryCart validates that the customer is in the Shopping Cart menu
    And Driver turns off

  Scenario: TC07: QueryCart customer should see ‘Go to Shopping’ when no product is added to the basket
    Given QueryCart customer clicks on the shopping basket button
    When QueryCart customer's shopping basket must be empty and Go to Shopping button must be visible and active
    Then Driver turns off

  Scenario: TC08: QueryCart customer adds a product to the basket and should see ‘Go to Shopping’ when he presses the ‘remove’ button.
    Given User clicks the button with description "Profile"
    When User clicks the button with description "Sign In"
    Then As a user muss be "phoneNumber" phone and "password" password Login
    And QueryCart customer selects the Flower Print Foil Tshirt product on the Home page
    And QueryCart customer selects "L" as size
    And QueryCart customer presses the Add To Cart button
    And User clicks tap coordinates 1195, 2699
    And QueryCart customer clicks the remove button and deletes the product in the shopping basket
    And QueryCart customer's shopping basket must be empty and Go to Shopping button must be visible and active
    And Driver turns off

  Scenario: TC09: QueryCart customer adds products to the basket and the price of the added product and the ‘Subtotal’ value in the basket must be the same
    Given User clicks the button with description "Profile"
    When User clicks the button with description "Sign In"
    Then As a user muss be "phoneNumber" phone and "password" password Login
    And QueryCart customer selects the Flower Print Foil Tshirt product on the Home page
    And QueryCart customer selects "L" as size
    And QueryCart customer presses the Add To Cart button
    And User clicks tap coordinates 1195, 2699
    And QueryCart customer verifies that subtotal is visible
    And Driver turns off

  Scenario: TC10: QueryCart customer should see the ‘Prooceed to Checkout’ button when the product attached to the basket appears
    Given User clicks the button with description "Profile"
    When User clicks the button with description "Sign In"
    Then As a user muss be "phoneNumber" phone and "password" password Login
    And QueryCart customer selects the Flower Print Foil Tshirt product on the Home page
    And QueryCart customer selects "L" as size
    And QueryCart customer presses the Add To Cart button
    And User clicks tap coordinates 1195, 2699
    And QueryCart customer verifies that the Prooceed to Checkout button is visible and active
    And QueryCart customer clicks Prooceed to Checkout button
    And QueryCart customer should reach Shipping Information menu
    And Driver turns off