package Page;


import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.OptionsMet;
import utilities.ReusableMethods;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;

@Getter
public class QueryCardPage {
    public QueryCardPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);

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
    private   WebElement wishListButton;
    @AndroidFindBy(xpath = "(//*[@class='android.widget.ImageView'])[15]")
    private WebElement theNortFaceArcticParkaHeartIcon;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Sign in to continue shopping\"]")
    private WebElement signInPageVerificationText;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Sign Up\"]")
    private  WebElement signUpSıgnIn;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Success Register Successfully.']")
    private WebElement successMessage;
    @AndroidFindBy(xpath = "(//*[@class='android.view.View'])[5]")
    private WebElement addedToWishlistNatification;
    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    private WebElement signUpNameBox ;
    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    private WebElement signUpPhoneBox ;
    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    private  WebElement signUpPasswordBox ;
    @AndroidFindBy(xpath = "(//*[@content-desc='Sign Up'])[2]")
    private WebElement signUpButton ;
    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    private  WebElement signInPhoneBox;
    @AndroidFindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    private  WebElement signInPasswordBox;


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






}







