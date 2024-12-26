package Page;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.pt.E;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.OptionsMet;
import utilities.ReusableMethods;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

import static utilities.Driver.getAppiumDriver;

@Getter
public class QueryCardPage {
    private final AppiumDriver driver;

    public QueryCardPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
        this.driver = getAppiumDriver();
    }

    @AndroidFindBy(xpath = "(//android.widget.ImageView[1])[1]")
    private WebElement queryCardLogoElement;
    @AndroidFindBy(xpath = "(//android.widget.ImageView[1])[2]")
    private WebElement searchBoxElement;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Sign In\").instance(1)")
    private WebElement signInLoginButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement phoneTextBox;
    @AndroidFindBy(accessibility = "See All")
    private WebElement seeAllIconElement;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement passwordTextBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(2)")
    private WebElement rememberMeCheckBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(4)")
    private WebElement addWishListToast;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[3]/android.view.View")
    private List<WebElement> categories;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\")")
    private WebElement forgotPssPhoneBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement newPasswordBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement confirmPasswordBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(1)")
    private WebElement aramaButonu;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\")")
    private WebElement searchTextBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(9)")
    private WebElement plusButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men's Analog Watch | 100 Meter Water Resistance | LED Light | Date Display | Leather/Cloth Band\n" +
            "0 (0  Reviews)\n" +
            "$119.00\")")
    private WebElement watchButton;


    public void LogoGorunurTest() {

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(queryCardLogoElement.isDisplayed());
        queryCardLogoElement.click();
    }

    public void Login(String phoneNumber, String password) {
        Actions actions = new Actions(getAppiumDriver());
        phoneTextBoxClickAndSendKeys(ConfigReader.getProperty(phoneNumber));
        // Telefon numarası alanından sonra Tab ile şifre alanına geç
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(ConfigReader.getProperty(password)).perform();
        ReusableMethods.wait(1);
        // Şifre alanından sonra Tab ile "remember me" checkbox'ına geç
        actions.sendKeys(Keys.TAB).perform();
        ReusableMethods.wait(1);
        signInLoginClick();
    }


    public void SearchBoxGorunurlukClickTest() {
        assertTrue(searchBoxElement.isDisplayed());
        searchBoxElement.click();
    }

    public void phoneTextBoxClickAndSendKeys(String phoneNumber) {
        assertTrue(phoneTextBox.isDisplayed());
        phoneTextBox.click();
        phoneTextBox.sendKeys(phoneNumber);
    }

    public void signInLoginClick() {
        assertTrue(signInLoginButton.isDisplayed());
        signInLoginButton.click();
    }

    public void wishListToast() {
        System.out.println(addWishListToast.getText());
        assertTrue(addWishListToast.isEnabled());
    }

    public void ForgetPasswordPhoneBox(String phoneNumber) {
        assertTrue(forgotPssPhoneBox.isDisplayed());
        assertTrue(forgotPssPhoneBox.isEnabled());
        forgotPssPhoneBox.click();
        forgotPssPhoneBox.sendKeys(phoneNumber);

    }

    public void NewPassword(String newPassword) {
        assertTrue(newPasswordBox.isDisplayed());
        assertTrue(newPasswordBox.isEnabled());
        newPasswordBox.click();
        newPasswordBox.sendKeys(newPassword);
        assertTrue(confirmPasswordBox.isDisplayed());
        assertTrue(confirmPasswordBox.isEnabled());
        confirmPasswordBox.click();
        confirmPasswordBox.sendKeys(newPassword);

    }

    public void LoginWithEmail(String registeredEmail, String registeredPassword) {
        Actions actions = new Actions(getAppiumDriver());
        phoneTextBoxClickAndSendKeys(ConfigReader.getProperty(registeredEmail));
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(ConfigReader.getProperty(registeredPassword)).perform();
        ReusableMethods.wait(1);
        actions.sendKeys(Keys.TAB).perform();
        signInLoginClick();
    }

    //**WishList**
    @AndroidFindBy(accessibility = "Wishlist")
    private WebElement wishListButton;
    // @AndroidFindBy(xpath = "(//android.widget.ImageView[@index='0'])[6]")
    // private WebElement mensAnalogWatch100MeterWater;
    @AndroidFindBy(xpath = "(//android.widget.ImageView[@index='0'])[6]")
    private WebElement theNorthfaceArcticParka;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Sign in to continue shopping\"]")
    private WebElement signInPageVerificationText;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Sign Up\"]")
    private WebElement signUpSıgnIn;
   // @AndroidFindBy(xpath = "//android.view.View[@content-desc='Success Register Successfully.']")
   // private WebElement successMessage;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(4)")
    private WebElement successMessage;
    @AndroidFindBy(xpath = "(//*[@class='android.view.View'])[5]")
    private WebElement addedToWishlistNatification;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    private WebElement signUpNameBox;
    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    private WebElement signUpPhoneBox;
    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    private WebElement signUpPasswordBox;
    @AndroidFindBy(xpath = "(//*[@content-desc='Sign Up'])[2]")
    private WebElement signUpButton;
    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    private WebElement signInPhoneBox;
    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    private WebElement signInPasswordBox;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Most Popular\")")
    private WebElement mostPopular;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Reviews')]")
    public List<WebElement> productList;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(4)")
    private WebElement removedToaster;


    public void registerNewUser(String name, String phone, String password) {
        signUpNameBox.click();
        signUpNameBox.sendKeys(name);
        signUpPhoneBox.click();
        signUpPhoneBox.sendKeys(phone);
        signUpPasswordBox.click();
        signUpPasswordBox.sendKeys(password);
        signUpButton.click();
    }

    public void LoginWithPhone(String phone, String Password) {
        signInPhoneBox.click();
        signInPhoneBox.sendKeys(phone);
        signInPasswordBox.click();
        signInPasswordBox.sendKeys(Password);
        signInLoginClick();
    }

    public void verifySuccessNotificationText() {
        // Success message doğrulama

        System.out.println(successMessage.getText());
        assertTrue(successMessage.isEnabled());
    }

    public void swipeMethotWithDuration(int startX, int startY, int endX, int endY, int duration, int swipeCount) {
        // 'Most Popular' bölümünün görünür olduğunu kontrol et
        if (mostPopular.isDisplayed()) {
            // Ekran kaydırma işlemi yaparak ürünleri kaydır
            for (int i = 0; i < swipeCount; i++) {
                // Ekranı kaydırmak için parametre olarak alınan koordinatları kullan
                swipe(startX, startY, endX, endY, duration);
            }
        } else {
            System.out.println("'Most Popular' section is not visible");
        }
    }

    private void swipe(int startX, int startY, int endX, int endY, int duration) {
        // Swipe işlemini gerçekleştiren yardımcı method
        MostPopularProductsPage.swipe(startX, startY, endX, endY, duration);

    }

    public void verifyWishlistButtonAfterScroll() {
        // XPath or locator for the wishlist button
        By wishlistButtonLocator = By.xpath("//android.widget.ImageView[@content-desc=\"Wishlist\"]");
        // Wait for the wishlist button to be visible before scrolling
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement wishlistButtonBefore = wait.until(ExpectedConditions.visibilityOfElementLocated(wishlistButtonLocator));

        if (wishlistButtonBefore.isDisplayed()) {
            System.out.println("Wishlist button is visible before scrolling.");
        } else {
            System.out.println("Wishlist button is NOT visible before scrolling.");
        }

        // Perform swipe action (scrolling) using PointerInput
        int startX = 364;
        int startY = 1946;
        int endX = 360;
        int endY = 311;
        int duration = 200;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(duration), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));

        // Wait for the wishlist button to be visible after scrolling
        WebElement wishlistButtonAfter = wait.until(ExpectedConditions.visibilityOfElementLocated(wishlistButtonLocator));

        if (wishlistButtonAfter.isDisplayed()) {
            System.out.println("Wishlist button is visible after scrolling.");
        } else {
            System.out.println("Wishlist button is NOT visible after scrolling.");
        }
    }

    public void xPathElementClicknormalizeSpace(String itemName, String reviews, String price) {
        String xpathExpression = String.format(
                "//android.view.View[contains(normalize-space(@content-desc), '%s') and contains(normalize-space(@content-desc), '%s') and contains(normalize-space(@content-desc), '%s')]/android.widget.ImageView",
                itemName, reviews, price
        );

        WebElement element = getAppiumDriver().findElement(MobileBy.xpath(xpathExpression));

        assertTrue(element.isDisplayed()); // Öğenin görünür olduğundan emin olun
        element.click();
    }


    public void verifyWishlistProducts(String listName) {
        if (productList.isEmpty()) {
            System.out.println("The wishlist '" + listName + "' is empty.");
        } else {
            System.out.println("Verifying products under the wishlist: '" + listName + "'");
            for (WebElement product : productList) {
                String productText = product.getAttribute("content-desc");
                String[] productDetails = productText.split("\n");
                String productName = productDetails[0];

                if (productName != null && !productName.isEmpty()) {
                    System.out.println("Verified product: " + productName);
                } else {
                    System.out.println("Product name could not be retrieved.");
                }
            }
        }
    }

    /// Gulnar editProfile
    @AndroidFindBy(xpath = "//*[@content-desc='Profile']\n")
    private WebElement Profile;
    @AndroidFindBy(xpath = "//*[@content-desc='Sign In']")
    private WebElement signİn;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"*Use Email Instead\")\n")
    private WebElement emailInstead;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)\n")
    private WebElement emailenter;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)\n")
    private WebElement passwordenter;
    @AndroidFindBy(xpath = "//*[@content-desc='Edit Profile']")
    private WebElement Editprofil;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement FullnameEdit;
    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'][2])")
    private WebElement EmailEdit;
    @AndroidFindBy(xpath = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement PhoneEdit;
    @AndroidFindBy(xpath = "(//*[@class='android.view.View'])[11]")
    private WebElement SaveChanges;
    @AndroidFindBy(xpath = "//*[@content-desc='Logout']")
    private WebElement Logout;

    public void phoneTextBoxClickAndSendKeyss(String phonenumber) {
        assertTrue(phoneTextBox.isDisplayed());
        phoneTextBox.click();
        phoneTextBox.sendKeys(phonenumber);


    }
    public void hesabimKutuTemizleme() {
        FullnameEdit.clear();
        EmailEdit.clear();
    }
    public void hesabimYeniBilgiDogrulama(String fullname, String Email) {
        //hesabimKutuTemizleme();


        ReusableMethods.wait(1);

        FullnameEdit.click();
        FullnameEdit.clear();
        FullnameEdit.sendKeys(ConfigReader.getProperty(fullname));
        EmailEdit.click();
        EmailEdit.clear();
        EmailEdit.sendKeys(ConfigReader.getProperty(Email));




    }




    }





