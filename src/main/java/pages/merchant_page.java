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
public class merchant_page extends base {

    @FindBy(id = "Courier")
    public WebElement courier_textbox;

    @FindBy(id = "Import/Export")
    public WebElement import_export_textbox;

    @FindBy(id = "From")
    public WebElement from_textbox;

    @FindBy(id = "To")
    public WebElement to_textbox;

    @FindBy(id = "Weight")
    public WebElement weight_textbox;

    @FindBy(css = "#shipment_is_dangerous_goods")
    public WebElement dangerous_goods;

    @FindBy(id = "ShowShippingPrices")
    public WebElement show_shipping_prices;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/main[1]/ul/li[2]/span")
    public WebElement shipments_textbox;

    @FindBy(xpath = "//div[normalize-space()=\"Please verify your email\"]")
    public WebElement very_email_message;


//CREATE SHIPMENT________________________________________________________________________________________________________________________________________________________________________
    @FindBy(xpath = "//span[normalize-space()='Create Shipment']")
    public WebElement create_shipments_button;

    @FindBy(id = "rc_select_17")
    public WebElement pickup_address_dropdown;

    @FindBy(id = "contact_name")
    public WebElement ship_to_fullname_textbox;

    @FindBy(id = "receiver_street1")
    public WebElement ship_to_address;

    @FindBy(id = "country")
    public WebElement ship_to_country_dropdown;

    @FindBy(id = "city")
    public WebElement ship_to_city_dropdown;

    @FindBy(css = "input[value=\"+971\"]")
    public WebElement ship_to_phone_number;

    @FindBy(id = "receiver_email")
    public WebElement ship_to_email;

    @FindBy(id = "shipment_description")
    public WebElement shipment_description;

    @FindBy(id = "company_name")
    public WebElement ship_to_company_name;

    @FindBy(id= "shipment_is_document")
    public WebElement is_this_a_document_checkbox;

    @FindBy(id = "reference")
    public WebElement shipment_reference_textbox;

    @FindBy(id = "quantity")
    public WebElement shipment_quantity_textbox;

    @FindBy(id = "shipment_pieces")
    public WebElement shipment_pieces_textbox;

    @FindBy(id = "weight_value")
    public WebElement shipment_weight_value_textbox;

    @FindBy(css = "button.ant-btn-primary:nth-child(2) > span:nth-child(1)")
    public WebElement create_order_button;

    @FindBy(xpath = "/html/body/div[6]/div/div[2]/div/div[2]/div[3]/button[1]/span")
    public WebElement cancel_button;

    @FindBy(id = "street1")
    public WebElement address_Line_1_textbox;

    @FindBy(id = "zipcode")
    public WebElement postal_code_textbox;

    @FindBy(id = "description")
    public WebElement description_of_your_document_textbox;

    @FindBy(xpath = "//span[normalize-space()=\"Continue\"]")
    public WebElement continue_button;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement create_my_order_button;

    @FindBy(xpath = "//h4[normalize-space()=\"Order created\"]")
    public WebElement order_created_message;

    @FindBy(xpath = "//span[normalize-space()=\"Schedule pickup now\"]")
    public WebElement schedule_pickup_button;

    @FindBy(css = "body div[id=\"root\"] div div div div div div div div div div div:nth-child(2) button:nth-child(1) span:nth-child(2)")
    public WebElement select_car_button;

    @FindBy(css = "body div[id=\"root\"] div main main div div div div div div div button:nth-child(1)")
    public WebElement deduct_button;

    @FindBy(css = "body > div:nth-child(10) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)")
    public WebElement insufficient_funds_message;

    //ADD MORE ADDRESS________________________________________________________________________________________________________________________________________________
    @FindBy(xpath = "//div[contains(text(),\"Add more\")]")
    public WebElement add_more_link;

    @FindBy(id = "contact_name")
    public WebElement add_more_contact_name_textbox;

