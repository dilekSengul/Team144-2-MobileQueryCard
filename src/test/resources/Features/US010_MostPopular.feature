Feature: Most Popular Products
  As a user,
  I would like to have a page where I can follow the latest products on the site where I shop.

  Background: User opens the app
    * User makes driver adjustments

  Scenario: Verify Most Popular section on the homepage
    Given the Most Popular menu title should be visible on the home page navBar
    And current products should be listed under "Most Popular" by swiping 1 times
    And User clicks on the 1 th item under list
    Then the user should return to the homepage
    When User clicks the button with description "See All"
    And current products should be listed under "See All" by swiping 10 times
    And User clicks on the 1 th item under list
    #BURADA BUG VAR
    Then the user should return to the homepage
