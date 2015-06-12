package AccountProcessing;
import java.util.ArrayList;

import AccountDataBase.AccountDatabase;
import AccountDataBase.AccountSQLiteHelper;

/**
 * Created by nevertry on 6/9/15.
 */
public abstract class AccountProcessing {

    public ArrayList<String> FirstNameList;
    public ArrayList<String> MiddleNameList;
    public ArrayList<String> LastNameList;
    public AccountSQLiteHelper accountSQLiteHelper;

    public abstract String GetFirstName();
    public abstract String GetLastName();
    public abstract String GetMiddleName();
    public abstract String GetBirthdayDay();
    public abstract String GetBirthdayMonth();
    public abstract String GetBirthdayYear();
    public abstract int GetSex();
    public abstract String GetPhoneNumber();
}
