package stepdefinitions;

import Page.CategoriesPage;
import Page.MostPopularProductsPage;
import Page.QueryCardPage;
import Page.ShoppingBasketPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.OptionsMet;
import utilities.ReusableMethods;


import javax.sound.midi.InvalidMidiDataException;

import java.time.Duration;
import java.util.List;

import static java.awt.SystemColor.text;
import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;
import static utilities.Driver.quitAppiumDriver;
import static utilities.ReusableMethods.ekranKaydirmaMethodu;

public class Stepdefinition extends OptionsMet {
    QueryCardPage card = new QueryCardPage();
    CategoriesPage categoriesPage = new CategoriesPage();
    Actions actions = new Actions(getAppiumDriver());
    WebDriverWait wait = new WebDriverWait(getAppiumDriver(),Duration.ofSeconds(15));
    ShoppingBasketPage basketPage = new ShoppingBasketPage();
    private static final Logger logger = LogManager.getLogger(stepdefinitions.Stepdefinition.class);


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
        ReusableMethods.wait(2);
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
        card.Login(phoneNumber, password);
    }

    @Given("User clicks the button with itemName {string} and {string} and {string} added WishList")
    public void user_clicks_the_button_with_item_name_and_and_added_wish_list(String itemName, String reviews, String price) {
        ReusableMethods.wait(3);
        xPathElementClick(itemName, reviews, price);
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
    public void user_confirms_that_categories_appear_on_the_screen() {
        // for (int i = 0; i <categoriesMen.size(); i++) {
        //    assertTrue(categoriesMen.get(i).);
        //  }
    }

    @Given("User clicks phone number textbox and {string} phone number")
    public void user_clicks_phone_number_textbox_and_phone_number(String phoneNumber) {
        card.ForgetPasswordPhoneBox(phoneNumber);
    }

    @Given("User clicks NewPasswordTextBox and confirmPasswordTextBox {string}")
    public void user_clicks_new_password_text_box_and_confirm_password_text_box(String newPassword) {
        card.NewPassword(newPassword);
    }

    @Given("User clicks tap coordinates {int}, {int}")
    public void user_clicks_tap_coordinates(Integer x, Integer y) {
        ReusableMethods.wait(1);
        OptionsMet.touchDown(x, y);
        ReusableMethods.wait(1);
    }

    @Given("User swipe to screen coordinates {int}, {int}, {int}, {int}")
    public void user_swipe_to_screen_coordinates(Integer x, Integer y, Integer endX, Integer endY) throws InvalidMidiDataException {
        OptionsMet.swipe(x, y, endX, endY);
        ReusableMethods.wait(2);
    }


    //***US04***//

    @When("User verifies that {string} button is visible")
    public void user_verifies_that_button_is_visible(String categories) {
        assertTrue(categoriesPage.getCategoriesText().isDisplayed());

    }


    @Then("User verifies all categories are displayed")
    public void user_verifies_all_categories_are_displayed() throws InterruptedException {
        List<WebElement> allCategories = categoriesPage.getAllCategories();

        int swipeCount = 0; // Kaydırma sayacını takip etmek için
        int kaydirmaSayisi = 4; //Bir swipe'da kaydırılan element sayısı
        for (int i = 0; i < allCategories.size(); i++) {
            WebElement category = allCategories.get(i);
            System.out.println("Category " + category.getAttribute("content-desc"));
            // Elementin görünür olduğunu doğrula
            Assert.assertTrue(
                    "Category " + category.getAttribute("content-desc") + " is not displayed",
                    category.isDisplayed()
            );

            // Her 4 kategoride bir swipe yap
            if ((i + 1) % kaydirmaSayisi == 0 && i != allCategories.size() - 1) {

                swipeCount++;
                System.out.println("kaydırma " + swipeCount + " kez ekran kaydırma yapıldı.");
                ekranKaydirmaMethodu(1310, 1410, 5000, 40, 1390); // Sağ kaydırma
                // Thread.sleep(2000) ;
            }
            if (i == 36) {
                kaydirmaSayisi = 3; //Son swipe'daki sayı
            }
        }

        System.out.println("Toplam " + swipeCount + " kez ekran kaydırma yapıldı.");
    }

    @When("User clicks on the category {string}")
    public void user_taps_on_the_category(String men) throws InterruptedException {
        assertTrue(categoriesPage.getMen().isDisplayed());
        categoriesPage.getMen().click();
        Thread.sleep(2000);
    }

    @Then("User clicks the element {string}")
    public void userClicksTheButton(String element) {
        ReusableMethods.koordinatTiklamaMethodu(303, 1873, 1000);

    }

    @Then("User clicks the backArrow button")
    public void userclicksthebackArrowbutton() {
        categoriesPage.getBackArrow().click();
        ReusableMethods.wait(1);
        categoriesPage.getBackArrow().click();
    }

    //****us11-23-26***

    @Then("User clicks the button with itemName {string}")
    public void user_clicks_the_button_with_item_name(String itemName) {
        //  clickButtonByDescription(itemName);
        ReusableMethods.wait(3);
        touchDown(874, 667);


    }

    @Then("As a user must be {string} email and {string} password Login")
    public void asAUserMustBeEmailAndPasswordLogin(String registeredEmail, String registeredPassword) {
        ReusableMethods.wait(7);
        card.LoginWithEmail(registeredEmail, registeredPassword);
    }

    @Then("User Verifies the visibility and functionality of the {string} button")
    public void userVerifiesTheVisibilityAndFunctionalityOfTheButton(String text) {
        ReusableMethods.wait(4);

        VerifyElementText(text);
        clickButtonByDescription(text);
    }

    @When("The user clicks the heart icon on the product named {string}")
    public void the_user_clicks_the_heart_icon_on_the_product_named(String favoriyeEklenenUrun) throws InvalidMidiDataException {
        ReusableMethods.wait(5);
        //  card.getMensAnalogWatch100MeterWater().click();
        card.getTheNorthfaceArcticParka().click();


    }

    @Then("Verifies that they are redirected to the sign-in page with the message Sign in to continue shopping.")
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
        ReusableMethods.wait(6);

        card.registerNewUser(name, phone, password);

    }

    @Then("User should see an Success message on the popup page.")
    public void userShouldSeeAnSuccessMessageOnThePopupPage() {
        card.verifySuccessNotificationText();
    }

    @Then("Logs in as a user with the {string} and {string}")
    public void logs_in_as_a_user_with_the_and(String phone, String Password) {
        ReusableMethods.wait(3);
        card.LoginWithPhone(phone, Password);
    }

    @Then("Sees the notification Added to Wishlist")
    public void sees_the_notification() {
        ReusableMethods.wait(4);
        card.getAddedToWishlistNatification().isDisplayed();
    }
