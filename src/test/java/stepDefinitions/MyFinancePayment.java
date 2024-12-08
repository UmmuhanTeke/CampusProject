package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
        dialogContentElement.wait.until(ExpectedConditions.urlContains(ConfigReader.getProperty("myFinanceURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("active"));
    }

    @When("The user clicks on the student information field")
    public void theUserClicksOnTheStudentInformationField() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.viewIconBtn));
        dialogContentElement.myClick(dialogContentElement.viewIconBtn);
    }

    @Then("The user views the Online Payment and Fee Balance Detail buttons")
    public void theUserViewsTheOnlinePaymentAndFeeBalanceDetailButtons() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.onlinePaymentButton));
        dialogContentElement.verifyContainsText(dialogContentElement.onlinePaymentButton,"Online Payment");

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.feeBalanceButton));
        dialogContentElement.verifyContainsText(dialogContentElement.feeBalanceButton,"Fee/Balance Detail");
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
        Assert.assertTrue(dialogContentElement.paymentOptions.isDisplayed());
    }

    @When("The user clicks the Pay option and views the card information field")
    public void theUserClicksThePayOptionAndViewsTheCardInformationField() {
        dialogContentElement.myClick(dialogContentElement.paymentCreateOption);
        dialogContentElement.myClick(dialogContentElement.closeIcon);
        dialogContentElement.myClick(dialogContentElement.payOption);
        dialogContentElement.mySendKeys(dialogContentElement.amountBox, "1");
        dialogContentElement.myClick(dialogContentElement.unactivePayButton);
        dialogContentElement.myClick(dialogContentElement.payButton);
    }

    @And("The user enters card details and completes the payment")
    public void theUserEntersCardDetailsAndCompletesThePayment() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.iframe));
        GWD.getDriver().switchTo().frame(dialogContentElement.iframe);

        dialogContentElement.wait.until(ExpectedConditions.elementToBeClickable(dialogContentElement.cardNumberBox));
        dialogContentElement.mySendKeys(dialogContentElement.cardNumberBox, ConfigReader.getProperty("cardNumber"));

        dialogContentElement.mySendKeys(dialogContentElement.expirationDateBox, "1224");

        int randomCVV = 100 + random.nextInt(900);
        String randomString = String.valueOf(randomCVV);
        dialogContentElement.mySendKeys(dialogContentElement.securityCodeBox, randomString);

        Select country=new Select(dialogContentElement.selectCountry);
        country.selectByValue("TR");

        GWD.getDriver().switchTo().parentFrame();
    }

    @Then("The user views a message that the payment was successfully completed")
    public void theUserViewsAMessageThatThePaymentWasSuccessfullyCompleted() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.successPaymentMsg));
        dialogContentElement.verifyContainsText(dialogContentElement.successPaymentMsg,"successfully");
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