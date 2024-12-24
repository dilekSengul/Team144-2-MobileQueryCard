Feature: As a registered user, I want to have a payment page where I can pay for my orders that I control.

  Background: User opens the app
    * User makes driver adjustments
    Given User clicks the button with description "Profile"
    When User clicks the button with description "Sign In"
    Then As a user muss be "phoneNumber" phone and "password" password Login
    And QueryCart customer selects the Flower Print Foil Tshirt product on the Home page
    And QueryCart customer selects "L" as size
    And QueryCart customer presses the Add To Cart button
    And User clicks tap coordinates 1195, 2699
    And QueryCart customer clicks Prooceed to Checkout button
    And QueryCart customer makes address selection
    And QueryCart customer makes the swipe operation for Save & Pay button
    And User clicks the button with description "Save & Pay"

  Scenario Outline: TC01: The QueryCart customer completes the purchase with the valid basket number in Stripe Test Mode and should receive a successful message, then click the ‘Go to Shopping’ button to reach the homepage
    And User clicks the button with description "Stripe"
    And User clicks the button with description "Confirm Order"
    And QueryCart customer enters "<cartNumber>" , "<MM_YY>" , "<CVC>" and "<ZipCode>"
    And QueryCart customer clicks Confrim button
    And QueryCart customer clicks on the Go to shopping button
    And User confirms to be on the homepage
    And Driver turns off
    Examples:
      | cartNumber       | MM_YY | CVC | ZipCode |
      | 4242424242424242 | 328   | 332 | 10100   |

  Scenario Outline: TC02: QueryCart customer receives error message with invalid card number in Stripe Test Mode
    And User clicks the button with description "Stripe"
    And User clicks the button with description "Confirm Order"
    And QueryCart customer enters "<cartNumber>" , "<MM_YY>" and "<CVC>"
    And User clicks tap coordinates 679, 776
    And QueryCart customer validates the error message "Your card number is invalid."
    And Driver turns off
    Examples:
      | cartNumber       | MM_YY | CVC |
      | 1234567891012135 | 328   | 332 |

  Scenario: TC03: QueryCart customer receives error message with empty card details in Stripe Test Mode
    And User clicks the button with description "Stripe"
    And User clicks the button with description "Confirm Order"
    And User waits 5 seconds
    And User clicks tap coordinates 679, 776
    And User clicks tap coordinates 679, 776
    And QueryCart customer validates the error message "Your card number is incomplete."
    And Driver turns off


  Scenario Outline: TC04: QueryCart customer uses Live Card in Stripe Test Mode and receives error message
    And User clicks the button with description "Stripe"
    And User clicks the button with description "Confirm Order"
    And QueryCart customer enters "<cartNumber>" , "<MM_YY>" and "<CVC>"
    And User clicks tap coordinates 679, 776
    And QueryCart customer receives an error message at Live cart login
    And Driver turns off
    Examples:
      | cartNumber       | MM_YY | CVC |
      | 4920951557715771 | 328   | 332 |


  Scenario: TC05: QueryCart customer makes the payment with ‘Cash On Delivery’ and should be able to access the ‘Order history’ menu by pressing the ‘Go to order details’ button
    And User clicks the button with description "Cash On Delivery"
    And User clicks the button with description "Confirm Order"
    And QueryCart customer clicks on the Go to shopping button
    And User confirms to be on the homepage
    And Driver turns off