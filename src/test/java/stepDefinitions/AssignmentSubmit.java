package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.GWD;

public class AssignmentSubmit {
    DialogContent dialogContentElement=new DialogContent();
    TopNav topNavElement=new TopNav();
    Faker faker=new Faker();

    @Given("The user clicks on the Assignment button")
    public void theUserClicksOnTheAssignmentButton() {
        topNavElement.myClick(topNavElement.assignmentsMenu);
    }

    @When("The user clicks on the Submit button")
    public void theUserClicksOnTheSubmitButton() {
        dialogContentElement.wait.until(ExpectedConditions.urlContains("assignment"));
        dialogContentElement.myClick(dialogContentElement.fileSubmitBtn);
    }

    @Then("The user displays a text editor")
    public void theUserDisplaysATextEditorAndTypesText() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.textEditorControl));
        Assert.assertTrue(dialogContentElement.textEditorControl.isDisplayed());
    }

    @And("The user clicks on the Save as Draft button")
    public void theUserClicksOnTheSaveAsDraftButton() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.saveAsDraftBtn));
        dialogContentElement.jsClick(dialogContentElement.saveAsDraftBtn);
    }

    @Then("The user displays a Success message")
    public void theUserDisplaysASuccessMessage() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.draftSuccessfullyMsg));
        dialogContentElement.verifyContainsText(dialogContentElement.draftSuccessfullyMsg,"saved as a draft");
    }

    @And("The user types the message text and uploads the file by clicks on the Attach Files button")
    public void theUserTypesTheMessageTextAndUploadsTheFileByClicksOnTheAttachFilesButton() {
        GWD.getDriver().switchTo().frame(0);
        dialogContentElement.mySendKeys(dialogContentElement.textBox, faker.lorem().paragraph());
        GWD.getDriver().switchTo().parentFrame();

        dialogContentElement.myClick(dialogContentElement.attachFileBtn);
        dialogContentElement.myClick(dialogContentElement.myFilesBtn);

        dialogContentElement.wait.until(ExpectedConditions.elementToBeClickable(dialogContentElement.fileControl));
        dialogContentElement.robotExecute(9);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.selectBtn));
        dialogContentElement.myClick(dialogContentElement.selectButton);
    }

    @When("The user clicks on the Submit button at the text editor")
    public void theUserClicksOnTheSubmitButtonAtTheTextEditor() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.submitBtn));
        dialogContentElement.jsClick(dialogContentElement.submitBtn);
    }

    @And("The user clicks on the Yes button and displays Confirm message")
    public void theUserClicksOnTheYesButtonAndDisplaysConfirmMessage() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.yesButton));
        dialogContentElement.myClick(dialogContentElement.yesButton);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.submitMsgControl));
        dialogContentElement.verifyContainsText(dialogContentElement.submitMsgControl,"submitted to review");
    }

    @Given("The user is directed to homework Detail page")
    public void theUserIsOnAHomeworkSDetailPage() {
        dialogContentElement.myClick(dialogContentElement.assignmentsInfoBtn);
        dialogContentElement.wait.until(ExpectedConditions.urlContains("info"));
    }

    @When("The user clicks on the New Submission button")
    public void theUserClicksOnTheNewSubmissionButton() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.newSubmissionBtn));
        dialogContentElement.myClick(dialogContentElement.newSubmissionBtn);
    }

    @Then("The user verifies a text editor")
    public void aPopupTextEditorIsDisplayed() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.textEditorControl));
        Assert.assertTrue(dialogContentElement.textEditorControl.isDisplayed());
    }
}
