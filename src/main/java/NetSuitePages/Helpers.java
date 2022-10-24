package NetSuitePages;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Helpers {
    //get today date by format MM/dd/yyyy
        static String date = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());


}