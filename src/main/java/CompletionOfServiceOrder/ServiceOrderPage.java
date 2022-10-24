package CompletionOfServiceOrder;

import NetSuitePages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ServiceOrderPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    EventFiringWebDriver efWebDriver = new EventFiringWebDriver(driver);
    @FindBy(xpath = "//*[text()='Time Entry']") //
    private WebElement timeEntryDropDown;
    @FindBy(xpath = "//*[text()=' Add Time Entry ']")
    private WebElement addTimeEntryButton;
    @FindBy(css = "[aria-label=' Service Item *']")
    private WebElement serviceItemDropDown;
    @FindBy(css = "[class^='sele']:first-child")
    private WebElement firstOfServiceItems;
    @FindBy(xpath = "//*[text()='OK']")
    private WebElement okButton;
    @FindBy(css = "[class^='rounded margi']")
    private WebElement submitTimeEntryButton;
    @FindBy(css = "[class^='action-submit']:nth-child(4)")
    private WebElement submitButton;
    @FindBy(xpath = "//*[text()='Service Report']")
    private WebElement serviceReportDropDown;
    @FindBy(css = "app-custom-field:nth-child(10) > form > ion-item")
    private WebElement selectRequiredCheckBox;
    @FindBy(css = "app-custom-field:nth-child(16) > form > ion-item > ion-textarea > div > textarea")
    private WebElement requiredField;
    @FindBy(css = "[class^='action-submit-button ion-color']")
    private WebElement submitServiceReportButton;
    @FindBy(xpath = "//*[text()='Quality Checks']")
    private WebElement qualityChecksDropDown;
    private By qualityChecksCheckboxes =
            By.cssSelector("ion-list>ion-item>app-boolean>ion-button:nth-of-type(even)");
    @FindBy(css = "ion-button[class^='action-submit-button marginTop']")
    private WebElement qualityChecksSubmitButton;
    String scrollBar = "document.querySelector('[class=\"\\holistic-section section-scrollbar\"\\]').scrollTop = ";
    @FindBy(xpath = "//*[text()='Service Tasks']")
    private WebElement serviceTasksDropDown;
    @FindBy(css = "ion-item-group:nth-child(2) > ion-item > app-boolean > ion-button:nth-child(1)")
    private WebElement serviceTasksRequiredButton;
    @FindBy(css = "[class^='action-submit-button ion-color']:nth-child(5)")
    private WebElement serviceTasksSubmitButton;
    @FindBy(xpath = "//*[text()='Signature']")
    private WebElement signatureDropDown;
    @FindBy(css = "[name='signatureWaived']:nth-child(1)")
    private WebElement signatureCustomerSignatureField;
    @FindBy(css = "[name='techSignatureWaived']:nth-child(1)")
    private WebElement signatureTechnicianSignatureField;
    @FindBy(css = "app-signature>ion-card>ion-card-content>ion-button")
    private WebElement signatureSubmitButton;
    @FindBy(xpath = "//*[text()=' Skip ']")
    private WebElement feedbackPopupSkipButton;
    @FindBy(css = "[class^='additionalEquipmentButton']")
    private WebElement serviceOrderAdditionalEquipmentButton;
    @FindBy(xpath = "//*[text()=' Assign Equipment ']")
    private WebElement serviceOrderAssignEquipmentButton;
    @FindBy(css = "[data-sid='0']")
    private WebElement serviceOrderSelectFirstEquipment;
    @FindBy(css = "ion-button[color='success']:first-child")
    private WebElement assignSelectedEquipment;
    @FindBy(xpath = "//*[text()='Save and assign Equipment']")
    private WebElement saveAndAssignEquipmentPopup;
    @FindBy(xpath = "//*[text()=' Complete Trip ']")
    private WebElement completeTrip;
    public ServiceOrderPage(WebDriver driver) {
        super(driver);
    }

    public void serviceOrderAssignEquipment() throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[alt='loading...']")));
        wait.until(ExpectedConditions.elementToBeClickable(timeEntryDropDown));
        Thread.sleep(500);
        try {
            serviceOrderAssignEquipmentButton.click();
        }
        catch (NoSuchElementException exception) {
            serviceOrderAdditionalEquipmentButton.click();
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[alt='loading...']")));
        wait.until(ExpectedConditions.elementToBeClickable(serviceOrderSelectFirstEquipment));
        Thread.sleep(1000);
        serviceOrderSelectFirstEquipment.click();
        serviceOrderSelectFirstEquipment.click();
        wait.until(ExpectedConditions.elementToBeClickable(assignSelectedEquipment));
        assignSelectedEquipment.click();
        wait.until(ExpectedConditions.elementToBeClickable(saveAndAssignEquipmentPopup));
        saveAndAssignEquipmentPopup.click();
        Thread.sleep(15000);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[alt='loading...']")));
    }
    public void serviceOrderTimeEntry() throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[alt='loading...']")));
        wait.until(ExpectedConditions.elementToBeClickable(timeEntryDropDown));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(timeEntryDropDown));
        timeEntryDropDown.click();
        wait.until(ExpectedConditions.elementToBeClickable(addTimeEntryButton));
        addTimeEntryButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(serviceItemDropDown));
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(serviceItemDropDown));
        serviceItemDropDown.click();
        wait.until(ExpectedConditions.elementToBeClickable(firstOfServiceItems));
        firstOfServiceItems.click();
        wait.until(ExpectedConditions.elementToBeClickable(okButton));
        okButton.click();
        submitTimeEntryButton.click();
        Thread.sleep(1000);
        efWebDriver.executeScript(scrollBar + " 500");
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }
    public void serviceOrderQualityChecks() throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[alt='loading...']")));
        wait.until(ExpectedConditions.elementToBeClickable(qualityChecksDropDown));
        Thread.sleep(1000);
        qualityChecksDropDown.click();
        wait.until(ExpectedConditions.elementToBeClickable(qualityChecksCheckboxes));
        List<WebElement> checkboxList = driver.findElements(qualityChecksCheckboxes);
        for (WebElement webElement : checkboxList) {
            webElement.click();
        }
        efWebDriver.executeScript(scrollBar + " 800");
        wait.until(ExpectedConditions.elementToBeClickable(qualityChecksSubmitButton));
        qualityChecksSubmitButton.click();
    }
    public void serviceOrderServiceReport() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(serviceReportDropDown));
        Thread.sleep(1000);
        serviceReportDropDown.click();
        Thread.sleep(1000);
        efWebDriver.executeScript(scrollBar + " 700");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(selectRequiredCheckBox));
        selectRequiredCheckBox.click();
        efWebDriver.executeScript(scrollBar + " 1100");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(requiredField));
        requiredField.sendKeys("Shepherd");
        efWebDriver.executeScript(scrollBar + " 1750");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(submitServiceReportButton));
        submitServiceReportButton.click();
    }
    public void serviceOrderServiceTasks() throws InterruptedException {
        Thread.sleep(500);
        serviceTasksDropDown.click();
        wait.until(ExpectedConditions.elementToBeClickable(serviceTasksRequiredButton));
        serviceTasksRequiredButton.click();
        efWebDriver.executeScript(scrollBar + " 1700");
        serviceTasksSubmitButton.click();
    }
    public void serviceSignature() throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[alt='loading...']")));
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(signatureDropDown));
        signatureDropDown.click();
        efWebDriver.executeScript(scrollBar + " 500");
        wait.until(ExpectedConditions.elementToBeClickable(signatureCustomerSignatureField));
        signatureCustomerSignatureField.sendKeys("Customer Signature");
        efWebDriver.executeScript(scrollBar + " 800");
        Thread.sleep(1000);
        signatureTechnicianSignatureField.sendKeys("Technician Signature");
        signatureSubmitButton.click();
        feedBackPopup();
    }
    public void feedBackPopup(){
        wait.until(ExpectedConditions.elementToBeClickable(feedbackPopupSkipButton)).click();
        feedbackPopupSkipButton.click();
    }
    public void serviceOrderCompleteTrip(){
        wait.until(ExpectedConditions.elementToBeClickable(completeTrip));
        completeTrip.click();
    }
}