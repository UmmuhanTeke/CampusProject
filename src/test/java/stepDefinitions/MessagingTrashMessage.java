package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;

public class MessagingTrashMessage {

    DialogContent dialogContentElement=new DialogContent();

    @And("The user clicks on the trash button")
    public void theUserClicksOnTheTrashButton() {
        dialogContentElement.myClick(dialogContentElement.trashBoxBtn);
    }

    @Then("The user should display Delete and Restore options for each message")
    public void theUserShouldDisplayDeleteAndRestoreOptionsForEachMessage() {
        dialogContentElement.wait.until(ExpectedConditions.urlContains("trash"));
        dialogContentElement.wait.until(ExpectedConditions.elementToBeClickable(dialogContentElement.deleteIcon));
        dialogContentElement.deleteIcon.isDisplayed();
        dialogContentElement.restoreIcon.isDisplayed();
    }

    @When("The user clicks the Restore button for a message")
    public void theUserClicksTheRestoreButtonForAMessage() {
        dialogContentElement.myClick(dialogContentElement.restoreIcon);
    }

    @Then("The message should be successfully restored with a Success message")
    public void theMessageShouldBeSuccessfullyRestoredWithAMessage() {
        dialogContentElement.verifyContainsText(dialogContentElement.msgControl,"Message successfully");
    }

    @When("The user clicks the Delete button for a message")
    public void theUserClicksTheDeleteButtonForAMessage() {
        dialogContentElement.myClick(dialogContentElement.deleteIcon);
    }

    @And("confirms the action in the confirmation popup")
    public void confirmsTheActionInTheConfirmationPopup() {
        dialogContentElement.myClick(dialogContentElement.deleteBtn);
    }

    @Then("The message should be permanently deleted with a Success message")
    public void theMessageShouldBePermanentlyDeletedWithAMessage() {
        dialogContentElement.verifyContainsText(dialogContentElement.msgControl,"Message successfully");
    }
}
