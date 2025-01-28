package tests;

import Base.base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import teststeps.login_actions;
import teststeps.merchant_actions;
import utilities.testlistener;
import java.util.concurrent.TimeUnit;

@Listeners(testlistener.class)
public class merchant_tests extends base {

    merchant_actions _merchant_actions;
    login_actions _login_actions;

    @BeforeMethod
    public void launchbrowser() {
        startBrowser();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        _merchant_actions = new merchant_actions();
        _login_actions = new login_actions();
    }

    @Test(description = "TC ID - 35086: Sign Up - Company functionality", priority = 1)
    public void SignUpCompany() {
        _merchant_actions.SignUpCompany();
    }

    @Test(description = "TC ID - 35088: Sign Up - Individual functionality", priority = 2)
    public void SignUpIndividual() {
        _merchant_actions.SignUpIndividual();
    }

    @Test(description = "TC ID - 37770: Create a domestic shipment using the new journey", priority = 3)
    public void CreateDomesticShipment() throws InterruptedException {
        _merchant_actions.create_domestic_shipment_add_dangerous_goods();
    }

    //@Test(description = "TC ID - 36708: Create a domestic shipment with no dangerous goods", priority = 4)
    public void CreateDomesticShipmentNoDangerousGoods() throws InterruptedException {
        _merchant_actions.create_domestic_shipment_no_dangerous_goods();
    }

    //@Test(description = "TBC: Create a domestic shipment with COD", priority = 4)
    public void CreateDomesticShipmentCOD() throws InterruptedException {
        _merchant_actions.create_domestic_shipment_COD();
    }

    //@Test(description = "TBC: Create a domestic shipment with is document", priority = 5)
    public void CreateDomesticShipmentIsDocument() throws InterruptedException {
        _merchant_actions.create_domestic_shipment_is_document_goods();
    }

    //Saudi Arabia
    //@Test(description = "TC ID - 37801: Create an International shipment with dangerous goods", priority = 6)
    public void CreateInternationalShipmentAddDangerousGoodsSaudi() throws InterruptedException{
        _merchant_actions.create_international_shipment_add_dangerous_goods_Saudi();
    }
    //UK
    //@Test(description = "TC ID - 37801: Create an International shipment with dangerous goods", priority = 7)
    public void CreateInternationalShipmentAddDangerousGoodsUK() throws InterruptedException {
        _merchant_actions.create_international_shipment_add_dangerous_goods_UK();
    }
    //India
    //@Test(description = "TC ID - 37801: Create an International shipment with dangerous goods", priority = 8)
    public void CreateInternationalShipmentAddDangerousGoodsIndia() throws InterruptedException {
        _merchant_actions.create_international_shipment_add_dangerous_goods_India();
    }

    //@Test(description = "TC ID - 36709: Create an International shipment with dangerous goods", priority = 9)
    public void CreateInternationalShipmentNoDangerousGoods() {
        _merchant_actions.create_international_shipment_no_dangerous_goods();
    }

    // @Test(description = "TC ID - 36709: Create a bulk shipment", priority = 16)
    public void CreateBulkShipment() throws InterruptedException {
        _merchant_actions.create_bulk_shipment();
    }
     @Test(description = "TC ID - TBC: Add a product", priority = 16)
    public void AddProduct() throws InterruptedException {
        _login_actions.LoginMerchantUiSuccessfully();
        _merchant_actions.AddProduct();
    }

    /*@Test(description = "TC ID - 36709: Filter pending shipments by country", priority = 7)
    public void PendingShipmentsByCountry() {
        _merchantactions.search_by_country();
    }*/

    @AfterMethod
    public void close()
    {
        closeBrowser();
    }
}