    @FindBy(id = "contact_name")
    public WebElement add_more_company_name_textbox;

    @FindBy(id = "country")
    public WebElement add_more_country_combobox;

    @FindBy(id = "phone")
    public WebElement add_more_phone_textbox;

    @FindBy(css = "input[placeholder=\"Enter a location\"]")
    public WebElement add_more_enter_location_textbox;

    @FindBy(id = "city")
    public WebElement add_more_city_combobox;

    @FindBy(css = "#type")
    public WebElement add_more_address_type_combobox;

    @FindBy(xpath = "//div[contains(text(),'Pickup')]")
    public WebElement add_more_address_type_pickup;

    @FindBy(css = "span[title=\"Return\"]")
    public WebElement add_more_address_type_return;

    @FindBy(id = "default")
    public WebElement add_more_default_checkbox;

    @FindBy(id = "clearance_declaredValue")
    public WebElement declared_value_textbox;

    @FindBy(css = "div[class=\"ant-modal-wrap\"] button:nth-child(2) span:nth-child(1)")
    public WebElement add_more_ok_button;

    @FindBy(css = ".ant-switch-handle")
    public WebElement cod_switch;

    @FindBy(css = "#shipment_totalAmount")
    public WebElement cod_amount_textbox;

    @FindBy(css = "div[class='ant-select-item ant-select-item-option ant-select-item-option-active'] div:nth-child(2)")
    public WebElement cod_currency_AED_selection;

    @FindBy(css = "#shipment_currency")
    public WebElement cod_currency_combobox;

    @FindBy(xpath = "//div[normalize-space()=\"Address saved successful\"]")
    public WebElement add_more_success_message;

    @FindBy(xpath = "//span[normalize-space()=\"Close This Popup\"]")
    public WebElement add_more_close_pup_button;

    @FindBy(css = "div[title='Western Region'] div[class='ant-select-item-option-content']")
    public WebElement western_region_city_selection;//UAE City

    @FindBy(css = "div[title='Bristol'] div[class='ant-select-item-option-content']")
    public WebElement bristol_city_selection;// UK City

    @FindBy(css = "div[title='HUBLI'] div[class='ant-select-item-option-content']")
    public WebElement hubli_city_selection;//India City

    @FindBy(css = "div[title='Jarab'] div[class='ant-select-item-option-content']")
    public WebElement jarab_city_selection;//Saudi City


    //Products Page___________________________________________________________________________________________________________________________________________________________________

    @FindBy(xpath = "//span[@class=\"ant-menu-title-content\"][normalize-space()=\"Products\"]")
    public WebElement products;//Saudi City

    @FindBy(xpath = "//span[normalize-space()=\"Add new Product\"]")
    public WebElement add_new_product_button;

    @FindBy(xpath = "//li[normalize-space()=\"Men\"]")
    public WebElement men_category;

    @FindBy(xpath = "//li[normalize-space()=\"Women\"]")
    public WebElement women_category;

    @FindBy(xpath = "//span[normalize-space()='Next']")
    public WebElement next_button;

    @FindBy(id= "name_en")
    public WebElement product_name_textbox;

    @FindBy(id= "description_en")
    public WebElement product_description_textbox;

    @FindBy(id= "price")
    public WebElement selling_price_textbox;

    @FindBy(id= "sku")
    public WebElement sku_textbox;

    @FindBy(xpath= "//span[@role=\"button\"]")
    public WebElement product_images;

    @FindBy(xpath= "//span[normalize-space()=\"Save and Publish\"]")
    public WebElement save_and_publish_button;

    @FindBy(xpath= "//span[normalize-space()=\"Cancel\"]")
    public WebElement products_cancel_button;

    @FindBy(xpath= "//div[@class='ant-notification-notice-message']")
    public WebElement product_added_success_message;



    WebDriverWait wait;

    public merchant_page() {
        //this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
}
