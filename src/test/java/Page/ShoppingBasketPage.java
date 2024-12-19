package Page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.Driver.getAppiumDriver;

public class ShoppingBasketPage {

    public ShoppingBasketPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }

    WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(20));

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(18)")
    private WebElement ShoppingBasketButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Shopping Cart\")")
    private WebElement ShoppingCartMenuText;

    public void ShoppingBasketAccesbility(){
        wait.until(ExpectedConditions.visibilityOf(ShoppingBasketButton));

        if (ShoppingBasketButton.isDisplayed() && ShoppingBasketButton.isEnabled()){
            System.out.println("Sepet butonu görünür ve aktif");
        }else {
            System.out.println("Sepet butonu görünür ve aktif değil!");
        }
    }

    public void ShoppingCartMenuAccesbility(){
        wait.until(ExpectedConditions.visibilityOf(ShoppingCartMenuText));

        if (ShoppingCartMenuText.isDisplayed() && ShoppingCartMenuText.isEnabled()){
            System.out.println("Sepet butonu görünür ve aktif");
        }else {
            System.out.println("Sepet butonu görünür ve aktif değil!");
        }
    }

    public WebElement getShoppingBasketButton() {
        return ShoppingBasketButton;
    }

}