/*
    @Given("The user swipe with coordinates startX {int}, startY {int}, endX {int}, endY {int}, duration {int} for {int} times.")
    public void theUserSwipeWithCoordinatesStartXStartYEndXEndYDurationForTimes(int startX, int startY, int endX, int endY, int duration, int swipeCount) {

        card.swipeMethotWithDuration(startX, startY, endX, endY, duration, swipeCount);
    }
*/
    @Then("The user verifies favorite icons before and after scrolling.")
    public void theUserVerifiesFavoriteIconsBeforeAndAfterScrolling() {
        card.verifyWishlistButtonAfterScroll();
    }

    @Then("Verifies that the products added to the Wishlist page are displayed correctly.")
    public void verifies_that_the_products_added_to_the_wishlist_page_are_displayed_correctly() {

        card.verifyWishlistProducts("wishlist");

    }

    @Then("User clicks the button with itemName {string} and {string} and {string} added WishList.")
    public void userClicksTheButtonWithItemNameAndAndAddedWishList(String itemName, String reviews, String price) {
        ReusableMethods.wait(3);
        card.xPathElementClicknormalizeSpace(itemName, reviews, price);
    }

    @Then("User clicks the button with itemName {string} and {string} and {string} removed WishList")
    public void userClicksTheButtonWithItemNameAndAndRemovedWishList(String itemName, String reviews, String price) {
        ReusableMethods.wait(6);
        // card.xPathElementClicknormalizeSpace(itemName,reviews,price);
        xPathElementClick(itemName, reviews, price);
    }

    @Then("Remove toaster is displayed")
    public void removeToasterIsDisplayed() {
        card.getRemovedToaster().isDisplayed();
    }


    /// /gulnar
    @Given("The user opens the application and click on the profile link")
    public void the_user_opens_the_application_and_click_on_the_profile_link() throws InterruptedException {
        Thread.sleep(500);
        card.getProfile().click();
    }

    @Given("User clicks the sign in button")
    public void User_clicks_the_sign_in_button() {
        card.getSignİn().click();
    }

    @Given("The user uses PHONE instead, enters {string}  and {string}")
    public void the_user_uses_phone_instead_enters_and(String string, String string2){
        card.phoneTextBoxClickAndSendKeys(string2);
        // Telefon numarası alanından sonra Tab ile şifre alanına geç
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("Query.151224").perform();
        ReusableMethods.wait(1);
        // Şifre alanından sonra Tab ile "remember me" checkbox'ına geç
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.SPACE).perform();
      //  actions.sendKeys(Keys.ENTER).perform();

    }
    @Given("The user  click on the profile link")
    public void the_user_click_on_the_profile_link() {
        card.getProfile().click();
    }

    @Given("click on {string} and edit profile")
    public void click_on_and_edit_profile(String text) {
        VerifyElementText(text);
        clickButtonByDescription(text);

    }

    @Given("Edit fullName {string} email address button {string}")
    public void edit_full_name_fullname_email_address_button(String fullName, String Email){

        card.hesabimYeniBilgiDogrulama(fullName,Email);




    }

    @Given("Click on the Save button to register")
    public void click_on_the_save_button_to_register() {
        ReusableMethods.wait(100);
        ReusableMethods.scrollWithUiScrollableAndClick("Save Changes");
        //card.getSaveChanges().click();

    }

    @And("User presses the magnifying glass button to make a search")
    public void userPressesTheMagnifyingGlassButtonToMakeASearch() {
        wait.until(ExpectedConditions.visibilityOf(card.getAramaButonu()));
        card.getAramaButonu().click();
    }

    @And("User types {string} in searchTextBox")
    public void userTypesInSearchTextBox(String productName) {
        card.getSearchTextBox().sendKeys(productName);
        actions.sendKeys(Keys.ENTER).perform();
    }

    @And("User selects the Flower Print Foil Tshirt product on the Home page")
    public void userSelectsTheFlowerPrintFoilTshirtProductOnTheHomePage() {
        basketPage.FirstProductClick();
    }

    @And("User selects {string} as size")
    public void userSelectsAsSize(String size) {
        switch (size) {
            case "L":
                wait.until(ExpectedConditions.visibilityOf(basketPage.getLSize()));
                basketPage.getLSize().click();
                logger.info("Beden olarak " + size + " seçildi");
                break;
            case "S":
                wait.until(ExpectedConditions.visibilityOf(basketPage.getLSize()));
                basketPage.getLSize().click();
                logger.info("Beden olarak " + size + " seçildi");
                break;
            case "M":
                wait.until(ExpectedConditions.visibilityOf(basketPage.getMSize()));
                basketPage.getMSize().click();
                logger.info("Beden olarak " + size + " seçildi");
                break;
            default:
                logger.error("Beden BULUNMAMAKTADIR!");
        }
    }

    @And("User presses the Add To Cart button")
    public void userPressesTheAddToCartButton() {
        try {
            OptionsMet.swipe(651, 2394, 641, 1098);
            logger.info("Kullanıcı sepete ürün eklemesi için kaydırma işlemini yapar");
            wait.until(ExpectedConditions.visibilityOf(basketPage.getAddToCart()));
            basketPage.getAddToCart().click();
            logger.info("Kullanıcı Add To Cart butonuna basar");
        } catch (InvalidMidiDataException e) {
            logger.error("Add To Cart butonu görünür değil!");
        }
        logger.info("Kullanıcı Sepet butonuna basar");
    }
    //us23
    @Given("The user swipes the screen twice to view the Most Popular section")
    public void theUserSwipesTheScreenTwiceToViewTheMostPopularSection() {
        int startX= 364;
        int  startY= 1946;
        int endX= 360;
        int endY =311;
        int duration= 500;
        int swipeCount= 2;
        card.swipeMethotWithDuration(startX, startY, endX, endY, duration, swipeCount);
    }
}

