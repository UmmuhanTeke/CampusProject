package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.ConfigReader;
import utilities.GWD;

public class MyFinancePayment {
    DialogContent dialogContentElement=new DialogContent();
    TopNav topNavElement=new TopNav();

    @Given("The user has been redirected to the payment page")
    public void theUserHasBeenRedirectedToThePaymentPage() {
        dialogContentElement.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("myFinanceURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("myFinanceURL")));
    }

    @Then("The user views the Online Payment and Fee Balance Detail buttons")
    public void theUserViewsTheOnlinePaymentAndFeeBalanceDetailButtons() {
    }

    @And("The user clicks the Stripe button")
    public void theUserClicksTheStripeButton() {
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
    public void theUserClicksTheNewMessageButtonInTheTopRightCornerOfTheToolbar() {
    }

    @Then("The user views the received message in the area")
    public void theUserViewsTheReceivedMessageInTheArea() {
    }
}