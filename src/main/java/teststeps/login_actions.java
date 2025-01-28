package teststeps;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import pages.login_page;
import utilities.common_actions;
import utilities.testlistener;

@Listeners(testlistener.class)
public class login_actions extends common_actions {

    login_page _loginPage = new login_page();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

    //MERCHANT UI
    //Login successfully
    public void LoginMerchantUiSuccessfully() throws InterruptedException{
        try {
            log.info("Logging in......");
            _loginPage.emailTexbox.click();
            _loginPage.emailTexbox.sendKeys(getProp().getProperty("stg-merchant.username"));
            _loginPage.passwordTexbox.sendKeys(getProp().getProperty("stg-merchant.password"));
            _loginPage.signInbutton.click();
            wait.until(ExpectedConditions.visibilityOf(_loginPage.DashboardHeader));
            Assert.assertTrue(_loginPage.DashboardHeader.isDisplayed());
            log.info("login successful");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("user could not login");
            Assert.fail("user could not login");
        }
    }
    //Incorrect Username
    public void LoginUnsuccessfully1() throws InterruptedException{
           try {
            log.info("starting TC ID - 34206: Incorrect Username/Correct password validation test case");
            _loginPage.emailTexbox.click();
            _loginPage.emailTexbox.sendKeys(("123@123.com"));
            _loginPage.passwordTexbox.sendKeys(getProp().getProperty("stg-merchant.password"));
            _loginPage.signInbutton.click();
            wait.until(ExpectedConditions.visibilityOf(_loginPage.WrongUsernameOrPasswordErrorMessage));
            Assert.assertTrue(_loginPage.WrongUsernameOrPasswordErrorMessage.isDisplayed());
            log.info("Validation was successful - test passed");
    }
           catch (Exception e) {

               e.printStackTrace();
               log.error("Test Failed - user logged in successfully");
               Assert.fail("Test Failed - user logged in successfully");
           }
    }

    //Incorrect Password
    public void LoginUnsuccessfully2() {
        try {
            log.info("starting TC ID - 34207: Correct username/Incorrect password validation test case");
        _loginPage.emailTexbox.click();
        _loginPage.emailTexbox.sendKeys(getProp().getProperty("stg-merchant.username"));
        _loginPage.passwordTexbox.sendKeys("6566567585");
        _loginPage.signInbutton.click();
        wait.until(ExpectedConditions.visibilityOf(_loginPage.WrongUsernameOrPasswordErrorMessage));
        Assert.assertTrue(_loginPage.WrongUsernameOrPasswordErrorMessage.isDisplayed());
        log.info("Validation was successful - test passed");
    }
        catch (Exception e) {
        e.printStackTrace();
            log.error("Test Failed - user logged in successfully");
            Assert.fail("Test Failed - user logged in successfully");
    }
    }

