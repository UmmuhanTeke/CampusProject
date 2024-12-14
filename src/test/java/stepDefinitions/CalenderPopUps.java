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

public class CalenderPopUps {
    DialogContent dialogContentElement = new DialogContent();

    @When("The user views Course Status \\(P,S,E,C), Course Name, and Teacher's Name of Weekly Course Plan page")
    public void theUserViewsCourseStatusPSECCourseNameAndTeacherSNameOfWeeklyCoursePlanPage() {
        dialogContentElement.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("calendarURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("calendarURL")));

        if (dialogContentElement.weeklyCoursePlanBtn.isDisplayed()) {
            dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.pIcon));
            if (dialogContentElement.pIcon.isDisplayed() && dialogContentElement.pDescription.isDisplayed()) {
                dialogContentElement.verifyContainsText(dialogContentElement.pIcon, "P");
                dialogContentElement.verifyContainsText(dialogContentElement.pDescription, "Published");
            }

            dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.sIcon));
            if (dialogContentElement.sIcon.isDisplayed() && dialogContentElement.sDescription.isDisplayed()) {
                dialogContentElement.verifyContainsText(dialogContentElement.sIcon, "S");
                dialogContentElement.verifyContainsText(dialogContentElement.sDescription, "Started");
            }

            dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.eIcon));
            if (dialogContentElement.eIcon.isDisplayed() && dialogContentElement.eDescription.isDisplayed()) {
                dialogContentElement.verifyContainsText(dialogContentElement.eIcon, "E");
                dialogContentElement.verifyContainsText(dialogContentElement.eDescription, "Ended");
            }

            dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.cIcon));
            if (dialogContentElement.cIcon.isDisplayed() && dialogContentElement.cDescription.isDisplayed()) {
                dialogContentElement.verifyContainsText(dialogContentElement.cIcon, "C");
                dialogContentElement.verifyContainsText(dialogContentElement.cDescription, "Cancelled");
            }

            dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.teacherText));
            System.out.println(dialogContentElement.teacherText.isDisplayed());
            dialogContentElement.verifyContainsText(dialogContentElement.teacherText,"Teacher");

            dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.courseControlText));
            System.out.println("2:"+dialogContentElement.courseControlText.getText());
            System.out.println(dialogContentElement.courseControlText.isDisplayed());
            dialogContentElement.verifyContainsText(dialogContentElement.courseControlText,"11A");
        }
    }

    @Then("The user verifies the all functions of the a opened pop-up window")
    public void theUserVerifiesTheAllFunctionsOfTheAOpenedPopUpWindow(DataTable dtBtn) {
        List<String> btn = dtBtn.asList();

        for (int i = 0; i < btn.size(); i++) {
            dialogContentElement.myClick(dialogContentElement.getWebElement(btn.get(i)));
            System.out.println("record:"+dialogContentElement.recordingBtn.isDisplayed());
        }


    }

    @And("The user clicks on the Course Meeting that has not yet started")
    public void theUserClicksOnTheCourseMeetingThatHasNotYetStarted() {
    }

    @Then("The user verifies the Teacher's name, the Date and Time of the lesson, and warning message")
    public void theUserVerifiesTheTeacherSNameTheDateAndTimeOfTheLessonTheWarningMessage() {
    }
}
