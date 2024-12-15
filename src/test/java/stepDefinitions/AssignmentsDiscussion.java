package stepDefinitions;

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

    @When("The user clicks on the Search button by selecting status Results Published and semester All options")
    public void theUserClicksOnTheSearchButtonBySelectingStatusResultsPublished() {
        dialogContentElement.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("assignmentURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("assignmentURL")));
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.overdueText));

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.statusMenu));
        dialogContentElement.myClick(dialogContentElement.statusMenu);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.publishedBtn));
        dialogContentElement.myClick(dialogContentElement.publishedBtn);
        dialogContentElement.myClick(dialogContentElement.resultsPublishedBtn);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.semesterMenu));
        dialogContentElement.myClick(dialogContentElement.semesterMenu);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.allBtn));
        dialogContentElement.myClick(dialogContentElement.allBtn);

        dialogContentElement.myClick(dialogContentElement.searchBtn);

    }

    @And("The user clicks on the Discussion icon to start a negotiation and verifies the Discussion window")
    public void theUserClicksOnTheDiscussionIconToStartANegotiationAndVerifiesTheDiscussionWindow() {
    }

    @When("The user clicks on the Contacts icon then selects randomly contacts")
    public void theUserClicksOnTheContactsIconThenSelectsRandomlyContacts() {
    }

    @And("The user clicks Attach Files icon to upload file and types text in Discussion chat")
    public void theUserClicksAttachFilesIconToUploadFileAndTypesTextInDiscussionChat() {
    }

    @Then("The user verifies the text of the Sent message and Date and Time")
    public void theUserVerifiesTheTextOfTheSentMessageAndDateAndTime() {
    }
}
