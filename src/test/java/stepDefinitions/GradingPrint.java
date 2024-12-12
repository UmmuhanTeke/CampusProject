package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.GWD;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;

public class GradingPrint {
    DialogContent dialogContentElement = new DialogContent();
    TopNav topNavElement = new TopNav();
    String downloadDir = System.getProperty("user.home") + "/Downloads";

    @Given("The user clicks on the Grading button")
    public void theUserClicksOnTheGradingButton() {
        topNavElement.myClick(topNavElement.gradingMenu);
    }

    @Then("The user views a Print icon and clicks on the Download button")
    public void theUserViewsAPrintIconAndClicksOnTheDownloadButton() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOfAllElements(dialogContentElement.printButton));
        Assert.assertTrue(dialogContentElement.printButton.isDisplayed());

        dialogContentElement.myClick(dialogContentElement.printButton);
    }

    @And("The user views PDF Document page and clicks on the Download button")
    public void theUserViewsPDFDocumentPageAndClicksOnTheDownloadButton() {
        String pageHandle = GWD.getDriver().getWindowHandle();
        Set<String> handles = GWD.getDriver().getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(pageHandle)) {
                GWD.getDriver().switchTo().window(handle);
                break;
            }
        }

        dialogContentElement.Wait(2);
        dialogContentElement.robotExecute(14);
        dialogContentElement.Wait(1);
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        File downloadFolder = new File(downloadDir);
        File[] files = downloadFolder.listFiles((dir, name) -> name.endsWith(".pdf"));
        Assert.assertNotNull(files);
        Assert.assertTrue(files.length > 0);
    }
}
