package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.List;
import java.util.Random;

public class FinanceFee {
    DialogContent dialogContentElement = new DialogContent();
    TopNav topNavElement = new TopNav();
    Random random = new Random();

    @Given("The user has been redirected to the payment page")
    public void theUserHasBeenRedirectedToThePaymentPage() {
        dialogContentElement.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("myFinanceURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("myFinanceURL")));
    }

    @When("The user clicks on the student information field")
    public void theUserClicksOnTheStudentInformationField() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.viewIconBtn));
        dialogContentElement.myClick(dialogContentElement.viewIconBtn);
    }

    @Then("The user views the Online Payment and Fee Balance Detail buttons")
    public void theUserViewsTheOnlinePaymentAndFeeBalanceDetailButtons() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.onlinePaymentButton));
        dialogContentElement.verifyContainsText(dialogContentElement.onlinePaymentButton, "Online ");

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.feeBalanceButton));
        dialogContentElement.verifyContainsText(dialogContentElement.feeBalanceButton, "Fee/Balance ");
    }

    @And("The user clicks the Stripe button")
    public void theUserClicksTheStripeButton(DataTable stripeBtn) {
        List<String> stripeButton = stripeBtn.asList();

        for (int i = 0; i < stripeButton.size(); i++) {
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
        dialogContentElement.mySendKeys(dialogContentElement.amountBox, ConfigReader.getProperty("amount"));
        dialogContentElement.myClick(dialogContentElement.unactivePayButton);
        dialogContentElement.myClick(dialogContentElement.payButton);
    }

    @And("The user enters card details and completes the payment")
    public void theUserEntersCardDetailsAndCompletesThePayment() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.iframe));
        GWD.getDriver().switchTo().frame(dialogContentElement.iframe);

        dialogContentElement.wait.until(ExpectedConditions.elementToBeClickable(dialogContentElement.cardNumberBox));
        dialogContentElement.mySendKeys(dialogContentElement.cardNumberBox, ConfigReader.getProperty("cardNumber"));
        dialogContentElement.mySendKeys(dialogContentElement.expirationDateBox, ConfigReader.getProperty("expirationDate"));

        int randomCVV = 100 + random.nextInt(900);
        String randomString = String.valueOf(randomCVV);
        dialogContentElement.mySendKeys(dialogContentElement.securityCodeBox, randomString);

        for (int i = 0; i < 2; i++) {
            dialogContentElement.myClick(dialogContentElement.selectCountry);
        }

        GWD.getDriver().switchTo().parentFrame();
        dialogContentElement.myClick(dialogContentElement.stripePaymentsButton);
    }

    @Then("The user views a message that the payment was successfully completed")
    public void theUserViewsAMessageThatThePaymentWasSuccessfullyCompleted() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.successPaymentMsg));
        dialogContentElement.verifyContainsText(dialogContentElement.successPaymentMsg, "successfully");
    }

    @Then("The user verifies that the payment has been completed")
    public void theUserVerifiesThatThePaymentHasBeenCompleted() {
        dialogContentElement.myClick(dialogContentElement.feeBalanceButton);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.totalBalance));
        dialogContentElement.scrollToElement(dialogContentElement.scrollElement);

        String amountRemain = dialogContentElement.totalBalance.getText().replaceAll("[^0-9,]", "");
        int amountRemainValue = Integer.parseInt(amountRemain.replace(",", ""));

        topNavElement.myClick(topNavElement.hamburgerMenu);
        topNavElement.hoverOver(topNavElement.financeButton);
        topNavElement.myClick(topNavElement.myFinanceButton);

        dialogContentElement.myClick(dialogContentElement.studentButton);
        dialogContentElement.myClick(dialogContentElement.feeBalanceButton);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.totalBalance));
        dialogContentElement.scrollToElement(dialogContentElement.scrollElement);

        String lastAmount = dialogContentElement.totalBalance.getText().replaceAll("[^0-9,]", "");
        int lastAmountInt = Integer.parseInt(lastAmount.replace(",", ""));
        int amountToSubtract = Integer.parseInt(ConfigReader.getProperty("amount"));
        int difference = amountRemainValue - amountToSubtract;
        Assert.assertEquals(difference,lastAmountInt );
    }

    @When("The user clicks the New Message button in the top right corner of the toolbar")
    public void theUserClicksTheNewMessageButtonInTheTopRightCornerOfTheToolbar(DataTable newMsgIcon) {
        List<String> newMessageIcon = newMsgIcon.asList();

        for (int i = 0; i < newMessageIcon.size(); i++) {
            topNavElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.newMessageIcon));
            topNavElement.jsClick(topNavElement.getWebElement(newMessageIcon.get(i)));
        }
    }

    @Then("The user views the received message in the area")
    public void theUserViewsTheReceivedMessageInTheArea() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.newMessageVerify));
        dialogContentElement.myClick(dialogContentElement.viewIconBtn);
        dialogContentElement.myClick(dialogContentElement.viewIconBtn);
        System.out.println("4");
        Assert.assertTrue(dialogContentElement.paymentMsgControl.isDisplayed());
        dialogContentElement.verifyContainsText(dialogContentElement.paymentMsgControl, "completed");
    }
}