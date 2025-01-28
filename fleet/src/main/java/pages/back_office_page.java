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
public class back_office_page extends base {


    @FindBy(xpath = "//*[@id=\"root\"]/section/section/aside/div/ul/li[3]/span/a")
    public WebElement SellerLink;//*[@id="root"]/section/section/section/main/main/h3/span

    @FindBy(xpath = "//*[@id=\"root\"]/section/section/aside/div/ul/li[3]/span/a")
    public WebElement SellerPageHeader;

    @FindBy(xpath = "//span[@class='ant-menu-title-content']//a[@class='nav-text active']")
    public WebElement Approvals;

    @FindBy(id = "View Details")
    public WebElement ViewDetails;

    @FindBy(id = "Approve")
    public WebElement ViewDetailApprove;


    private WebDriverWait wait;


    public void BackOfficePage() {
        //this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
}
