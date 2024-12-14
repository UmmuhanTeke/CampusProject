package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.GWD;

import java.util.List;
import java.util.Random;

public class CalendarVideoRecording {
    DialogContent dialogContentElement = new DialogContent();
    Random random = new Random();

    @When("The user clicks on a completed \\(E) course")
    public void theUserClicksOnACompletedECourse() {
        List<WebElement> endedLessons = dialogContentElement.endedLessonBtn;
        int randomIndex = random.nextInt(endedLessons.size());
        dialogContentElement.myClick(endedLessons.get(randomIndex));
        dialogContentElement.verifyContainsText(dialogContentElement.popUpVerify, "Information");
        dialogContentElement.myClick(endedLessons.get(randomIndex));
    }

    @Then("The user views the Recording button to access the course recording and clicks on it")
    public void theUserViewsTheRecordingButtonToAccessTheCourseRecordingAndClicksOnIt(DataTable recordingBtn) {
        List<String> recordingButton = recordingBtn.asList();

        for (int i = 0; i < recordingButton.size(); i++) {
            dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.recordingButton));
            dialogContentElement.myClick(dialogContentElement.getWebElement(recordingButton.get(i)));
        }
    }

    @And("The user accesses the course video")
    public void theUserAccessesTheCourseVideo() {
        dialogContentElement.wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.videoIframe));
        GWD.getDriver().switchTo().frame(0);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.playVideoBtn));
    }

    @Then("The user views the Play button in the course video and clicks on it")
    public void theUserViewsThePlayButtonInTheCourseVideoAndClicksOnIt() {
        Assert.assertTrue(dialogContentElement.playVideoBtn.isDisplayed());
        dialogContentElement.myClick(dialogContentElement.playVideoBtn);
    }

    @And("The user starts watching the video")
    public void theUserClicksThePlayIconAndStartsWatchingTheVideo() {
        dialogContentElement.Wait(10); //The time allocated to watch the video
        GWD.getDriver().switchTo().parentFrame();
    }
}