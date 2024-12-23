Feature: As a user, I want to be able to see all the categories on the site under the Categories heading.

  Background: User opens the app
    * User makes driver adjustments

Scenario: Categories and filter icons should be visible and active correctly on the home page navigation bar.
  Given The “Category” icon must be visible and clickable
  When The “Men” heading must be visible and clickable
  Then Click the filter icon on the “Men” page.
  And The “Sort By” filter option is displayed.
  Then The “Women” heading must be visible and clickable
  Then Women “Sort By” filter option is displayed.
  Then The “Junior” heading must be visible and clickable
  Then Junior “Sort By” filter option is displayed.

