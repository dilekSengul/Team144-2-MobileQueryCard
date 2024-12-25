
@gulnar

Feature: Edit Profile As a registered user

  Background: User opens the app
    * User makes driver adjustments

Scenario Outline: :As a registered user, I would like to be able to edit my profile information on the site

    * The user opens the application and click on the profile link
    * User clicks the sign in button
    * As a user muss be "phonenumber" phone and "Password" password Login
    * The user  click on the profile link
    * click on "Edit Profile" and edit profile
    * Edit fullName "<fullname>" email address button "<Email>"
    * Click on the Save button to register
    * Driver turns off

  Examples:
    |fullname| Email|
    | fullname1|Email1|
    | fullname2|Email2|

