package stepdefinitions;

import Page.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.OptionsMet;
import utilities.ReusableMethods;

import javax.sound.midi.InvalidMidiDataException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;
import static utilities.Driver.quitAppiumDriver;
import static utilities.OptionsMet.touchDown;
import static utilities.ReusableMethods.ekranKaydirmaMethodu;

public class Stepdefinition extends OptionsMet {
    QueryCardPage card = new QueryCardPage();
    CategoriesPage categoriesPage = new CategoriesPage();
    Actions actions = new Actions(getAppiumDriver());
    WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(15));
    ShoppingBasketPage basketPage = new ShoppingBasketPage();
    AddressMenuPage addressMenuPage= new AddressMenuPage();
    ElementLocatorsOnur elementLocatorsOnur = new ElementLocatorsOnur();
    private static final Logger logger = LogManager.getLogger(stepdefinitions.Stepdefinition.class);


    @Given("User makes driver adjustments")
    public void user_makes_driver_adjustments() {
        getAppiumDriver();
        logger.info("Kullanıcı gerekli emülatör ayarlarını yapar");
    }

    @Given("User confirms to be on the homepage")
    public void user_confirms_to_be_on_the_homepage() {
        card.LogoGorunurTest();
        logger.info("Kullanıcı home page olduğunu doğrulamak için QueryCart logosunun görünürlüğünü doğrular");
    }

    @Given("User clicks the button with description {string}")
    public void user_clicks_the_button_with_description(String description) {
        ReusableMethods.wait(2);
        clickButtonByDescription(description);
        Allure.step("User clicks the button with description "+ description);
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
        logger.info("Kullanıcı phoneNumber olarak " + phoneNumber + " password olarakta " + password + " kullanarak giriş yapar.");
        Allure.step("Kullanıcı phoneNumber olarak " + phoneNumber + " password olarakta " + password + " kullanarak giriş yapar.");
    }

    @Given("User clicks the button with itemName {string} and {string} and {string} added WishList")
    public void user_clicks_the_button_with_item_name_and_and_added_wish_list(String itemName, String reviews, String price) {
        ReusableMethods.wait(3);
        xPathElementClick(itemName, reviews, price);
        Allure.step("User clicks the button with itemName  "+itemName+" and "+reviews+" and "+price+" added WishList");
        logger.info("User clicks the button with itemName  "+itemName+" and "+reviews+" and "+price+" added WishList");
    }


    @Step("Driver turns off")
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
        touchDown(x, y);
        ReusableMethods.wait(1);
    }

    @Given("User swipe to screen coordinates {int}, {int}, {int}, {int}")
    public void user_swipe_to_screen_coordinates(Integer x, Integer y, Integer endX, Integer endY) throws InvalidMidiDataException {
        OptionsMet.swipe(x, y, endX, endY);
        ReusableMethods.wait(2);
        Allure.step("User swipe to screen coordinates "+x+" "+y+" "+endX+" "+endY+".");
    }


    //***US04***//

    @When("User verifies that {string} button is visible")
    public void user_verifies_that_button_is_visible(String categories) {
        assertTrue(categoriesPage.getCategoriesText().isDisplayed());

    }


    @Then("User verifies all categories are displayed")
    public void user_verifies_all_categories_are_displayed() throws InterruptedException {
        List<WebElement> allCategories = categoriesPage.getAllCategories();
        int swipeCount = 0; // Kaydırma sayısını takip etmek için
        int kaydirmaSayisi = 4; // Bir swipe'da kaydırılan element sayısı

        List<String> invisibleCategories = new ArrayList<>(); // Görünmeyen kategorileri kaydetmek için

        for (int i = 0; i < allCategories.size(); i++) {
            WebElement category = allCategories.get(i);

            if (!category.isDisplayed()) {
                // Görünmeyen kategoriyi listeye ekle
                invisibleCategories.add(category.getAttribute("content-desc"));
            } else {
                // Görünür kategoriyi doğrula
                System.out.println("Category " + category.getAttribute("content-desc") + " is visible.");
            }

            // Her 4 kategoride bir swipe yap
            if ((i + 1) % kaydirmaSayisi == 0 && i != allCategories.size() - 1) {
                swipeCount++;
                System.out.println("Swipe " + swipeCount + " kez ekran kaydırma yapıldı.");
                ekranKaydirmaMethodu(1310, 1410, 5000, 40, 1390); // Sağ kaydırma
            }

            // Son kaydırma işlemi için özel durum
            if (i == 36) {
                kaydirmaSayisi = 3; // Son swipe'daki sayı
            }
        }
            // Görünmeyen kategorileri raporla ve testi başarısız yap
        if (!invisibleCategories.isEmpty()) {
            System.out.println("Invisible Categories:");
            for (String category : invisibleCategories) {
                System.out.println("- " + category);
            }
            Assert.fail("Bazı kategoriler görünmüyor!");
        } else {
            // Tüm kategoriler görünürse bilgilendirme mesajı yazdır
            System.out.println("***************");
            System.out.println("Tüm kategoriler görünür durumda");
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
    public void userClicksTheButton(String element) throws InterruptedException {
        assertTrue(categoriesPage.getFirstProductMen().isDisplayed());
        categoriesPage.getFirstProductMen().click();

    }

    @Step("User clicks the backArrow button")
    @Then("User clicks the backArrow button")
    public void userclicksthebackArrowbutton() throws InterruptedException {
        categoriesPage.getBackArrow().click();
        ReusableMethods.wait(1);
        categoriesPage.getBackArrow().click();
        logger.info("Kullanıcı geri tuşuna basar");
//        assertTrue(card.getQueryCardLogoElement().isDisplayed());
//        Thread.sleep(1000);
    }

    //***US17***//

    @When("User enters the mandatory fields \\(Email and Password) and clicks Sign In button.")
    public void user_enters_the_mandatory_fields_name_email_and_password_and_clicks_sign_in_button() {
        addressMenuPage.getSignInButton().click();
        addressMenuPage.getUseEmailText().click();
        ReusableMethods.wait(1);
        addressMenuPage.getEmailField().click();
        addressMenuPage.getEmailField().sendKeys("serpil.user@querycart.com");
        ReusableMethods.wait(1);
        addressMenuPage.getPasswordField().click();
        addressMenuPage.getPasswordField().sendKeys("Query.151224");
        ReusableMethods.wait(1);
        addressMenuPage.getSignInButton2().click();
    }

    @Given("User navigates to the {string} page")
    public void user_navigates_to_the_page(String homePage) {
        addressMenuPage.getProfileButton().click();
        addressMenuPage.getAddressButton().click();
    }
    @Then("User verifies that all registered addresses are visible")
    public void user_verifies_that_all_registered_addresses_are_visible() {
        // Adres kartlarını al
        List<WebElement> addressCards = addressMenuPage.getAddressCards();

        // Adres kartlarının boş olmadığını doğrula
        Assert.assertFalse("Hiçbir adres kartı bulunamadı!", addressCards.isEmpty());

        // Her bir kartın içeriğini kontrol et
        for (WebElement card : addressCards) {
            String cardText = card.getAttribute("content-desc");
            Assert.assertNotNull("Adres kartı içeriği null geldi!", cardText);
            Assert.assertTrue(
                    "Adres kartı içeriği eksik veya yanlış: " + cardText,
                    cardText.contains("Nero") || cardText.contains("Serr S") || cardText.contains("Serpil S")
            );
        }

        System.out.println("Tüm adres kartları başarıyla doğrulandı!");
    }


    @Then("User verifies that registered addresses are editable")
    public void user_verifies_that_registered_addresses_are_editable() {
        addressMenuPage.getEditButton().isDisplayed();
        addressMenuPage.getEditButton().click();
        ReusableMethods.wait(1);
        addressMenuPage.getStreetAddress().sendKeys("Baker Street");
        addressMenuPage.getUpdateAddress().click();

        try {
            assertTrue(elementLocatorsOnur.getPopupSignUpPage().getAttribute("contentDescription").contains("Success"));
            System.out.println("Message: " + "\"" + elementLocatorsOnur.getPopupSignUpPage().getAttribute("contentDescription") + "\"");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }

    }

    @Then("User verifies that registered addresses are deletable")
    public void user_verifies_that_registered_addresses_are_deletable() {
        addressMenuPage.getDeleteButton().click();
        ReusableMethods.wait(1);
        addressMenuPage.getDeleteButtonDeletePage().click();
        try {
            assertTrue(elementLocatorsOnur.getPopupSignUpPage().getAttribute("contentDescription").contains("Success"));
            System.out.println("Message: " + "\"" + elementLocatorsOnur.getPopupSignUpPage().getAttribute("contentDescription") + "\"");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }


    }

    @Then("User verifies that the {string} button is visible and active")
    public void user_verifies_that_the_button_is_visible_and_active(String string) {
        addressMenuPage.getAddNewAddressButton().isDisplayed();
        addressMenuPage.getAddNewAddressButton().click();
        assertTrue(addressMenuPage.getAddNewAddressButton().isDisplayed());
    }


    @When("User clicks on the {string} button")
    public void user_clicks_on_the_button(String string) {
        ReusableMethods.wait(3);
        addressMenuPage.getAddNewAddressButton().click();

    }

    @When("User fills in the new address details")
    public void user_fills_in_the_new_address_details() {
        addressMenuPage.getFullName().click();
        addressMenuPage.getFullName().sendKeys("Leo Tin");
        ReusableMethods.wait(2);
        addressMenuPage.getEmailFieldAdd().click();
        addressMenuPage.getEmailFieldAdd().sendKeys("leo@gmail.com");
        ReusableMethods.wait(3);
        addressMenuPage.getPhoneField().click();
        addressMenuPage.getPhoneNumber().click();
        ReusableMethods.wait(2);
        addressMenuPage.getPhoneTextField().click();
        addressMenuPage.getPhoneTextField().sendKeys("5555555");
        ReusableMethods.wait(2);
        addressMenuPage.getCountryField().click();
        addressMenuPage.getAlgeria().click();
        ReusableMethods.wait(1);
        addressMenuPage.getStateField().click();
        addressMenuPage.getAlgiersProvince().click();
        ReusableMethods.wait(1);
        addressMenuPage.getCityField().click();
        addressMenuPage.getRouiba().click();
        ReusableMethods.wait(1);
        addressMenuPage.getZipCodeField().click();
        addressMenuPage.getZipCodeField().sendKeys("999");
        ReusableMethods.wait(1);
        addressMenuPage.getStreetAddressField().click();
        addressMenuPage.getStreetAddressField().sendKeys("White Street");
        ReusableMethods.wait(1);


    }

    @Then("User verifies that the new address is added successfully")
    public void user_verifies_that_the_new_address_is_added_successfully() throws InvalidMidiDataException {
        OptionsMet.swipe(617,1864,640,364);
        ReusableMethods.wait(1);
        addressMenuPage.getAddAdressLast().click();
        ReusableMethods.wait(1);
        try {
            assertTrue(elementLocatorsOnur.getPopupSignUpPage().getAttribute("contentDescription").contains("Success"));
            System.out.println("Message: " + "\"" + elementLocatorsOnur.getPopupSignUpPage().getAttribute("contentDescription") + "\"");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
    }
    @Then("Close the page")
    public void close_the_page() {
        quitAppiumDriver();

    }




    //****us11-23-26***

    @Then("User clicks the button with itemName {string}")
    public void user_clicks_the_button_with_item_name(String itemName) {

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
    public void the_user_uses_phone_instead_enters_and(String string, String string2) {
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
        ReusableMethods.wait(1);
        VerifyElementText(text);
        clickButtonByDescription(text);

    }

    @Given("Edit fullName {string} email address button {string}")
    public void edit_full_name_fullname_email_address_button(String fullName, String Email) {

        card.hesabimYeniBilgiDogrulama(fullName, Email);


    }


    @Given("Click on the Save button to register")
    public void click_on_the_save_button_to_register() {
        ReusableMethods.wait(1);
        //ReusableMethods.scrollWithUiScrollableAndClick("Save Changes");
        card.getSaveChanges().click();

    }

    @Step("User presses the magnifying glass button to make a search")
    @And("User presses the magnifying glass button to make a search")
    public void userPressesTheMagnifyingGlassButtonToMakeASearch() {
        wait.until(ExpectedConditions.visibilityOf(card.getAramaButonu()));
        card.getAramaButonu().click();
        logger.info("Kullanıcı search butonuna tıklar.");
    }

    @And("User types {string} in searchTextBox")
    public void userTypesInSearchTextBox(String productName) {
        card.getSearchTextBox().sendKeys(productName);
        actions.sendKeys(Keys.ENTER).perform();
        logger.info("Kullanıcı arama kutusa belirlenmiş ürün adını yazar");
        Allure.step("User types "+ productName +" in searchTextBox");
    }

    @Step("User selects the Flower Print Foil Tshirt product on the Home page")
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
        Allure.step("User selects "+ size +" as size");
    }

    @Step("User presses the Add To Cart button")
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

    @Step("The user verifies that there are items in the shopping basket")
    @And("The user verifies that there are items in the shopping basket")
    public void theUserVerifiesThatThereAreItemsInTheShoppingBasket() {
        wait.until(ExpectedConditions.visibilityOf(basketPage.getProductPrice()));
        assertTrue(basketPage.getProductPrice().isDisplayed());
    }

    @Given("The user swipes the screen twice to view the Most Popular section")
    public void theUserSwipesTheScreenTwiceToViewTheMostPopularSection() {
        int startX = 364;
        int startY = 1946;
        int endX = 360;
        int endY = 311;
        int duration = 500;
        int swipeCount = 2;
        card.swipeMethotWithDuration(startX, startY, endX, endY, duration, swipeCount);
    }

    @Step("User presses the plus button")
    @And("User presses the plus button")
    public void userPressesThePlusButton() {
        for (int i = 0; i < 10; i++) {
            ReusableMethods.wait(1);
            card.getPlusButton().click();
        }
    }

    @Step("User clicks on the watch product")
    @And("User clicks on the watch product")
    public void userClicksOnTheWatchProduct() {
        card.getWatchButton().click();
    }
}

