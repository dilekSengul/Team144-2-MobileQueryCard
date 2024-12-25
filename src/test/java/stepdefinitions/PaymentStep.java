package stepdefinitions;

import Page.PaymentPage;
import io.cucumber.java.en.*;
import io.qameta.allure.Step;
import utilities.OptionsMet;
import utilities.ReusableMethods;

import javax.sound.midi.InvalidMidiDataException;

public class PaymentStep {

    PaymentPage paymentPage = new PaymentPage();

    @Step("QueryCart customer makes the swipe operation for Save & Pay button")
    @And("QueryCart customer makes the swipe operation for Save & Pay button")
    public void querycartCustomerMakesTheSwipeOperationForSavePayButton() throws InvalidMidiDataException {
        OptionsMet.swipe(655,2365,651,951);
    }

    @Step("QueryCart customer makes address selection")
    @And("QueryCart customer makes address selection")
    public void querycartCustomerMakesAddressSelection() {
        paymentPage.AdressClick();
    }


    @Step("QueryCart customer enters {string} , {string} , {string} and {string}")
    @And("QueryCart customer enters {string} , {string} , {string} and {string}")
    public void querycartCustomerEntersAnd(String cartNumber, String MM_YY, String CVC, String ZipCode) {
        paymentPage.StripeCardIntroduction(cartNumber,MM_YY,CVC,ZipCode);
    }

    @Step("QueryCart customer clicks Confrim button")
    @And("QueryCart customer clicks Confrim button")
    public void querycartCustomerClicksConfrimButton() {
        paymentPage.ConfrimClick();
    }

    @Step("User waits {int} seconds")
    @And("User waits {int} seconds")
    public void userWaitsSeconds(int sec) {
        ReusableMethods.wait(sec);
    }

    @And("QueryCart customer clicks on the Go to shopping button")
    public void querycartCustomerClicksOnTheGoToShoppingButton() {
        paymentPage.GoToShoppingClick();
    }

    @Step("QueryCart customer validates the error message {string}")
    @And("QueryCart customer validates the error message {string}")
    public void querycartCustomerValidatesTheErrorMessage(String message) {
        paymentPage.errorMesagge(message);
    }

    @Step("QueryCart customer enters {string} , {string} and {string}")
    @And("QueryCart customer enters {string} , {string} and {string}")
    public void querycartCustomerEntersAnd(String cartNumber, String MM_YY, String CVC) {
        paymentPage.invalidStripeTest(cartNumber,MM_YY,CVC);
    }

    @Step("QueryCart customer receives an error message at Live cart login")
    @And("QueryCart customer receives an error message at Live cart login")
    public void querycartCustomerReceivesAnErrorMessageAtLiveCartLogin() {
        paymentPage.errorDisplay();
    }
}
