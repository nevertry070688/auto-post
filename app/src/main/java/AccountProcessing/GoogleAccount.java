package AccountProcessing;

import java.util.ArrayList;
import java.util.Random;

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
    public String GetFirstName() {
            this.FirstNameList = this.accountSQLiteHelper.GetFirstName();
            int NameRange = this.FirstNameList.size();
        if(NameRange > 0){
            Random rd = new Random();
            int Index = rd.nextInt(NameRange);
            return this.FirstNameList.get(Index);
        }
            return null;
    }

    @Override
    public String GetLastName() {
        this.LastNameList = this.accountSQLiteHelper.GetLastName();
        int NameRange = this.LastNameList.size();
        if(NameRange > 0){
            Random rd = new Random();
            int Index = rd.nextInt(NameRange);
            return this.LastNameList.get(Index);
        }
        return null;
    }

    @Override
    public String GetMiddleName() {
        this.MiddleNameList = this.accountSQLiteHelper.GetMiddleName();
        int NameRange = this.MiddleNameList.size();
        if(NameRange > 0){
            Random rd = new Random();
            int Index = rd.nextInt(NameRange);
            return this.MiddleNameList.get(Index);
        }
        return null;
    }

    @Override
    public String GetBirthdayDay() {

        return null;
    }

    @Override
    public String GetBirthdayMonth() {

        return null;
    }

    @Override
    public String GetBirthdayYear() {

        return null;
    }

    @Override
    public int GetSex() {

        return 0;
    }

    @Override
    public String GetPhoneNumber() {

        return null;
    }
}
