package Page;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
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
        this.driver = Driver.getAppiumDriver();
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
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Success Register Successfully.']")
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

        // Content-description değerini doğrulama
        String actualText = successMessage.getAttribute("content-desc");
        Assert.assertEquals("Success Register Successfully.", actualText);
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

    public void xPathElementClickTable(List<List<String>> productData) {
        for (int i = 1; i < productData.size(); i++) {
            // Veriyi tablo satırından al
            String itemName = productData.get(i).get(0);
            String reviews = productData.get(i).get(1);
            String price = productData.get(i).get(2);

            // XPath ifadesini formatla
            String xpathExpression = String.format(
                    "//android.view.View[contains(@content-desc, '%s') and contains(@content-desc, '%s') and contains(@content-desc, '%s')]/android.widget.ImageView",
                    itemName, reviews, price
            );

            try {
                // XPath'e uygun öğeyi bul ve tıkla
                WebElement element = getAppiumDriver().findElement(MobileBy.xpath(xpathExpression));
                element.click();
                System.out.println("Tıklandı: " + itemName + " - " + reviews + " - " + price);
            } catch (Exception e) {
                System.out.println("Hata oluştu: " + itemName + " için element bulunamadı.");
            }
        }
    }

    public void verifyWishlistItems(List<List<String>> productData) {
        // Wishlist öğelerini al
        List<WebElement> wishlistItems = driver.findElements(By.xpath("//android.view.View[contains(@content-desc, '0 Reviews')]"));

        // Öğe sayısını doğrula
        Assert.assertEquals("Ürün sayısı uyuşmuyor!", productData.size() - 1, wishlistItems.size());

        for (int i = 0; i < wishlistItems.size(); i++) {
            // Wishlist öğesinin açıklamasını al
            String itemDescription = wishlistItems.get(i).getAttribute("content-desc");

            // Beklenen verileri alın
            String expectedName = productData.get(i + 1).get(0);  // İlk satır başlık olduğu için +1
            String expectedReviews = productData.get(i + 1).get(1);
            String expectedPrice = productData.get(i + 1).get(2);

            // Ürün bilgilerini doğrula
            Assert.assertTrue("Beklenen ürün adı bulunamadı!", itemDescription.contains(expectedName));
            Assert.assertTrue("Beklenen yorum bilgisi bulunamadı!", itemDescription.contains(expectedReviews));
            Assert.assertTrue("Beklenen fiyat bulunamadı!", itemDescription.contains(expectedPrice));
        }

        System.out.println("Wishlist ürünleri başarıyla doğrulandı.");
    }

    public void xPathElementClickDynamic(String itemName, String reviews, String price) {/*
        String xpathExpression = String.format(
                "//android.view.View[contains(@content-desc, '%s') and contains(@content-desc, '%s') and contains(@content-desc, '%s')]/android.widget.ImageView",
                itemName, reviews, price
        );*/
        String xpathExpression = String.format("//android.view.View[contains(@content-desc, '%s') and contains(@content-desc, '%s') and contains(@content-desc, '%s')]/android.widget.ImageView", itemName, reviews, price);

        // Öğeyi bulma


        try {
            WebElement element = getAppiumDriver().findElement(MobileBy.xpath(xpathExpression));
            element.click();
            System.out.println("Tıklandı: " + itemName + " - " + reviews + " - " + price);
        } catch (Exception e) {
            System.out.println("Hata oluştu: " + itemName + " için element bulunamadı.");
        }
    }



}







