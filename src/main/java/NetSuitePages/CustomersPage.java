package NetSuitePages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CustomersPage extends BasePage {

    JavascriptExecutor jse = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, 15);
    private int index;
    public By assertTicketCreated = By.cssSelector("[style='color:red;font-size:16px;']");
    @FindBy(css = "#custpage_srvreqmsg0_val > span > a")
    public WebElement newServiceID;
    private By customerIndex = By.cssSelector("#row" + index + " a.dottedlink.viewitem");
    private By serviceRequesterButton = By.cssSelector("[id='custpage_servicerequesterbtn']");
    //below serviceRequester page elements
    private By serviceDate = By.cssSelector("[id='custrecord_cmms_sca_service_date']"); //*
    private By technicianOrVendorField = By.cssSelector("#custrecord_cmms_sca_techs_vendors_fs > textarea");
    private By timeZoneCityDropDown = By.cssSelector("[id='inpt_custrecord_cmms_sca_timezone_source7']");
    private By firstCityFromTimeZoneDropDown = By.cssSelector("[id='nl3']");
    private By serviceOrderType = By.cssSelector("[id='inpt_custrecord_cmms_sca_service_order_type8']");
    private By maintenanceServiceFromDropDown = By.cssSelector("[id='nl10']");
    private By serviceZoneDropDown = By.cssSelector("[id='inpt_custpage_servicezone12']");
    private By selectServiceZone = By.cssSelector("[id='nl17']");
    private By serviceDropDown = By.cssSelector("[id='inpt_custpage_service17']");
    private By selectFirstService = By.cssSelector("[id='nl44']");
    private By contractSLADropDown = By.cssSelector("[id='inpt_custpage_contractservice18']");
    private By selectDemoContractFromSLA = By.cssSelector("[id='nl54']");
    private By saveButtonOnTheDown = By.cssSelector("[id='secondarysubmitter']");
    public CustomersPage(WebDriver driver) {
        super(driver);
    }
    public void customersPage(int index) {
        this.index = index;
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerIndex));
        driver.findElement(customerIndex).click();
    }
    public void serviceRequester(String technic) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(serviceRequesterButton));
        driver.findElement(serviceRequesterButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(serviceDate));
        Thread.sleep(4000);
        driver.findElement(technicianOrVendorField).sendKeys(technic + Keys.ENTER);
        driver.findElement(serviceDate).sendKeys(Helpers.date);
        Thread.sleep(250);
        jse.executeScript("window.scrollBy(0,650)");

        wait.until(ExpectedConditions.visibilityOfElementLocated(timeZoneCityDropDown));
        driver.findElement(timeZoneCityDropDown).click();
        driver.findElement(firstCityFromTimeZoneDropDown).click();
        driver.findElement(serviceOrderType).click();
        driver.findElement(maintenanceServiceFromDropDown).click();
        jse.executeScript("window.scrollBy(0,620)");

        wait.until(ExpectedConditions.elementToBeClickable(contractSLADropDown));
        driver.findElement(serviceZoneDropDown).click();
        driver.findElement(selectServiceZone).click();
        driver.findElement(serviceDropDown).click();
        driver.findElement(selectFirstService).click();
        driver.findElement(contractSLADropDown).click();
        driver.findElement(selectDemoContractFromSLA).click();

        jse.executeScript("window.scrollBy(0,500)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveButtonOnTheDown));
        driver.findElement(saveButtonOnTheDown).click();
    }

}
//customers element #row0 a.dottedlink.viewitem
