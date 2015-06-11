package AccountProcessing;

import java.util.ArrayList;

import AccountDTO.GoogleAccountDTO;
import AccountDataBase.AccountSQLiteHelper;

/**
 * Created by nevertry on 6/9/15.
 */
public class GoogleAccount extends AccountProcessing {

    public GoogleAccountDTO ggAccount;

    public GoogleAccount(){
        GetFirstName();
        GetLastName();
        GetMiddleName();
    }

    public int InsertFirstName(String FirstName){
       return this.accountSQLiteHelper.InsertFirstName(FirstName);
    }

    public int InsertLastName(String LastName){
        return this.accountSQLiteHelper.InsertLastName(LastName);
    }

    public int InsertMiddleName(String MiddleName){
        return this.accountSQLiteHelper.InsertMiddleName(MiddleName);
    }

    @Override
    public void GetFirstName() {
            this.FirstNameList = this.accountSQLiteHelper.GetFirstName();
    }

    @Override
    public void GetLastName() {
        this.LastNameList = this.accountSQLiteHelper.GetLastName();
    }

    @Override
    public void GetMiddleName() {
        this.MiddleNameList = this.accountSQLiteHelper.GetMiddleName();
    }

    @Override
    public void GetBirthdayDay() {

    }

    @Override
    public void GetBirthdayMonth() {

    }

    @Override
    public void GetBirthdayYear() {

    }

    @Override
    public void GetSex() {

    }

    @Override
    public void GetPhoneNumber() {

    }
}
