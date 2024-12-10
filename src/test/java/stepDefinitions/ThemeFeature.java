package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ThemeFeature {
    DialogContent dialogContentElement=new DialogContent();
    TopNav topNavElement=new TopNav();
    Random random=new Random();

    @Given("The user clicks on the Profile and selects the Settings link in the Profile menu")
    public void theUserClicksOnOnTheProfile() {
        topNavElement.wait.until(ExpectedConditions.urlContains("user-courses"));
        topNavElement.myClick(topNavElement.profileBtn);

        topNavElement.wait.until(ExpectedConditions.visibilityOfAllElements(topNavElement.profileSettings));
        topNavElement.myClick(topNavElement.profileSettings);
    }

    @When("The user clicks on the Default Theme dropdown and selects a new theme")
    public void theUserClicksOnTheDefaultThemeDropdownAndSelectsANewTheme() {
        dialogContentElement.myClick(dialogContentElement.themeBtn);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.themeOptions));

        dialogContentElement.jsClick(dialogContentElement.themeControlText);
        int randomIndex= random.nextInt(dialogContentElement.themeOptions.size());
        String text=dialogContentElement.themeOptions.get(randomIndex).getText();
        dialogContentElement.myClick(dialogContentElement.themeOptions.get(randomIndex));

        dialogContentElement.verifyContainsText(dialogContentElement.themeControlText, text);

        List<String> themeCode=new ArrayList<>();
        Collections.addAll(themeCode,"#6a1b9a","#673ab7","#361e54","#3f51b5");
        for (String theme : themeCode){
            if (dialogContentElement.jsColor("--mat-toolbar-container-background-color",dialogContentElement.topBar).trim().equals(theme)){
                Assert.assertEquals(theme,dialogContentElement.jsColor("--mat-toolbar-container-background-color",dialogContentElement.topBar));
                break;
            }
        }
    }

    @Then("The user clicks on the save button and displays Success message")
    public void theUserClicksOnTheSaveButtonAndDisplaysSuccessMessage() {
        dialogContentElement.myClick(dialogContentElement.saveBtn);

        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.updateMsg));
        dialogContentElement.verifyContainsText(dialogContentElement.updateMsg,"successfully updated");
    }
}
