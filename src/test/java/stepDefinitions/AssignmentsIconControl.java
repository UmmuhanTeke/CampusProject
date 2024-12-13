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

        dialogContentElement.verifyContainsText(dialogContentElement.courseText,"Course");
        dialogContentElement.verifyContainsText(dialogContentElement.homeworkText,"Homework");
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

    @When("The user clicks on the Submit icon")
    public void theUserClicksOnTheSubmitIcon() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.submitIcon));
        if ( dialogContentElement.submitIcon.isDisplayed()){
            dialogContentElement.myClick(dialogContentElement.submitIcon);
        }
    }

    @Then("The user verifies the submission window on the page")
    public void theUserVerifiesTheSubmissionWindowOnThePage() {
        dialogContentElement.Wait(3);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.submitWindow));
        System.out.println("1:"+dialogContentElement.submitWindow.isDisplayed());

        GWD.getDriver().switchTo().frame(0);
        System.out.println("2:"+dialogContentElement.textBox.isDisplayed());
        GWD.getDriver().switchTo().parentFrame();

        System.out.println("3:"+dialogContentElement.submitBtn.isDisplayed());
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
