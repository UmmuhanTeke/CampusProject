package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class FinancePayment {
    DialogContent dialogContentElement = new DialogContent();
    TopNav topNavElement = new TopNav();

    @When("The user hovers over the Hamburger Menu and clicks on My Finance")
    public void the_user_hovers_over_the_hamburger_menu_and_clicks_on_my_finance() {
        topNavElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.hamburgerMenu));
        topNavElement.myClick(topNavElement.hamburgerMenuBtn);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.financeButton));
        topNavElement.hoverOver(topNavElement.financeButton);

        topNavElement.wait.until((ExpectedConditions.visibilityOf(topNavElement.myFinance)));
        topNavElement.myClick(topNavElement.myFinance);
    }

    @When("The user clicks their name and is redirected to the payment page")
    public void the_user_clicks_their_name_and_is_redirected_to_the_payment_page() {
        topNavElement.myClick(topNavElement.studentBtn);
        topNavElement.verifyContainsText(topNavElement.studentBtn, topNavElement.studentBtn.getText());
    }

    @When("The user enters the amount and clicks the pay button")
    public void the_user_enters_the_amount_and_clicks_the_pay_button() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.stripeBtn));
        topNavElement.myClick(dialogContentElement.stripeBtn);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.payCtrl));
        topNavElement.jsClick(dialogContentElement.payCtrl);
        topNavElement.myClick(dialogContentElement.payCtrl);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.payButton));
        topNavElement.myClick(dialogContentElement.payButton);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.amountBtn));
        topNavElement.myClick(dialogContentElement.amountBtn);
        topNavElement.mySendKeys(dialogContentElement.amountBtn, ConfigReader.getProperty("amount"));

        dialogContentElement.wait.until(ExpectedConditions.elementToBeClickable(dialogContentElement.payBtn));
        topNavElement.myClick(dialogContentElement.payBtn);
    }

    @When("The user enters their card details")
    public void the_user_enters_their_card_details(DataTable dataTable) {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.iframe));
        GWD.getDriver().switchTo().frame(dialogContentElement.iframe);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.cardNumber));
        topNavElement.myClick(dialogContentElement.cardNumber);
        topNavElement.mySendKeys(dialogContentElement.cardNumber, ConfigReader.getProperty("cardNumber"));

        int randomCVV = topNavElement.randomGenerator(900) + 100;
        topNavElement.mySendKeys(dialogContentElement.expirationDate, Integer.toString(randomCVV));
        int randomMonth = topNavElement.randomGenerator(12) + 1;
        int randomYear = topNavElement.randomGenerator(10) + 25;
        String expireDate = Integer.toString(randomMonth) + randomYear;
        topNavElement.mySendKeys(dialogContentElement.expirationDate, expireDate);
    }

    @When("The user confirms the payment")
    public void the_user_confirms_the_payment() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.payButton));
        topNavElement.myClick(dialogContentElement.payButton);
    }

    @Then("The user displays a confirmation message {string}")
    public void the_user_displays_a_confirmation_message() {
        topNavElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.newMessageIcon));
        topNavElement.jsClick(topNavElement.newMessageIcon);
        dialogContentElement.verifyContainsText(dialogContentElement.msgControl, "successfully");
        Assert.assertTrue(dialogContentElement.paymentMsgControl.isDisplayed());
        dialogContentElement.verifyContainsText(dialogContentElement.paymentMsgControl, "completed");
    }
}
