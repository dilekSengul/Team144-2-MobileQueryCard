package Page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.OptionsMet;
import utilities.ReusableMethods;

import javax.sound.midi.InvalidMidiDataException;
import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;

@Getter
public class ShoppingBasketPage {

    private static final Logger logger = LogManager.getLogger(Page.ShoppingBasketPage.class);

    public ShoppingBasketPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(20));

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(18)")
    private WebElement ShoppingBasketButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Shopping Cart\")")
    private WebElement ShoppingCartMenuText;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
    private WebElement EmptyBox;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Go to Shopping\")")
    private WebElement GoToShopping;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Flower Print Foil T-shirt\n" +
            "0 (0  Reviews)\n" +
            "$65.00\")")
    private WebElement FlowerPrintFoilTshirt;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"S\")")
    private WebElement SSize;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"M\")")
    private WebElement MSize;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"L\")")
    private WebElement LSize;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Add To Cart\")")
    private WebElement AddToCart;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Remove\")")
    private WebElement RemoveButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Flower Print Foil T-shirt L $65.00 1\")")
    private WebElement ProductPrice;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"$65.00\")")
    private WebElement Subtotal;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Proceed to Checkout\")")
    private WebElement ProceedToCheckout;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Shipping Address\")")
    private WebElement ShippingAddress;



    public void ShoppingBasketAccesbility() {
        wait.until(ExpectedConditions.visibilityOf(ShoppingBasketButton));

        if (ShoppingBasketButton.isDisplayed() && ShoppingBasketButton.isEnabled()) {
            System.out.println("Sepet butonu görünür ve aktif");
        } else {
            System.out.println("Sepet butonu görünür ve aktif değil!");
        }
    }

    public void ShoppingCartMenuAccesbility() {
        wait.until(ExpectedConditions.visibilityOf(ShoppingCartMenuText));

        if (ShoppingCartMenuText.isDisplayed() && ShoppingCartMenuText.isEnabled()) {
            logger.info("Sepet butonu görünür ve aktif");
        } else {
            logger.info("Sepet butonu görünür ve aktif değil!");
        }
    }

    public void EmptyShoppingBasket() {

        ReusableMethods.wait(5);

        try {

            assertTrue(EmptyBox.isDisplayed());
            assertTrue(EmptyBox.isEnabled());
            logger.info("Sepette ürün ekli değil, Sepet BOŞ");

            assertTrue(GoToShopping.isDisplayed());
            assertTrue(GoToShopping.isEnabled());
            logger.info("Alışverişe devam et butonu görünür ve aktif");

        } catch (Exception e) {

            logger.error("Sepette ürün var!");
            logger.error("Alışverişe devam et butonu görünür ve aktif DEĞİL!");

        }

    }

    public void FirstProductClick() {
        wait.until(ExpectedConditions.visibilityOf(FlowerPrintFoilTshirt));
        FlowerPrintFoilTshirt.click();
        logger.info("Kullanıcı Anasayfadaki ilk ürüne tıklar");
    }

    public void SizeChoice(String size) {
        switch (size) {
            case "L":
                wait.until(ExpectedConditions.visibilityOf(LSize));
                LSize.click();
                logger.info("Beden olarak " + size + " seçildi");
                break;
            case "S":
                wait.until(ExpectedConditions.visibilityOf(SSize));
                SSize.click();
                logger.info("Beden olarak " + size + " seçildi");
                break;
            case "M":
                wait.until(ExpectedConditions.visibilityOf(MSize));
                MSize.click();
                logger.info("Beden olarak " + size + " seçildi");
                break;
            default:
                logger.error("Beden BULUNMAMAKTADIR!");
        }
    }

    public void ScroolAndAddtocartClick() throws InvalidMidiDataException {
        try {
            OptionsMet.swipe(651, 2394, 641, 1098);
            logger.info("Kullanıcı sepete ürün eklemesi için kaydırma işlemini yapar");
            wait.until(ExpectedConditions.visibilityOf(AddToCart));
            AddToCart.click();
            logger.info("Kullanıcı Add To Cart butonuna basar");
        } catch (InvalidMidiDataException e) {
            logger.error("Add To Cart butonu görünür değil!");
        }
        logger.info("Kullanıcı Sepet butonuna basar");
    }

    public void RemoveClick(){
        try {
            wait.until(ExpectedConditions.visibilityOf(RemoveButton));
            RemoveButton.click();
            logger.info("Kullanıcı Remove butonuna basar");
        } catch (Exception e) {
            logger.error("Remove butonu görünür değil");
        }
    }

    public void SubtotalVerification(){
        try {
            assertTrue(Subtotal.isDisplayed());
            logger.info("Subtotal değeri görünür");
        } catch (Exception e) {
            logger.error("Subtotak değeri görünür değil!");
        }
    }

    public void ProceedVerification(){
        try {
            assertTrue(ProceedToCheckout.isDisplayed());
            assertTrue(ProceedToCheckout.isEnabled());
            logger.info("Proceed to Checkout butonu görünür ve aktif");
        } catch (Exception e) {
            logger.error("Proceed to Checkout butonu görünür ve aktif değil!");
        }
    }

    public void ShippingAddressVerification(){
        try {
            assertTrue(ShippingAddress.isDisplayed());
            assertTrue(ShippingAddress.isEnabled());
            logger.info("ShippingAddress butonu görünür ve aktif");
        } catch (Exception e) {
            logger.error("ShippingAddress butonu görünür ve aktif değil!");
        }
    }

}
