package stepdefinitions;

import Page.CategoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefDamla {

    CategoryPage categoryPage=new CategoryPage();



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


}
