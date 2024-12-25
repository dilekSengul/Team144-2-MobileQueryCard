package Page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static utilities.Driver.getAppiumDriver;

public class PaymentInfoAddress {

    public PaymentInfoAddress() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }


    // Shopping cart
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Proceed to Checkout\")")
    public WebElement SepetCheckout;

    // Shipping information page
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Delivery\")")
    public WebElement DeliveryButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Pick Up\")")
    public WebElement PickUpButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Shipping Address\")")
    public WebElement ShippingAddress;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Edit\")")
    public WebElement EditShippingAddress;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(1)")
    public WebElement AddressEditIn;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Add\")")
    public WebElement AddShippingAddress;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(3)")
    public WebElement AddressEdit2;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Add New Address\")")
    public WebElement AddNewAddress;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Save & Pay\")")
    public WebElement SavePay;

    //Summary details
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Order Summary\")")
    public WebElement OrderSummaryButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Subtotal\")")
    public WebElement Subtotal;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Tax\")")
    public WebElement Tax;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Shipping Charge\")")
    public WebElement ShippingCharge;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Discount\")")
    public WebElement Discount;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Total\")")
    public WebElement Total;
}
