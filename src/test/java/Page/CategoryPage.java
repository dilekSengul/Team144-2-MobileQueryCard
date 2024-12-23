package Page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;

public class CategoryPage {
    public CategoryPage(){
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }



    @AndroidFindBy(xpath = "(//android.widget.ImageView[1])[1]")
    private WebElement queryCardLogoElementi;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Sign In\").instance(1)")
    private WebElement signInLoginButtonu;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Category\")")
    private WebElement categoriesButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men\")")
    private WebElement categoriesMenButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Women\")")
    private WebElement categoriesWomenButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Juniors\")")
    private WebElement CategoriesJuniorsButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(2)")
    private WebElement menFiltrelemeButton;

    @AndroidFindBy (uiAutomator = "new UiSelector().description(\"Sort By\")")
    private WebElement filrelemeSortBy;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Newest\")")
    private WebElement sortByNewestButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Price Low To High\")")
    private WebElement sortByPriceLowToHigh;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Price High To Low\")")
    private WebElement sortByPriceHighToLow;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Top Rated\")")
    private WebElement sortByTopRated;


    public void category(){
        ReusableMethods.wait(3);
        assertTrue(categoriesButton.isDisplayed());
        categoriesButton.click();

        ReusableMethods.wait(3);
        assertTrue(categoriesMenButton.isDisplayed());
        categoriesMenButton.click();


    }

    public void filterButton(){
        assertTrue(menFiltrelemeButton.isDisplayed());
        menFiltrelemeButton.click();
        assertTrue(filrelemeSortBy.isDisplayed());
        filrelemeSortBy.click();
        sortByNewestButton.click();

    }

}
