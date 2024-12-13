package stepDefinitions;

import io.cucumber.java.en.*;
import pages.DialogContent;
import pages.TopNav;

import java.util.Random;

public class CalendarVideoRecording {
    DialogContent dialogContentElement = new DialogContent();
    TopNav topNavElement = new TopNav();
    Random random = new Random();

    @When("The user clicks on a completed \\(E) course")
    public void theUserClicksOnACompletedECourse() {
    }

    @Then("The user views the Recording button to access the course recording and clicks on it")
    public void theUserViewsTheRecordingButtonToAccessTheCourseRecordingAndClicksOnIt() {
    }

    @And("The user accesses the course video")
    public void theUserAccessesTheCourseVideo() {
    }

    @Then("The user views the Play button in the course video and clicks on it")
    public void theUserViewsThePlayButtonInTheCourseVideoAndClicksOnIt() {
    }

    @And("The user clicks the Play icon and starts watching the video")
    public void theUserClicksThePlayIconAndStartsWatchingTheVideo() {
    }
}
