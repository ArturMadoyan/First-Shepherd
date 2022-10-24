package ShepherdPages;

import NetSuitePages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShepherdHomePage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, 25);

    @FindBy(css = "//*[text()='Later']")
    private WebElement serviceOrderPopupLaterButton;
    @FindBy(css = "//*[text()='Go']")
    private WebElement serviceOrderPopupGoButton;
    @FindBy(css = "[class^='alert-button-i']")
    private WebElement remindersPopup;
    public By serviceOrderList = By.cssSelector("[data-sid='1']");

    public ShepherdHomePage(WebDriver driver) {
        super(driver);
    }
    public void selectServiceOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class^='alert-button-i']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class^='alert-button-i']")));
        remindersPopup.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='ion-text-wrap']")));

        try {
            serviceOrderPopupGoButton.click();
        }
        catch (Exception NoSuchElementException)
        {
            driver.findElement(serviceOrderList).click();
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[alt='loading...']")));
        }

    }





//List<WebElement> list = driver.findElements(By.cssSelector("div [data-sid="+2+"]"));
//        for(int i=0; i<list.size();i++ ){
//            if(list.get(i).getText().contains(id)){
//                list.get(i).click();
//                break; }