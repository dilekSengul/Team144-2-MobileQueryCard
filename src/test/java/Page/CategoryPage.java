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
    private WebElement categoriesJuniorsButton;

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

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
    private WebElement back;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(2)")
    private WebElement womenFilterButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Sort By\")")
    private WebElement womenSortBy;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Price Low To High\")")
    private WebElement womenPriceLowToHigh;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(2)")
    private WebElement juniorFilterButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Sort By\")")
    private WebElement juniorSortBy;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Newest\")")
    private WebElement juniorNewest;




    public void category(){
        ReusableMethods.wait(3);
        assertTrue(categoriesButton.isDisplayed());
        categoriesButton.click();


    }

    public void menCategory(){
        ReusableMethods.wait(3);
        assertTrue(categoriesMenButton.isDisplayed());
        categoriesMenButton.click();
        ReusableMethods.wait(2);
        assertTrue(menFiltrelemeButton.isDisplayed());
        menFiltrelemeButton.click();

    }
    public void filter(){
        ReusableMethods.wait(2);
        assertTrue(filrelemeSortBy.isDisplayed());
        filrelemeSortBy.click();
        ReusableMethods.wait(2);
        sortByNewestButton.click();
        ReusableMethods.wait(2);
        back.click();
    }

    public void womenCategory(){
        assertTrue(categoriesWomenButton.isDisplayed());
        categoriesWomenButton.click();

    }
    public void womenFilter(){
        ReusableMethods.wait(2);
        assertTrue(womenFilterButton.isDisplayed());
        womenFilterButton.click();
        ReusableMethods.wait(1);
        womenSortBy.click();
        womenPriceLowToHigh.click();
        ReusableMethods.wait(1);
        back.click();

    }

    public void juniorCategory(){
        assertTrue(categoriesJuniorsButton.isDisplayed());
        categoriesJuniorsButton.click();
    }

    public void juniorFilter(){
        ReusableMethods.wait(2);
        assertTrue(juniorFilterButton.isDisplayed());
        juniorFilterButton.click();
        juniorSortBy.click();
        ReusableMethods.wait(2);
        juniorNewest.click();
    }

}
