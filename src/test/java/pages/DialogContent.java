package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

public class DialogContent extends ReusableMethods {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
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
    public List<WebElement> checkBoxList;

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

    @FindBy(xpath = "//tfoot[@role='rowgroup']//button[@aria-haspopup='menu']")
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

    @FindBy(xpath = "//ms-confirm-button/button")
    public WebElement moveToTrashIcon;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement yesButton;

    @FindBy(xpath = "//strong[text()='Confirm']")
    public WebElement confirmTitleText;

    @FindBy(xpath = "//div[text()='Message successfully moved to trash!']")
    public WebElement trashConfirm;

    @FindBy(xpath = "//*[contains(text(),'move this message')]")
    public WebElement confirmTextSentence;

    @FindBy(xpath = "(//span[text()=' Student_6 11A'])[1]")
    public WebElement studentButton;

    @FindBy(xpath = "//span[text()='Online Payment']")
    public WebElement onlinePaymentButton;

    @FindBy(xpath = "//span[text()='Fee/Balance Detail']")
    public WebElement feeBalanceButton;

    @FindBy(xpath = "//*[text()='Stripe '] ")
    public WebElement stripeButton;

    @FindBy(xpath = "(//label[@class='mdc-label'])[3]")
    public WebElement paymentCreateOption;

    @FindBy(xpath = "(//*[@fxlayoutalign='center center'])[2]")
    public WebElement closeIcon;

    @FindBy(xpath = "(//label[@class='mdc-label'])[4]")
    public WebElement payOption;

    @FindBy(xpath = "//input[contains(@id, 'ms-currency-field')]")
    public WebElement amountBox;

    @FindBy(xpath = "//*[@class='svg-inline--fa fa-wallet fa-fw']")
    public WebElement payButton;

    @FindBy(xpath = "//input[@id='Field-numberInput']")
    public WebElement cardNumberBox;

    @FindBy(xpath = "//input[@id='Field-expiryInput']")
    public WebElement expirationDateBox;

    @FindBy(xpath = "//input[@id='Field-cvcInput']")
    public WebElement securityCodeBox;

    @FindBy(xpath = "//select[@id='Field-countryInput']")
    public WebElement selectCountry;

    @FindBy(xpath = "//span[@class='mdc-button__label']/img")
    public WebElement stripePaymentsButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successPaymentMsg;

    @FindBy(xpath = "//*[contains(text(),'Total :')]")
    public WebElement totalBalance;

    @FindBy(xpath = "//div[text()='Payment is completed']")
    public WebElement paymentMsgControl;

    @FindBy(xpath = "//ms-standard-button[@icon='eye']/button")
    public WebElement viewIconBtn;

    @FindBy(xpath = "//div[text()=' Installment ']")
    public WebElement installmentText;

    @FindBy(xpath = "//mat-panel-title[text()=' Fees ']")
    public WebElement feesText;

    @FindBy(xpath = "//*[text()='Fee/Balance Detail']")
    public WebElement feeBalanceDetailText;

    @FindBy(xpath = "(//*[@role='radiogroup'])[2]")
    public WebElement paymentOptions;

    @FindBy(xpath = "//*[@icon='wallet']")
    public WebElement unactivePayButton;

    @FindBy(css = "[matsortactive='date'] div")
    public WebElement scrollElement;

    @FindBy(xpath = "//div[@class='mdc-radio']")
    public WebElement stripeBtn;

    @FindBy(xpath = "(//div[@class='mdc-radio__background'])[2]")
    public WebElement payCtrl;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement amountBtn;

    @FindBy(xpath = "(//span[contains(text(), 'Pay')])[2]")
    public WebElement payBtn;

    @FindBy(xpath = "//div[@class='p-CardNumberInput']")
    public List<WebElement> cardNumber;

    @FindBy(xpath = "(//div[@class='p-Input'])[2]")
    public WebElement expirationDate;

    @FindBy(xpath = "//span[text()='Settings']")
    public WebElement settingsBtn;

    @FindBy(xpath = "//span[text()='Sign Out']")
    public WebElement signOut;

    @FindBy(css = "[title='Secure payment input frame']")
    public WebElement iframe;

    @FindBy(xpath = "//span[text()=' ATTENDANCE EXCUSES ']")
    public WebElement attendanceExcusesBtn;

    @FindBy(xpath = "//ms-add-button/button")
    public WebElement addButton;

    @FindBy(xpath = "//ms-textarea-field/textarea")
    public WebElement inputMessage;

    @FindBy(xpath = "(//div[@class='mdc-checkbox'])[2]")
    public WebElement checkBox;

    @FindBy(css = "div[class='hot-toast-bar-base']")
    public WebElement toolTipBar;

    @FindBy(xpath = "//ms-button[@caption='GENERAL.BUTTON.SELECT']/button")
    public WebElement myDriveSelect;

