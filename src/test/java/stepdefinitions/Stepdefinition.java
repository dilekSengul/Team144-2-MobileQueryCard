package stepdefinitions;

import Page.QueryCardPage;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.OptionsMet;
import utilities.ReusableMethods;


import javax.sound.midi.InvalidMidiDataException;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.*;

public class Stepdefinition extends OptionsMet {
    QueryCardPage card = new QueryCardPage();
    Actions actions = new Actions(getAppiumDriver());

    @Given("User makes driver adjustments")
    public void user_makes_driver_adjustments() {
        getAppiumDriver();
    }

    @Given("User confirms to be on the homepage")
    public void user_confirms_to_be_on_the_homepage() {
        card.LogoGorunurTest();
    }

    @Given("User clicks the button with description {string}")
    public void user_clicks_the_button_with_description(String description) {
        ReusableMethods.wait(5);
        clickButtonByDescription(description);
    }

    @Given("User clicks the button {string} and sendKeys {string}")
    public void user_clicks_the_button_and_send_keys(String elementName, String text) {
        card.phoneTextBoxClickAndSendKeys(text);
        // Telefon numarası alanından sonra Tab ile şifre alanına geç
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("Wise.123").perform();
        ReusableMethods.wait(1);
        // Şifre alanından sonra Tab ile "remember me" checkbox'ına geç
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.SPACE).perform();
        actions.sendKeys(Keys.ENTER).perform();

    }

    @Given("User clicks the button {string}")
    public void user_clicks_the_button(String elementName) {
        card.signInLoginClick();
        ReusableMethods.wait(1);
        hideKeyboard();
        ReusableMethods.wait(2);

    }

    @Given("Verifies username {string} in dashboard")
    public void verifies_username_in_dashboard(String userName) {
        ReusableMethods.wait(1);
        VerifyElementText(userName);
    }
    /***US 11   **/
    @Given("As a user muss be {string} phone and {string} password Login")
    public void as_a_user_muss_be_phone_and_password_login(String phoneNumber, String password) {
        card.Login(phoneNumber,password);
    }
    @Given("User clicks the button with itemName {string} and {string} and {string} added WishList")
    public void user_clicks_the_button_with_item_name_and_and_added_wish_list(String itemName, String reviews,String price) {
       xPathElementClick(itemName,reviews,price);
    }


    @Given("Driver turns off")
    public void driver_turns_off() {
        quitAppiumDriver();
    }
    @Given("Toaster is displayed")
    public void toast_is_displayed() {
        card.wishListToast();

    }
    @Given("User confirms that categories appear on the screen")
    public void user_confirms_that_categories_appear_on_the_screen(){
       // for (int i = 0; i <categoriesMen.size(); i++) {
        //    assertTrue(categoriesMen.get(i).);
      //  }
    }

    @Given("User clicks phone number textbox and {string} phone number")
    public void user_clicks_phone_number_textbox_and_phone_number(String phoneNumber) {
     card. ForgetPasswordPhoneBox(phoneNumber);
    }
    @Given("User clicks NewPasswordTextBox and confirmPasswordTextBox {string}")
    public void user_clicks_new_password_text_box_and_confirm_password_text_box(String newPassword) {
        card.NewPassword(newPassword);
    }
    @Given("User clicks tap coordinates {int}, {int}")
    public void user_clicks_tap_coordinates(Integer x, Integer y) {
        ReusableMethods.wait(1);
        OptionsMet.touchDown(x,y);
        ReusableMethods.wait(1);
    }
    @Given("User swipe to screen coordinates {int}, {int}, {int}, {int}")
    public void user_swipe_to_screen_coordinates(Integer x, Integer y, Integer endX, Integer endY) throws InvalidMidiDataException {
        OptionsMet.swipe(x,y,endX,endY);
        ReusableMethods.wait(2);
    }
    //****us11***

    @Then("User clicks the button with itemName {string}")
    public void user_clicks_the_button_with_item_name(String itemName) {
        //  clickButtonByDescription(itemName);
        ReusableMethods.wait(3);
        touchDown(874,667);


    }
    @Then("As a user must be {string} email and {string} password Login")
    public void asAUserMustBeEmailAndPasswordLogin(String registeredEmail, String registeredPassword) {
        ReusableMethods.wait(3);
        card.LoginWithEmail(registeredEmail,registeredPassword);
    }

    @Then("User Verifies the visibility and functionality of the {string} button")
    public void userVerifiesTheVisibilityAndFunctionalityOfTheButton(String text) {
        ReusableMethods.wait(4);

        VerifyElementText(text);
        clickButtonByDescription(text);
    }
    @Given("The user clicks the heart icon on the product named {string}")
    public void the_user_clicks_the_heart_icon_on_the_product_named(String favoriyeEklenenUrun) throws InvalidMidiDataException {
        ReusableMethods.wait(5);
        swipe(530,2132,526,91);
        ReusableMethods.wait(3);
        swipe(419,1931,407,534);
        card.getTheNortFaceArcticParkaHeartIcon().click();


    }
    @When("Verifies that they are redirected to the sign-in page with the message Sign in to continue shopping.")
    public void verifies_that_they_are_redirected_to_the_sign_in_page_with_the_message() {
        ReusableMethods.wait(3);
        Assert.assertTrue(card.getSignInPageVerificationText().isDisplayed());
    }
    @Then("Then Clicks the {string} link")
    public void thenClicksTheLink(String signUp) {
        clickButtonByDescription(signUp);

    }
    @Then("Registers as a new user with {string},{string} and {string}")
    public void registersAsANewUserWithAnd(String name, String phone, String password) {
        ReusableMethods.wait(3);
        // card.signUp(name,phone,Password);
        card.registerNewUser(name,phone,password);

    }
    @Then("A Success notification is displayed.")
    public void a_notification_is_displayed() {
      //  ReusableMethods.wait(1);
       // card.getSuccessMessage().isDisplayed();
       // WebElement successMessage = getAppiumDriver().findElement(AppiumBy.xpath("//*[contains(@content-desc, 'item added')]"));
       card.verifySuccessNotificationText();
    }
    @Then("Logs in as a user with the {string} and {string}")
    public void logs_in_as_a_user_with_the_and(String phone, String Password) {
        ReusableMethods.wait(3);
        card.LoginWithPhone(phone,Password);
    }

    @Then("Sees the notification Added to Wishlist")
    public void sees_the_notification() {
        ReusableMethods.wait(4);
        card.getAddedToWishlistNatification().isDisplayed();
    }
}

