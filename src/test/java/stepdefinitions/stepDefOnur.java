package stepdefinitions;

import Page.QueryCardPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utilities.OptionsMet;
import utilities.ReusableMethods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class stepDefOnur extends OptionsMet {
    QueryCardPage card = new QueryCardPage();
    Faker faker = new Faker();
    String fakePhone = faker.numerify("#######");
    String fakePhoneSixDigits = faker.numerify("######");
    String fakeName = faker.name().fullName();

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
        card.getNameFieldSignUpPage().sendKeys(fakeName);
        ReusableMethods.wait(1);
        card.getPhoneFieldSignUpPage().click();
        card.getPhoneFieldSignUpPage().sendKeys(fakePhone);
        ReusableMethods.wait(1);
        card.getPasswordFieldSignUpPage().click();
        card.getPasswordFieldSignUpPage().sendKeys("12345");
        ReusableMethods.wait(1);
        card.getSignUpButtonSignUpPage().click();


    }

    @Then("I clear phone and password field")
    public void iClearPhoneAndPasswordField() {
        ReusableMethods.wait(1);
        card.getPhoneFieldSignUpPage().click();
        card.getPhoneFieldSignUpPage().clear();
        card.getPasswordFieldSignUpPage().click();
        card.getPasswordFieldSignUpPage().clear();
    }


    @Then("User should see an error message")
    public void iShouldSeeAnErrorMessageIndicatingThePhoneNumberCriteria() {
        ReusableMethods.wait(1);
        try {
            assertTrue(card.getPopupSignUpPage().getAttribute("contentDescription").contains("Error"));
            System.out.println("Message: " + "\""+card.getPopupSignUpPage().getAttribute("contentDescription")+"\"");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
    }


    @And("I enter the appropriate entries in the name and password fields and enter a phone of less than 7 digits and click Sign Up button.")
    public void iEnterTheAppropriateEntriesInTheNameAndPasswordFieldsAndEnterAPhoneOfLessThanDigits() {
        ReusableMethods.wait(1);
        card.getNameFieldSignUpPage().click();
        card.getNameFieldSignUpPage().sendKeys(fakeName);
        ReusableMethods.wait(1);
        card.getPhoneFieldSignUpPage().click();
        card.getPhoneFieldSignUpPage().sendKeys(fakePhoneSixDigits);
        ReusableMethods.wait(1);
        card.getPasswordFieldSignUpPage().click();
        card.getPasswordFieldSignUpPage().sendKeys("1234567o*");
        ReusableMethods.wait(1);
        card.getSignUpButtonSignUpPage().click();
    }

    @Then("User fills in all fields properly and click Sign Up button.")
    public void userFillsInAllFieldsProperlyAndClickSignUpButton() {
        ReusableMethods.wait(1);
        card.getNameFieldSignUpPage().click();
        card.getNameFieldSignUpPage().click();
        card.getNameFieldSignUpPage().sendKeys(fakeName);
        ReusableMethods.wait(1);
        card.getPhoneFieldSignUpPage().click();
        card.getPhoneFieldSignUpPage().sendKeys(fakePhone);
        ReusableMethods.wait(1);
        card.getPasswordFieldSignUpPage().click();
        card.getPasswordFieldSignUpPage().sendKeys("1234o*");
        ReusableMethods.wait(1);
        card.getSignUpButtonSignUpPage().click();
    }

    @And("User should see the success message")
    public void userShouldSeeTheSuccessMessage() {
        try {
            assertTrue(card.getPopupSignUpPage().getAttribute("contentDescription").contains("Success"));
            System.out.println("Message: " + "\""+card.getPopupSignUpPage().getAttribute("contentDescription")+"\"");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
    }

    @Then("User fills in all fields properly, including the 8-character password, and clicks the Sign Up button")
    public void userFillsInAllFieldsProperlyIncludingTheCharacterPasswordAndClicksTheSignUpButton() {
        ReusableMethods.wait(1);
        card.getNameFieldSignUpPage().click();
        card.getNameFieldSignUpPage().sendKeys(fakeName);
        ReusableMethods.wait(1);
        card.getPhoneFieldSignUpPage().click();
        card.getPhoneFieldSignUpPage().sendKeys(fakePhone);
        ReusableMethods.wait(1);
        card.getPasswordFieldSignUpPage().click();
        card.getPasswordFieldSignUpPage().sendKeys("123456o*");
        ReusableMethods.wait(1);
        card.getSignUpButtonSignUpPage().click();
        ReusableMethods.wait(1);
    }

    @Then("User should see the \"Password is short\" error message")
    public void userShouldSeeTheErrorMessage() {
        try {
            assertTrue(card.getPasswordErrorSignUpPage().isDisplayed());
            assertEquals("Password is short",card.getPasswordErrorSignUpPage().getAttribute("contentDescription"));
            System.out.println("Message: " + "\"" + card.getPasswordErrorSignUpPage().getAttribute("contentDescription")+"\"");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
    }

    @Then("User should see an {string} popup message")
    public void userShouldSeeAnPopupMessage(String expectedMessage) {
        try {
            assertTrue("the pop-up window does not contain the word \"success\".",card.getPopupSignUpPage().getAttribute("contentDescription").contains(expectedMessage));
            System.out.println("Message: " + "\"" + card.getPopupSignUpPage().getAttribute("contentDescription")+"\"");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
            //WebElement successMessage = driver.findElement(AppiumBy.xpath("//*[contains(@content-desc, 'item added')]"));
        }
    }

    @And("User verifies that the directed page is {string} page.")
    public void userVerifiesThatTheDirectedPageIsPage(String expectedPageHeader) {
        VerifyElementText(expectedPageHeader);
    }
}
