package ShepherdPages;

import NetSuitePages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;

public class ShepherdLoginPage extends BasePage {


    WebDriverWait wait = new WebDriverWait(driver, 20);

    @FindBy(css = "[name='ion-input-1']")
    private WebElement accountField;
    @FindBy(css = "[name='ion-input-2']")
    private WebElement scriptId;
    @FindBy(css = "[name='ion-input-6']")
    private WebElement pageParameter;
    @FindBy(css = "[name='ion-input-3']")
    private WebElement email;
    @FindBy(css = "[name='ion-input-4']")
    private WebElement password;
    @FindBy(css = "ion-button[type='button']")
    private WebElement loginButton;
    @FindBy(css = "[class='alert-title sc-ion-alert-md']")
    private WebElement appVersionIsUpdatedPopup;
    @FindBy(css = "[class='alert-button-inner sc-ion-alert-md']")
    private WebElement appVersionIsUpdatedPopupOKButton;
    @FindBy(css = "[class^='alert-button ion-focusable ion-activatable alert-button-role-o']")
    private WebElement popupOkButton;
    public ShepherdLoginPage(WebDriver driver) throws AWTException {
        super(driver);
    }
    public void Login () throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='ion-input-1']")));
//        robot.keyPress(KeyEvent.VK_TAB);
//        robot.keyPress(KeyEvent.VK_TAB);
//        robot.keyPress(KeyEvent.VK_TAB);
//        Thread.sleep(300);
//        robot.keyPress(KeyEvent.VK_ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(accountField));
        accountField.sendKeys("TSTDRV2160113");
        scriptId.sendKeys("1104");
        pageParameter.sendKeys("55bb78ae66645a4f2105");
        email.sendKeys("artur@shepherdcmms.com");
        password.sendKeys("Shepherd");

        loginButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.
                cssSelector("[class^='alert-button ion-focusable ion-activatable alert-button-role-o']")));
        popupOkButton.click();
    }
    public void ifAppVersionUpdated() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(appVersionIsUpdatedPopup));
        Thread.sleep(1000);
        System.out.println(appVersionIsUpdatedPopup.getText());
//        try {
//            appVersionIsUpdatedPopupOKButton.click();
//        }
//        catch(Exception e) {
//            //  Block of code to handle errors
//        }
        if(appVersionIsUpdatedPopup.getText().contains("Application Version Updated")){
            appVersionIsUpdatedPopupOKButton.click();
            Login();
            Thread.sleep(2000);
        }
        else Login();
    }
    public void selectTechnic(String technic) throws InterruptedException {
        Thread.sleep(4500);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[src='./assets/icons/shepherd-loading.svg']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.
                cssSelector("[class^='ionic-selectable-it']:nth-child(3)")));
        Thread.sleep(1000);
       List<WebElement> list = driver.findElements(By.
               cssSelector("[class='sc-ion-label-md-h sc-ion-label-md-s md hydrated']"));
                for(int i=0; i<list.size();i++ ) {
                    if (list.get(i).getText().contains(technic)) {
                        list.get(i).click();
                        break;
                    }
                }
    }

}
