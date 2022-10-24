package NetSuitePages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenerateBackupCode extends BasePage{
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    WebDriverWait wait = new WebDriverWait(driver, 12);
    @FindBy(css = "[id='ns-component-6304364188783571-1793573278']")
    private WebElement generate2FABackupCodesButton;
    @FindBy(css = "[id='currentpassword']")
    private WebElement currentPasswordField;
    @FindBy(css = "[id='submitter']")
    private WebElement submitButton;

    public GenerateBackupCode(WebDriver driver) {
        super(driver);
    }
    public void generateNewCodes(){
        jse.executeScript("window.scrollBy(0,2000)");
        wait.until(ExpectedConditions.visibilityOf(generate2FABackupCodesButton));
        generate2FABackupCodesButton.click();
        wait.until(ExpectedConditions.visibilityOf(currentPasswordField));
        currentPasswordField.sendKeys("Artur1990a");
        submitButton.click();
        //Create list to get all generated codes and select one to the variable
    }
}
