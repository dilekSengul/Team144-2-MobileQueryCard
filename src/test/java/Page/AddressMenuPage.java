package Page;



import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utilities.Driver.getAppiumDriver;
@Getter
public class AddressMenuPage {
    public AddressMenuPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);

    }

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Profile\")")
    private WebElement profileButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Sign In\")")
    private WebElement signInButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"*Use Email Instead\")")
    private WebElement useEmailText;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement emailField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement passwordField;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Sign In\").instance(1)")
    private WebElement signInButton2;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Address\")")
    private WebElement addressButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Add New Address\")")
    private WebElement addNewAddressButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement fullName;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement email;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(2)")
    private WebElement phone;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Country\")")
    private WebElement country;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"State\")")
    private WebElement state;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"City\")")
    private WebElement city;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(3)")
    private WebElement zipCode;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(4)")
    private WebElement streetAddress;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Add Address\")")
    private WebElement addAddress;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(1)")
    private WebElement editButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(2)")
    private WebElement deleteButton;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Nero')]")
    private WebElement addressCard;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Update Address\").instance(1)")
    private WebElement updateAddress;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Delete\")")
    private WebElement deleteButtonDeletePage;
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Dismiss\"]")
    private WebElement tickButton;
    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Nero') or " +
            "contains(@content-desc, 'Serr S') or " +
            "contains(@content-desc, 'Serpil S')]")
    private List<WebElement> addressCards;


    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement fullNameField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement emailFieldAdd;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"+1201\")")
    private WebElement phoneField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(2)")
    private WebElement phoneTextField;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"+93\")")
    private WebElement phoneNumber;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Country\")")
    private WebElement countryField;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"State\")")
    private WebElement stateField;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"City\")")
    private WebElement cityField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(3)")
    private WebElement zipCodeField;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(4)")
    private WebElement streetAddressField;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Algeria\")")
    private WebElement algeria;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Algiers Province\")")
    private WebElement algiersProvince;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Rouiba\")")
    private WebElement rouiba;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Add Address\")")
    private WebElement addAdressLast;






}
