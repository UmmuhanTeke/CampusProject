package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;

public class AssignmentsIconControl {
    DialogContent dialogContentElement = new DialogContent();

    @When("The user selects a assignment is selected from the list and views the icons next to the assignment")
    public void theUserSelectsAAssignmentIsSelectedFromTheListAndViewsTheIconsNextToTheAssignment() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.overdueText));
        dialogContentElement.overdueText.isDisplayed();
        dialogContentElement.verifyContainsText(dialogContentElement.overdueText,"Overdue");
    }

    @When("The user clicks on the Information icon")
    public void theUserClicksOnTheInformationIcon() {
    }

    @Then("The user verifies the assignment details on the page")
    public void theUserVerifiesTheAssignmentDetailsOnThePage() {
    }

    @And("The user clicks on another place without an icon from the assignment list")
    public void theUserClicksOnAnotherPlaceWithoutAnIconFromTheAssignmentList() {
    }

    @And("The user goes back the Assignment list")
    public void theUserGoesBackTheAssignmentList(DataTable dtBtn) {
    }

    @When("The user clicks on the Submit icon")
    public void theUserClicksOnTheSubmitIcon() {
    }

    @Then("The user verifies the submission window on the page")
    public void theUserVerifiesTheSubmissionWindowOnThePage() {
    }

    @When("The user clicks on the Mark it icon")
    public void theUserClicksOnTheMarkItIcon() {
    }

    @Then("The user verifies marked as a favorite")
    public void theUserVerifiesMarkedAsAFavorite() {
    }

    @When("The user clicks on the Discussion icon")
    public void theUserClicksOnTheDiscussionIcon() {
    }

    @Then("The user verifies the discussion window on the page")
    public void theUserVerifiesTheDiscussionWindowOnThePage() {
    }
}
