package utilities;

import Base.base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import pages.merchant_page;


public class common_actions extends base {

    merchant_page _merchant_page;
    WebDriverWait wait;
    public String company_name = getSaltString();


    //generate the current date and time
    public String generateDateTimeString() {
        Date dateNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
        return dateFormat.format(dateNow).toString();
    }

    //Load web_config.properties file
    public common_actions() {

        prop = new Properties();

        try {
            FileInputStream propFile = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/resources/web_config.properties");
            prop.load(propFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProp() {
        return prop;
    }


    //takes screenshot and saves the screenshot in the reports folder
    public void takeScreenshot(String screenshotName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("./reports/" + screenshotName + ".png"));
            log.info("Screenshot taken");
        } catch (IOException e) {
            e.printStackTrace();
            log.info("Could not take the screenshot");
        }
    }

    //generate random letters which are less than 10 characters
    public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();

    }

    //generate random letters which are less than 10 characters
    public String getSaltString50() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() == 50) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();

    }

    //generates a random phone number which starts with 50 (so it becomes a valid Dubai phone number)
    public CharSequence UAE_random_phone_number() {

        Random rand = new Random();
        int num1 = 50;
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros
        String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
        return phoneNumber;
    }
    //generates a random phone number which starts with 117 (so it becomes a valid UK phone number)
    public CharSequence UK_random_phone_number() {

        Random rand = new Random();
        int num1 = 117;
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros
        String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + df4.format(num3);
        return phoneNumber;
    }

    //generates a random phone number which starts with 117 (so it becomes a valid UK phone number)
    public CharSequence India_random_phone_number() {

        Random rand = new Random();
        int num1 = 22;
        int num2 = rand.nextInt(7432);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros
        String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + df4.format(num3);
        return phoneNumber;
    }

    //generates a random phone number which starts with 12 after the country code(so it becomes a valid Saudi Arabia phone number)
    public CharSequence Saudi_random_phone_number() {

        Random rand = new Random();
        int num1 = 12;
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros
        String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
        return phoneNumber;
    }

    //generates a random phone number which starts with 50 after the country code(so it becomes a valid Dubai phone number)
    public CharSequence USA_random_phone_number() {

        Random rand = new Random();
        String num1 = "+1";
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(743);
        int num4 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros
        String phoneNumber = num1 + "-" + df3.format(num2) + "-" + df3.format(num3) + "-" + df4.format(num4);
        return phoneNumber;
    }
    //Add UAE address
    public void add_UAE_address() {
        try {
            log.info("adding UAE address");
            _merchant_page.add_more_link.click();
            _merchant_page.add_more_contact_name_textbox.click();
            _merchant_page.add_more_company_name_textbox.sendKeys(company_name);
            _merchant_page.add_more_country_combobox.sendKeys("United Arab");
            //Select UAE
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'United Arab Emirates')]")));
            driver.findElement(By.xpath("//div[contains(text(),'United Arab Emirates')]")).click();
            _merchant_page.add_more_phone_textbox.clear();
            _merchant_page.add_more_phone_textbox.sendKeys(UAE_random_phone_number());
            _merchant_page.add_more_enter_location_textbox.sendKeys("United Arab Emirates");
            _merchant_page.add_more_address_type_combobox.click();
            _merchant_page.add_more_address_type_pickup.click();
            _merchant_page.add_more_default_checkbox.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
            _merchant_page.add_more_city_combobox.click();
            wait.until(ExpectedConditions.elementToBeClickable(_merchant_page.western_region_city_selection));
            _merchant_page.western_region_city_selection.click();
            _merchant_page.add_more_ok_button.click();
            Assert.assertTrue(_merchant_page.add_more_success_message.isDisplayed());
            _merchant_page.add_more_close_pup_button.click();
            log.info("UAE address added successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.info("could not add a UAE address");
        }
    }

    //Add UAE address
    public void add_UK__address() {
        try {
            log.info("adding UK address");
            _merchant_page.add_more_link.click();
            _merchant_page.add_more_contact_name_textbox.click();
            _merchant_page.add_more_company_name_textbox.sendKeys(company_name);
            _merchant_page.add_more_country_combobox.sendKeys("United Kingdom");
            //Select UAE
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'United Kingdom')]")));
            driver.findElement(By.xpath("//div[contains(text(),'United Kingdom')]")).click();
            _merchant_page.add_more_phone_textbox.clear();
            _merchant_page.add_more_phone_textbox.sendKeys(UK_random_phone_number());
            _merchant_page.add_more_enter_location_textbox.sendKeys("United Kingdom");
            _merchant_page.add_more_address_type_combobox.click();
            _merchant_page.add_more_address_type_pickup.click();
            _merchant_page.add_more_default_checkbox.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
            _merchant_page.add_more_city_combobox.click();
            wait.until(ExpectedConditions.elementToBeClickable(_merchant_page.bristol_city_selection));
            _merchant_page.bristol_city_selection.click();
            _merchant_page.add_more_ok_button.click();
            Assert.assertTrue(_merchant_page.add_more_success_message.isDisplayed());
            _merchant_page.add_more_close_pup_button.click();
            log.info("UK address added successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.info("could not add a UK address");
        }
    }
    //Add UAE address
    public void add_Saudi__address() {
        try {
            log.info("adding Saudi address");
            //wait.until(ExpectedConditions.elementToBeClickable(_merchant_page.add_more_link));
            _merchant_page.add_more_link.click();
            _merchant_page.add_more_contact_name_textbox.click();
            _merchant_page.add_more_company_name_textbox.sendKeys(company_name);
            _merchant_page.add_more_country_combobox.sendKeys("Saudi");
            //Select UAE
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Saudi Arabia')]")));
            driver.findElement(By.xpath("//div[contains(text(),'Saudi Arabia')]")).click();
            _merchant_page.add_more_phone_textbox.clear();
            _merchant_page.add_more_phone_textbox.sendKeys(UK_random_phone_number());
            _merchant_page.add_more_enter_location_textbox.sendKeys("Saudi Arabia");
            _merchant_page.add_more_address_type_combobox.click();
            _merchant_page.add_more_address_type_pickup.click();
            _merchant_page.add_more_default_checkbox.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
            _merchant_page.add_more_city_combobox.click();
            wait.until(ExpectedConditions.elementToBeClickable(_merchant_page.jarab_city_selection));
            _merchant_page.jarab_city_selection.click();
            _merchant_page.add_more_ok_button.click();
            Assert.assertTrue(_merchant_page.add_more_success_message.isDisplayed());
            _merchant_page.add_more_close_pup_button.click();
            log.info("Saudi address added successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.info("could not add a Saudi address");
        }
    }
    //Add UAE address
    public void add_India__address() {
        try {
            log.info("adding India address");
            _merchant_page.add_more_link.click();
            _merchant_page.add_more_contact_name_textbox.click();
            _merchant_page.add_more_company_name_textbox.sendKeys(company_name);
            _merchant_page.add_more_country_combobox.sendKeys("India");
            //Select UAE
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'India')]")));
            driver.findElement(By.xpath("//div[contains(text(),'India')]")).click();
            _merchant_page.add_more_phone_textbox.clear();
            _merchant_page.add_more_phone_textbox.sendKeys(UAE_random_phone_number());
            _merchant_page.add_more_enter_location_textbox.sendKeys("India");
            _merchant_page.add_more_address_type_combobox.click();
            _merchant_page.add_more_address_type_pickup.click();
            _merchant_page.add_more_default_checkbox.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
            _merchant_page.add_more_city_combobox.click();
            wait.until(ExpectedConditions.elementToBeClickable(_merchant_page.hubli_city_selection));
            _merchant_page.hubli_city_selection.click();
            _merchant_page.add_more_ok_button.click();
            Assert.assertTrue(_merchant_page.add_more_success_message.isDisplayed());
            _merchant_page.add_more_close_pup_button.click();
            log.info("India address added successfully");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.info("could not add a India address");
        }
    }

    public void excelreader() throws Exception {

    }

    public void excelwriter() throws Exception
    {

    }
}
