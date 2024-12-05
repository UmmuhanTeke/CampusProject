package stepDefinitions;

import io.cucumber.java.en.*;
import io.reactivex.rxjava3.exceptions.Exceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.ArrayList;
import java.util.Collections;
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
        topNavElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.sendMsgBtn));
    }

    @Then("The user clicks on the buttons and verifies")
    public void theUserClicksOnTheButtonsAndVerifies() {
        for (int i = 0; i < topNavElement.msgSubMenuList.size(); i++) {
            topNavElement.myClick(topNavElement.msgSubMenuList.get(i));
            topNavElement.myClick(topNavElement.hamburgerMenu);
            dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.textControl));
            topNavElement.hoverOver(topNavElement.messagingBtn);
            Assert.assertTrue(topNavElement.msgSubMenuList.get(i).isDisplayed());
        }
    }
}
