package stepDefinitions;

import io.cucumber.java.en.*;
import pages.DialogContent;
import pages.TopNav;

public class MessagingTrashMessage {

    DialogContent dialogContentElement=new DialogContent();
    TopNav topNavElement=new TopNav();

    @And("The user clicks on the trash button")
    public void theUserClicksOnTheTrashButton() {
    }

    @When("The user views the list of deleted messages")
    public void theUserViewsTheListOfDeletedMessages() {
    }

    @Then("The user should display Delete and Restore options for each message")
    public void theUserShouldDisplayDeleteAndRestoreOptionsForEachMessage() {
    }

    @When("The user clicks the Restore button for a message")
    public void theUserClicksTheRestoreButtonForAMessage() {
    }

    @Then("The message should be successfully restored with a Success message")
    public void theMessageShouldBeSuccessfullyRestoredWithAMessage() {
    }

    @When("The user clicks the Delete button for a message")
    public void theUserClicksTheDeleteButtonForAMessage() {
    }

    @And("confirms the action in the confirmation popup")
    public void confirmsTheActionInTheConfirmationPopup() {
    }

    @Then("The message should be permanently deleted with a Success message")
    public void theMessageShouldBePermanentlyDeletedWithAMessage() {
    }
}
