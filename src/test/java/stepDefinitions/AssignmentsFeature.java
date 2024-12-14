package stepDefinitions;

import io.cucumber.java.en.*;
import pages.DialogContent;

public class AssignmentsFeature {
    DialogContent dialogContentElement = new DialogContent();

    @Given("The user is on the Assignments page")
    public void theUserIsOnTheAssignmentsPage() {
    }

    @When("The user clicks the search button on the default Assignments page")
    public void theUserClicksTheSearchButtonOnTheDefaultAssignmentsPage() {
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