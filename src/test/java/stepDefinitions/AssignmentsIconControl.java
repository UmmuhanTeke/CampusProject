package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.List;
import java.util.Random;

public class AssignmentsIconControl {
    DialogContent dialogContentElement = new DialogContent();
    Random random = new Random();

    @When("The user selects a assignment is selected from the list and views the icons next to the assignment")
    public void theUserSelectsAAssignmentIsSelectedFromTheListAndViewsTheIconsNextToTheAssignment() {
        dialogContentElement.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("assignmentURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("assignmentURL")));

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.overdueText));
        if (dialogContentElement.overdueText.isDisplayed()) {
            dialogContentElement.verifyContainsText(dialogContentElement.overdueText, "Overdue");
            dialogContentElement.iconsMenu.isDisplayed();
        }
    }

    @When("The user clicks on the Information icon")
    public void theUserClicksOnTheInformationIcon() {
        if (dialogContentElement.iconsMenu.isDisplayed()) {
            dialogContentElement.infoIcon.isDisplayed();
            dialogContentElement.myClick(dialogContentElement.infoIcon);
        }
    }

    @Then("The user verifies the assignment details on the page")
    public void theUserVerifiesTheAssignmentDetailsOnThePage() {
        dialogContentElement.wait.until(ExpectedConditions.urlContains("info"));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("info"));

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.courseText));
        dialogContentElement.verifyContainsText(dialogContentElement.courseText,"Course");
        dialogContentElement.verifyContainsText(dialogContentElement.assignmentStatusText,"Assignment Status");
        dialogContentElement.verifyContainsText(dialogContentElement.descriptionText,"Description");
    }

    @And("The user clicks on another place without an icon from the assignment list")
    public void theUserClicksOnAnotherPlaceWithoutAnIconFromTheAssignmentList() {
        dialogContentElement.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("assignmentURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("assignmentURL")));

        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.assignmentsList));
        int randomIndex = random.nextInt(dialogContentElement.assignmentsList.size());
        dialogContentElement.myClick(dialogContentElement.assignmentsList.get(randomIndex));
    }

    @And("The user goes back the Assignment list")
    public void theUserGoesBackTheAssignmentList(DataTable dtBtn) {
        List<String> btn = dtBtn.asList();

        for (int i = 0; i < btn.size(); i++) {
            dialogContentElement.myClick(dialogContentElement.getWebElement(btn.get(i)));
        }
    }

    @Then("The user clicks on the Submit icon and verifies the submission window on the page")
    public void theUserClicksOnTheSubmitIconAndVerifiesTheSubmissionWindowOnThePage() {
        dialogContentElement.clickAndEsc(dialogContentElement.submitIcon,dialogContentElement.submitBtn);
    }

    @Then("The user clicks on the Discussion icon and verifies the discussion window on the page")
    public void theUserClicksOnTheDiscussionIconAndVerifiesTheDiscussionWindowOnThePage() {
        dialogContentElement.clickAndEsc(dialogContentElement.discussionIcon,dialogContentElement.contactIcon);
    }

    @Then("The user clicks on the Mark it icon and verifies marked as a favorite")
    public void theUserClicksOnTheMarkItIconAndVerifiesMarkedAsAFavorite() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.markItIcon));
        boolean found=false;
        if (dialogContentElement.svg.getAttribute("data-prefix").contains("fal")){
            found=true;
        }
        Assert.assertTrue(found);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.markItIcon));
        dialogContentElement.myClick(dialogContentElement.markItIcon);

        if (dialogContentElement.svg.getAttribute("data-prefix").contains("fas")){
            found=true;
        }
        Assert.assertTrue(found);
    }
}
