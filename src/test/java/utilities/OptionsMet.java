package utilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import javax.sound.midi.InvalidMidiDataException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;
import static utilities.screenshotTester.verifyElementVisibility;

public class OptionsMet {
    //
    public static void swipe(int x, int y, int endX, int endY) throws InvalidMidiDataException {
        /******  PointerInput ve Sequence Kullanımı: PointerInput ile parmak hareketlerini
         *      ve Sequence ile bu hareketlerin sırasını tanımlıyoruz.
         addAction metodunu doğru PointerInput nesnesi üzerinde kullanarak sıraya işlemler ekliyoruz.  ***********/
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(x, y);
        Point end = new Point(endX, endY);
        /** Bu sınıflar Selenium WebDriver içinde ekran üzerinde işaretlemeler yapmak için kullanılır.**/
        Sequence swipe = new Sequence(finger, 0); // 0 or any other index

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getAppiumDriver().perform(Arrays.asList(swipe));
    }

    public static void touchDown(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point tapPoint = new Point(x, y);
        Sequence tap = new Sequence(finger, 1); //sıralama diziye alma
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),//parmak olustur
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y)); //
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(50)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getAppiumDriver().perform(Arrays.asList(tap));
    }

    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
                        + elementText + "\").instance(0))"));
    }

    // Ekrandaki bir butona tıklama metodu
    public static void clickButtonByDescription(String description) {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        WebElement button = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().description(\"" + description + "\")"));
        button.click();
    }

    public static void clickAndSendKeys(WebElement element, String context) {
        assertTrue(element.isDisplayed());
        element.click();
        element.clear();
        element.sendKeys(context);
    }

    public static void clickAndVerify(WebElement element) {
        assertTrue(element.isDisplayed());
        assertTrue(element.isEnabled());
        element.click();
    }

    public static void VerifyElementText(String description) {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        WebElement webElement = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().description(\"" + description + "\")"));
        assertTrue(webElement.isDisplayed());
    }

    public static void hideKeyboard() {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        driver.hideKeyboard(); // Klavyeyi kapatma komutu
    }

    public static void KeyBack() {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        // Geri tuşuna basın
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }

    public static void xPathElementClick(String itemName, String reviews, String price) {
        String xpathExpression = String.format("//android.view.View[contains(@content-desc, '%s') and contains(@content-desc, '%s') and contains(@content-desc, '%s')]/android.widget.ImageView", itemName, reviews, price);

        // Öğeyi bulma
        WebElement element = getAppiumDriver().findElement(MobileBy.xpath(xpathExpression));

        // Öğeyle etkileşim
        element.click();

    }

    public static void assertElementText(String expectedMessage) {
        AndroidDriver driver = (AndroidDriver) getAppiumDriver();
        WebElement webElement = driver.findElement(MobileBy.xpath("//*[contains(@content-desc, '" + expectedMessage + "')]"));
        assertTrue("the element does not contain the word \"" + expectedMessage + "\".", webElement.getAttribute("contentDescription").contains(expectedMessage));
        System.out.println("element görünür/textAssertion basarılı");
    }

    /**
     * <h2>assertElementTextAndVisibility</h2>
     * <p>Elementin görünürlüğünü text ile test eder</p>
     * <p>Eğer locate yakalanamaz ise screenshot üzerinden test eder.</p>
     * <p>Method kullanımı için örnek step:</p> <p>{@link stepdefinitions.stepDefOnur#userShouldSeeAnMessageOnPopupPage}</p>
     */

    public static void assertElementTextAndVisibility(String expectedMessage) throws Exception {
        try {
            assertElementText(expectedMessage);
        } catch (AssertionError | NoSuchElementException e) {
            System.out.println("Message:" + e.getMessage());
        }
        //Aşağıdaki kısmın normalde catch içerisinde olması lazım.
        // Şimdilik hem text hem ss ile test yaparak tutarlılığı ölçülüyor.
        double threshold = 0.8; // %80 eşleşme oranı - template ve test esnasında yakalanan ss'lerin min eşleşme yüzdesi
        verifyElementVisibility("target/Screenshots/" + expectedMessage + ".png", threshold);
    }

    public static void swipeOnur(int x, int y, int endX, int endY, int startSpeed, int endSpeed) throws InvalidMidiDataException {
        /******  PointerInput ve Sequence Kullanımı: PointerInput ile parmak hareketlerini
         *      ve Sequence ile bu hareketlerin sırasını tanımlıyoruz.
         addAction metodunu doğru PointerInput nesnesi üzerinde kullanarak sıraya işlemler ekliyoruz.  ***********/
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Point start = new Point(x, y);
        Point end = new Point(endX, endY);
        /** Bu sınıflar Selenium WebDriver içinde ekran üzerinde işaretlemeler yapmak için kullanılır.**/
        Sequence swipe = new Sequence(finger, 0); // 0 or any other index

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(startSpeed),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(endSpeed),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getAppiumDriver().perform(Arrays.asList(swipe));
    }

    public static void scrollLeftAndVerifyElements(List<String> expectedElements) throws InvalidMidiDataException {
        for (String expectedElement : expectedElements) {
            boolean isVisible = false;

            // Scroll ve elementi bulma işlemi
            for (int i = 0; i < 15; i++) { // Maksimum 15 swipe
                try {
                    WebElement element = Driver.getAppiumDriver().findElement(By.xpath("//android.view.View[@content-desc=\"" + expectedElement + "\"]"));
                    if (element.isDisplayed()) {
                        isVisible = true;
                        System.out.println("Visible: " + expectedElement);
                        break; // Öğeyi gördüysek kaydırmayı bırak
                    }
                } catch (Exception e) {
                    System.out.println("Element not found, scrolling left...");
                    OptionsMet.swipeOnur(1100, 1150, 200, 1150, 0, 1000); //bu ayarlarda anasayfa categories üzerinde tüm elementleri tarar
                }
            }

            // Eğer öğe 15 deneme sonunda hala bulunamazsa hata ver
            assertTrue("Category not visible: " + expectedElement, isVisible);
        }
    }

    public static void scrollLeftAndClickElement(String expectedElement) throws InvalidMidiDataException {


        // Scroll ve elementi bulma işlemi
        for (int i = 0; i < 15; i++) { // Maksimum 15 swipe
            try {
                WebElement element = Driver.getAppiumDriver().findElement(By.xpath("//android.view.View[@content-desc=\"" + expectedElement + "\"]"));

                if (element.isDisplayed()) {

                    System.out.println("Visible: " + expectedElement);
                    element.click();
                    break; // Öğeyi gördüysek kaydırmayı bırak
                }
            } catch (Exception e) {
                System.out.println("Element not found, scrolling left...");
                OptionsMet.swipeOnur(1100, 1150, 200, 1150, 0, 1000); //bu ayarlarda anasayfa categories üzerinde tüm elementleri tarar
            }
        }


    }

    public static void returnHome() throws InvalidMidiDataException {

        for (int i = 0; i < 15; i++) {
            try {
                WebElement element = Driver.getAppiumDriver().findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Home\"]")); //home button
                if (element.isDisplayed()) {
                    System.out.println("Successfully navigated back to the home screen.");
                    break; // logoyu gördüğü için geri dönmeyi bırakır
                }
            } catch (Exception e) {
                System.out.println("Not on home screen, pressing back button...");
                Driver.getAppiumDriver().navigate().back();
            }
        }

    }


}
