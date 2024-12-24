package stepdefinitions;

import Page.ShoppingBasketPage;
import io.cucumber.java.en.*;
import utilities.OptionsMet;
import utilities.ReusableMethods;

import javax.sound.midi.InvalidMidiDataException;

public class ShoppingBasketStep {

    ShoppingBasketPage basketPage = new ShoppingBasketPage();

    @Given("QueryCart customer shopping basket must be visible and active")
    public void query_cart_customer_shopping_basket_must_be_visible_and_active() {
        basketPage.ShoppingBasketAccesbility();
    }

    @When("QueryCart customer clicks on the shopping basket button")
    public void query_cart_customer_clicks_on_the_shopping_basket_button() {
        OptionsMet.touchDown(666,2636);
    }

    @Then("QueryCart validates that the customer is in the Shopping Cart menu")
    public void query_cart_validates_that_the_customer_is_in_the_shopping_cart_menu() {
        basketPage.ShoppingCartMenuAccesbility();
    }

    @When("QueryCart customer's shopping basket must be empty and Go to Shopping button must be visible and active")
    public void query_cart_customer_s_shopping_basket_must_be_empty_and_go_to_shopping_button_must_be_visible_and_active() {
        basketPage.EmptyShoppingBasket();
    }

    @Then("QueryCart customer selects the Flower Print Foil Tshirt product on the Home page")
    public void query_cart_customer_selects_the_flower_print_foil_tshirt_product_on_the_home_page() {
        basketPage.FirstProductClick();
    }

    @And("QueryCart customer selects {string} as size")
    public void querycartCustomerSelectsAsSize(String size) {
        basketPage.SizeChoice(size);
    }

    @Then("QueryCart customer presses the Add To Cart button")
    public void query_cart_customer_presses_the_add_to_cart_button() throws InvalidMidiDataException {
        basketPage.ScroolAndAddtocartClick();
    }

    @Then("QueryCart customer clicks the remove button and deletes the product in the shopping basket")
    public void query_cart_customer_clicks_the_remove_button_and_deletes_the_product_in_the_shopping_basket() {
        ReusableMethods.wait(7);
        basketPage.RemoveClick();
    }

    @And("QueryCart customer verifies that subtotal is visible")
    public void querycartCustomerVerifiesThatSubtotalIsVisible() {
        basketPage.SubtotalVerification();
    }

    @And("QueryCart customer verifies that the Prooceed to Checkout button is visible and active")
    public void querycartCustomerVerifiesThatTheProoceedToCheckoutButtonIsVisibleAndActive() {
        basketPage.ProceedVerification();
    }

    @And("QueryCart customer clicks Prooceed to Checkout button")
    public void querycartCustomerClicksProoceedToCheckoutButton() {
        basketPage.getProceedToCheckout().click();
    }

    @And("QueryCart customer should reach Shipping Information menu")
    public void querycartCustomerShouldReachShippingInformationMenu() {
        basketPage.ShippingAddressVerification();
    }
}
