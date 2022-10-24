package ShepherdTests;

import NetSuitePages.Constants;
import NetSuitePages.CustomersPage;
import NetsuiteTests.BaseTest;
import ShepherdPages.ShepherdHomePage;
import ShepherdPages.ShepherdLoginPage;
import org.junit.Test;

import java.awt.*;

public class ServiceOrderCompletion extends BaseTest {

    @Test
    public void ShepherdHomePage() throws InterruptedException, AWTException {
        ShepherdLoginPage shepLoginPage = new ShepherdLoginPage(driver);
        ShepherdHomePage shepHomePage = new ShepherdHomePage(driver);
        CustomersPage cp = new CustomersPage(driver);
        driver.get(Constants.SHEPHERD_HOME_PAGE);
        shepLoginPage.Login();
        //shepLoginPage.selectTechnic();
        //shepHomePage.selectServiceOrder(cp.newServiceRequesterID());
    }
}
