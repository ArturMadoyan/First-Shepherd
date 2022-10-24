package NetsuiteTests;

import CompletionOfServiceOrder.ServiceOrderPage;
import NetSuitePages.Constants;
import NetSuitePages.CustomersPage;
import NetSuitePages.LoginPage;
import ShepherdPages.ShepherdHomePage;
import ShepherdPages.ShepherdLoginPage;
import Technics.Technic;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;


public class HomePageTest extends BaseTest {
    String newServiceIDCode;
    @Test
    public void CustomersPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        CustomersPage customers = new CustomersPage(driver);
        driver.get(Constants.CUSTOMERS_URL);
        loginPage.login();
        loginPage.chooseAnAccount();
        loginPage.verification("87947739");
        customers.customersPage(1);
        customers.serviceRequester(Technic.ARTUR_MADOYAN);
        newServiceIDCode = customers.newServiceID.getText();
        System.out.println(newServiceIDCode);

        Assert.assertTrue(driver.findElement(customers.assertTicketCreated)
                .getText().contains(Constants.TICKET_CREATED_MESSAGE));
    }
    @Test
    public void ShepherdHomePage() throws InterruptedException, AWTException {
        ShepherdLoginPage shepLoginPage = new ShepherdLoginPage(driver);
        ShepherdHomePage shepHomePage = new ShepherdHomePage(driver);
        CustomersPage cp = new CustomersPage(driver);
        driver.get(Constants.SHEPHERD_HOME_PAGE);
//        shepLoginPage.Login();
//        shepLoginPage.ifAppVersionUpdated();
//        shepLoginPage.selectTechnic(Technic.ARTUR_MADOYAN);
//        //System.out.println(newServiceIDCode);
        shepHomePage.selectServiceOrder();
        CompletionOfServiceOrder();
    }

    @Test
    public void CompletionOfServiceOrder() throws InterruptedException {
        ServiceOrderPage service = new ServiceOrderPage(driver);
        service.serviceOrderAssignEquipment();
        service.serviceOrderTimeEntry();
        service.serviceOrderServiceReport();
        //service.serviceOrderQualityChecks();
        service.serviceOrderServiceTasks();
        service.serviceSignature();
        service.serviceOrderAssignEquipment();
        service.serviceOrderCompleteTrip();

    }

    @Test
    public void TestGeneration() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://demo.automationtesting.in/Register.html");
        Thread.sleep(2500);
        loginPage.codeGeneration();
    }
}
//driver.navigate().to(url);