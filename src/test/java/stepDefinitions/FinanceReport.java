package stepDefinitions;

import io.cucumber.java.en.*;
import pages.DialogContent;
import pages.TopNav;


public class FinanceReport {

    DialogContent dialogContentElement=new DialogContent();
    TopNav topNavElement=new TopNav();

    @When("The user navigates to Finance and then to My Finance")
    public void theUserNavigatesToFinanceAndThenToMyFinance() {
    }

    @Then("The user should access the finance page")
    public void theUserShouldAccessTheFinancePage() {
    }

    @When("The user clicks on the three-dot dropdown menu for report types")
    public void theUserClicksOnTheThreeDotDropdownMenuForReportTypes() {
    }

    @And("The user selects a report format")
    public void theUserSelectsAReportFormat() {
    }

    @Then("The user should be successfully downloaded to the local drive")
    public void theUserShouldBeSuccessfullyDownloadedToTheLocalDrive() {
    }
}
