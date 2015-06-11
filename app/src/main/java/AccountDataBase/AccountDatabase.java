package AccountDataBase;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 * Created by nevertry on 6/9/15.
 */
public abstract class AccountDatabase {
    public String databaseName;

    abstract public String GetLastName();
    abstract public String GetBirthdayDay();
    abstract public String GetBirthdayMonth();
    abstract public String GetBirthdayYear();
    abstract public int GetSex();
    abstract public String GetPhoneNumber();
}
