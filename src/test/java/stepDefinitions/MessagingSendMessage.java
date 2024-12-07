package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
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
    Faker faker = new Faker();

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
            }

            dialogContentElement.wait.until(ExpectedConditions.elementToBeClickable(dialogContentElement.studentControl));
            dialogContentElement.Wait(3);

            int randomIndex = random.nextInt(dialogContentElement.checkBoxList.size()) + 1;
            dialogContentElement.myClick(dialogContentElement.checkBoxList.get(randomIndex));
            dialogContentElement.myClick(dialogContentElement.addAndCloseBtn);
        }
        dialogContentElement.verifyContainsText(dialogContentElement.successMsg, "successfully");
        dialogContentElement.verifyContainsText(dialogContentElement.studentTextControl, "Student");
    }

    @And("The user selects the message types and types the subject for it")
    public void theUserSelectsTheMessageTypesAndTypesTheSubjectForIt() {
        dialogContentElement.myClick(dialogContentElement.selectBtn);
        dialogContentElement.myClick(dialogContentElement.emailBtn);

        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).perform();
        dialogContentElement.mySendKeys(dialogContentElement.subjectBox, faker.lorem().sentence());
    }

    @Then("The user types the message text and uploads the file by clicking on the Attach Files button")
    public void theUserTypesTheMessageTextAndUploadsTheFileByClickingOnTheAttachFilesButton() {
        GWD.getDriver().switchTo().frame(0);
        dialogContentElement.mySendKeys(dialogContentElement.textBox, faker.lorem().paragraph());
        GWD.getDriver().switchTo().parentFrame();

        dialogContentElement.myClick(dialogContentElement.attachFileBtn);
        dialogContentElement.myClick(dialogContentElement.myFilesBtn);

        dialogContentElement.wait.until(ExpectedConditions.elementToBeClickable(dialogContentElement.fileControl));
        dialogContentElement.Wait(3);
        int indexRandom = random.nextInt(dialogContentElement.checkBoxList.size()) + 1;
        dialogContentElement.myClick(dialogContentElement.checkBoxList.get(indexRandom));
        dialogContentElement.myClick(dialogContentElement.selectButton);
    }

    @And("The user clicks on the save button and verifies the confirmation message")
    public void theUserClicksOnTheSaveButtonAndVerifiesTheConfirmationMessage() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.appearFileControl));
        if (dialogContentElement.appearFileControl.isDisplayed()) {
            dialogContentElement.jsClick(dialogContentElement.sendBtn);
        }
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.sendConfirmMessage));
        dialogContentElement.verifyContainsText(dialogContentElement.sendConfirmMessage, "Successfully");
    }

    @When("The user click outbox message and verifies the outbox message list")
    public void theUserClickOutboxMessageAndVerifiesTheOutboxMessageList(DataTable dtBtn) {
        List<String> btn = dtBtn.asList();

        for (int i = 0; i < btn.size(); i++) {
            topNavElement.myClick(topNavElement.getWebElement(btn.get(i)));
            Assert.assertTrue(topNavElement.outboxBtn.isDisplayed());
            topNavElement.verifyEqualsText(topNavElement.outboxBtn, "Outbox");
        }

        topNavElement.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("outboxURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("outboxURL")));

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.outboxMsgControl));
        dialogContentElement.outboxMsgControl.isDisplayed();
    }
}
