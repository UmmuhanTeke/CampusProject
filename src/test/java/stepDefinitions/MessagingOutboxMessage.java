package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;

public class MessagingOutboxMessage {
    DialogContent dialogContentElement = new DialogContent();

    @When("The user clicks the Yes button in the confirm window by clicking on the Move to Trash icon")
    public void theUserClicksTheYesButtonInTheConfirmWindowByClickingOnTheMoveToTrashIcon() {
        dialogContentElement.myClick(dialogContentElement.moveToTrashIcon.getFirst());

        dialogContentElement.Wait(3);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.confirmTitleText));
        dialogContentElement.verifyContainsText(dialogContentElement.confirmTitleText,"Confirm");

        dialogContentElement.Wait(3);
        dialogContentElement.jsClick(dialogContentElement.yesButton);

    }

    @Then("The user verifies the confirmation message")
    public void theUserVerifiesTheConfirmationMessage() {
    }
}
