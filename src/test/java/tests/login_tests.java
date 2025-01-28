package tests;


import Base.base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import teststeps.login_actions;
import utilities.testlistener;
import java.util.concurrent.TimeUnit;


@Listeners(testlistener.class)
public class login_tests extends base{

    login_actions _loginActions;

    @BeforeMethod
    public void launchbrowser() {
        startBrowser();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        _loginActions = new login_actions();
    }

    @Test(description = "TC ID - 34206: Login", priority = 1)
    public void loginSuccessfullyTest()  throws InterruptedException{
            _loginActions.LoginMerchantUiSuccessfully();
    }

    @Test(description = "TC ID - 34206: Login - Incorrect Username/Correct password validation", priority = 2)
    public void loginUnsuccessfullyTest1() throws InterruptedException {
            _loginActions.LoginUnsuccessfully1();
    }

    @Test(description = "TC ID - 34207: Correct username/Incorrect password validation", priority = 3)
    public void loginUnsuccessfullyTest2() throws InterruptedException {
        _loginActions.LoginUnsuccessfully2();
    }

    @Test(description = "TC ID - 34208: Incorrect username/Incorrect password validation", priority = 4)
    public void loginUnsuccessfullyTest3() throws InterruptedException {
        _loginActions.LoginUnsuccessfully3();
    }

    @Test(description = "TC ID - 34209: Blank username/Correct password validation", priority = 5)
    public void loginUnsuccessfullyTest4() throws InterruptedException {
        _loginActions.LoginUnsuccessfully4();
    }

    @Test(description = "TC ID - 34210: Blank username/Incorrect password validation", priority = 6)
    public void loginUnsuccessfullyTest5() throws InterruptedException {
        _loginActions.LoginUnsuccessfully5();
    }

    @Test(description = "TC ID - 34211: Incorrect Username email format /blank password validation", priority = 7)
    public void loginUnsuccessfullyTest6() throws InterruptedException {
        _loginActions.LoginUnsuccessfully6();
    }

    @Test(description = "TC ID - 34212: Correct username/Blank password validation", priority = 8)
    public void loginUnsuccessfullyTest7() throws InterruptedException {
        _loginActions.LoginUnsuccessfully7();
    }

    @Test(description = "TC ID - 35084: Reset password", priority = 9)
    public void ResetPassword() throws InterruptedException {
        _loginActions.ForgotPassword();
    }

    @Test(description = "TC ID - 35084: Successfully send forgot password email", priority = 12)
    public void forgotPasswordSuccessfully() throws InterruptedException {
        _loginActions.ForgotPassword();
    }

    @Test(description = "TC ID - 34270: Invalid email address format validation", priority = 13)
    public void InvalidEmail() throws InterruptedException {
        _loginActions.InvalidEmailFormat();
    }
    @Test(description = "TC ID - 34213: Logout", priority = 14)
    public void Logout() throws InterruptedException {
        _loginActions.LogoutSuccessfully();
    }
    
    @AfterMethod
    public void close()
    {
        closeBrowser();
    }

}
