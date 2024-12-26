package Page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;
import static utilities.Driver.getAppiumDriver;

public class MyAccountPage {
    public MyAccountPage(){
        PageFactory.initElements(new AppiumFieldDecorator(getAppiumDriver()), this);
    }


    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"*Use Email Instead\")")
    private WebElement useEmailInstead;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Profile\")")
    private WebElement profileIcon;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Profile\")")
    private WebElement profileIconUser;

    @AndroidFindBy (uiAutomator = "new UiSelector().description(\"damla.user@querycart.com\")")
    private WebElement dashboardDamlaUser;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"My Account\")")
    private WebElement dashboardMyAccount;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Total Orders\")")
    private WebElement myAccountTotalOrders;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Total Completed\")")
    private WebElement myAccountTotalCompleted;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Total Returnd\")")
    private WebElement myAccountTotalReturnd;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Wallet Balance\")")
    private WebElement myAccountWalletBalance;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Order History\")")
    private WebElement myAccountOrderHistory;


    public void UseEmailInstead(){
        useEmailInstead.click();
    }

    public void profileIcon(){
        ReusableMethods.wait(3);
        profileIcon.click();
    }

    public void profileIconUser(){
        profileIconUser.click();
    }

    public void dashboard(){
        ReusableMethods.wait(3);
        assertTrue("Dashboard sayfasi görünür", dashboardDamlaUser.isDisplayed());
    }
    public void myAccount(){
        ReusableMethods.wait(3);
        assertTrue("My account basligi goruntulenir", dashboardMyAccount.isDisplayed());
        dashboardMyAccount.click();
    }
    public void totalOrders(){
        assertTrue("Total Orders basligi goruntulenir",myAccountTotalOrders.isDisplayed());
    }
    public void totalCompleted(){
        assertTrue("Total Completed basligi goruntulenir",myAccountTotalCompleted.isDisplayed());
    }
    public void totalReturnd(){
        assertTrue("Total Returnd basligi goruntulenir",myAccountTotalReturnd.isDisplayed());
    }
    public void walletBalance(){
        assertTrue("Wallet Ballance basligi goruntulenir",myAccountWalletBalance.isDisplayed());
    }
    public void orderHistory(){
        assertTrue("Sipariş geçmişi görüntülenir",myAccountOrderHistory.isDisplayed());
    }


}
