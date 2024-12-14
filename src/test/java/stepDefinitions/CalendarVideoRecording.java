package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;

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
        System.out.println(dialogContentElement.popUpVerify.getText());
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
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.videoPopUpVerify));
        dialogContentElement.verifyContainsText(dialogContentElement.videoPopUpVerify, "11A");
    }

    @Then("The user views the Play button in the course video and clicks on it")
    public void theUserViewsThePlayButtonInTheCourseVideoAndClicksOnIt() {
    }

    @And("The user clicks the Play icon and starts watching the video")
    public void theUserClicksThePlayIconAndStartsWatchingTheVideo() {
    }
}