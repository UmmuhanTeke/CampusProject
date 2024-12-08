package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.ConfigReader;
import utilities.GWD;

import java.io.File;


public class FinanceReport {

    DialogContent dialogContentElement=new DialogContent();
    TopNav topNavElement=new TopNav();
    String downloadDir = System.getProperty("user.home") + "/Downloads";

    @When("The user navigates to Finance and then to My Finance")
    public void theUserNavigatesToFinanceAndThenToMyFinance() {
        topNavElement.hoverOver(topNavElement.financeBtn);
        topNavElement.myClick(topNavElement.myFinanceButton);
    }

    @Then("The user should access the finance page")
    public void theUserShouldAccessTheFinancePage() {
        dialogContentElement.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("myFinanceURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("myFinanceURL")));
    }

    @When("The user clicks on the Overflow menu for report types")
    public void theUserClicksOnTheThreeDotDropdownMenuForReportTypes() {
        dialogContentElement.myClick(dialogContentElement.overFlowMenuBtn);
    }

    @And("The user selects a report format")
    public void theUserSelectsAReportFormat() {
        dialogContentElement.myClick(dialogContentElement.excelBtn);
    }

    @Then("The user should be successfully downloaded to the local drive")
    public void theUserShouldBeSuccessfullyDownloadedToTheLocalDrive() {
        dialogContentElement.Wait(5); // Time to wait until the file is downloaded

        File downloadFolder = new File(downloadDir);
        File[] files = downloadFolder.listFiles((dir, name) -> name.endsWith(".xlsx"));
        Assert.assertNotNull(files);
        Assert.assertTrue(files.length > 0);
    }
}
