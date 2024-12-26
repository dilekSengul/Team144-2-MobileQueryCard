Feature: Payment completion
  As a registered user,
  I would like to have a page on the site where I can select and manage my address information before completing the payment.

  Background: User opens the app
    * User makes driver adjustments
    * User confirms to be on the homepage

Scenario: Signing in before shopping
  Given User clicks the button with description "Profile"
  When User clicks the button with description "Sign In"
  Then As a user must be {string} email and {string} password Login
  Then QueryCart customer selects the Flower Print Foil Tshirt product on the Home page
  Then QueryCart customer selects "L" as size
  Then QueryCart customer presses the Add To Cart button
  Then User clicks tap coordinates 1195, 2699
  Then QueryCart customer clicks Prooceed to Checkout button
  Then QueryCart customer should reach Shipping Information page
  And Driver turns off

Scenario:Verify Delivery and Pick Up buttons are visible and active
  Given User on the Shipping Information page
  When "Delivery" button should be visible
  Then User click on the "Delivery" button
  Then Shipping address section should be displayed
  Then "Pick Up" button should be visible
  Then "Pick Up" button should be clickable
  And Order summary section should be visible

Scenario: Verify to edit an existing shipping address
  Given I am on the Shipping Information page
  When I click on the "Delivery" button
  Then I click on the "Edit" button for an existing address
  Then I modify the State field
  Then I Update address
  And Updated address should be displayed
