package Page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;

@Getter
public class PaymentPage {

    private static final Logger logger = LogManager.getLogger(Page.PaymentPage.class);

    public PaymentPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(15));

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"İsmail Kaya\n" +
            "+905555555555\n" +
            "ismail.user@querycart.com\n" +
            "Akörenİlçesi,Konya,Turkey,42005\n" +
            "Ağalar, A. Tenekeci Sk. No:2, 42460 Akören/Konya\")")
    private WebElement AdressIsmail;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"confirmBtn\")")
    private WebElement confirmButonu;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Go to shopping\")")
    private WebElement GoToShopping;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement cardNumber;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement MM__YY;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(2)")
    private WebElement cvc;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(3)")
    private WebElement Zip;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"card-errors\")")
    private WebElement cartError;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Your card was declined. Your request was in test mode, but used a non test (live) card. For a list of valid test cards, visit: https://stripe.com/docs/testing.\\\")")
    private WebElement LiveCarderror;


    public void AdressClick(){
        try {
            AdressIsmail.click();
            logger.info("Kullanıcı adres seçimini yapar");
        } catch (Exception e) {
            if (! AdressIsmail.isDisplayed()){
                logger.error("Adres bulunamadı");
            }
        }
    }

    public void ConfrimClick(){
        ReusableMethods.wait(5);

        try {
            confirmButonu.click();
            logger.info("Kullanıcı adres seçimini yapar");
        } catch (Exception e) {
            if (! confirmButonu.isDisplayed()){
                logger.error("Adres bulunamadı");
            }
        }
    }

    public void StripeCardIntroduction(String cartNumber, String MM_YY, String CVC, String ZipCode){

        wait.until(ExpectedConditions.visibilityOf(confirmButonu));

        try {
            cardNumber.sendKeys(cartNumber);
            MM__YY.sendKeys(MM_YY);
            cvc.sendKeys(CVC);
            Zip.sendKeys(ZipCode);
            logger.info("Kullanıcı Card Number olarak " + cartNumber +
                        " MM/YY olarak " + MM_YY +
                        " CVC olarak " + CVC +
                        " Zip Code olarak " + ZipCode + " girer.");
        } catch (Exception e) {
            logger.error("Kart bilgileri girişi yapılamadı!");
        }

    }

    public void invalidStripeTest(String cartNumber, String MM_YY, String CVC){

        wait.until(ExpectedConditions.visibilityOf(confirmButonu));

        try {
            cardNumber.sendKeys(cartNumber);
            MM__YY.sendKeys(MM_YY);
            cvc.sendKeys(CVC);
            logger.info("Kullanıcı Card Number olarak " + cartNumber +
                        " MM/YY olarak " + MM_YY +
                        " CVC olarak " + CVC + " girer.");
        } catch (Exception e) {
            logger.error("Kart bilgileri girişi yapılamadı!");
        }

    }

    public void GoToShoppingClick(){
        try {
            ReusableMethods.wait(10);
            GoToShopping.click();
            logger.info("Kullanıcı Go to shopping butonuna basar");
        } catch (Exception e) {
            ReusableMethods.wait(10);
            GoToShopping.click();
            logger.info("Kullanıcı Go to shopping butonuna basar");
        }
    }

    public void errorMesagge(String message){
        try {
            assertEquals(cartError.getText(),message);
            logger.info("Hata mesajı beklenen ile aynı");
        } catch (Exception e) {
            logger.info("Hata mesajı beklenen ile aynı değil!");
        }
    }

    public void errorDisplay(){
        ReusableMethods.wait(5);
        try {
            assertTrue(LiveCarderror.isDisplayed());
            logger.info("Hata mesajı beklenen ile aynı");
        } catch (Exception e) {
            logger.info("Hata mesajı beklenen ile aynı değil!");
        }
    }


}
