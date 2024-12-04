package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class DialogContent extends ReusableMethods {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver() ,this);
    }

    @FindBy(css = "input[formcontrolname='username']")
    public WebElement usernameInput;

    @FindBy(css = "input[formcontrolname='password']")
    public WebElement passwordInput;

    @FindBy(css = "button[aria-label='LOGIN']")
    public WebElement loginBtn;

    @FindBy(xpath = "//span[text()=' New Message ']")
    public WebElement newMsgText;

    @FindBy(xpath = "//span[text()=' Inbox ']")
    public WebElement inboxText;

    @FindBy(xpath = "//span[text()=' Outbox ']")
    public WebElement outboxText;

    @FindBy(xpath = "//span[text()=' Trash ']")
    public WebElement trashText;
}
