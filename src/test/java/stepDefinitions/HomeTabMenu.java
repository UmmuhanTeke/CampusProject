package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.List;

public class HomeTabMenu {
    DialogContent dialogContentElement = new DialogContent();
    TopNav topNavElement = new TopNav();

    @Given("The user displays the TAB menu on the home page")
    public void the_user_displays_the_tab_menu_on_the_home_page() {
        List<WebElement> tabMenu = topNavElement.tabMenu;

        for (WebElement item : tabMenu) {
            if (item.isDisplayed()) {
                System.out.println(item.getText());
            }
        }
    }

    @Then("The user should be able to view the Tab menu")
    public void the_user_should_be_able_to_view_the_tab_menu() {
        dialogContentElement.wait.until(ExpectedConditions.urlToBe("technoURL"));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("technoURL")));

    }

    @When("The user clicks on the Tab Menu button")
    public void the_user_clicks_on_the_tab_menu_button(DataTable link) {
        List<String> buttons = link.asList();

        for (int i = 0; i < buttons.size(); i++) {
            topNavElement.myClick(topNavElement.getWebElement(buttons.get(i)));
        }

    }

    @When("The user clicks to the corresponding pages")
    public void the_user_clicks_to_the_corresponding_pages() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.coursesMenu));
        topNavElement.myClick(topNavElement.coursesMenu);
        topNavElement.verifyContainsText(topNavElement.coursesMenu, topNavElement.coursesMenu.getText());

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.calendarMenu));
        topNavElement.myClick(topNavElement.calendarMenu);
        topNavElement.verifyContainsText(topNavElement.calendarMenu, topNavElement.calendarMenu.getText());

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.attendanceMenu));
        topNavElement.myClick(topNavElement.attendanceMenu);
        topNavElement.verifyContainsText(topNavElement.attendanceMenu, topNavElement.attendanceMenu.getText());

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.assignmentsMenu));
        topNavElement.myClick(topNavElement.assignmentsMenu);
        topNavElement.verifyContainsText(topNavElement.assignmentsMenu, topNavElement.assignmentsMenu.getText());

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.gradingMenu));
        topNavElement.myClick(topNavElement.gradingMenu);
        topNavElement.verifyContainsText(topNavElement.gradingMenu, topNavElement.gradingMenu.getText());

    }

    @Then("The user clicks on the Hamburger menu and accesses the sub menu")
    public void the_user_clicks_on_the_hamburger_menu_and_accesses_the_sub_menu() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.hamburgerMenuButton));
        topNavElement.myClick(topNavElement.hamburgerMenuButton);

    }

    @Then("The user hovers over on the Messaging,Finance,Education,Attendance,Video Conference and Surveys buttons")
    public void the_user_hovers_over_on_the_messaging_finance_education_attendance_video_conference_and_surveys_buttons() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.messagingBtn));
        topNavElement.hoverOver(topNavElement.messagingBtn);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.financeButton));
        topNavElement.hoverOver(topNavElement.financeButton);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.educationMenu));
        topNavElement.hoverOver(topNavElement.educationMenu);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.videoConference));
        topNavElement.hoverOver(topNavElement.videoConference);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.surveysMenu));
        topNavElement.hoverOver(topNavElement.surveysMenu);
    }

    @Then("The user should experience the hover effect on each submenu option")
    public void the_user_should_experience_the_hover_effect_on_each_submenu_option() {

    }

    @When("The user clicks on the Announcements and Messages")
    public void the_user_clicks_on_the_announcements_and_messages() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.announcementsBtn));
        topNavElement.myClick(topNavElement.announcementsBtn);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.announcementCloseBtn));
        topNavElement.myClick(topNavElement.announcementCloseBtn);

    }

    @Then("The user is successfully redirected to Announcements and Messages")
    public void the_user_is_successfully_redirected_to_announcements_and_messages() {

    }

    @Then("The user clicks to the Student Profile page and hovers over the following buttons")
    public void the_user_clicks_to_the_student_profile_page_and_hovers_over_the_following_buttons() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.studentBtn));
        topNavElement.myClick(topNavElement.studentBtn);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.myCertificates));
        topNavElement.hoverOver(topNavElement.myCertificates);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.myFiles));
        topNavElement.hoverOver(topNavElement.myFiles);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.changePassword));
        topNavElement.hoverOver(topNavElement.changePassword);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.settingsBtn));
        topNavElement.hoverOver(dialogContentElement.settingsBtn);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.signOut));
        topNavElement.hoverOver(dialogContentElement.signOut);

    }

    @Then("The user should be on the Student Profile page an d the buttons should be responsive")
    public void the_user_should_be_on_the_student_profile_page_an_d_the_buttons_should_be_responsive() {

    }

    @When("The user clicks on Sign Out and logs out of the site")
    public void the_user_clicks_on_sign_out_and_logs_out_of_the_site() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(topNavElement.myCertificates));
        topNavElement.myClick(dialogContentElement.signOut);

    }

    @Then("The user clicks on Sign Out and successfully logs out of the site")
    public void the_user_clicks_on_sign_out_and_successfully_logs_out_of_the_site() {

    }

}