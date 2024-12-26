package stepdefinitions;

import Page.CategoryPage;
import Page.ElementLocatorsOnur;
import Page.MyAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefDamla {

    CategoryPage categoryPage=new CategoryPage();
    MyAccountPage myAccountPage=new MyAccountPage();



    @Given("The “Category” icon must be visible and clickable")
    public void the_category_icon_must_be_visible_and_clickable() {
    categoryPage.category();
    }

    @When("The “Men” heading must be visible and clickable")
    public void the_men_heading_must_be_visible_and_clickable() {
    categoryPage.menCategory();
    }

    @Then("Click the filter icon on the “Men” page.")
    public void click_the_filter_icon_on_the_men_page() {

    }

    @Then("The “Sort By” filter option is displayed.")
    public void the_sort_by_filter_option_is_displayed() {
    categoryPage.filter();
    }

    @Then("The “Women” heading must be visible and clickable")
    public void the_women_heading_must_be_visible_and_clickable() {
        categoryPage.womenCategory();

    }

    @Then("Women “Sort By” filter option is displayed.")
    public void women_sort_by_filter_option_is_displayed() {
    categoryPage.womenFilter();
    }

    @Then("The “Junior” heading must be visible and clickable")
    public void the_junior_heading_must_be_visible_and_clickable() {
    categoryPage.juniorCategory();
    }


    @Then("Junior “Sort By” filter option is displayed.")
    public void junior_sort_by_filter_option_is_displayed() {
    categoryPage.juniorFilter();
    }


    //US16

    @Then("User clicks the button with itemName use email instead")
    public void user_clicks_the_button_with_item_name_use_email_instead() {
    myAccountPage.UseEmailInstead();
    }


    @Then("Click on the profile icon")
    public void click_on_the_profile_icon() {
    myAccountPage.profileIcon();
    }
    @Then("Verify that the Dashboard page has been opened")
    public void verify_that_the_dashboard_page_has_been_opened() {
    myAccountPage.dashboard();
    }

    @Then("My Account header should be visible and clickable")
    public void my_account_header_should_be_visible_and_clickable() {
    myAccountPage.myAccount();
    }
    @Then("Total orders should be visible")
    public void total_orders_should_be_visible() {
    myAccountPage.totalOrders();
    }
    @Then("Total completed should be visible")
    public void total_completed_should_be_visible() {
    myAccountPage.totalCompleted();
    }
    @Then("Total returnd should be visible")
    public void total_returnd_should_be_visible() {
    myAccountPage.totalReturnd();
    }
    @Then("Wallet Ballance should be visible")
    public void wallet_ballance_should_be_visible() {
    myAccountPage.walletBalance();
    }

    @Then("Order history is displayed")
    public void orderHistoryIsDisplayed() {
        myAccountPage.orderHistory();
    }


}
