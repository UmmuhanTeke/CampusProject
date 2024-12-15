package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.Random;

public class AssignmentsFeature {
    DialogContent dialogContentElement = new DialogContent();
    Random random = new Random();

    @Given("The user is on the Assignments page")
    public void theUserIsOnTheAssignmentsPage() {
        dialogContentElement.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("assignmentURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("assignmentURL")));
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.overdueText));
        dialogContentElement.verifyContainsText(dialogContentElement.overdueText, "Overdue");
    }

    @When("The user clicks the search button on the default Assignments page")
    public void theUserClicksTheSearchButtonOnTheDefaultAssignmentsPage() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.searchBtn));
        dialogContentElement.myClick(dialogContentElement.searchBtn);
    }

    @Then("The user views the list of all assigned tasks")
    public void theUserViewsTheListOfAllAssignedTasks() {
        for (int i = 0; i < dialogContentElement.assignmentsList.size(); i++) {
            dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.assignmentsList));
            dialogContentElement.scrollToElement(dialogContentElement.assignmentsList.get(i));
            Assert.assertTrue(dialogContentElement.assignmentsList.get(i).isDisplayed());
        }
    }

    @And("The user filters the search \\(Course,Status,Semester)")
    public void theUserFiltersTheSearchCourseStatusSemester() {
        dialogContentElement.scrollToElement(dialogContentElement.showAllBtn);
        dialogContentElement.jsClick(dialogContentElement.showAllBtn);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.showAllOptions));
        int randomIndex = random.nextInt(dialogContentElement.showAllOptions.size());
        dialogContentElement.clickAndEsc(dialogContentElement.showAllOptions.get(randomIndex),
                dialogContentElement.showAllOptions.get(randomIndex));

        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.statusMenu));
        dialogContentElement.jsClick(dialogContentElement.statusMenu);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.resultsPublishedBtn));
        dialogContentElement.clickAndEsc(dialogContentElement.resultsPublishedBtn,
                dialogContentElement.resultsPublishedBtn);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.semesterMenu));
        dialogContentElement.jsClick(dialogContentElement.semesterMenu);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.allBtn));
        dialogContentElement.clickAndEsc(dialogContentElement.allBtn, dialogContentElement.allBtn);
    }

    @And("The user accesses a dropdown menu to sort search results on the Assignments page")
    public void theUserAccessesADropdownMenuToSortSearchResultsOnTheAssignmentsPage() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.defaultViewBtn));
        dialogContentElement.jsClick(dialogContentElement.defaultViewBtn);
        for (int i = 0; i < dialogContentElement.defaultDropDown.size(); i++) {
            dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.defaultDropDown.get(i)));
            Assert.assertTrue(dialogContentElement.defaultDropDown.get(i).isDisplayed());
        }
    }

    @And("The user can sort results by course, type, date, and table from the dropdown menu")
    public void theUserCanSortResultsByCourseTypeDateAndTableFromTheDropdownMenu() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.defaultDropDown));
        int randomIndex = random.nextInt(dialogContentElement.defaultDropDown.size());
        dialogContentElement.jsClick(dialogContentElement.defaultDropDown.get(randomIndex));

        for (int i = 0; i < dialogContentElement.assignmentsList.size(); i++) {
            dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.assignmentsList));
            dialogContentElement.scrollToElement(dialogContentElement.assignmentsList.get(i));
            Assert.assertTrue(dialogContentElement.assignmentsList.get(i).isDisplayed());
        }
    }
}