package stepdefinitions;

import Page.MostPopularProductsPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;

public class stepDefinitionsHurrem {

    MostPopularProductsPage mostPopularProductsPage = new MostPopularProductsPage();

    @Given("the Most Popular menu title should be visible on the home page navBar")
    public void the_most_popular_menu_title_should_be_visible_on_the_home_page_nav_bar() {
        mostPopularProductsPage.verifyMostPopularIsVisible();
    }

    @And("current products should be listed under {string} by swiping {int} times")
    public void currentProductsShouldBeListedUnderBySwipingTimes(String productListName, int swipeCount) {
        mostPopularProductsPage.verifyProductsUnderMostPopularWithSwipe(productListName,mostPopularProductsPage.productList,swipeCount);

    }
    @Then("the user should return to the homepage")
    public void the_user_should_return_to_the_homepage() throws InterruptedException {
        mostPopularProductsPage.backButton.click();
        Thread.sleep(3000);
        mostPopularProductsPage.swipe(MostPopularProductsPage.SwipeDirection.SWIPE_DOWN,mostPopularProductsPage.mostPopularScroll);

    }

    @And("User clicks on the {int} th item under list")
    public void userClicksOnTheThItemUnderlist(int productIndex) throws InterruptedException {
        mostPopularProductsPage.userClicksOnAProductUnderList(productIndex-1);

    }
    //---------------US_012_ProductDetails----------------//

    @Then("the user should be redirected to the selected product page")
    public void the_user_should_be_redirected_to_the_selected_product_page() throws InterruptedException {

        Assert.assertTrue(mostPopularProductsPage.mostPopularScroll.isDisplayed());
        MostPopularProductsPage.swipe(679, 2660, 694, 638, 1000);
        Thread.sleep(3000);

    }
    @Then("the {string} title should be displayed")
    public void theTitleShouldBeDisplayed(String title) throws InterruptedException {
        MostPopularProductsPage.isDisplayed(title);
    }
}



