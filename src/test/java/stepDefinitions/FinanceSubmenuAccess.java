package stepDefinitions;

import io.cucumber.java.en.*;
import pages.DialogContent;
import pages.TopNav;

public class FinanceSubmenuAccess {
    DialogContent dialogContentElement=new DialogContent();
    TopNav topNavElement=new TopNav();

    @And("The user clicks on the Hamburger menu")
    public void theUserClicksOnTheHamburgerMenu() {
    }

    @Then("The user views the submenus in the Hamburger menu")
    public void theUserViewsTheSubmenusInTheHamburgerMenu() {
    }

    @And("The user hovers over the Finance button in the Hamburger menu")
    public void theUserHoversOverTheFinanceButtonInTheHamburgerMenu() {
    }

    @Then("The user views the My Finance submenu")
    public void theUserViewsTheMyFinanceSubmenu() {
    }

    @When("The user clicks the My Finance button")
    public void theUserClicksTheMyFinanceButton() {
    }

    @Then("The user checks that they are redirected to the My Finance page")
    public void theUserChecksThatTheyAreRedirectedToTheMyFinancePage() {
    }
}