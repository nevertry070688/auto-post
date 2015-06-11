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

    public abstract void GetFirstName();
    public abstract void GetLastName();
    public abstract void GetMiddleName();
    public abstract void GetBirthdayDay();
    public abstract void GetBirthdayMonth();
    public abstract void GetBirthdayYear();
    public abstract void GetSex();
    public abstract void GetPhoneNumber();
}
