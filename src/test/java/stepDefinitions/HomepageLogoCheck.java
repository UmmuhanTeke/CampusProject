package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.Set;

public class HomepageLogoCheck {
    DialogContent dialogContentElement = new DialogContent();
    TopNav topNavElement = new TopNav();

    @Given("The user is on the Campus homepage")
    public void theUserNavigatesToTheCampusWebsite() {
        dialogContentElement.verifyContainsText(dialogContentElement.loginControl, "Welcome,");
    }

    @And("The user Techno Study website logo is displayed in the top left corner")
    public void theUserTechnoStudyWebsiteLogoIsDisplayedInTheTopLeftCorner() {
        Assert.assertTrue(topNavElement.homepageLogo.isDisplayed());
    }

    @When("The user clicks on the Techno Study website logo")
    public void theUserClicksOnTheTechnoStudyWebsiteLogo() {
        topNavElement.myClick(topNavElement.homepageLogo);
    }

    @Then("The user checks the redirected page using the URL")
    public void theUserChecksTheRedirectedPageUsingTheURL() {
        String homepageHandle = GWD.getDriver().getWindowHandle();
        Set<String> handles = GWD.getDriver().getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(homepageHandle)) {
                GWD.getDriver().switchTo().window(handle);
                topNavElement.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("technoURL")));
                Assert.assertTrue(GWD.getDriver().getCurrentUrl().equalsIgnoreCase(ConfigReader.getProperty("technoURL")));
            }
        }
    }
}