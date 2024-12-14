package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;
import pages.TopNav;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeTabMenu {
    TopNav topNavElement = new TopNav();
    DialogContent dialogContentElement = new DialogContent();

    @When("The user verifies Header menu by clicking on the Header menu links")
    public void theUserVerifiesHeaderMenuByClickingOnTheHeaderMenuLinks(DataTable dt) {
        List<String> url = new ArrayList<>();
        Collections.addAll(url, "courses", "calendar", "attendance", "assignment", "grading");
        List<String> links = dt.asList(String.class);

        for (int i = 0; i < links.size(); i++) {
            topNavElement.jsClick(topNavElement.getWebElement(links.get(i)));
            topNavElement.wait.until(ExpectedConditions.urlContains(url.get(i)));
        }
    }

    @And("The user clicks on the Hamburger menu and Hamburger submenu")
    public void theUserClicksOnTheHamburgerMenuAndHamburgerSubmenu() {

        List<String> containsURL = new ArrayList<>();
        Collections.addAll(containsURL, "new", "inbox", "outbox", "trash");
        for (int i = 0; i < 4; i++) {
            topNavElement.myClick(topNavElement.hamburgerMenu);
            topNavElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.messagingBtn));
            topNavElement.hoverOver(topNavElement.messagingBtn);
            topNavElement.wait.until(ExpectedConditions.visibilityOfAllElements(topNavElement.msgSubMenuList));
            topNavElement.myClick(topNavElement.msgSubMenuList.get(i));
            topNavElement.wait.until(ExpectedConditions.urlContains(containsURL.get(i)));
        }

        topNavElement.myClick(topNavElement.hamburgerMenu);
        topNavElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.financeBtn));
        topNavElement.hoverOver(topNavElement.financeBtn);
        topNavElement.jsClick(topNavElement.myFinance);
        topNavElement.wait.until(ExpectedConditions.urlContains("finance"));

        topNavElement.myClick(topNavElement.hamburgerMenu);
        topNavElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.attendanceBtn));
        topNavElement.hoverOver(topNavElement.attendanceBtn);
        topNavElement.jsClick(topNavElement.attendanceExcusesBtn);
        topNavElement.wait.until(ExpectedConditions.urlContains("attendance-excuse"));
        dialogContentElement.wait.until(ExpectedConditions.invisibilityOf(dialogContentElement.toolTipBar));

        topNavElement.myClick(topNavElement.hamburgerMenu);
        topNavElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.videoConference));
        topNavElement.hoverOver(topNavElement.videoConference);
        topNavElement.wait.until(ExpectedConditions.visibilityOfAllElements(topNavElement.videoMeetingsBtn));
        topNavElement.jsClick(topNavElement.videoMeetingsBtn);
        topNavElement.wait.until(ExpectedConditions.urlContains("meetings"));

        topNavElement.myClick(topNavElement.hamburgerMenu);
        topNavElement.wait.until(ExpectedConditions.visibilityOfAllElements(topNavElement.surveysMenu));
        topNavElement.hoverOver(topNavElement.surveysMenu);
        topNavElement.jsClick(topNavElement.mySurveysBtn);
        topNavElement.wait.until(ExpectedConditions.urlContains("surveys"));
    }

    @Then("The user verifies items in the upper right corner")
    public void theUserVerifiesItemsInTheUpperRightCorner() {
        topNavElement.clickAndEsc(topNavElement.notificationBtn,topNavElement.dialogTitle);
        topNavElement.clickAndEsc(topNavElement.messagesBtn,topNavElement.userMessageList);

        topNavElement.myClick(topNavElement.profileBtn);
        topNavElement.myClick(topNavElement.myCertificates);
        topNavElement.wait.until(ExpectedConditions.urlContains("my-certificates"));

        topNavElement.myClick(topNavElement.profileBtn);
        topNavElement.clickAndEsc(topNavElement.myFiles,topNavElement.dialogTitle);

        topNavElement.myClick(topNavElement.profileBtn);
        topNavElement.myClick(topNavElement.changePassword);
        topNavElement.wait.until(ExpectedConditions.visibilityOfAllElements(topNavElement.passwordChangedInput));
        topNavElement.myClick(topNavElement.closeBtn);

        topNavElement.myClick(topNavElement.profileBtn);
        topNavElement.clickAndEsc(topNavElement.profileSettings,topNavElement.dialogTitle);
    }
}
