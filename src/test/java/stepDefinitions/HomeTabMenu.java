package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.TopNav;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeTabMenu {
    TopNav topNavElement=new TopNav();

    @When("The user verifies Header menu by clicking on the Header menu links")
    public void theUserVerifiesHeaderMenuByClickingOnTheHeaderMenuLinks(DataTable dt) {
        List<String>url=new ArrayList<>();
        Collections.addAll(url,"courses","calendar","attendance","assignment","grading");

        List<String> links=dt.asList(String.class);
        for (int i = 0; i < links.size(); i++) {
            System.out.println("? : "+topNavElement.getWebElement(links.get(i)).isDisplayed());
            //topNavElement.wait.until(ExpectedConditions.visibilityOfAllElements(topNavElement.getWebElement(links.get(i))));
            topNavElement.myClick(topNavElement.getWebElement(links.get(i)));
            topNavElement.wait.until(ExpectedConditions.urlContains(url.get(i)));
        }
    }

    @And("The user clicks on the Hamburger menu and Hamburger submenu")
    public void theUserClicksOnTheHamburgerMenuAndHamburgerSubmenu() {

    }

    @Then("The user verifies items in the upper right corner")
    public void theUserVerifiesItemsInTheUpperRightCorner() {

    }
}
