package Page;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

import static utilities.Driver.getAppiumDriver;

@Getter
public class CategoriesPage {
    public CategoriesPage() {
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);

    }



    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Categories\")")
    private WebElement categoriesText;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men\")")
    private WebElement men;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men Clothing\")")
    private WebElement menClothing;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men T-Shirt\")")
    private WebElement menTshirt;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men Shorts\")")
    private WebElement menShorts;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men Coat\")")
    private WebElement menCoat;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men Suit\")")
    private WebElement menSuit;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men Shoes\")")
    private WebElement menShoes;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men Sneakers\")")
    private WebElement menSneakers;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men Classic Shoes\")")
    private WebElement menClassicShoes;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men Boots\")")
    private WebElement menBoots;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men Casual Shoes\")")
    private WebElement menCasualShoes;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men Accessories\")")
    private WebElement menAccesories;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men Bags\")")
    private WebElement menBags;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Men Socks\")")
    private WebElement menSocks;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Women\")")
    private WebElement women;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Women Clothing\")")
    private WebElement womenClothing;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Woman Dresses - Skirts\")")
    private WebElement womenDresses;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Woman T-shirt\")")
    private WebElement womenTshirt;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Woman Trousers\")")
    private WebElement womenTrousers;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Woman Coat\")")
    private WebElement womenCoat;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Women Shoes\")")
    private WebElement womenShoes;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Women Casual Shoes\")")
    private WebElement womenCasualShoes;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Women Classic Shoes\")")
    private WebElement womenClassicShoes;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Women's Boots\")")
    private WebElement womenBoots;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Women Sneakers\")")
    private WebElement womenSneakers;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Women Accessories\")")
    private WebElement womenAccessories;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Women Bags\")")
    private WebElement womenBags;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Women Watch\")")
    private WebElement womenWatch;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Women Jewelry\")")
    private WebElement womenJewelry;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Juniors\")")
    private WebElement juniors;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Juniors Clothing\")")
    private WebElement juniorsClothing;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Girl Clothes\")")
    private WebElement girlClothes;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Juniors Sleepwear\")")
    private WebElement juniorsSleepwear;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Boy Clothes\")")
    private WebElement boyClothes;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Baby Clothes\")")
    private WebElement babyClothes;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Juniors Shoes\")")
    private WebElement juniorsShoes;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Girl Shoes\")")
    private WebElement girlsShoes;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Boy Shoes\")")
    private WebElement boyShoes;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Juniors Accessories\")")
    private WebElement juniorsAccessories;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Juniors Bags\")")
    private WebElement juniorsBags;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Juniors Hat & Beres\")")
    private WebElement juniorsHats;
    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Toys\")")
    private WebElement toys;

    public List<WebElement> getAllCategories() {
        return Arrays.asList(
                // Men Categories
                men, menClothing, menTshirt, menShorts, menCoat, menSuit, menShoes,
                menSneakers, menClassicShoes, menBoots, menCasualShoes, menAccesories,
                menBags, menSocks,

                // Women Categories
                women, womenClothing, womenDresses, womenTshirt, womenTrousers, womenCoat,
                womenShoes, womenCasualShoes, womenClassicShoes, womenBoots, womenSneakers,
                womenAccessories, womenBags, womenWatch, womenJewelry,

                // Juniors Categories
                juniors, juniorsClothing, girlClothes, juniorsSleepwear, boyClothes,
                babyClothes, juniorsShoes, girlsShoes, boyShoes, juniorsAccessories,
                juniorsBags, juniorsHats,

                // Other Categories
                toys
        );
    }
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
    private WebElement backArrow;


    @AndroidFindBy(xpath = "//android.view.View[4]/android.view.View/android.view.View[1]")
    private WebElement firstProductMen;


}






