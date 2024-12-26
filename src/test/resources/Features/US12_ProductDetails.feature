Feature: Access detailed information about the selected product

  Background: User opens the app
    * User makes driver adjustments


  Scenario: Verify the user can access product details
    Given the Most Popular menu title should be visible on the home page navBar
    And User clicks on the 1 th item under list
    Then the user should be redirected to the selected product page
    When User clicks the button with description "Details"
    Then the "Product Details" title should be displayed
    When User clicks the button with description "Videos"
    Then the "Product Videos" title should be displayed
    When User clicks the button with description "Review"
    Then the "Product Reviews" title should be displayed
    When User clicks the button with description "Shipping & Return"
    Then the "Shipping & Return" title should be displayed
