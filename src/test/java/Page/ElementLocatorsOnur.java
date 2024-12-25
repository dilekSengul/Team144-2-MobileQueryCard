package Page;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import static utilities.Driver.getAppiumDriver;

@Getter
public class ElementLocatorsOnur {

    public ElementLocatorsOnur() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);

    }
    //product
    //First product of a list
    @AndroidFindBy(xpath = "//android.view.View[4]/android.view.View/android.view.View[1]")
    private WebElement firstProduct;

    //product feature like colur, size etc...
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[8]/android.view.View/android.view.View")
    private WebElement productFeatureButton;

    //Add to Cart button of the product
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Add To Cart\"]")
    private WebElement addToCartButton;

    //Favorite button of the product
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Favorite\"]")
    private WebElement favoriteButton;

    //Wishlist page
    //Favorite button of the first element in wishlist
    @AndroidFindBy(xpath = "(//android.view.View[1]/android.widget.ImageView[1])[2]")
    private WebElement favButtonWishlist;
    //0 product found text on wishlist page
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"(0  Products Found)\"]")
    private WebElement zeroProductFoundWishlist;

    //Categories page
    //Categories toaster button
    @AndroidFindBy (xpath = "//android.widget.ImageView[@content-desc=\"Category\"]")
    private WebElement categoriesToaster;
    //Filter icon
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(2)")
    private WebElement filterIconCategories;
    //Filter page X button
    @AndroidFindBy (uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
    private WebElement filterXButton;



    // SIGN UP PAGE
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Sign Up\").instance(1)")
    private WebElement signUpButtonSignUpPage;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private WebElement nameFieldSignUpPage;
    @AndroidFindBy(xpath = "//android.view.View[2]/android.widget.EditText[1]/android.view.View")
    private WebElement nameErrorSignUpPage;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement phoneFieldSignUpPage;
    @AndroidFindBy(xpath = "//android.view.View[2]/android.widget.EditText[2]/android.view.View")
    private WebElement phoneErrorSignUpPage;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(2)")
    private WebElement passwordFieldSignUpPage;
    @AndroidFindBy(xpath = "//android.view.View[2]/android.widget.EditText[3]/android.view.View")
    private WebElement passwordErrorSignUpPage;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[2]/android.view.View")
    private WebElement popupSignUpPage;
    //OrderHistory
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View/android.view.View/android.widget.ImageView[1]")
    private WebElement firstOrderDetailsButton;

    public void firstOrderDetailsButton(){

    };






}