    //Incorrect Username and Password
    public void LoginUnsuccessfully3() throws InterruptedException{
        try {
            log.info("starting TC ID - 34208: Incorrect username/Incorrect password validation test case");
        _loginPage.emailTexbox.click();
        _loginPage.emailTexbox.sendKeys(getProp().getProperty("stg-backoffice.username"));
        _loginPage.passwordTexbox.sendKeys("6566567585");
        _loginPage.signInbutton.click();
        wait.until(ExpectedConditions.visibilityOf(_loginPage.WrongUsernameOrPasswordErrorMessage));
        Assert.assertTrue(_loginPage.WrongUsernameOrPasswordErrorMessage.isDisplayed());
            log.info("Validation was successful - test passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("Test Failed - user logged in successfully");
            Assert.fail("Test Failed - user logged in successfully");
        }
    }

    //Blank username/ Correct Password
    public void LoginUnsuccessfully4() {
        try {
            log.info("starting TC ID - 34209: Blank username/Correct password validation test case");
        _loginPage.emailTexbox.click();
        _loginPage.emailTexbox.sendKeys("");
        _loginPage.passwordTexbox.sendKeys(getProp().getProperty("stg-merchant.password"));
        _loginPage.signInbutton.click();
        wait.until(ExpectedConditions.visibilityOf(_loginPage.FillInEmailErrorMessage));
        Assert.assertTrue(_loginPage.FillInEmailErrorMessage.isDisplayed());
            log.info("Validation was successful - test passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("Test Failed - user logged in successfully");
            Assert.fail("Test Failed - user logged in successfully");
        }
    }

    //Blank username/ Incorrect Password
    public void LoginUnsuccessfully5() {
        try {
            log.info("starting TC ID - 34210: Blank username/Incorrect password validation test case");
        _loginPage.emailTexbox.click();
        _loginPage.emailTexbox.sendKeys("");
        _loginPage.passwordTexbox.sendKeys(getProp().getProperty("stg-backoffice.password"));
        _loginPage.signInbutton.click();
        wait.until(ExpectedConditions.visibilityOf(_loginPage.FillInEmailErrorMessage));
        Assert.assertTrue(_loginPage.FillInEmailErrorMessage.isDisplayed());
            log.info("Validation was successful - test passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("Test Failed - user logged in successfully");
            Assert.fail("Test Failed - user logged in successfully");
        }
    }

    //Incorrect username/ Incorrect Password
    public void LoginUnsuccessfully6() {
        try {
            log.info("starting TC ID - 34211: Incorrect Username email format/blank password validation test case");
        _loginPage.emailTexbox.click();
        _loginPage.emailTexbox.sendKeys("stg-backoffice.username");
        _loginPage.passwordTexbox.sendKeys("");
        _loginPage.signInbutton.click();
        wait.until(ExpectedConditions.visibilityOf(_loginPage.InvalidEmailErrorMessage));
        Assert.assertTrue(_loginPage.InvalidEmailErrorMessage.isDisplayed());
        Assert.assertTrue(_loginPage.FillInPasswordErrorMessage.isDisplayed());
            log.info("Validation was successful - test passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("Test Failed - user logged in successfully");
            Assert.fail("Test Failed - user logged in successfully");
        }
    }

    //Correct username/ Blank Password
    public void LoginUnsuccessfully7() {
        try {
            log.info("starting TC ID - 34212: Correct username/Blank password validation test case");
        _loginPage.emailTexbox.click();
        _loginPage.emailTexbox.sendKeys("stg-merchant.username");
        _loginPage.passwordTexbox.sendKeys("");
        _loginPage.signInbutton.click();
        wait.until(ExpectedConditions.visibilityOf(_loginPage.FillInEmailErrorMessage));
        Assert.assertTrue(_loginPage.FillInPasswordErrorMessage.isDisplayed());
            log.info("Validation was successful - test passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("Test Failed - user logged in successfully");
            Assert.fail("Test Failed - user logged in successfully");
        }
    }

    //Invalid email address format
    public void InvalidEmailFormat() {
        try {
            log.info("starting TC ID - 34270: Invalid email address format validation test case");
        _loginPage.emailTexbox.click();
        _loginPage.emailTexbox.sendKeys("stg-merchant.username");
        _loginPage.passwordTexbox.sendKeys("");
        _loginPage.signInbutton.click();
        wait.until(ExpectedConditions.visibilityOf(_loginPage.InvalidEmailErrorMessage));
        Assert.assertTrue(_loginPage.InvalidEmailErrorMessage.isDisplayed());
            log.info("Email format validation was successful - test passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("Email format validation was unsuccessful - test failed");
            Assert.fail("Email format validation was unsuccessful - test failed");
        }
    }

    //Forgot password
    public void ForgotPassword() {
        try {
            log.info("starting TC ID - 35084: Successfully Reset validation test case");
        _loginPage.forgotPasswordlink.click();
        _loginPage.SignUpEmailTextBox.sendKeys(getProp().getProperty("stg-merchant.username"));
        _loginPage.ResetPasswordButton.click();
        wait.until(ExpectedConditions.visibilityOf(_loginPage.ForgotPasswordEmailHasBeenSentMessage));
        Assert.assertTrue(_loginPage.ForgotPasswordEmailHasBeenSentMessage.isDisplayed());
            log.info("Forgot password email was sent successfully - test passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("forgot email password was not sent - test failed");
            Assert.fail("forgot email password was not sent - test failed");
        }
    }

    //Logout successfully and make sure you are redirected to the login page
    public void LogoutSuccessfully() {
        try {
            log.info("starting TC ID - 34213: Logout test case");
        LoginMerchantUiSuccessfully();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        _loginPage.ProfileButton.click();
        wait.until(ExpectedConditions.visibilityOf(_loginPage.LogoutButton)).click();
        wait.until(ExpectedConditions.visibilityOf(_loginPage.signInbutton));
        Assert.assertTrue(_loginPage.signInbutton.isDisplayed());
            log.info("user logged out successfully - test passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.info("user could not log out - test failed");
            Assert.fail("user could not log out - test failed");
        }
    }
}
