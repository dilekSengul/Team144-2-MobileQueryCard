Feature: Categories on the homepage

  As a user, I want to see the categories listed under the "Categories" heading on the homepage
  so that I can select a product from my desired category.

  Scenario: Verify all categories are visible under the "Categories" heading
    Given User confirms to be on the homepage
    When User verifies that "Categories" button is visible
    Then User verifies all categories are displayed

  Scenario: Select a product from a specific category
    Given User confirms to be on the homepage
    When User verifies that "Categories" button is visible
    Then User clicks on the category "Men"
    And User clicks the element "Ariat Men's Rambler Patriot Western Boot"
    Then User clicks the backArrow button


