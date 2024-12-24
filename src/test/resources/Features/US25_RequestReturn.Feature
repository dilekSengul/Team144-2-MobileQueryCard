Feature: Manage Product Returns


  Background: User opens the app
    * User makes driver adjustments
    * User confirms to be on the homepage
    * User clicks the button with description "Profile"
    * User clicks the button with description "Sign In"
    * User clicks the button "phoneTextBox" and sendKeys "6505551212"
    * User clicks the button "signInLoginButton"


  Scenario: Initiating a return request for a delivered order
    Given User navigates to the "Dashboard Order History" page
    When User selects an order with the status "Delivered"
    And User clicks the button with description "Return Request"
    Then the user should be directed to the "Request Return" page
    And should be able to select the desired product(s) for return


  Scenario: Completing and submitting a return request
    Given the user is on the "Request Return" page
    When the user selects the product(s) to return
    And provides a reason for the return, a note, and an attachment if necessary
    And clicks the "Request Return" button
    Then the return request should be successfully submitted
    And the user should see the return status as "Process Started" on the "Return Orders" page
