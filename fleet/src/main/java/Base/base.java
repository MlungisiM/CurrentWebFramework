package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;


public class base {

    public static WebDriver driver;
    public static Logger log = LogManager.getLogger(base.class);
    public static Properties prop = null;

    //Initialize driver and start browser
    public void startBrowser() {
        String browserName = prop.getProperty("browser");
        System.clearProperty("hudson.model.DirectoryBrowserSupport.CSP");
        System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "sandbox allow-scripts; default-src 'self'; script-src * 'unsafe-eval'; img-src *; style-src * 'unsafe-inline'; font-src *");
        try {


            if ("chrome".equalsIgnoreCase(browserName)) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                driver = new ChromeDriver(options);
                log.info("Starting Chrome driver");
            } else if ("firefox".equalsIgnoreCase(browserName)) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions(); // Create options for Firefox
                options.addArguments("--headless=new"); // Run in headless mode
                driver = new FirefoxDriver(options); // Pass options to the driver
                log.info("Starting firefox driver");
            } else if ("edge".equalsIgnoreCase(browserName)) {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=new");
                driver = new EdgeDriver();
                log.info("Starting Edge driver");
            }

            long start = System.currentTimeMillis();
            driver.get(prop.getProperty("stg-merchant.url"));
            long finish = System.currentTimeMillis();
            long Total = (finish - start) / 1000;
            driver.manage().window().fullscreen();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            System.out.println("Total time it took the system to respond is: " + Total + " seconds");
            log.info("Total time it took the system to respond is: " + Total + " seconds");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("unable to start " + browserName + " browser");
            log.info("unable to start " + browserName + " browser");
        }
    }

    //Tear down method - return driver into its initial state
    public void closeBrowser() {

            driver.manage().deleteAllCookies();
            log.info("Cookies deleted");
            driver.quit();
            log.info("Browser closed");
    }

}
