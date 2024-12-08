package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.List;
import java.util.Random;

public class MyFinancePayment {
    DialogContent dialogContentElement=new DialogContent();
    Random random = new Random();
    Faker faker = new Faker();

    @Given("The user has been redirected to the payment page")
    public void theUserHasBeenRedirectedToThePaymentPage() {
        dialogContentElement.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("myFinanceURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("myFinanceURL")));
    }

    @Then("The user views the Online Payment and Fee Balance Detail buttons")
    public void theUserViewsTheOnlinePaymentAndFeeBalanceDetailButtons() {
        Assert.assertTrue(dialogContentElement.onlinePaymentButton.isDisplayed());
        Assert.assertTrue(dialogContentElement.feeBalanceButton.isDisplayed());
    }

    @And("The user clicks the Stripe button")
    public void theUserClicksTheStripeButton(DataTable stripeBtn) {
        List<String> stripeButton=stripeBtn.asList();

        for (int i = 0; i <stripeButton.size() ; i++) {
            dialogContentElement.myClick(dialogContentElement.getWebElement(stripeButton.get(i)));
        }
    }

    @Then("The user views the payment options")
    public void theUserViewsThePaymentOptions() {
    }

    @When("The user clicks the Pay option and views the card information field")
    public void theUserClicksThePayOptionAndViewsTheCardInformationField() {
    }

    @And("The user enters card details and completes the payment")
    public void theUserEntersCardDetailsAndCompletesThePayment() {
    }

    @Then("The user views a message that the payment was successfully completed")
    public void theUserViewsAMessageThatThePaymentWasSuccessfullyCompleted() {
    }

    @Then("The user verifies that the payment has been completed")
    public void theUserVerifiesThatThePaymentHasBeenCompleted() {
    }

    @When("The user clicks the New Message button in the top right corner of the toolbar")
    public void theUserClicksTheNewMessageButtonInTheTopRightCornerOfTheToolbar(DataTable newMsgIcon) {
        List<String> newMessageIcon =newMsgIcon.asList();

        for (int i = 0; i < newMessageIcon.size() ; i++) {
            dialogContentElement.myClick(dialogContentElement.getWebElement(newMessageIcon.get(i)));
        }
    }

    @Then("The user views the received message in the area")
    public void theUserViewsTheReceivedMessageInTheArea() {
        Assert.assertTrue(dialogContentElement.paymentMsgControl.isDisplayed());
        dialogContentElement.verifyContainsText(dialogContentElement.paymentMsgControl,"completed");
    }
}