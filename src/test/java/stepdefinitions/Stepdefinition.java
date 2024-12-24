package stepdefinitions;

import Page.CategoriesPage;
import Page.QueryCardPage;
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
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;
import static utilities.Driver.quitAppiumDriver;
import static utilities.ReusableMethods.ekranKaydirmaMethodu;

public class Stepdefinition extends OptionsMet {
    QueryCardPage card = new QueryCardPage();
    CategoriesPage categoriesPage = new CategoriesPage();
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
        card.Login(phoneNumber, password);
    }

    @Given("User clicks the button with itemName {string} and {string} and {string} added WishList")
    public void user_clicks_the_button_with_item_name_and_and_added_wish_list(String itemName, String reviews, String price) {
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
    //****us11***

    @Then("User clicks the button with itemName {string}")
    public void user_clicks_the_button_with_item_name(String itemName) {
        //  clickButtonByDescription(itemName);
        ReusableMethods.wait(3);
        touchDown(874, 667);


    }

    @Then("As a user must be {string} email and {string} password Login")
    public void asAUserMustBeEmailAndPasswordLogin(String registeredEmail, String registeredPassword) {
        ReusableMethods.wait(3);
        card.LoginWithEmail(registeredEmail, registeredPassword);
    }

    @Then("User Verifies the visibility and functionality of the {string} button")
    public void userVerifiesTheVisibilityAndFunctionalityOfTheButton(String WishList) {
        ReusableMethods.wait(4);
        VerifyElementText(WishList);
       // assertTrue(card.wishListButton.isEnabled());
        //clickAndVerify(card.wishListButton);
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

    @Then("User clicks the backArrow button")
    public void userclicksthebackArrowbutton() throws InterruptedException {
        categoriesPage.getBackArrow().click();
        ReusableMethods.wait(1);
        categoriesPage.getBackArrow().click();
        assertTrue(card.getQueryCardLogoElement().isDisplayed());
        Thread.sleep(1000);
    }


}