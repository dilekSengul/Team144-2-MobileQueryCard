package Page;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;

public class MostPopularProductsPage {

    public MostPopularProductsPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Most Popular\")")
    private WebElement mostPopular;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
    public WebElement backButton;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Reviews')]")
    public List<WebElement> productList;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ScrollView\")")
    public WebElement mostPopularScroll;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ScrollView\")")
    public WebElement detailsButton;


    public void verifyMostPopularIsVisible() {
        ReusableMethods.wait(3);
        Assert.assertTrue("The Most Popular menu title is not visible on the home page navBar.", mostPopular.isDisplayed());
    }

    public void verifyProductsUnderMostPopularWithSwipe(String listName,List<WebElement> productList,int swipeCount ) {
        // 'Most Popular' bölümünün görünür olduğunu kontrol et
        if (mostPopular.isDisplayed()) {
            // İlk başta mevcut ürünleri al
            getProductNames(listName,productList);

            // Ekran kaydırma işlemi yaparak yeni ürünleri al
            for (int i = 0; i < swipeCount; i++) {
                // Ekranı kaydırmak için reusable methodu çağır
                MostPopularProductsPage.swipe(654, 2430, 648, 434, 1000); // Koordinatlar ayarlanabilir
                getProductNames(listName,productList); // Yeni ürünleri al
            }
        } else {
            System.out.println("'Most Popular' section is not visible");
        }
    }

    // Ürün adlarını alıp yazdıran metod
    private void getProductNames(String listName,List<WebElement> productList) {
        for (WebElement product : productList) {
            // Ürün metnini al (content-desc özelliği ile)
            String productText = product.getAttribute("content-desc");

            // Satırlara ayır
            String[] productDetails = productText.split("\n");

            // İlk satırı (ürün adını) al
            String productName = productDetails[0];

            System.out.println("Product found under '"+listName+"': " + productName);
        }
    }

    public void userClicksOnAProductUnderList(int productIndex) throws InterruptedException {
        // 'See All' altındaki ürünlerin bulunduğu listeyi al
        if (productList.size() > 0) {
            // İlk ürüne tıklama
            WebElement firstProduct = productList.get(productIndex); // 0, ilk ürünü ifade eder
            firstProduct.click();
            Thread.sleep(3000);
        } else {
            System.out.println("No products found ");
        }
    }

    public static void isDisplayed(String description) throws InterruptedException {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        WebElement webElement = driver.findElement(MobileBy.AndroidUIAutomator(
            "new UiSelector().description(\"" + description + "\")"));
        assertTrue(webElement.isDisplayed());
        Thread.sleep(3000);
    }

    public static void swipe(int startX, int startY, int endX, int endY, int wait) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);

        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0),
            PointerInput.Origin.viewport(), startX, startY));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(wait),
            PointerInput.Origin.viewport(), endX, endY));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getAppiumDriver().perform(Arrays.asList(dragNDrop));
    }

    public void swipe(MostPopularProductsPage.SwipeDirection direction, WebElement ele) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        int startX, startY, endX, endY;
        switch (direction) {
            case SWIPE_RIGHT:
                startX = ele.getRect().x + (ele.getSize().width / 4);
                startY = ele.getRect().y + (ele.getSize().height / 2);
                endX = ele.getRect().x + (ele.getSize().width * 3 / 4);
                endY = ele.getRect().y + (ele.getSize().height / 2);
                break;
            case SWIPE_LEFT:
                startX = ele.getRect().x + (ele.getSize().width * 3 / 4);
                startY = ele.getRect().y + (ele.getSize().height / 2);
                endX = ele.getRect().x + (ele.getSize().width / 4);
                endY = ele.getRect().y + (ele.getSize().height / 2);
                break;
            case SWIPE_DOWN:
                startX = ele.getRect().x + (ele.getSize().width / 2);
                startY = ele.getRect().y + (ele.getSize().height / 4);
                endX = ele.getRect().x + (ele.getSize().width / 2);
                endY = ele.getRect().y + (ele.getSize().height * 3 / 4);
                break;
            case SWIPE_UP:
                startX = ele.getRect().x + (ele.getSize().width / 2);
                startY = ele.getRect().y + (ele.getSize().height * 3 / 4);
                endX = ele.getRect().x + (ele.getSize().width / 2);
                endY = ele.getRect().y + (ele.getSize().height / 4);
                break;
            default:
                throw new IllegalArgumentException("Invalid swipe direction: " + direction);
        }
        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0),
            PointerInput.Origin.viewport(), startX, startY));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
            PointerInput.Origin.viewport(), endX, endY));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getAppiumDriver().perform(Arrays.asList(dragNDrop));
    }

    public enum SwipeDirection {
        SWIPE_RIGHT,
        SWIPE_LEFT,
        SWIPE_DOWN,
        SWIPE_UP
    }

}
