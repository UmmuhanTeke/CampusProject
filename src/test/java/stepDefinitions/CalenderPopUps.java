package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.ArrayList;
import java.util.Collections;
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
            dialogContentElement.verifyContainsText(dialogContentElement.teacherText,"Teacher");

            dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.courseControlText));
            dialogContentElement.verifyContainsText(dialogContentElement.courseControlText,"11A");
        }
    }

    @Then("The user verifies the all functions of the a opened pop-up window")
    public void theUserVerifiesTheAllFunctionsOfTheAOpenedPopUpWindow(DataTable dtBtn) {
        List<String> popupTabMenu=new ArrayList<>();
        Collections.addAll(popupTabMenu,"Topic","Attachments","Recent Events");

        List<String> btn = dtBtn.asList();
        for (int i = 0; i < btn.size(); i++) {
            dialogContentElement.myClick(dialogContentElement.getWebElement(btn.get(i)));
            Assert.assertTrue(dialogContentElement.recordingBtn.isDisplayed());
            Assert.assertTrue(dialogContentElement.getWebElement(btn.get(i)).getText().contains(popupTabMenu.get(i)));
        }
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.recordingBtn));
        dialogContentElement.myClick(dialogContentElement.recordingBtn);
        dialogContentElement.wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.videoIframe));

        GWD.getDriver().switchTo().frame(0);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.playVideoBtn));
        Assert.assertTrue(dialogContentElement.playVideoBtn.isDisplayed());
        GWD.getDriver().switchTo().parentFrame();
        dialogContentElement.myClick(dialogContentElement.closeBtn);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.closeIconBtn));
        dialogContentElement.myClick(dialogContentElement.closeIconBtn);
    }

    @And("The user clicks on the Course Meeting that has not yet started")
    public void theUserClicksOnTheCourseMeetingThatHasNotYetStarted() {
        dialogContentElement.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("calendarURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("calendarURL")));

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.selectsLesson));
        dialogContentElement.myClick(dialogContentElement.selectsLesson);
    }

    @Then("The user verifies the Teacher's name, the Date and Time of the lesson, and warning message")
    public void theUserVerifiesTheTeacherSNameTheDateAndTimeOfTheLessonTheWarningMessage() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.teacherControlText));
        dialogContentElement.verifyContainsText(dialogContentElement.teacherControlText,"Teacher");
        dialogContentElement.verifyContainsText(dialogContentElement.dateControlText,"Date");

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.lessonMessage));
        dialogContentElement.verifyContainsText(dialogContentElement.lessonMessage,"not been started");
    }
}