    @FindBy(xpath = "//div[contains(text(),'successfully sent')]")
    public WebElement excuseConfirmMsg;

    @FindBy(xpath = "//mat-select[@formcontrolname='theme']")
    public WebElement themeBtn;

    @FindBy(xpath = "//mat-option[@role='option']")
    public List<WebElement> themeOptions;

    @FindBy(css = ".mat-toolbar.mat-primary")
    public WebElement topBar;

    @FindBy(xpath = "//ms-save-button/button")
    public WebElement saveBtn;

    @FindBy(xpath = "//div[contains(text(),'successfully updated')]")
    public WebElement updateMsg;

    @FindBy(css = "[formcontrolname='theme']")
    public WebElement themeControlText;

    @FindBy(xpath = "//*[@role='tab']")
    public WebElement courseGradeButton;

    @FindBy(xpath = "(//*[@role='tab'])[2]")
    public WebElement studentTranscriptBtn;

    @FindBy(xpath = "(//*[@role='tab'])[3]")
    public WebElement transcriptBySubjectBtn;

    @FindBy(xpath = "//span[text()=' Grading ']")
    public WebElement gradingPageVerify;

    @FindBy(xpath = "//div[@id='all-course']")
    public WebElement courseGradeTableVerify;

    @FindBy(xpath = "//*[@role='table']")
    public WebElement studentTranscriptVerify;

    @FindBy(xpath = "//*[contains(text(), 'no data to display')]")
    public WebElement transcriptBySubjectVerify;

    @FindBy(xpath = "//ms-icon-button[@icon='file-import']/button")
    public WebElement fileSubmitBtn;

    @FindBy(css = "[title='Rich Text Area']")
    public WebElement textEditorControl;

    @FindBy(xpath = "//*[@icon='save']/button")
    public WebElement saveAsDraftBtn;

    @FindBy(xpath = "//div[text()='Successfully saved as a draft']")
    public WebElement draftSuccessfullyMsg;

    @FindBy(xpath = "//mat-dialog-actions//*[@icon='file-import']/button")
    public WebElement submitBtn;

    @FindBy(xpath = "//div[text()='Successfully submitted to review']")
    public WebElement submitMsgControl;

    @FindBy(xpath = "//ms-icon-button[@icon='info']")
    public WebElement assignmentsInfoBtn;

    @FindBy(xpath = "//span[text()='New Submission']")
    public WebElement newSubmissionBtn;

    @FindBy(css = "[class='ng-star-inserted'] strong")
    public WebElement dateVerify;

    @FindBy(xpath = "//table[@class='ng-star-inserted']")
    public WebElement coursePlanTableVerify;

    @FindBy(xpath = "//*[text()=' P ']")
    public WebElement pIcon;

    @FindBy(xpath = "//*[text()=' Published ']")
    public WebElement pDescription;

    @FindBy(xpath = "//*[text()=' S ']")
    public WebElement sIcon;

    @FindBy(xpath = "//*[text()=' Started ']")
    public WebElement sDescription;

    @FindBy(xpath = "//*[text()=' E ']")
    public WebElement eIcon;

    @FindBy(xpath = "//*[text()=' Ended ']")
    public WebElement eDescription;

    @FindBy(xpath = "//*[text()=' C ']")
    public WebElement cIcon;

    @FindBy(xpath = "//*[text()=' Cancelled ']")
    public WebElement cDescription;

    @FindBy(xpath = "//*[contains(text(),' Weekly Course Plan ')]")
    public WebElement weeklyCoursePlanBtn;

    @FindBy(xpath = "(//*[text()=' Calendar '])[2]")
    public WebElement calendarBtn;

    @FindBy(xpath = "//table[@role='grid']")
    public WebElement calendarTableVerify;

    @FindBy(xpath = "//div[@class='user-info']/img")
    public WebElement uploadPhotoBtn;

    @FindBy(css = "mat-form-field button")
    public WebElement uploadPictureBtn;

    @FindBy(xpath = "//span[@class='file-info']")
    public WebElement verifiesTypeOfFile;

    @FindBy(css = "ms-standard-button[icon='print']")
    public WebElement printButton;

    @FindBy(xpath = "(//button[@color='primary'])[1]")
    public WebElement uploadBtn;

    @FindBy(xpath = "(//div/button)[8]")
    public WebElement previousButton;

    @FindBy(xpath = "(//div/button)[9]")
    public WebElement todayButton;

    @FindBy(xpath = "(//div/button)[10]")
    public WebElement nextButton;

    @FindBy(xpath = "//strong[contains(text(),' Overdue ')]")
    public WebElement overdueText;

    @FindBy(xpath = "//td/div")
    public List<WebElement> lessonsButton;

    @FindBy(xpath = "//*[contains(text(),'not been started')]")
    public WebElement lessonMessage;

