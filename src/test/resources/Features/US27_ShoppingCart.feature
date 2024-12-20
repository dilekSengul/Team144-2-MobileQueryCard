Feature: As a registered user, I want to have a cart on the site and I want to be able to manage these cart operations

  Background: User opens the app
    * User makes driver adjustments

  Scenario: TC06: QueryCart customer should see the basket icon and verify that the ‘Shopping Cart’ menu opens when clicked
    Given QueryCart customer shopping basket must be visible and active
    When QueryCart customer clicks on the shopping basket button
    Then QueryCart validates that the customer is in the Shopping Cart menu
    And Driver turns off

  Scenario: TC07: QueryCart customer should see ‘Go to Shopping’ when no product is added to the basket
    Given QueryCart customer clicks on the shopping basket button
    # new UiSelector().description("Go to Shopping") Go to shoping butonu
  # new UiSelector().className("android.widget.ImageView").instance(0) # boş kutu simgesi
  #deneme
  #deneme

  Scenario: TC08: QueryCart customer adds a product to the basket and should see ‘Go to Shopping’ when he presses the ‘remove’ button.

  Scenario: TC09: QueryCart customer adds products to the basket and the price of the added product and the ‘Subtotal’ value in the basket must be the same

  Scenario: TC10: QueryCart customer should see the ‘Prooceed to Checkout’ button when the product attached to the basket appears