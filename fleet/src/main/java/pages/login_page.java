package pages;

import Base.base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import utilities.testlistener;
import java.time.Duration;


@Listeners(testlistener.class)
public class login_page extends base{

    @FindBy(css = "a[href='/en/register']")
    public WebElement signUplink;

    @FindBy(id = "uid")
    public WebElement emailTexbox;

    @FindBy(id = "password")
    public WebElement passwordTexbox;

    @FindBy(css = "button[type='submit'] span")
    public WebElement signInbutton;

    @FindBy(css = ".login-form-forgot")
    public WebElement forgotPasswordlink;

    @FindBy(id = "root")
    public WebElement languageButton;

    @FindBy(xpath = "//h3[normalize-space()='Login to your Wasla account']")
    public WebElement LoginToYourWaslaAccountText;

    @FindBy(xpath = "//p[@class='subtitle']")
    public WebElement DontHaveAWaslaAccountText;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/form/div[2]/div/div/div/div/button/span")
    public WebElement ResetPasswordButton;

    //SIGN UP

    @FindBy(xpath = "//*[@id=\"business_type\"]/label[1]/span[1]/input")
    public WebElement individualRadioButton;

    @FindBy(xpath = "//*[@id=\"business_type\"]/label[2]/span[1]/input")
    public WebElement companyRadioButton;

    @FindBy(id = "email")
    public WebElement SignUpEmailTextBox;

    @FindBy(id = "name")
    public WebElement SignUpFullNameTextBox;

    @FindBy(id = "company_name")
    public WebElement SignUpCompanyNameTextBox;

    @FindBy(id = "password")
    public WebElement SignUpPasswordTextBox;

    @FindBy(id = "website")
    public WebElement SignUpWebsiteTextBox;

    @FindBy(css = "input[value=\"+971\"]")
    public WebElement SignUpPhoneTextBox;

    @FindBy(id = "email_subscription")
    public WebElement SignUpMarketingCheckBox;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[9]/div/div/div/div/button/span")
    public WebElement SignUpCompanyCreateAccountButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div/div/form/div[7]/div/div/div/div/button/span")
    public WebElement SignUpIndividualCreateAccountButton;

    @FindBy(css = "button[title=\"Profile\"]")
    public WebElement ProfileButton;

    @FindBy(xpath = "//span[normalize-space()='Logout']")
    public WebElement LogoutButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main[2]/main/main/div[1]/div[1]/div/h4")
    public WebElement DashboardHeader;

    @FindBy(xpath= "//*[@id=\"uid_help\"]/div")
    public WebElement InvalidEmailErrorMessage;

    @FindBy(xpath= "//*[@id=\"root\"]/div/div/form/div[1]/div/div")
    public WebElement ForgotPasswordEmailHasBeenSentMessage;

    @FindBy(css= ".ant-alert-message")
    public WebElement WrongUsernameOrPasswordErrorMessage;

    @FindBy(xpath= "//*[@id=\"uid_help\"]/div")
    public WebElement FillInEmailErrorMessage;

    @FindBy(xpath= "//*[@id=\"password_help\"]/div")
    public WebElement FillInPasswordErrorMessage;

    @FindBy(css = ".ant-btn-default > span:nth-child(1)")
    public WebElement ResendVerificationEmailButton;


    WebDriverWait wait;

    public login_page() {
        //this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }



}
