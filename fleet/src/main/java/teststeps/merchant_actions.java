package teststeps;

import Base.base;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import pages.login_page;
import pages.merchant_page;
import utilities.common_actions;
import utilities.testlistener;
import java.time.Duration;

@Listeners(testlistener.class)
public class merchant_actions extends base {
    
    merchant_page _merchant_page = new merchant_page();
    login_page _loginPage = new login_page();
    login_actions _loginActions = new login_actions();
    common_actions _commonActions = new common_actions();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));


    //Account manager logging in as a seller
    public void AccountManagersSellerLogin() {
        //Sign up your seller in merchant Ui
        //_merchantuiActions.com
        //Approve the seller you just used to sign up
        _loginPage.emailTexbox.sendKeys(System.getProperty("stg-backoffice.username"));
        _loginPage.passwordTexbox.sendKeys(System.getProperty("stg-backoffice.password"));
        _loginPage.signInbutton.click();
        //_backOfficePage.Approvals.click();
        //_backOfficePage.ViewDetails.click();
        //_backOfficePage.ViewDetailApprove.click();
        //Login to merchant Ui as your seller
        //LoginMerchantUiSuccessfully();
    }


    //Display customized rates
    public void DisplayCustomizedRates() {
        _merchant_page.import_export_textbox.click();
        _merchant_page.from_textbox.click();
        _merchant_page.to_textbox.click();
        _merchant_page.weight_textbox.sendKeys("0.5");
        _merchant_page.show_shipping_prices.click();
    }



    //Courier Integration_________________________________________________________________________________________________________________________________________________________________
    public void create_domestic_shipment_add_dangerous_goods() throws InterruptedException {
        try {
            log.info("starting TC ID - 36708: Create a domestic shipment test case");
            _loginActions.LoginMerchantUiSuccessfully();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/main[1]/ul/li[2]/span")).click();
            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .ignoring(StaleElementReferenceException.class)
                    .until((WebDriver d) -> {
                        d.findElement(By.xpath("//span[normalize-space()='Create Shipment']")).click();
                        return true;
                    });

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li:nth-child(50)")));
            driver.findElement(By.cssSelector("li:nth-child(50)")).click();//first address
            _merchant_page.continue_button.click();
            //driver.findElement(By.cssSelector("body > div:nth-child(4) > div:nth-child(1) > main:nth-child(2) > main:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(3) > button:nth-child(5) > span:nth-child(1)")).click();
            //_commonActions.add_UAE_address();
            String fullname = _commonActions.getSaltString();
            _merchant_page.ship_to_fullname_textbox.sendKeys(fullname);
            _merchant_page.ship_to_company_name.sendKeys(fullname);
            _merchant_page.ship_to_country_dropdown.sendKeys("United Arab");
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='rc-virtual-list-holder'] div:nth-child(2)")));
            driver.findElement(By.cssSelector("div[class='rc-virtual-list-holder'] div:nth-child(2)")).click();
            _merchant_page.ship_to_city_dropdown.click();
            driver.findElement(By.cssSelector("div[title='Abu Dhabi'] div[class='ant-select-item-option-content']")).click();
            _merchant_page.address_Line_1_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_phone_number.click();
            _merchant_page.ship_to_phone_number.clear();
            _merchant_page.ship_to_phone_number.sendKeys(_commonActions.UAE_random_phone_number());
            _merchant_page.continue_button.click();
            _merchant_page.shipment_reference_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.description_of_your_document_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_quantity_textbox.sendKeys("7");
            _merchant_page.shipment_weight_value_textbox.click();
            _merchant_page.shipment_weight_value_textbox.clear();
            _merchant_page.shipment_weight_value_textbox.sendKeys("7");
            _merchant_page.continue_button.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/main/main/div/div/div[2]/div[1]/div/form/div[1]/div/div[2]/div/div/div/div[1]/div/div[1]")));
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/main/div/div/div[2]/div[1]/div/form/div[1]/div/div[2]/div/div/div/div[1]/div/div[1]")).click();//choose first courier
            _merchant_page.create_my_order_button.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[normalize-space()=\"Order created\"]")));
            Assert.assertTrue(driver.findElement(By.xpath("//h4[normalize-space()=\"Order created\"]")).isDisplayed());
            /*_merchant_page.ship_to_address.sendKeys(_commonActions.getSaltString());




            _merchant_page.ship_to_email.sendKeys(_commonActions.getSaltString() + "@gmail.com");
            _merchant_page.shipment_description.sendKeys(_commonActions.getSaltString());

            _
            _merchant_page.shipment_pieces_textbox.sendKeys("5");
            _merchant_page.shipment_weight_value_textbox.click();

            _merchant_page.dangerous_goods.click();
            _merchant_page.create_order_button.click();
            Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()=\"Shipments\"]")).isDisplayed());*/
            log.info("successfully created a domestic shipment - test passed");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("could not create a domestic shipment - test failed");
            Assert.fail("could not create a domestic shipment - test failed");
        }
    }

    public void create_domestic_shipment_is_document_goods() throws InterruptedException {
        try {
            log.info("starting TC ID - 36708: Create a domestic shipment test case");
            _loginActions.LoginMerchantUiSuccessfully();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/main[1]/ul/li[2]/span")).click();
            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .ignoring(StaleElementReferenceException.class)
                    .until((WebDriver d) -> {
                        d.findElement(By.xpath("//span[normalize-space()='Create Shipment']")).click();
                        return true;
                    });

            _commonActions.add_UAE_address();
            driver.findElement(By.cssSelector(".ant-select-selection-search-input[autocomplete=\"off\"][aria-expanded=\"true\"]")).click();
            driver.findElement(By.cssSelector("body > div:nth-child(14) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > form:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)")).click();
            _merchant_page.ship_to_fullname_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_address.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_country_dropdown.sendKeys("United Arab");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'United Arab Emirates')]")));
            driver.findElement(By.xpath("//div[contains(text(),'United Arab Emirates')]")).click();
            _merchant_page.ship_to_city_dropdown.click();
            driver.findElement(By.cssSelector("div[title='Abu Dhabi'] div[class='ant-select-item-option-content']")).click();
            _merchant_page.ship_to_phone_number.sendKeys(_commonActions.UAE_random_phone_number());
            _merchant_page.ship_to_email.sendKeys(_commonActions.getSaltString() + "@gmail.com");
            _merchant_page.shipment_description.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_reference_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_quantity_textbox.sendKeys("3");
            _merchant_page.shipment_pieces_textbox.sendKeys("5");
            _merchant_page.shipment_weight_value_textbox.click();
            _merchant_page.shipment_weight_value_textbox.sendKeys("7");
            _merchant_page.is_this_a_document_checkbox.click();
            _merchant_page.dangerous_goods.click();
            _merchant_page.create_order_button.click();
            Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()=\"Shipments\"]")).isDisplayed());
            log.info("successfully created a domestic shipment - test passed");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("could not create a domestic shipment - test failed");
            Assert.fail("could not create a domestic shipment - test failed");
        }
    }

    public void create_domestic_shipment_no_dangerous_goods() throws InterruptedException {
        try {
            log.info("starting TC ID - 36708: Create a domestic shipment test case");
            _loginActions.LoginMerchantUiSuccessfully();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/main[1]/ul/li[2]/span")).click();
            new WebDriverWait(driver, Duration.ofSeconds(60))
                    .ignoring(StaleElementReferenceException.class)
                    .until((WebDriver d) -> {
                        d.findElement(By.xpath("//span[normalize-space()='Create Shipment']")).click();
                        return true;
                    });

            _commonActions.add_UAE_address();
            _merchant_page.ship_to_fullname_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_address.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_country_dropdown.sendKeys("United Arab");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'United Arab Emirates')]")));
            driver.findElement(By.xpath("//div[contains(text(),'United Arab Emirates')]")).click();
            _merchant_page.ship_to_city_dropdown.click();
            driver.findElement(By.cssSelector("div[title='Abu Dhabi'] div[class='ant-select-item-option-content']")).click();
            _merchant_page.ship_to_phone_number.sendKeys(_commonActions.UAE_random_phone_number());
            _merchant_page.ship_to_email.sendKeys(_commonActions.getSaltString() + "@gmail.com");
            _merchant_page.shipment_description.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_reference_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_quantity_textbox.sendKeys("3");
            _merchant_page.shipment_pieces_textbox.sendKeys("5");
            _merchant_page.shipment_weight_value_textbox.click();
            _merchant_page.shipment_weight_value_textbox.sendKeys("7");
            _merchant_page.create_order_button.click();
            Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()=\"Shipments\"]")).isDisplayed());
            log.info("successfully created a domestic shipment - test passed");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("could not create a domestic shipment - test failed");
            Assert.fail("could not create a domestic shipment - test failed");
        }
    }

    public void create_domestic_shipment_COD() throws InterruptedException {
        try {
            log.info("starting TC ID - 36708: Create a domestic shipment test case");
            _loginActions.LoginMerchantUiSuccessfully();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/main[1]/ul/li[2]/span")).click();
            new WebDriverWait(driver, Duration.ofSeconds(60))
                    .ignoring(StaleElementReferenceException.class)
                    .until((WebDriver d) -> {
                        d.findElement(By.xpath("//span[normalize-space()='Create Shipment']")).click();
                        return true;
                    });

            _commonActions.add_UAE_address();
            _merchant_page.ship_to_fullname_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_address.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_country_dropdown.sendKeys("United Arab");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'United Arab Emirates')]")));
            driver.findElement(By.xpath("//div[contains(text(),'United Arab Emirates')]")).click();
            _merchant_page.ship_to_city_dropdown.click();
            driver.findElement(By.cssSelector("div[title='Abu Dhabi'] div[class='ant-select-item-option-content']")).click();
            _merchant_page.ship_to_phone_number.sendKeys(_commonActions.UAE_random_phone_number());
            _merchant_page.ship_to_email.sendKeys(_commonActions.getSaltString() + "@gmail.com");
            _merchant_page.shipment_description.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_reference_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_quantity_textbox.sendKeys("3");
            _merchant_page.shipment_pieces_textbox.sendKeys("5");
            _merchant_page.shipment_weight_value_textbox.click();
            _merchant_page.shipment_weight_value_textbox.sendKeys("7");
            _merchant_page.cod_switch.click();
            wait.until(ExpectedConditions.elementToBeClickable(_merchant_page.cod_amount_textbox));
            _merchant_page.cod_amount_textbox.sendKeys("20");
            _merchant_page.cod_currency_combobox.click();
            wait.until(ExpectedConditions.elementToBeClickable(_merchant_page.cod_currency_AED_selection));
            _merchant_page.cod_currency_AED_selection.click();
            _merchant_page.create_order_button.click();
            Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()=\"Shipments\"]")).isDisplayed());
            log.info("successfully created a domestic shipment - test passed");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("could not create a domestic shipment - test failed");
            Assert.fail("could not create a domestic shipment - test failed");
        }
    }

    //UAE
    public void create_international_shipment_add_dangerous_goods_UAE() throws InterruptedException {
        try {
            log.info("starting TC ID - 36709: Create an International shipment test case");
            _loginActions.LoginMerchantUiSuccessfully();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/main[1]/ul/li[2]/span")).click();
            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .ignoring(StaleElementReferenceException.class)
                    .until((WebDriver d) -> {
                        d.findElement(By.xpath("//span[normalize-space()='Create Shipment']")).click();
                        return true;
                    });

            _commonActions.add_UAE_address();
            _merchant_page.ship_to_fullname_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_address.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_country_dropdown.sendKeys("Saudi Arabia");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-select-item-option-content']//div[@class='ant-space-item'][normalize-space()='Saudi Arabia']")));
            driver.findElement(By.xpath("//div[@class='ant-select-item-option-content']//div[@class='ant-space-item'][normalize-space()='Saudi Arabia']")).click();
            _merchant_page.ship_to_city_dropdown.click();
            driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='Abha']")).click();
            _merchant_page.ship_to_phone_number.sendKeys(_commonActions.UAE_random_phone_number());
            _merchant_page.ship_to_email.sendKeys(_commonActions.getSaltString() + "@gmail.com");
            _merchant_page.shipment_description.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_reference_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_quantity_textbox.sendKeys("3");
            _merchant_page.shipment_pieces_textbox.sendKeys("5");
            _merchant_page.shipment_weight_value_textbox.click();
            _merchant_page.shipment_weight_value_textbox.sendKeys("7");
            _merchant_page.is_this_a_document_checkbox.click();
            _merchant_page.dangerous_goods.click();
            _merchant_page.declared_value_textbox.click();
            _merchant_page.declared_value_textbox.sendKeys("20");
            _merchant_page.create_order_button.click();
            Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()=\"Shipments\"]")).isDisplayed());
            log.info("successfully created an international shipment - test passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("could not create an international shipment - test failed");
            Assert.fail("could not create an international shipment - test failed");
        }

    }
    public void create_international_shipment_add_dangerous_goods_UK() throws InterruptedException {
        try {
            log.info("TBC: Create an International shipment to the UK");
            _loginActions.LoginMerchantUiSuccessfully();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/main[1]/ul/li[2]/span")).click();
            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .ignoring(StaleElementReferenceException.class)
                    .until((WebDriver d) -> {
                        d.findElement(By.xpath("//span[normalize-space()='Create Shipment']")).click();
                        return true;
                    });

            _commonActions.add_UAE_address();
            _merchant_page.ship_to_fullname_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_address.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_country_dropdown.sendKeys("Saudi Arabia");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-select-item-option-content']//div[@class='ant-space-item'][normalize-space()='Saudi Arabia']")));
            driver.findElement(By.xpath("//div[@class='ant-select-item-option-content']//div[@class='ant-space-item'][normalize-space()='Saudi Arabia']")).click();
            _merchant_page.ship_to_city_dropdown.click();
            driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='Abha']")).click();
            _merchant_page.ship_to_phone_number.sendKeys(_commonActions.UAE_random_phone_number());
            _merchant_page.ship_to_email.sendKeys(_commonActions.getSaltString() + "@gmail.com");
            _merchant_page.shipment_description.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_reference_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_quantity_textbox.sendKeys("3");
            _merchant_page.shipment_pieces_textbox.sendKeys("5");
            _merchant_page.shipment_weight_value_textbox.click();
            _merchant_page.shipment_weight_value_textbox.sendKeys("7");
            _merchant_page.is_this_a_document_checkbox.click();
            _merchant_page.dangerous_goods.click();
            _merchant_page.declared_value_textbox.click();
            _merchant_page.declared_value_textbox.sendKeys("20");
            _merchant_page.create_order_button.click();
            Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()=\"Shipments\"]")).isDisplayed());
            log.info("successfully created an international shipment - test passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("could not create an international shipment - test failed");
            Assert.fail("could not create an international shipment - test failed");
        }

    }

    public void create_international_shipment_add_dangerous_goods_Saudi() throws InterruptedException {
        try {
            log.info("TBC: Create an International shipment");
            _loginActions.LoginMerchantUiSuccessfully();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/main[1]/ul/li[2]/span")).click();
            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .ignoring(StaleElementReferenceException.class)
                    .until((WebDriver d) -> {
                        d.findElement(By.xpath("//span[normalize-space()='Create Shipment']")).click();
                        return true;
                    });

            _commonActions.add_UAE_address();
            _merchant_page.ship_to_fullname_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_address.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_country_dropdown.sendKeys("Saudi Arabia");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-select-item-option-content']//div[@class='ant-space-item'][normalize-space()='Saudi Arabia']")));
            driver.findElement(By.xpath("//div[@class='ant-select-item-option-content']//div[@class='ant-space-item'][normalize-space()='Saudi Arabia']")).click();
            _merchant_page.ship_to_city_dropdown.click();
            driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='Abha']")).click();
            _merchant_page.ship_to_phone_number.sendKeys(_commonActions.UAE_random_phone_number());
            _merchant_page.ship_to_email.sendKeys(_commonActions.getSaltString() + "@gmail.com");
            _merchant_page.shipment_description.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_reference_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_quantity_textbox.sendKeys("3");
            _merchant_page.shipment_pieces_textbox.sendKeys("5");
            _merchant_page.shipment_weight_value_textbox.click();
            _merchant_page.shipment_weight_value_textbox.sendKeys("7");
            _merchant_page.is_this_a_document_checkbox.click();
            _merchant_page.dangerous_goods.click();
            _merchant_page.declared_value_textbox.click();
            _merchant_page.declared_value_textbox.sendKeys("20");
            _merchant_page.create_order_button.click();
            Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()=\"Shipments\"]")).isDisplayed());
            log.info("successfully created an international shipment - test passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("could not create an international shipment - test failed");
            Assert.fail("could not create an international shipment - test failed");
        }
    }

    public void create_international_shipment_add_dangerous_goods_India() throws InterruptedException {
        try {
            log.info("TBC: Create an International shipment test case");
            _loginActions.LoginMerchantUiSuccessfully();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/main[1]/ul/li[2]/span")).click();
            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .ignoring(StaleElementReferenceException.class)
                    .until((WebDriver d) -> {
                        d.findElement(By.xpath("//span[normalize-space()='Create Shipment']")).click();
                        return true;
                    });

            _commonActions.add_India__address();
            _merchant_page.ship_to_fullname_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_address.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_country_dropdown.sendKeys("Saudi Arabia");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-select-item-option-content']//div[@class='ant-space-item'][normalize-space()='Saudi Arabia']")));
            driver.findElement(By.xpath("//div[@class='ant-select-item-option-content']//div[@class='ant-space-item'][normalize-space()='Saudi Arabia']")).click();
            _merchant_page.ship_to_city_dropdown.click();
            driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='Abha']")).click();
            _merchant_page.ship_to_phone_number.sendKeys(_commonActions.UAE_random_phone_number());
            _merchant_page.ship_to_email.sendKeys(_commonActions.getSaltString() + "@gmail.com");
            _merchant_page.shipment_description.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_reference_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_quantity_textbox.sendKeys("3");
            _merchant_page.shipment_pieces_textbox.sendKeys("5");
            _merchant_page.shipment_weight_value_textbox.click();
            _merchant_page.shipment_weight_value_textbox.sendKeys("7");
            _merchant_page.is_this_a_document_checkbox.click();
            _merchant_page.dangerous_goods.click();
            _merchant_page.declared_value_textbox.click();
            _merchant_page.declared_value_textbox.sendKeys("20");
            _merchant_page.create_order_button.click();
            Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()=\"Shipments\"]")).isDisplayed());
            log.info("successfully created an international shipment - test passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("could not create an international shipment - test failed");
            Assert.fail("could not create an international shipment - test failed");
        }

    }

    public void create_international_shipment_no_dangerous_goods() {
        try {
            log.info("starting TC ID - 36709: Create an International shipment test case");
            _loginActions.LoginMerchantUiSuccessfully();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/main[1]/ul/li[2]/span")).click();
            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .ignoring(StaleElementReferenceException.class)
                    .until((WebDriver d) -> {
                        d.findElement(By.xpath("//span[normalize-space()='Create Shipment']")).click();
                        return true;
                    });

            _commonActions.add_UAE_address();
            log.info("address added successfully");
            _merchant_page.ship_to_fullname_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_address.sendKeys(_commonActions.getSaltString());
            _merchant_page.ship_to_country_dropdown.sendKeys("Saudi Arabia");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-select-item-option-content']//div[@class='ant-space-item'][normalize-space()='Saudi Arabia']")));
            driver.findElement(By.xpath("//div[@class='ant-select-item-option-content']//div[@class='ant-space-item'][normalize-space()='Saudi Arabia']")).click();
            _merchant_page.ship_to_city_dropdown.click();
            driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='Abha']")).click();
            _merchant_page.ship_to_phone_number.sendKeys(_commonActions.UAE_random_phone_number());
            _merchant_page.ship_to_email.sendKeys(_commonActions.getSaltString() + "@gmail.com");
            _merchant_page.shipment_description.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_reference_textbox.sendKeys(_commonActions.getSaltString());
            _merchant_page.shipment_quantity_textbox.sendKeys("3");
            _merchant_page.shipment_pieces_textbox.sendKeys("5");
            _merchant_page.shipment_weight_value_textbox.click();
            _merchant_page.shipment_weight_value_textbox.sendKeys("7");
            _merchant_page.is_this_a_document_checkbox.click();
            _merchant_page.declared_value_textbox.click();
            _merchant_page.declared_value_textbox.sendKeys("20");
            _merchant_page.create_order_button.click();
            Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()=\"Shipments\"]")).isDisplayed());
            log.info("successfully created an international shipment - test passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("could not create an international shipment - test failed");
            Assert.fail("could not create an international shipment - test failed");
        }

    }

    public void create_bulk_shipment() throws InterruptedException{
        log.info("starting TC ID - 34206: Incorrect Username/Correct password validation test case");
        _loginActions.LoginMerchantUiSuccessfully();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/main[1]/ul/li[2]/span")).click();
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    d.findElement(By.xpath("//span[normalize-space()=\"Bulk Create\"]")).click();
                    return true;
                });

        WebElement element = driver.findElement(By.cssSelector("#root > div > div > main > main > div > div > main > div.steps-content > div > span > div.css-dev-only-do-not-override-1r0hevj.ant-upload.ant-upload-drag > span > div > p.ant-upload-hint"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys("/Users/mlungisimbele/Downloads/Domestic_Template_Data_V1 1 1.xlsx");
        //driver.findElement(By.xpath("//p[normalize-space()=\"Click or drag file to this area to upload\"]"));

        //driver.findElement(By.xpath("//p[normalize-space()=\"Click or drag file to this area to upload\"]")).click();
        //upload.sendKeys("/Users/mlungisimbele/Downloads/Domestic_Template_Data_V1 1 1.xlsx");
        //Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()=\"Shipments\"]")).isDisplayed());
    }


    //Create an account as an individual
    public void SignUpIndividual() {
        try {
            log.info("starting TC ID - 35088: Sign Up - Individual functionality test case");
            _loginPage.signUplink.click();
            _loginPage.individualRadioButton.click();
            _loginPage.SignUpEmailTextBox.sendKeys(_commonActions.getSaltString() + "@gmail.com");
            _loginPage.SignUpFullNameTextBox.sendKeys(_commonActions.getSaltString() + " " + _commonActions.getSaltString());
            _loginPage.SignUpPhoneTextBox.sendKeys(_commonActions.UAE_random_phone_number());
            _loginPage.SignUpPasswordTextBox.sendKeys("Waslah@123");
            _loginPage.SignUpMarketingCheckBox.click();
            _loginPage.SignUpIndividualCreateAccountButton.click();
            wait.until(ExpectedConditions.visibilityOf(_merchant_page.very_email_message));
            Assert.assertTrue(_merchant_page.very_email_message.isDisplayed());
            log.info("Individual signed up successfully - test passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.info("Individual failed to sign up for an account - test failed");
            Assert.fail("Individual failed to sign up for an account - test failed");
        }
    }

    //Create an account as a company
    public void SignUpCompany() {
        try {
            log.info("starting TC ID - 35086: Sign Up - Company functionality test case");
            _loginPage.signUplink.click();
            _loginPage.companyRadioButton.click();
            _loginPage.SignUpEmailTextBox.sendKeys(_commonActions.getSaltString() + "@gmail.com");
            _loginPage.SignUpFullNameTextBox.sendKeys(_commonActions.getSaltString() + " " + _commonActions.getSaltString());
            _loginPage.SignUpCompanyNameTextBox.sendKeys(_commonActions.company_name);
            _loginPage.SignUpWebsiteTextBox.sendKeys("www." + _commonActions.company_name + ".com");
            _loginPage.SignUpPhoneTextBox.click();
            _loginPage.SignUpPhoneTextBox.clear();
            _loginPage.SignUpPhoneTextBox.sendKeys(_commonActions.UAE_random_phone_number());
            _loginPage.SignUpPasswordTextBox.sendKeys("Waslah@123");
            _loginPage.SignUpMarketingCheckBox.click();
            _loginPage.SignUpCompanyCreateAccountButton.click();
            wait.until(ExpectedConditions.visibilityOf(_merchant_page.very_email_message));
            Assert.assertTrue(_merchant_page.very_email_message.isDisplayed());
            log.info("Company signed up successfully  - test passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.info("Company failed to sign up for an account - test failed");
            Assert.fail("Company failed to sign up for an account - test failed");
        }
    }

    //Add a product
    public void AddProduct() {
        try {
//            log.info("starting TC ID - TBC: Add a product test case");
            _merchant_page.products.click();
            _merchant_page.add_new_product_button.click();
            _merchant_page.men_category.click();
            _merchant_page.next_button.click();
//            _merchant_page.product_name_textbox.sendKeys(_commonActions.getSaltString());
//            _merchant_page.product_description_textbox.sendKeys(_commonActions.getSaltString50());
//            _merchant_page.selling_price_textbox.sendKeys("100");
//            _merchant_page.sku_textbox.sendKeys("1234567890");
               _merchant_page.product_images.sendKeys("/Users/mlungisimbele/Documents/GitHub/waslah.web/src/main/resources/image.jpg");

//            _merchant_page.save_and_publish_button.click();
//            Assert.assertTrue(_merchant_page.product_added_success_message.isDisplayed());
//            log.info("product added successfully  - test passed");
        }
        catch (Exception e) {
            e.printStackTrace();
            log.info("Product could not be added - test failed");
            Assert.fail("Product could not be added - test failed");
        }
    }
}
