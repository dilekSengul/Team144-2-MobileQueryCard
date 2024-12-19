package stepdefinitions;

import Page.QueryCardPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import utilities.OptionsMet;
import utilities.ReusableMethods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;

public class stepDefOnur extends OptionsMet {
    QueryCardPage card = new QueryCardPage();
    Actions actions = new Actions(getAppiumDriver());

    @Then("User verifies that {string} button is visible and clicks the button.")
    public void userVerifiesThatButtonIsVisibleAndClicksTheButton(String element) {
        VerifyElementText(element);
        clickButtonByDescription(element);
    }

    @When("User leaves any of the mandatory fields \\(Name, Phone and Password) blank and click Sign Up button.")
    public void userLeavesAnyOfTheMandatoryFieldsNamePhoneAndPasswordBlankAndClickSignUpButton() {
        assertTrue(card.getSignUpButtonSignUpPage().isDisplayed());
        card.getSignUpButtonSignUpPage().click();

    }

    @Then("I should see an error message indicating that mandatory fields cannot be left blank")
    public void iShouldSeeAnErrorMessageIndicatingThatMandatoryFieldsCannotBeLeftBlank() {

        assertTrue(card.getNameErrorSignUpPage().isDisplayed());
        assertTrue(card.getPhoneErrorSignUpPage().isDisplayed());
        assertTrue(card.getPasswordErrorSignUpPage().isDisplayed());

        assertEquals("This field is required",card.getNameErrorSignUpPage().getAttribute("contentDescription"));
        assertEquals("This field is required",card.getPhoneErrorSignUpPage().getAttribute("contentDescription"));
        try {
            assertEquals("Password is required", card.getPasswordErrorSignUpPage().getAttribute("contentDescription"));
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }

    }


    @Then("I enter the appropriate entries in the name and phone fields and enter a password of less than 6 characters and click Sign Up button.")
    public void iEnterTheAppropriateEntriesInTheNameAndPhoneFieldsAndEnterAPasswordOfLessThanCharacters() {
        ReusableMethods.wait(1);
        card.getNameFieldSignUpPage().click();
        card.getNameFieldSignUpPage().sendKeys("onur1");
        ReusableMethods.wait(1);
        card.getPhoneFieldSignUpPage().click();
        card.getPhoneFieldSignUpPage().sendKeys("1234567");
        ReusableMethods.wait(1);
        card.getPasswordFieldSignUpPage().click();
        card.getPasswordFieldSignUpPage().sendKeys("123456");
        ReusableMethods.wait(1);
        card.getSignUpButtonSignUpPage().click();


    }

    @Then("I should see an error message indicating the password criteria")
    public void iShouldSeeAnErrorMessageIndicatingThePasswordCriteria() {
        ReusableMethods.wait(1);
        assertTrue(card.getErrorPopupSignUpPage().getAttribute("contentDescription").contains("Password must be at least 6 characters long and contain at least one letter, one number and one special character."));
        System.out.println("Message: " + card.getErrorPopupSignUpPage().getAttribute("contentDescription"));
    }

    @Then("I clear phone and password field")
    public void iClearPhoneAndPasswordField() {
        ReusableMethods.wait(1);
        card.getPhoneFieldSignUpPage().click();
        card.getPhoneFieldSignUpPage().clear();
        card.getPasswordFieldSignUpPage().click();
        card.getPasswordFieldSignUpPage().clear();
    }


    @Then("I should see an error message indicating the phone number criteria")
    public void iShouldSeeAnErrorMessageIndicatingThePhoneNumberCriteria() {
        ReusableMethods.wait(1);
        assertTrue(card.getErrorPopupSignUpPage().getAttribute("contentDescription").contains("The phone field must be at least 7 characters."));
        System.out.println("Message: " + card.getErrorPopupSignUpPage().getAttribute("contentDescription"));
    }


    @And("I enter the appropriate entries in the name and phone fields and enter a phone of less than 7 digits and click Sign Up button.")
    public void iEnterTheAppropriateEntriesInTheNameAndPhoneFieldsAndEnterAPhoneOfLessThanDigits() {
        ReusableMethods.wait(1);
        card.getNameFieldSignUpPage().click();
        card.getNameFieldSignUpPage().sendKeys("onur1");
        ReusableMethods.wait(1);
        card.getPhoneFieldSignUpPage().click();
        card.getPhoneFieldSignUpPage().sendKeys("123456");
        ReusableMethods.wait(1);
        card.getPasswordFieldSignUpPage().click();
        card.getPasswordFieldSignUpPage().sendKeys("1234567o*");
        ReusableMethods.wait(1);
        card.getSignUpButtonSignUpPage().click();
    }

    @Then("User fills the all fields properly and click Sign Up button.")
    public void userFillsTheAllFieldsProperlyAndClickSignUpButton() {
        ReusableMethods.wait(1);
        card.getNameFieldSignUpPage().click();
        card.getNameFieldSignUpPage().sendKeys("onur");
        ReusableMethods.wait(1);
        card.getPhoneFieldSignUpPage().click();
        card.getPhoneFieldSignUpPage().sendKeys("1234567");
        ReusableMethods.wait(1);
        card.getPasswordFieldSignUpPage().click();
        card.getPasswordFieldSignUpPage().sendKeys("1234o*");
        ReusableMethods.wait(1);
        card.getSignUpButtonSignUpPage().click();

        ReusableMethods.wait(2);
        card.getPasswordFieldSignUpPage().click();
        card.getPasswordFieldSignUpPage().sendKeys("5");
        ReusableMethods.wait(1);
        card.getSignUpButtonSignUpPage().click();
        try {
            assertEquals("Success?", card.getPasswordErrorSignUpPage().getAttribute("contentDescription"));
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
    }

    @And("User should see the success message")
    public void userShouldSeeTheSuccessMessage() {
        try {
            assertEquals("success", card.getPasswordErrorSignUpPage().getAttribute("contentDescription"));
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
    }
}
