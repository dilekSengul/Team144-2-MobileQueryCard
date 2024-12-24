@us23
Feature: As a user, I want to create a favorite list with the products I like without registering.
  Background: User opens the app
    * User makes driver adjustments

  Scenario:

    Given The user swipe with coordinates startX 364, startY 1946, endX 360, endY 311, duration 200 for 1 times.
    When The user clicks the heart icon on the product named "The North Face Arctic Parka"
    Then Verifies that they are redirected to the sign-in page with the message Sign in to continue shopping.
    Then Then Clicks the "Sign Up" link
    Then Registers as a new user with "Ceren","5392898964" and "Selam.1234"
    #Then A Success notification is displayed.
    # And User should see an "Success" popup message
    Then Logs in as a user with the "5392898964" and "Selam.1234"
    Then The user swipe with coordinates startX 364, startY 1946, endX 360, endY 311, duration 200 for 1 times.
    Then The user clicks the heart icon on the product named "The North Face Arctic Parka"
    Then Sees the notification Added to Wishlist
    And Driver turns off


    #ONURThen User should see an "Success" message on "Success" popup page.