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

    @FindBy(xpath = "//div[text()='Invalid username or password']")
    public WebElement invalidMessage;

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

    @FindBy(xpath = "//span[text()='Add & Close']")
    public WebElement addAndCloseBtn;

    @FindBy(xpath = "//span[text()=' Students Fees '] ")
    public WebElement myFinancePageVerify;

    @FindBy(xpath = "//span[text()='Trash']")
    public WebElement trashBoxBtn;

    @FindBy(xpath = "//ms-delete-button/button")
    public WebElement deleteIcon;

    @FindBy(xpath = "//ms-standard-button[@icon='trash-restore']/button")
    public WebElement restoreIcon;

    @FindBy(xpath = "//div[contains(text(), 'Message successfully')]")
    public WebElement msgControl;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement deleteBtn;

    @FindBy(xpath = "//span[@class='mdc-evolution-chip__text-label mat-mdc-chip-action-label']")
    public WebElement studentTextControl;
    
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

    @FindBy(xpath = "(//button[@aria-haspopup='menu'])[7]")
    public WebElement overFlowMenuBtn;

    @FindBy(xpath = "(//div[@class='cdk-overlay-pane']//button)[1]")
    public WebElement excelBtn;

    @FindBy(xpath = "//div[@class='cdk-drop-list']")
    public WebElement fileControl;

    @FindBy(xpath = "(//td[@role='cell'])[1]")
    public WebElement studentControl;

    @FindBy(xpath = "//div[@class='attachment ng-star-inserted']")
    public WebElement appearFileControl;

    @FindBy(xpath = "//span[text()='Send']")
    public WebElement sendBtn;

    @FindBy(xpath = "//div[contains(text(),'Message Successfully sent')]")
    public WebElement sendConfirmMessage;

    @FindBy(xpath = "(//tbody[@role='rowgroup']/tr)[1]")
    public WebElement outboxMsgControl;

    @FindBy(xpath = "//ms-confirm-button[@icon='shopping-basket']/button")
    public List<WebElement> moveToTrashIcon;

    @FindBy(xpath = "//mat-dialog-actions//button")
    public WebElement yesButton;

    @FindBy(xpath = "//strong[text()='Confirm']")
    public WebElement confirmTitleText;

    @FindBy(xpath = "//*[contains(text(),'move this message')]")
    public WebElement confirmTextSentence;

    @FindBy(xpath = "//div[@fxlayout='column']/div")
    public WebElement studentButton;

    @FindBy(xpath = "//div[contains(@id, 'mat-tab-group-1-label')]")
    public WebElement onlinePaymentButton;

    @FindBy(xpath = "(//div[contains(@id, 'mat-tab-group-1-label')])[2]")
    public WebElement feeBalanceButton;

    @FindBy(xpath = "//input[@value='STRIPE'] ")
    public WebElement stripeButton;

    @FindBy(xpath = "(//input[@class='mdc-radio__native-control'])[3]")
    public WebElement paymentCreateOption;

    @FindBy(xpath = "//*[@data-icon='square-xmark']")
    public WebElement closeIcon;

    @FindBy(xpath = "//input[@value='CUSTOM_AMOUNT']")
    public WebElement payOption;

    @FindBy(xpath = "//input[contains(@id, 'ms-currency-field')]")
    public WebElement amountBox;

    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[5]")
    public WebElement payButton;

    @FindBy(xpath = "//input[@id='Field-numberInput']")
    public WebElement cardNumberBox;

    @FindBy(xpath = "//input[@id='Field-expiryInput']")
    public WebElement expirationDateBox;

    @FindBy(xpath = "//input[@id='Field-cvcInput']")
    public WebElement securityCodeBox;

    @FindBy(xpath = "//select[@id='Field-countryInput']")
    public WebElement selectCountry;

    @FindBy(xpath = "(//*[contains(@class, 'mdc-button__ripple')])[9]")
    public WebElement stripePaymentsButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successPaymentMsg;

    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[5]")
    public WebElement totalBalance;

    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[6]")
    public WebElement debitAmount;

    @FindBy(xpath = "(//span[@class='ng-star-inserted'])[7]")
    public WebElement creditAmount;

    @FindBy(xpath = "//*[@data-icon='chevron-left'//*[@data-icon='chevron-left']")
    public WebElement studentFeeIcon;

    @FindBy(xpath = "(//*[contains(@role,'cell')])[8]")
    public WebElement totalRevenue;

    @FindBy(xpath = "(//*[contains(@role,'cell')])[9]")
    public WebElement studentBalance;

    @FindBy(xpath = "//*[@data-icon='envelope']")
    public WebElement  newMessageIcon;

    @FindBy(xpath = "//*[@data-icon='eye']")
    public WebElement viewIcon;

    @FindBy(xpath = "//div[text()='Payment is completed']")
    public WebElement paymentMsgControl;

    public WebElement getWebElement(String strElementName) {

        switch (strElementName) {
            case "usernameBox": return this.usernameBox;
        }
        return null;
    }
}