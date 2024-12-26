package stepdefinitions;

import Page.ElementLocatorsOnur;
import Page.QueryCardPage;
import com.github.javafaker.Faker;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import utilities.Driver;
import utilities.OptionsMet;
import utilities.ReusableMethods;
import javax.sound.midi.InvalidMidiDataException;
import java.util.List;


import static org.junit.Assert.*;



public class stepDefOnur {


    private String firstProductCount;
    private String lastProductCount;
    QueryCardPage card = new QueryCardPage();
    ElementLocatorsOnur elementLocatorsOnur = new ElementLocatorsOnur();
    Faker faker = new Faker();
    String fakePhone = faker.numerify("#######");
    String fakePhoneSixDigits = faker.numerify("######");
    String fakeName = faker.name().fullName();

    @Then("User verifies that {string} button is visible and clicks the button.")
    public void userVerifiesThatButtonIsVisibleAndClicksTheButton(String element) {
        OptionsMet.VerifyElementText(element);
        OptionsMet.clickButtonByDescription(element);
    }

    @When("User leaves any of the mandatory fields \\(Name, Phone and Password) blank and click Sign Up button.")
    public void userLeavesAnyOfTheMandatoryFieldsNamePhoneAndPasswordBlankAndClickSignUpButton() {
        assertTrue(elementLocatorsOnur.getSignUpButtonSignUpPage().isDisplayed());
        elementLocatorsOnur.getSignUpButtonSignUpPage().click();

    }

    @Then("User should see an error message indicating that mandatory fields cannot be left blank")
    public void userShouldSeeAnErrorMessageIndicatingThatMandatoryFieldsCannotBeLeftBlank() {

        assertTrue(elementLocatorsOnur.getNameErrorSignUpPage().isDisplayed());
        assertTrue(elementLocatorsOnur.getPhoneErrorSignUpPage().isDisplayed());
        assertTrue(elementLocatorsOnur.getPasswordErrorSignUpPage().isDisplayed());

        assertEquals("This field is required", elementLocatorsOnur.getNameErrorSignUpPage().getAttribute("contentDescription"));
        assertEquals("This field is required", elementLocatorsOnur.getPhoneErrorSignUpPage().getAttribute("contentDescription"));
        try {
            assertEquals("Password is required", elementLocatorsOnur.getPasswordErrorSignUpPage().getAttribute("contentDescription"));
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }

    }


    @Then("I enter the appropriate entries in the name and phone fields and enter a password of less than 6 characters and click Sign Up button.")
    public void iEnterTheAppropriateEntriesInTheNameAndPhoneFieldsAndEnterAPasswordOfLessThanCharacters() {
        ReusableMethods.wait(1);
        elementLocatorsOnur.getNameFieldSignUpPage().click();
        elementLocatorsOnur.getNameFieldSignUpPage().sendKeys(fakeName);
        ReusableMethods.wait(1);
        elementLocatorsOnur.getPhoneFieldSignUpPage().click();
        elementLocatorsOnur.getPhoneFieldSignUpPage().sendKeys(fakePhone);
        ReusableMethods.wait(1);
        elementLocatorsOnur.getPasswordFieldSignUpPage().click();
        elementLocatorsOnur.getPasswordFieldSignUpPage().sendKeys("12345");
        ReusableMethods.wait(1);
        elementLocatorsOnur.getSignUpButtonSignUpPage().click();


    }

    @Then("I clear phone and password field")
    public void iClearPhoneAndPasswordField() {
        ReusableMethods.wait(1);
        elementLocatorsOnur.getPhoneFieldSignUpPage().click();
        elementLocatorsOnur.getPhoneFieldSignUpPage().clear();
        elementLocatorsOnur.getPasswordFieldSignUpPage().click();
        elementLocatorsOnur.getPasswordFieldSignUpPage().clear();
    }


