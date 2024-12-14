package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

public class AssignmentsFeature {
    DialogContent dialogContentElement = new DialogContent();

    @Given("The user is on the Assignments page")
    public void theUserIsOnTheAssignmentsPage() {
        dialogContentElement.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("assignmentURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("assignmentURL")));
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.overdueText));
        dialogContentElement.verifyContainsText(dialogContentElement.overdueText, "Overdue");
    }

    @When("The user clicks the search button on the default Assignments page")
    public void theUserClicksTheSearchButtonOnTheDefaultAssignmentsPage() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.searchButton));
        dialogContentElement.myClick(dialogContentElement.searchButton);
    }

    @Then("The user views the list of all assigned tasks")
    public void theUserViewsTheListOfAllAssignedTasks() {

    }

    @And("The user filters the search \\(Course,Status,Semester)")
    public void theUserFiltersTheSearchCourseStatusSemester() {
    }

    @And("The user accesses a dropdown menu to sort search results on the Assignments page")
    public void theUserAccessesADropdownMenuToSortSearchResultsOnTheAssignmentsPage() {
    }

    @And("The user can sort results by course, type, date, and table from the dropdown menu")
    public void theUserCanSortResultsByCourseTypeDateAndTableFromTheDropdownMenu() {
    }
}