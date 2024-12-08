package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

public class FinanceInstallmentTable {
    DialogContent dialogContentElement = new DialogContent();

    @When("The user clicks on the View icon to view the Installment Table")
    public void theUserClicksOnTheViewIconToViewTheInstallmentTable() {
        dialogContentElement.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("myFinanceURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("myFinanceURL")));

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.viewIconBtn));
        dialogContentElement.myClick(dialogContentElement.viewIconBtn);

        dialogContentElement.wait.until(ExpectedConditions.urlContains("student-fees"));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("student-fees"));
    }

    @And("The user views Installment Table the by clicking on the Fee-Balance Details button")
    public void theUserViewsInstallmentTableTheByClickingOnTheFeeBalanceDetailsButton() {
        if (dialogContentElement.feeBalanceDetailText.isDisplayed()) {
            dialogContentElement.myClick(dialogContentElement.feeBalanceDetailText);
        }

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.viewIconBtn));
        dialogContentElement.myClick(dialogContentElement.viewIconBtn);

        dialogContentElement.feesText.isDisplayed();
        dialogContentElement.verifyEqualsText(dialogContentElement.feesText,"Fees");

        dialogContentElement.installmentText.isDisplayed();
        dialogContentElement.verifyEqualsText(dialogContentElement.installmentText,"Installment");
    }
}