    @Then("User should see an error message")
    public void iShouldSeeAnErrorMessageIndicatingThePhoneNumberCriteria() {
        ReusableMethods.wait(1);
        try {
            assertTrue(elementLocatorsOnur.getPopupSignUpPage().getAttribute("contentDescription").contains("Error"));
            System.out.println("Message: " + "\"" + elementLocatorsOnur.getPopupSignUpPage().getAttribute("contentDescription") + "\"");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
    }


    @And("I enter the appropriate entries in the name and password fields and enter a phone of less than 7 digits and click Sign Up button.")
    public void iEnterTheAppropriateEntriesInTheNameAndPasswordFieldsAndEnterAPhoneOfLessThanDigits() {
        ReusableMethods.wait(1);
        elementLocatorsOnur.getNameFieldSignUpPage().click();
        elementLocatorsOnur.getNameFieldSignUpPage().sendKeys(fakeName);
        ReusableMethods.wait(1);
        elementLocatorsOnur.getPhoneFieldSignUpPage().click();
        elementLocatorsOnur.getPhoneFieldSignUpPage().sendKeys(fakePhoneSixDigits);
        ReusableMethods.wait(1);
        elementLocatorsOnur.getPasswordFieldSignUpPage().click();
        elementLocatorsOnur.getPasswordFieldSignUpPage().sendKeys("1234567o*");
        ReusableMethods.wait(1);
        elementLocatorsOnur.getSignUpButtonSignUpPage().click();
    }

    @Then("User fills in all fields properly and click Sign Up button.")
    public void userFillsInAllFieldsProperlyAndClickSignUpButton() {
        ReusableMethods.wait(1);
        elementLocatorsOnur.getNameFieldSignUpPage().click();
        elementLocatorsOnur.getNameFieldSignUpPage().click();
        elementLocatorsOnur.getNameFieldSignUpPage().sendKeys(fakeName);
        ReusableMethods.wait(1);
        elementLocatorsOnur.getPhoneFieldSignUpPage().click();
        elementLocatorsOnur.getPhoneFieldSignUpPage().sendKeys(fakePhone);
        ReusableMethods.wait(1);
        elementLocatorsOnur.getPasswordFieldSignUpPage().click();
        elementLocatorsOnur.getPasswordFieldSignUpPage().sendKeys("1234o*");
        ReusableMethods.wait(1);
        elementLocatorsOnur.getSignUpButtonSignUpPage().click();
    }

    @And("User should see the success message")
    public void userShouldSeeTheSuccessMessage() {
        try {
            assertTrue(elementLocatorsOnur.getPopupSignUpPage().getAttribute("contentDescription").contains("Success"));
            System.out.println("Message: " + "\"" + elementLocatorsOnur.getPopupSignUpPage().getAttribute("contentDescription") + "\"");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
    }

    @Then("User fills in all fields properly, including the 8-character password, and clicks the Sign Up button")
    public void userFillsInAllFieldsProperlyIncludingTheCharacterPasswordAndClicksTheSignUpButton() {
        ReusableMethods.wait(1);
        elementLocatorsOnur.getNameFieldSignUpPage().click();
        elementLocatorsOnur.getNameFieldSignUpPage().sendKeys(fakeName);
        ReusableMethods.wait(1);
        elementLocatorsOnur.getPhoneFieldSignUpPage().click();
        elementLocatorsOnur.getPhoneFieldSignUpPage().sendKeys(fakePhone);
        ReusableMethods.wait(1);
        elementLocatorsOnur.getPasswordFieldSignUpPage().click();
        elementLocatorsOnur.getPasswordFieldSignUpPage().sendKeys("123456o*");
        ReusableMethods.wait(1);
        elementLocatorsOnur.getSignUpButtonSignUpPage().click();
        ReusableMethods.wait(1);
    }

    @Then("User should see the \"Password is short\" error message")
    public void userShouldSeeTheErrorMessage() {
        try {
            assertTrue(elementLocatorsOnur.getPasswordErrorSignUpPage().isDisplayed());
            assertEquals("Password is short", elementLocatorsOnur.getPasswordErrorSignUpPage().getAttribute("contentDescription"));
            System.out.println("Message: " + "\"" + elementLocatorsOnur.getPasswordErrorSignUpPage().getAttribute("contentDescription") + "\"");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
    }

    @And("User verifies that the directed page is {string} page.")
    public void userVerifiesThatTheDirectedPageIsPage(String expectedPageHeader) {
        OptionsMet.VerifyElementText(expectedPageHeader);
    }

    @Then("User should see an {string} message on the popup page.")
    public void userShouldSeeAnMessageOnPopupPage(String expectedMessage) throws Exception {
       // ReusableMethods.wait(2);
       // ReusableMethods.getScreenshot(expectedMessage); //test edilecek örnek ekran görüntüsünü almak için ilk seferde kullanılır
        OptionsMet.assertElementTextAndVisibility(expectedMessage);


    }

    @Then("User should see the following categories in the categories window in the body section")
    public void userShouldSeeTheFollowingCategoriesInTheCategoriesWindowInTheBodySection(List<String> expectedElements) throws InvalidMidiDataException {

        //OptionsMet.swipeOnur(1200,1150,600,1150,0,150); //istenen kategorilere hızlı yaklaşmak için - hata verebilir
        OptionsMet.scrollLeftAndVerifyElements(expectedElements);
    }

    @Given("User finds and opens the {string} category page in the Categories Bar in the Homepage body")
    public void userOpensTheCategoryPage(String element) throws InvalidMidiDataException {
        //OptionsMet.swipeOnur(1200,1150,400,1150,100,100); //istenen kategorilere hızlı yaklaşmak için - hata verebilir
        OptionsMet.scrollLeftAndClickElement(element);
    }

    @When("User views the first product")
    public void userViewsTheFirstProduct() {
        ReusableMethods.wait(2);
        elementLocatorsOnur.getFirstProduct().click();
    }

    @And("User selects a feature of the product")
    public void userSelectsAFeatureOfTheProduct() {
        ReusableMethods.wait(2);
        elementLocatorsOnur.getProductFeatureButton().click();
    }


    @Then("User should be able to add it to the cart")
    public void userShouldBeAbleToAddItToTheCart() throws InvalidMidiDataException {
        OptionsMet.swipe(700,2300,700,1100);
        ReusableMethods.wait(1);
        elementLocatorsOnur.getAddToCartButton().click();
    }

    @Then("User should be able to add it to the favorites")
    public void userShouldBeAbleToAddItToTheFavorites() {
        ReusableMethods.wait(2);
        elementLocatorsOnur.getFavoriteButton().click();

    }

    @And("User navigates back to the homepage")
    public void userNavigatesBackToTheHomepage() throws InvalidMidiDataException {
        ReusableMethods.wait(2);
        OptionsMet.returnHome();
    }


    @And("User opens the wishlist section")
    public void userOpensTheWishlistSection() {
        card.getWishListButton().click();
    }

    @And("User verifies that the product has been added to favorites")
    public void userVerifiesThatTheProductHasBeenAddedToFavorites() {
        ReusableMethods.wait(1);
        assertTrue("element display testi başarısız",elementLocatorsOnur.getFavButtonWishlist().isDisplayed());

    }

    @Then("The user should be able to remove the product from favorites via the fav button")
    public void theUserShouldBeAbleToRemoveTheProductFromFavoritesViaTheFavButton() {
        ReusableMethods.wait(1);
        elementLocatorsOnur.getFavButtonWishlist().click();
        ReusableMethods.wait(1);
    }

    @And("User verifies that the product has been disappeared on the favorites list")
    public void userVerifiesThatTheProductHasBeenDisappearedOnTheFavoritesList() {
        card.getWishListButton().click();
        ReusableMethods.wait(3);
        assertTrue(elementLocatorsOnur.getZeroProductFoundWishlist().isDisplayed());
    }

    @And("User opens the Categories section")
    public void userOpensTheCategoriesSection() {
        elementLocatorsOnur.getCategoriesToaster().click();
    }

    @When("User clicks the filter")
    public void userClicksTheFilter() {
        ReusableMethods.wait(1);
        firstProductCount = Driver.getAppiumDriver().findElement(MobileBy.xpath("(//android.view.View/android.view.View[3])[1]")).getAttribute("contentDescription");
        elementLocatorsOnur.getFilterIconCategories().click();
    }

    @Then("the filter icons should be displayed properly")
    public void theFilterIconsShouldBeDisplayedProperly() {
        ReusableMethods.wait(1);
        OptionsMet.VerifyElementText("Sort By");
        OptionsMet.VerifyElementText("Brands");
        OptionsMet.VerifyElementText("color");
        OptionsMet.VerifyElementText("size");
    }

    @And("User sets the {string} filter option to S")
    public void userSetsTheFilterOptionTo(String type) {
        ReusableMethods.wait(2);
        OptionsMet.clickButtonByDescription(type);
        ReusableMethods.wait(2);
        Driver.getAppiumDriver().findElement(MobileBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(4)")).click();

    }

    @And("User navigates back to the product list via X button")
    public void userNavigatesBackToTheProductListViaXButton() {
        elementLocatorsOnur.getFilterXButton().click();
    }

    @And("User verifies that the filter works properly")
    public void userVerifiesThatTheFilterWorksProperly() {
        ReusableMethods.wait(2);
        lastProductCount = Driver.getAppiumDriver().findElement(MobileBy.xpath("(//android.view.View/android.view.View[3])[1]")).getAttribute("contentDescription");
        System.out.println("Filtre sonrası ürün sayıları karşılaştırılıyor: " + firstProductCount + " ve " + lastProductCount);
        assertNotEquals("Değerler aynı, filtre çalışmıyor", firstProductCount, lastProductCount);

    }

    @Then("The {string} title should be displayed")
    public void theTitleShouldBeDisplayed(String title) {
        ReusableMethods.wait(2);
        OptionsMet.assertElementText(title);
    }


    @Step("User clicks on the first order in the list")
    @And("User clicks on the first order in the list")
    public void userClicksOnTheFirstOrderInTheList() {
        ReusableMethods.wait(2);
        elementLocatorsOnur.getFirstOrderDetailsButton().click();
    }

    @Step("User scroll down the screen")
    @And("User scroll down the screen")
    public void userScrollDownTheScreen() throws InvalidMidiDataException {
        ReusableMethods.wait(1);
        OptionsMet.swipeOnur(700,2300,700,1300,0,100);
        ReusableMethods.wait(1);
    }

    @Then("User returns to previous page")
    public void userReturnsToPreviousPage() {
        ReusableMethods.wait(2);
        Driver.getAppiumDriver().navigate().back();
        ReusableMethods.wait(2);
    }

    @Given("the user click on the {string} button")
    public void theUserClickOnTheButton(String arg0) {
    }

    @And("User enters {string} and {string} and clicks on the “Sign In” button.")
    public void userEntersAndAndClicksOnTheSignInButton(String phoneNumber, String password) {
        card.Login(phoneNumber, password);
    }

    @And("User clicks the fav button of the product for adding it to the wishlist")
    public void userClicksTheFavButtonOfTheProductForAddingItToTheWishlist() {
        elementLocatorsOnur.getFavButtonSearchSmoke().click();
    }
}

