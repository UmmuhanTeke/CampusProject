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

        topNavElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.financeButton));
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
        dialogContentElement.myClick(dialogContentElement.stripeBtn);

        dialogContentElement.wait.until(ExpectedConditions.elementToBeClickable(dialogContentElement.payCtrl));
        dialogContentElement.jsClick(dialogContentElement.payCtrl);
        dialogContentElement.wait.until(ExpectedConditions.elementToBeClickable(dialogContentElement.payCtrl));
        topNavElement.myClick(dialogContentElement.payCtrl);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.payButton));
        topNavElement.myClick(dialogContentElement.payButton);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.amountBtn));
        dialogContentElement.myClick(dialogContentElement.amountBtn);
        dialogContentElement.mySendKeys(dialogContentElement.amountBtn, ConfigReader.getProperty("amount"));

        dialogContentElement.wait.until(ExpectedConditions.elementToBeClickable(dialogContentElement.payBtn));
        dialogContentElement.myClick(dialogContentElement.payBtn);
    }

    @When("The user enters their card details")
    public void the_user_enters_their_card_details(DataTable dataTable) {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.iframe));
        GWD.getDriver().switchTo().frame(dialogContentElement.iframe);

        List<String>cardNumber=dataTable.asList();
        for (int i = 0; i <cardNumber.size() ; i++) {
            dialogContentElement.wait.until(ExpectedConditions.visibilityOf((WebElement) dialogContentElement.cardNumber));
            dialogContentElement.myClick(dialogContentElement.getWebElement(cardNumber.get(i)));
        }
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf((WebElement)dialogContentElement.cardNumber));
        dialogContentElement.mySendKeys((WebElement) dialogContentElement.cardNumber, ConfigReader.getProperty("cardNumber"));

        int randomCVV = dialogContentElement.randomGenerator(900) + 100;
        dialogContentElement.mySendKeys(dialogContentElement.expirationDate, Integer.toString(randomCVV));
        int randomMonth = dialogContentElement.randomGenerator(12) + 1;
        int randomYear = dialogContentElement.randomGenerator(10) + 25;
        String expireDate = Integer.toString(randomMonth) + randomYear;
        dialogContentElement.mySendKeys(dialogContentElement.expirationDate, expireDate);
    }

    @When("The user confirms the payment")
    public void the_user_confirms_the_payment() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.payButton));
        dialogContentElement.myClick(dialogContentElement.payButton);
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
