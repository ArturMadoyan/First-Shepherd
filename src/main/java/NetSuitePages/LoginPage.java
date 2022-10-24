package NetSuitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    WebDriverWait wait = new WebDriverWait(driver, 12);
    @FindBy(css = "[id='email']")
    private WebElement emailField;
    @FindBy(css = "[id='password']")
    private WebElement passwordField;
    @FindBy(css = "[id='login-submit']")
    private WebElement loginSubmitButton;
    @FindBy(css = "[href='?account_switch=TSTDRV2160113']")
    private WebElement selectBeck_UpAccount;
    @FindBy(css = "[id='n-id-component-64']")
    private WebElement backUpCodesButton;
    @FindBy(css = "[id='n-id-component-32']")
    private WebElement verificationCodeField;
    @FindBy(css = "[id='n-id-component-58']")
    private WebElement verificationSubmitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='login-submit']")));
        emailField.sendKeys("artur@shepherdcmms.com");
        passwordField.sendKeys("Artur1990a");
        loginSubmitButton.click();
    }
    public void chooseAnAccount(){
        selectBeck_UpAccount.click();
    }
    public void verification(String beckUpCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='n-id-component-64']")));
        backUpCodesButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='n-id-component-32']")));
        verificationCodeField.sendKeys(beckUpCode);
        verificationSubmitButton.click();
    }
    public void codeGeneration(){
        jse.executeScript("window.scrollBy(0,2000)");
        List<WebElement> obj = driver.findElements(By.cssSelector("#daybox > option"));
        List<String> arrayList = new ArrayList<>();
            for (int i =0 ; i < obj.size(); i++) {

                System.out.println(obj.get(i).getText() + "---------------");
                arrayList.add(String.valueOf(obj.get(i).getText()));

            }
        System.out.println(arrayList.size() + "*******");
        System.out.println(arrayList.get(0));
        arrayList.remove(0);
        System.out.println(arrayList.get(0));



        //Write code generating logic there are 10 codes for verifying login the element of those are =
        //[id='code_fs_lbl']

    }
}