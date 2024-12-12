package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ProfileUploadProfilePhoto {
    DialogContent dialogContentElement = new DialogContent();


    @When("The user clicks on the Upload Picture button to upload or change Profile Photo")
    public void theUserClicksOnTheUploadPictureButtonToUploadOrChangeProfilePhoto() {
//        System.out.println("mesaj:"+dialogContentElement.settingsBtn);
//        dialogContentElement.verifyContainsText(dialogContentElement.settingsBtn, "Settings");

//        if (dialogContentElement.settingsBtn.isDisplayed()) {
            dialogContentElement.Wait(5);
            dialogContentElement.jsClick(dialogContentElement.uploadPhotoBtn);
//        }

        dialogContentElement.Wait(5);
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.profilePhotoText));
        System.out.println("mesaj:"+dialogContentElement.profilePhotoText.getText());
        dialogContentElement.verifyContainsText(dialogContentElement.profilePhotoText,"Profile Photo");
        dialogContentElement.Wait(5);
        dialogContentElement.wait.until(ExpectedConditions.elementToBeClickable(dialogContentElement.uploadPictureBtn));
        dialogContentElement.myClick(dialogContentElement.uploadPictureBtn);
        dialogContentElement.Wait(2);

        try {
            Robot robot=new Robot();
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);

            robot.keyPress(KeyEvent.VK_KP_DOWN);
            robot.keyRelease(KeyEvent.VK_KP_DOWN);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }


//        if (dialogContentElement.uploadPictureBtn.isDisplayed()){
//            dialogContentElement.wait.until(ExpectedConditions.elementToBeClickable(dialogContentElement.uploadPhotoBtn));
//            dialogContentElement.Wait(5);
//

//        }

    }

    @And("The user views the type of Profile Photo and size of the image by clicking on the Upload button")
    public void theUserViewsTheTypeOfProfilePhotoAndSizeOfTheImageByClickingOnTheUploadButton() {
    }
}
