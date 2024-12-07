package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

public class CampusLogin {
    DialogContent dialogContentElement=new DialogContent();

    @When("The user types invalid username and password")
    public void theUserTypesInvalidUsernameAndPassword() {
        dialogContentElement.mySendKeys(dialogContentElement.usernameInput, ConfigReader.getProperty("invalidUserName"));
        dialogContentElement.mySendKeys(dialogContentElement.passwordInput, ConfigReader.getProperty("invalidPassword"));
    }

    @And("The user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        dialogContentElement.myClick(dialogContentElement.loginBtn);
    }

    @Then("The user verifies warning message")
    public void theUserVerifiesWarningMessage() {
        dialogContentElement.verifyContainsText(dialogContentElement.invalidMessage, "Invalid username or password");
    }

    @Given("Navigate to Campus")
    public void navigateToCampus() {
        GWD.getDriver().get(ConfigReader.getProperty("URL"));
    }

    @When("The user types username and password and click login button")
    public void theUserTypesUsernameAndPasswordAndClickLoginButton() {
        dialogContentElement.mySendKeys(dialogContentElement.usernameInput, ConfigReader.getProperty("username"));
        dialogContentElement.mySendKeys(dialogContentElement.passwordInput, ConfigReader.getProperty("password"));
        dialogContentElement.myClick(dialogContentElement.loginBtn);
    }

    @Then("The user verifies login successfully")
    public void theUserVerifiesLoginSuccessfully() {
        dialogContentElement.verifyContainsText(dialogContentElement.loginControl, "Welcome");
    }
}
