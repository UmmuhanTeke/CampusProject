package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;

import java.util.List;

public class AssignmentsViewAssignedTasks {
    DialogContent dialogContentElement=new DialogContent();
    TopNav topNavElement=new TopNav();

    @When("The user hovers over the Assignments link")
    public void theUserHoversOverTheAssignmentsLink() {
        topNavElement.hoverOver(topNavElement.assignmentsMenu);
    }

    @Then("The number of assigned tasks should be displayed")
    public void theNumberOfAssignedTasksShouldBeDisplayed() {
        dialogContentElement.verifyContainsText(dialogContentElement.assingmentsCount, "16");
    }

    @Then("The user clicks on the Semester link and select All")
    public void theUserClicksOnTheSemesterLinkAndSelectAll() {
        dialogContentElement.myClick(dialogContentElement.semesterBtn);
        dialogContentElement.myClick(dialogContentElement.semesterAllBtn);
    }

    @Then("The user should see all assigned tasks on the page")
    public void theUserShouldSeeAllAssignedTasksOnThePage() {
        String expectedTaskCount = dialogContentElement.assingmentsCount.getText().trim();
        List<WebElement> displayedTasks = dialogContentElement.assingmentsPublished;
        int actualTaskCount = displayedTasks.size();
        Assert.assertEquals(String.valueOf(actualTaskCount), expectedTaskCount,
                "The number of tasks displayed on the page does not match the expected count.");
    }
}