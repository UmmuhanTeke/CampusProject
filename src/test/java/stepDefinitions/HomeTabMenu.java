package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeTabMenu {
    TopNav topNavElement=new TopNav();
    DialogContent dialogContentElement = new DialogContent();

    @When("The user verifies Header menu by clicking on the Header menu links")
    public void theUserVerifiesHeaderMenuByClickingOnTheHeaderMenuLinks(DataTable dt) {
        List<String>url=new ArrayList<>();
        Collections.addAll(url,"courses","calendar","attendance","assignment","grading");
        List<String> links=dt.asList(String.class);

        for (int i = 0; i < links.size(); i++) {
            topNavElement.jsClick(topNavElement.getWebElement(links.get(i)));
            topNavElement.wait.until(ExpectedConditions.urlContains(url.get(i)));
        }
    }

    @And("The user clicks on the Hamburger menu and Hamburger submenu")
    public void theUserClicksOnTheHamburgerMenuAndHamburgerSubmenu() {
        topNavElement.Wait(2);
        topNavElement.myClick(topNavElement.hamburgerMenu);

        List<String> containsURL =new ArrayList<>();
        Collections.addAll(containsURL,"new","inbox","outbox","trash");
        for (int i = 0; i < topNavElement.msgSubMenuList.size(); i++) {
            topNavElement.myClick(topNavElement.hamburgerMenu);
            topNavElement.hoverOver(topNavElement.msgSubMenuList.get(i));
            topNavElement.wait.until(ExpectedConditions.visibilityOfAllElements(topNavElement.msgSubMenuList));
            topNavElement.wait.until(ExpectedConditions.urlContains(containsURL.get(i)));
            Assert.assertTrue(topNavElement.msgSubMenuList.get(i).isDisplayed());
        }

        topNavElement.hoverOver(topNavElement.financeBtn);
        topNavElement.jsClick(topNavElement.myFinance);
        topNavElement.wait.until(ExpectedConditions.urlContains("finance"));

        topNavElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.hamburgerMenu));
        topNavElement.myClick(topNavElement.hamburgerMenu);
        topNavElement.hoverOver(topNavElement.attendanceBtn);
        topNavElement.jsClick(topNavElement.attendanceExcusesBtn);
        topNavElement.wait.until(ExpectedConditions.urlContains("attendance-excuse"));

        topNavElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.hamburgerMenu));
        topNavElement.myClick(topNavElement.hamburgerMenu);
        topNavElement.hoverOver(topNavElement.videoConference);
        topNavElement.wait.until(ExpectedConditions.visibilityOfAllElements(topNavElement.videoMeetingsBtn));
        topNavElement.jsClick(topNavElement.videoMeetingsBtn);
        topNavElement.wait.until(ExpectedConditions.urlContains("meetings"));

        topNavElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.hamburgerMenu));
        topNavElement.myClick(topNavElement.hamburgerMenu);
        topNavElement.hoverOver(topNavElement.surveysMenu);
        topNavElement.jsClick(topNavElement.mySurveysBtn);
        topNavElement.wait.until(ExpectedConditions.urlContains("surveys"));
    }

    @Then("The user verifies items in the upper right corner")
    public void theUserVerifiesItemsInTheUpperRightCorner() {

    }
}
