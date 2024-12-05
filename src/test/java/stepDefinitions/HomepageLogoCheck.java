package stepDefinitions;

import io.cucumber.java.en.*;
import pages.DialogContent;
import pages.TopNav;
import utilities.ConfigReader;
import utilities.GWD;

public class HomepageLogoCheck {
    DialogContent dialogContentElement=new DialogContent();
    TopNav topNavElement=new TopNav();

    @Given("The user navigates to the Campus website")
    public void theUserNavigatesToTheCampusWebsite() {
        GWD.getDriver().get(ConfigReader.getProperty("URL"));
    }

    @When("The user logs in to the system with a valid username and password")
    public void theUserLogsInToTheSystemWithAValidUsernameAndPassword() {
        dialogContentElement.mySendKeys(dialogContentElement.usernameInput,ConfigReader.getProperty("username") );
        dialogContentElement.mySendKeys(dialogContentElement.passwordInput,ConfigReader.getProperty("password") );
        dialogContentElement.myClick(dialogContentElement.loginBtn);
    }

    @Then("The user verifies that they have successfully logged into the Campus website")
    public void theUserVerifiesLoggedInSuccessfully() {
        dialogContentElement.verifyContainsText(dialogContentElement.loginControl,"Welcome,");
    }

    @And("The user Techno Study website logo is displayed in the top left corner")
    public void theUserTechnoStudyWebsiteLogoIsDisplayedInTheTopLeftCorner() {
    }

    @When("The user clicks on the Techno Study website logo")
    public void theUserClicksOnTheTechnoStudyWebsiteLogo() {
    }

    @Then("The user checks the redirected page using the URL")
    public void theUserChecksTheRedirectedPageUsingTheURL() {
    }
}