    @FindBy(xpath = "(//div[@fxlayoutalign.lt-md='space-between center'])[3]")
    public WebElement iconsMenu;

    @FindBy(xpath = "(//ms-icon-button[@icon='info'])[3]")
    public WebElement infoIcon;

    @FindBy(xpath = "//strong[text()='Course:']")
    public WebElement courseText;

    @FindBy(xpath = "//strong[text()='Assignment Status:']")
    public WebElement assignmentStatusText;

    @FindBy(xpath = "//span[text()='Description']")
    public WebElement descriptionText;

    @FindBy(xpath = "//div[@class='ng-star-inserted']/button")
    public WebElement backIcon;

    @FindBy(xpath = "//div[@class='assignment ng-star-inserted']")
    public List<WebElement>assignmentsList;

    @FindBy(xpath = "(//ms-icon-button[@icon='file-import']/button)[3]")
    public WebElement submitIcon;

    @FindBy(xpath = "//mat-dialog-container[contains(@id,'mat-mdc-dialog')]")
    public WebElement submitWindow;

    @FindBy(xpath = "(//td[contains(text(),'1 $')])[1]")
    public WebElement fileBalanceDetailText;

    @FindBy(xpath = "(//button//span[@class='mat-focus-indicator'])[36]")
    public WebElement paymentStripeBtn;

    @FindBy(xpath = "//*[text()='Payment is completed']")
    public WebElement paymentCompletedText;

    @FindBy(xpath = "(//*[@class='ng-fa-icon'])[8]")
    public WebElement newMessagesCloseBtn;

    @FindBy(xpath = "(//div[contains(@class, 'mat-mdc-select-value')])[3]")
    public WebElement semesterBtn;

    @FindBy(xpath = "(//span[@class='mdc-list-itemprimary-text'])[1]")
    public WebElement semesterAllBtn;

    @FindBy(xpath = "//div[@class='mat-mdc-tooltip-surface mdc-tooltipsurface']")
    public WebElement assingmentsCount;

    @FindBy(xpath = "//span[text()=' Published ']")
    public List<WebElement> assingmentsPublished;

    @FindBy(xpath = "//div[@class='ng-star-inserted']/button")
    public WebElement studentFeesBtn;

    @FindBy(xpath = "//ms-standard-button[@icon='users']")
    public WebElement contactIcon;

    @FindBy(xpath = "(//ms-icon-button[@icon='comments-alt']/button)[3]")
    public WebElement discussionIcon;

    @FindBy(xpath = "(//ms-icon-button[@icon='star']/button)[3]")
    public WebElement markItIcon;

    @FindBy(xpath = "//tbody//span[text() = 'E']/parent::*")
    public List<WebElement> endedLessonBtn;

    @FindBy(xpath = "(//div[@role='tab'])[3]")
    public WebElement popUpVerify;

    @FindBy(xpath = "//ms-button[@icon='eye']/button")
    public WebElement recordingButton;

    @FindBy(xpath = "div[class='center']")
    public WebElement videoPopUpVerify;

    @FindBy(css = "[class='container']")
    public WebElement container;

    @FindBy(xpath = "(//*[@data-icon='star'])[3]")
    public WebElement svg;

    @FindBy(css = "[allowfullscreen='1']")
    public WebElement videoIframe;

    @FindBy(css = "button[title='Play Video']")
    public WebElement playVideoBtn;

    @FindBy(xpath = "//*[contains(text(),'Teacher')]")
    public WebElement teacherText;

    @FindBy(xpath = "//span[contains(text(),'11A-')]")
    public WebElement courseControlText;

    @FindBy(xpath = "(//div[@role='tab'])[4]")
    public WebElement topicBtn;

    @FindBy(xpath = "(//div[@role='tab'])[5]")
    public WebElement attachmentsBtn;

    @FindBy(xpath = "(//div[@role='tab'])[6]")
    public WebElement recentEventsBtn;

    @FindBy(xpath = "//ms-button[@caption='MEETINGS.TITLE.RECORDING']/button")
    public WebElement recordingBtn;

    public WebElement getWebElement(String strElementName) {

        switch (strElementName) {
            case "usernameBox": return this.usernameBox;
            case "stripeButton": return this.stripeButton;
            case "courseGradeButton": return  this.courseGradeButton;
            case "studentTranscriptBtn": return this.studentTranscriptBtn;
            case "transcriptBySubjectBtn": return this.transcriptBySubjectBtn;
            case "previousButton": return this.previousButton;
            case "todayButton": return this.todayButton;
            case "nextButton": return this.nextButton;
            case "backButton" : return this.backIcon;
            case "recordingButton": return this.recordingButton;
            case "topic": return this.topicBtn;
            case "attachments": return this.attachmentsBtn;
            case "recentEvents": return this.recentEventsBtn;
        }
        return null;
    }
}