package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.List;
import java.util.Random;

public class MessagingSendMessage {
    DialogContent dialogContentElement = new DialogContent();
    TopNav topNavElement = new TopNav();
    Random random = new Random();


    @When("The user click send message")
    public void theUserClickSendMessage(DataTable dtBtn) {
        List<String> btn = dtBtn.asList();

        for (int i = 0; i < btn.size(); i++) {
            topNavElement.myClick(topNavElement.getWebElement(btn.get(i)));
            Assert.assertTrue(topNavElement.sendMsgBtn.isDisplayed());
            topNavElement.verifyEqualsText(topNavElement.sendMsgBtn, "Send Message");
        }
    }

    @Then("The user types and selects the receivers by clicking on the Add Receivers icon")
    public void theUserTypesAndSelectsTheReceiversByClickingOnTheAddReceiversIcon(DataTable sendText) {
        List<List<String>> sendKey = sendText.asLists();

        topNavElement.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("sendURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("sendURL")));

        if (dialogContentElement.addReceiver.isDisplayed()) {
            dialogContentElement.myClick(dialogContentElement.addReceiver);
            for (int i = 0; i < sendKey.size(); i++) {
                WebElement box = dialogContentElement.getWebElement(sendKey.get(i).get(0));
                dialogContentElement.mySendKeys(box, sendKey.get(i).get(1));
                dialogContentElement.wait.until(ExpectedConditions.textToBePresentInElement(dialogContentElement.teacherTextControl, "Teacher"));

                if (dialogContentElement.teacherTextControl.isDisplayed()) {
                    int randomIndex = random.nextInt(8) + 1;
                    new Actions(GWD.getDriver()).click(dialogContentElement.checkBoxList.get(randomIndex)).perform();
                    dialogContentElement.myClick(dialogContentElement.addAndCloseBtn);
                }
            }
        }
    }

    @And("The user selects the message types and types the subject for it")
    public void theUserSelectsTheMessageTypesAndTypesTheSubjectForIt() {
    }

    @Then("The user types the message text and uploads the file by clicking on the Attach Files button")
    public void theUserTypesTheMessageTextAndUploadsTheFileByClickingOnTheAttachFilesButton() {
    }

    @And("The user clicks on the save button and verifies the confirmation message")
    public void theUserClicksOnTheSaveButtonAndVerifiesTheConfirmationMessage() {
    }

    @When("The user click outbox message and verifies the outbox message list")
    public void theUserClickOutboxMessageAndVerifiesTheOutboxMessageList(DataTable dtBtn) {
        topNavElement.myClick(topNavElement.hamburgerMenu);
        topNavElement.hoverOver(topNavElement.messagingBtn);
    }
}
