package stepdefinitions;

import Page.PaymentInfoAddress;
import Page.PaymentPage;
import Page.QueryCardPage;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;

import static utilities.Driver.getAppiumDriver;

public class PaymentInfoArzu {
    PaymentInfoAddress paymentInfoAddress = new PaymentInfoAddress();
    PaymentPage paymentPage = new PaymentPage();
    QueryCardPage queryCardPage = new QueryCardPage();
    Actions actions = new Actions(getAppiumDriver());






}
