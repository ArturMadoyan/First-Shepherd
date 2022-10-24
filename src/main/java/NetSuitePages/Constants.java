package NetSuitePages;


import org.openqa.selenium.WebDriver;

public class Constants {
    static WebDriver driver;
    public static final String SHEPHERD_HOME_PAGE =
            "https://shepherdcmms.azurewebsites.net/prerelease/#/serviceorder/desktop";
    public static final String HOME_PAGE_URL =
            "https://tstdrv2076705.app.netsuite.com/app/center/card.nl?sc=-29&whence=";
    public static final String LOGIN_VERIFICATION_URL =
            "https://tstdrv2076705.app.netsuite.com/app/login/secure/loginchallenge/entry.nl?src_dc=001&whence=";
    public static final String REDIRECTED_TO_LOGIN_URL =
            "https://tstdrv2076705.app.netsuite.com/app/login/secure/enterpriselogin.nl?c=TSTDRV2076705&redirect=%2Fapp%2Fcenter%2Fcard.nl%3Fsc%3D-29%26whence%3D&whence=";
    public static final String CUSTOMERS_URL =
            "https://tstdrv2076705.app.netsuite.com/app/common/entity/custjoblist.nl?Customer_STAGE=CUSTOMER&whence=";
    public static final String TICKET_CREATED_MESSAGE = "Service Order";

    public static final String NEW_CREATED_SERVICE_REQUESTER = null;
    public static void main(String[] args) throws InterruptedException {


    }
}


