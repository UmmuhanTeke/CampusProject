package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessagingSubMenu {
     DialogContent dialogContentElement=new DialogContent();
     TopNav topNavElement=new TopNav();

    @When("The user hovers over the messaging link")
    public void theUserHoversOverTheMessagingLink() {
        topNavElement.hoverOver(topNavElement.messagingBtn);
        topNavElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.sendMsgBtn));
    }

    @Then("The user clicks on the buttons and verifies")
    public void theUserClicksOnTheButtonsAndVerifies() {
        List<String> containsURL =new ArrayList<>();
        Collections.addAll(containsURL,"new","inbox","outbox","trash");

        for (int i = 0; i < topNavElement.msgSubMenuList.size(); i++) {
            topNavElement.myClick(topNavElement.msgSubMenuList.get(i));
            topNavElement.myClick(topNavElement.hamburgerMenu);
            dialogContentElement.wait.until(ExpectedConditions.urlContains(containsURL.get(i)));
            topNavElement.hoverOver(topNavElement.messagingBtn);
            Assert.assertTrue(topNavElement.msgSubMenuList.get(i).isDisplayed());
        }
    }
}
