package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;
import pages.TopNav;

public class AttendanceFeature {
    DialogContent dialogContentElement=new DialogContent();
    TopNav topNavElement=new TopNav();
    Faker faker=new Faker();

    @Given("The user clicks the Attendance link on the homepage")
    public void theUserClicksTheAttendanceLinkOnTheHomepage() {
        topNavElement.myClick(topNavElement.attendanceMenu);
    }

    @Then("The user is redirected to the Attendance Excuse page")
    public void theUserIsRedirectedToTheAttendanceExcusePage() {
        dialogContentElement.wait.until(ExpectedConditions.urlContains("attendance"));
        dialogContentElement.wait.until(ExpectedConditions.invisibilityOf(dialogContentElement.toolTipBar));
        dialogContentElement.myClick(dialogContentElement.attendanceExcusesBtn);
        dialogContentElement.myClick(dialogContentElement.addButton);
    }

    @When("The user types an excuse and attaches a file")
    public void theUserTypesAnExcuseAndAttachesAFile() {
        dialogContentElement.mySendKeys(dialogContentElement.inputMessage,faker.lorem().paragraph());

        dialogContentElement.jsClick(dialogContentElement.attachFileBtn);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.myFilesBtn));
        dialogContentElement.myClick(dialogContentElement.myFilesBtn);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.checkBox));
        dialogContentElement.myClick(dialogContentElement.checkBox);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.selectBtn));
        dialogContentElement.jsClick(dialogContentElement.myDriveSelect);
    }

    @And("The user submits the excuse")
    public void theUserSubmitsTheExcuse() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.sendBtn));
        dialogContentElement.jsClick(dialogContentElement.sendBtn);
    }

    @Then("The user views a confirmation message")
    public void theUserViewsAConfirmationMessage() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.excuseConfirmMsg));
        dialogContentElement.verifyContainsText(dialogContentElement.excuseConfirmMsg,"Excuse successfully");
    }
}
