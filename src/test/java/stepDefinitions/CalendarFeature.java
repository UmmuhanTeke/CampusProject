package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.List;
import java.util.Random;

public class CalendarFeature {
    DialogContent dialogContentElement = new DialogContent();
    TopNav topNavElement = new TopNav();
    Random random = new Random();

    @When("The user clicks on the Calendar button on the top navigation bar")
    public void theUserClicksOnTheCalendarButtonOnTheTopNavigationBar(DataTable calendarBtn) {
        List<String> calendarButton = calendarBtn.asList();

        for (int i = 0; i < calendarButton.size(); i++) {
            topNavElement.myClick(topNavElement.getWebElement(calendarButton.get(i)));
        }
    }

    @Then("The user views today's date and the Weekly Course Plan by default")
    public void theUserViewsTodaySDateAndTheWeeklyCoursePlanByDefault() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.dateVerify));
        Assert.assertTrue(dialogContentElement.dateVerify.isDisplayed());

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.coursePlanTableVerify));
        Assert.assertTrue(dialogContentElement.coursePlanTableVerify.isDisplayed());
    }

    @Then("The user views the icons \\(P,S,E,C) and descriptions of the scheduled lessons")
    public void theUserViewsTheIconsPSECAndDescriptionsOfTheScheduledLessons() {
        Assert.assertTrue(dialogContentElement.pIcon.isDisplayed());
        Assert.assertTrue(dialogContentElement.pDescription.isDisplayed());

        Assert.assertTrue(dialogContentElement.sIcon.isDisplayed());
        Assert.assertTrue(dialogContentElement.sDescription.isDisplayed());

        Assert.assertTrue(dialogContentElement.eIcon.isDisplayed());
        Assert.assertTrue(dialogContentElement.eDescription.isDisplayed());

        Assert.assertTrue(dialogContentElement.cIcon.isDisplayed());
        Assert.assertTrue(dialogContentElement.cDescription.isDisplayed());
    }

    @Given("The user is on the Calendar page")
    public void theUserIsOnTheCalendarPage() {
        dialogContentElement.wait.until(ExpectedConditions.urlContains("calendar"));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("calendar"));
    }

    @Then("The user should view two links to navigate to the Weekly Course Plan and Calendar pages")
    public void theUserShouldViewTwoLinksToNavigateToTheWeeklyCoursePlanAndCalendarPages() {
    }

    @When("The user clicks on these links")
    public void theUserClicksOnTheseLinks() {
    }

    @Then("The user should be redirected to the respective page")
    public void theUserShouldBeRedirectedToTheRespectivePage() {
    }

    @Given("The user is on the Weekly Course Plan page")
    public void theUserIsOnTheWeeklyCoursePlanPage() {
    }

    @Then("The user should view icons to navigate forward and backward \\(Previous, Today, Next) on the page")
    public void theUserShouldViewIconsToNavigateForwardAndBackwardPreviousTodayNextOnThePage() {
    }

    @When("The user clicks on these icons")
    public void theUserClicksOnTheseIcons() {
    }

    @Then("The user should be redirected to the corresponding date on the calendar")
    public void theUserShouldBeRedirectedToTheCorrespondingDateOnTheCalendar() {
    }

    @Then("The user should view the courses they are responsible for")
    public void theUserShouldViewTheCoursesTheyAreResponsibleFor() {
    }

    @When("The user clicks on a course")
    public void theUserClicksOnACourse() {
    }

    @Then("The user should view the details of that course")
    public void theUserShouldViewTheDetailsOfThatCourse() {
    }
}