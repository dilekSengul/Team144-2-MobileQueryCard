package stepdefinitions;

import Page.ShoppingBasketPage;
import io.cucumber.java.en.*;
import io.qameta.allure.Step;
import utilities.OptionsMet;
import utilities.ReusableMethods;

import javax.sound.midi.InvalidMidiDataException;

public class ShoppingBasketStep {

    ShoppingBasketPage basketPage = new ShoppingBasketPage();

    @Step("QueryCart customer shopping basket must be visible and active")
    @Given("QueryCart customer shopping basket must be visible and active")
    public void query_cart_customer_shopping_basket_must_be_visible_and_active() {
        basketPage.ShoppingBasketAccesbility();
    }

    @Step("QueryCart customer clicks on the shopping basket button")
    @When("QueryCart customer clicks on the shopping basket button")
    public void query_cart_customer_clicks_on_the_shopping_basket_button() {
        OptionsMet.touchDown(666,2636);
    }

    @Step("QueryCart validates that the customer is in the Shopping Cart menu")
    @Then("QueryCart validates that the customer is in the Shopping Cart menu")
    public void query_cart_validates_that_the_customer_is_in_the_shopping_cart_menu() {
        basketPage.ShoppingCartMenuAccesbility();
    }

    @Step("QueryCart customer's shopping basket must be empty and Go to Shopping button must be visible and active")
    @When("QueryCart customer's shopping basket must be empty and Go to Shopping button must be visible and active")
    public void query_cart_customer_s_shopping_basket_must_be_empty_and_go_to_shopping_button_must_be_visible_and_active() {
        basketPage.EmptyShoppingBasket();
    }

    @Step("QueryCart customer selects the Flower Print Foil Tshirt product on the Home page")
    @Then("QueryCart customer selects the Flower Print Foil Tshirt product on the Home page")
    public void query_cart_customer_selects_the_flower_print_foil_tshirt_product_on_the_home_page() {
        basketPage.FirstProductClick();
    }

    @Step("QueryCart customer selects L as size")
    @And("QueryCart customer selects {string} as size")
    public void querycartCustomerSelectsAsSize(String size) {
        basketPage.SizeChoice(size);
    }

    @Step("QueryCart customer presses the Add To Cart button")
    @Then("QueryCart customer presses the Add To Cart button")
    public void query_cart_customer_presses_the_add_to_cart_button() throws InvalidMidiDataException {
        basketPage.ScroolAndAddtocartClick();
    }

    @Step("QueryCart customer clicks the remove button and deletes the product in the shopping basket")
    @Then("QueryCart customer clicks the remove button and deletes the product in the shopping basket")
    public void query_cart_customer_clicks_the_remove_button_and_deletes_the_product_in_the_shopping_basket() {
        ReusableMethods.wait(7);
        basketPage.RemoveClick();
    }

    @Step("QueryCart customer verifies that subtotal is visible")
    @And("QueryCart customer verifies that subtotal is visible")
    public void querycartCustomerVerifiesThatSubtotalIsVisible() {
        basketPage.SubtotalVerification();
    }

    @And("QueryCart customer verifies that the Prooceed to Checkout button is visible and active")
    public void querycartCustomerVerifiesThatTheProoceedToCheckoutButtonIsVisibleAndActive() {
        basketPage.ProceedVerification();
    }

    @Step("QueryCart customer clicks Prooceed to Checkout button")
    @And("QueryCart customer clicks Prooceed to Checkout button")
    public void querycartCustomerClicksProoceedToCheckoutButton() {
        basketPage.getProceedToCheckout().click();
    }

    @Step("QueryCart customer should reach Shipping Information menu")
    @And("QueryCart customer should reach Shipping Information menu")
    public void querycartCustomerShouldReachShippingInformationMenu() {
        basketPage.ShippingAddressVerification();
    }
}
