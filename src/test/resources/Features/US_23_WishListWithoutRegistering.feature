  @us23
  Feature: As a user, I want to create a favorite list with the products I like without registering.

  Scenario:
    Given The user clicks the heart icon on the product named "The North Face Arctic Parka."
    When Verifies that they are redirected to the sign-in page with the message Sign in to continue shopping.
    Then Then Clicks the "Sign Up" link
    Then Registers as a new user with "Ceren","5422898969" and "Selam.1234"
      #name=Ceren
      #phone=5441898969 Teli degisss
      #Password=Selam.1234
   #Then A Success notification is displayed.
    # And User should see an "Success" popup message
    Then Logs in as a user with the "5422898969" and "Selam.1234"
    Then The user clicks the heart icon on the product named "The North Face Arctic Parka."
    Then Sees the notification Added to Wishlist
    And Driver turns off


    #ONURThen User should see an "Success" message on "Success" popup page.