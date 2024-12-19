package stepdefinitions;

import Page.ShoppingBasketPage;
import io.cucumber.java.en.*;

public class ShoppingBasketStep {

    ShoppingBasketPage basketPage = new ShoppingBasketPage();

    @Given("QueryCart customer shopping basket must be visible and active")
    public void query_cart_customer_shopping_basket_must_be_visible_and_active() {
        basketPage.ShoppingBasketAccesbility();
    }

    @When("QueryCart customer clicks on the shopping basket button")
    public void query_cart_customer_clicks_on_the_shopping_basket_button() {
        basketPage.getShoppingBasketButton().click();
    }

    @Then("QueryCart validates that the customer is in the Shopping Cart menu")
    public void query_cart_validates_that_the_customer_is_in_the_shopping_cart_menu() {
        basketPage.ShoppingCartMenuAccesbility();
    }

}
