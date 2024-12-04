package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.List;


public class MessagingSubMenu {
     DialogContent dialogContentElement=new DialogContent();
     TopNav topNavElement=new TopNav();

    @Given("Navigate to campus")
    public void navigateToCampus() {
        GWD.getDriver().get(ConfigReader.getProperty("URL"));
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        dialogContentElement.mySendKeys(dialogContentElement.usernameInput,ConfigReader.getProperty("username") );
        dialogContentElement.mySendKeys(dialogContentElement.passwordInput,ConfigReader.getProperty("password") );
        dialogContentElement.myClick(dialogContentElement.loginBtn);
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        dialogContentElement.verifyContainsText(dialogContentElement.loginControl,"Welcome,");
    }

    @Given("The user clicks on the hamburger menu")
    public void theUserClicksOnTheHamburgerMenu() {
        topNavElement.myClick(topNavElement.hamburgerMenu);
    }

    @When("The user hovers over the messaging link")
    public void theUserHoversOverTheMessagingLink() {
        topNavElement.hoverOver(topNavElement.messagingBtn);
    }

    @Then("The user clicks on the buttons and verifies")
    public void theUserClicksOnTheButtonsAndVerifies() {
//        topNavElement.myClick(topNavElement.sendMsgBtn);
//        System.out.println(dialogContentElement.msgSubMenuControl.getText());
//        System.out.println(GWD.getDriver().getCurrentUrl());
//        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("new"));
//        topNavElement.myClick(topNavElement.hamburgerMenu);
//        topNavElement.hoverOver(topNavElement.messagingBtn);
//        topNavElement.myClick(topNavElement.inboxBtn);
//        topNavElement.verifyContainsText(dialogContentElement.msgSubMenuControl," Inbox ");
//        topNavElement.myClick(topNavElement.hamburgerMenu);
//        topNavElement.hoverOver(topNavElement.messagingBtn);
//        topNavElement.myClick(topNavElement.outboxBtn);
//        topNavElement.verifyContainsText(dialogContentElement.msgSubMenuControl," Outbox ");
//        topNavElement.myClick(topNavElement.hamburgerMenu);
//        topNavElement.hoverOver(topNavElement.messagingBtn);
//        topNavElement.myClick(topNavElement.trashBtn);
//        topNavElement.verifyContainsText(dialogContentElement.msgSubMenuControl," Trash ");
    }
}
