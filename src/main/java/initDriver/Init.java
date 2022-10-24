package initDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Init {
    WebDriver webDriver;

    public WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--user-data-dir=C:/Users/Dell/AppData/Local/Google/Chrome/User Data");
        opt.addArguments("--profile-directory=Profile 1");
        webDriver = new ChromeDriver(opt);
        return webDriver;
    }
}

