package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;
import pages.TopNav;

import java.util.Random;

public class ThemeFeature {
    DialogContent dialogContentElement=new DialogContent();
    TopNav topNavElement=new TopNav();
    Random random=new Random();

    @Given("The user clicks on on the Profile")
    public void theUserClicksOnOnTheProfile() {
        topNavElement.wait.until(ExpectedConditions.urlContains("user-courses"));
        topNavElement.myClick(topNavElement.profileBtn);
    }

    @And("The user clicks on the Settings link")
    public void theUserClicksOnTheSettingsLink() {
        topNavElement.wait.until(ExpectedConditions.visibilityOfAllElements(topNavElement.profileSettings));
        topNavElement.myClick(topNavElement.profileSettings);
    }

    @When("The user clicks on the Default Theme dropdown and selects a new theme")
    public void theUserClicksOnTheDefaultThemeDropdownAndSelectsANewTheme() {
        dialogContentElement.myClick(dialogContentElement.themeBtn);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.themeOptions));

        int randomIndex= random.nextInt(dialogContentElement.themeOptions.size());
        dialogContentElement.myClick(dialogContentElement.themeOptions.get(randomIndex));
    }

    @Then("The user clicks on the save button and displays Success message")
    public void theUserClicksOnTheSaveButtonAndDisplaysSuccessMessage() {
        dialogContentElement.myClick(dialogContentElement.saveBtn);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.updateMsg));
        dialogContentElement.verifyContainsText(dialogContentElement.updateMsg,"successfully updated");
    }
}
