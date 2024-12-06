package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

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

    @FindBy(xpath = "//span[text()=' Welcome, Student_6 11A ! ']")
    public WebElement loginControl;

    @FindBy(xpath = "(//mat-drawer-content[@class='mat-drawer-content']//span)[5]")
    public WebElement textControl;

    @FindBy(xpath = "(//span[@class='mat-focus-indicator'])[17]")
    public WebElement addReceiver;

    @FindBy(xpath = "//input[@placeholder='Name, Username or E-mail']")
    public WebElement usernameBox;

    @FindBy(xpath = "//div[@class='mdc-checkbox']")
    public List<WebElement>checkBoxList;

    @FindBy(xpath = "//span[@class='mdc-evolution-chip__text-label mat-mdc-chip-action-label']")
    public WebElement studentTextControl;

    @FindBy(xpath = "//span[text()='Add & Close']")
    public WebElement addAndCloseBtn;

    @FindBy(xpath = "//mat-select[@role='combobox']")
    public WebElement selectBtn;

    @FindBy(xpath = "//mat-option[@value='EMAIL']")
    public WebElement emailBtn;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMsg;

    @FindBy(css = "input[placeholder='Subject']")
    public WebElement subjectBox;

    @FindBy(css = "body[id='tinymce']")
    public WebElement textBox;

    @FindBy(xpath = "//ms-button[@class='mat-mdc-menu-trigger']/button")
    public WebElement attachFileBtn;

    @FindBy(xpath = "//span[text()='From My Files']")
    public WebElement myFilesBtn;

    @FindBy(xpath = "//span[text()='Select']")
    public WebElement selectButton;

    public WebElement getWebElement(String strElementName) {

        switch (strElementName) {
            case "usernameBox": return this.usernameBox;
        }
        return null;
    }

}
