package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.Random;

public class AssignmentsDiscussion {
    DialogContent dialogContentElement = new DialogContent();
    Random random = new Random();
    Faker faker = new Faker();

    @When("The user clicks on the Search button by selecting status Results Published and semester All options")
    public void theUserClicksOnTheSearchButtonBySelectingStatusResultsPublished() {
        dialogContentElement.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("assignmentURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("assignmentURL")));

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.statusMenu));
        dialogContentElement.myClick(dialogContentElement.statusMenu);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.resultsPublishedBtn));
        dialogContentElement.myClick(dialogContentElement.resultsPublishedBtn);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.semesterMenu));
        dialogContentElement.jsClick(dialogContentElement.semesterMenu);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.allBtn));
        dialogContentElement.myClick(dialogContentElement.allBtn);
    }

    @And("The user clicks on the Discussion icon to start a negotiation and verifies the Discussion window")
    public void theUserClicksOnTheDiscussionIconToStartANegotiationAndVerifiesTheDiscussionWindow() {
        if (dialogContentElement.overdueText.isDisplayed()){
            if (!dialogContentElement.discussionBtn.isEmpty()){
                int randomIndex= random.nextInt(dialogContentElement.discussionBtn.size());
                dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.discussionBtn));
                dialogContentElement.jsClick(dialogContentElement.discussionBtn.get(randomIndex));
            }
        }
    }

    @When("The user clicks on the Contacts icon then selects randomly contacts")
    public void theUserClicksOnTheContactsIconThenSelectsRandomlyContacts() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.contactIcon));
        if (dialogContentElement.contactIcon.isDisplayed()){
            dialogContentElement.jsClick(dialogContentElement.contactIcon);
            dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.contactsList));
            int randomIndex= random.nextInt(dialogContentElement.contactsList.size());
            dialogContentElement.jsClick(dialogContentElement.contactsList.get(randomIndex));
        }
    }

    @And("The user clicks Attach Files icon to upload file and types text in Discussion chat")
    public void theUserClicksAttachFilesIconToUploadFileAndTypesTextInDiscussionChat() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.attachIconChat));
        dialogContentElement.myClick(dialogContentElement.attachIconChat);
        dialogContentElement.robotExecute(1);
        dialogContentElement.uploadFilePath("C:\\Users\\User\\IdeaProjects\\Campus_Project\\src\\test\\resources\\campus2photo.png");

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.discussionFileText));
        if (dialogContentElement.discussionFileText.isDisplayed()){
            dialogContentElement.verifyContainsText(dialogContentElement.discussionFileText,"png");
        }

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.textBoxChat));
        dialogContentElement.mySendKeys(dialogContentElement.textBoxChat,faker.lorem().sentence());
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.sendIcon));
        dialogContentElement.myClick(dialogContentElement.sendIcon);
    }

    @Then("The user verifies the text of the Sent message and Date and Time")
    public void theUserVerifiesTheTextOfTheSentMessageAndDateAndTime() {
    }
}
