package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.List;
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
//        List<WebElement> assignmentLessons = dialogContentElement.assignmentsList;
//
//        for (WebElement lessons : assignmentLessons) {
//            dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(lessons));
//            Assert.assertTrue(lessons.isDisplayed());
//            System.out.println(lessons);
//        }
    }

    @And("The user filters the search \\(Course,Status,Semester)")
    public void theUserFiltersTheSearchCourseStatusSemester() {
        dialogContentElement.myClick(dialogContentElement.showAllBtn);
        dialogContentElement.Wait(2);
        List<WebElement> showAllOption = dialogContentElement.showAllOptions;
        int randomIndex = random.nextInt(showAllOption.size());
        dialogContentElement.myClick(showAllOption.get(randomIndex));

        dialogContentElement.myClick(dialogContentElement.statusMenu);
        dialogContentElement.myClick(dialogContentElement.resultsPublishedBtn);
        dialogContentElement.myClick(dialogContentElement.allBtn);
    }

    @And("The user accesses a dropdown menu to sort search results on the Assignments page")
    public void theUserAccessesADropdownMenuToSortSearchResultsOnTheAssignmentsPage() {
    }

    @And("The user can sort results by course, type, date, and table from the dropdown menu")
    public void theUserCanSortResultsByCourseTypeDateAndTableFromTheDropdownMenu() {
    }
}