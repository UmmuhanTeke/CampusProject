package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;

public class ProfileUploadProfilePhoto {
    DialogContent dialogContentElement = new DialogContent();

    @When("The user clicks on the Upload Picture button to upload or change Profile Photo")
    public void theUserClicksOnTheUploadPictureButtonToUploadOrChangeProfilePhoto() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.uploadPhotoBtn));
        dialogContentElement.jsClick(dialogContentElement.uploadPhotoBtn);

        dialogContentElement.Wait(3);
        dialogContentElement.wait.until(ExpectedConditions.elementToBeClickable(dialogContentElement.uploadPictureBtn));
        dialogContentElement.myClick(dialogContentElement.uploadPictureBtn);
        dialogContentElement.Wait(2);

        dialogContentElement.robotExecute(1);
        dialogContentElement.uploadFilePath("C:\\Users\\User\\IdeaProjects\\Campus_Project\\src\\test\\resources\\campus2photo.png");
    }

    @And("The user views the type of Profile Photo and size of the image by clicking on the Upload button")
    public void theUserViewsTheTypeOfProfilePhotoAndSizeOfTheImageByClickingOnTheUploadButton() {
        dialogContentElement.wait.until(ExpectedConditions.visibilityOf(dialogContentElement.verifiesTypeOfFile));
        dialogContentElement.verifyContainsText(dialogContentElement.verifiesTypeOfFile,"png");
        dialogContentElement.verifyContainsText(dialogContentElement.verifiesTypeOfFile,"430.0 bytes");
        dialogContentElement.myClick(dialogContentElement.uploadBtn);
        dialogContentElement.wait.until(ExpectedConditions.invisibilityOfAllElements(dialogContentElement.uploadBtn));

    }
}
