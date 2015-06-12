package AccountDataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import AccountDTO.GoogleAccountDTO;

/**
 * Created by nevertry on 6/9/15.
 */
public class AccountSQLiteHelper extends SQLiteOpenHelper {
    private static AccountSQLiteHelper sInstance;
    private static SQLiteDatabase db ;
    private static final int databaseVersion = 1;
    // Database Name
    private static final String databaseName = "account_register";
    // Login table name
    private static final String googleAccount = "GoogleAccount";

    public interface Tables{
        static final String GoogleAccount = "GoogleAccount";
        static final String FirstName = "FirstName";
        static final String MiddleName = "MiddleName";
        static final String LastName = "LastName";
    }
    public static synchronized AccountSQLiteHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new AccountSQLiteHelper(context.getApplicationContext());
            db = sInstance.getWritableDatabase();
        }
        return sInstance;
    }
    public interface GoogleAccountDbColumn {
        // Login Table Columns names
         static final String keyId = "No";
         static final String FirstName = "FirstName";
         static final String LastName = "LastName";
         static final String emailAddress = "emailAddress";
         static final String password = "password";
         static final String birthday_day = "birthday_day";
         static final String birthday_month = "birthday_month";
         static final String birthday_year = "birthday_year";
         static final String sex = "sex";
         static final String phoneNumber = "phoneNumber";
         static final String currentEmail = "currentEmail";
         static final String skipVerification = "skipVerification";
         static final String insertText = "insertText";
         static final String loginSuccess = "loginSuccess";
    }
    public interface FirstNameDbColumn {
        // Login Table Columns names
        static final String keyId = "No";
        static final String FirstName = "FirstName";
    }

    public interface MiddleNameDbColumn {
        // Login Table Columns names
        static final String keyId = "No";
        static final String MiddleName = "MiddleName";
    }
    public interface LastNameDbColumn {
        // Login Table Columns names
        static final String keyId = "No";
        static final String LastName = "LastName";
    }


    public AccountSQLiteHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        setupTables(sqLiteDatabase);

    }
    private void setupTables(SQLiteDatabase db) {
       // db.execSQL("CREATE TABLE constants (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, value REAL);");
        String createGoogleAccountTable = "CREATE TABLE " + Tables.GoogleAccount + " ("
                + GoogleAccountDbColumn.keyId + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + GoogleAccountDbColumn.FirstName + " TEXT,"
                + GoogleAccountDbColumn.LastName + " TEXT, "
                + GoogleAccountDbColumn.emailAddress + " TEXT, "
                + GoogleAccountDbColumn.password + " TEXT, "
                + GoogleAccountDbColumn.birthday_day + " TEXT, "
                + GoogleAccountDbColumn.birthday_month + " TEXT, "
                + GoogleAccountDbColumn.birthday_year + " TEXT, "
                + GoogleAccountDbColumn.sex + " INTEGER, "
                + GoogleAccountDbColumn.phoneNumber + " TEXT, "
                + GoogleAccountDbColumn.currentEmail + " TEXT, "
                + GoogleAccountDbColumn.skipVerification + " INTEGER, "
                + GoogleAccountDbColumn.insertText + " TEXT, "
                + GoogleAccountDbColumn.loginSuccess + " TEXT"
                + ")";
        String createFirstNameTable = "CREATE TABLE " + Tables.FirstName + " ("
                + FirstNameDbColumn.keyId + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + FirstNameDbColumn.FirstName + " TEXT"
                + ");";
        String createMiddleNameTable = "CREATE TABLE " + Tables.MiddleName + " ("
                + MiddleNameDbColumn.keyId + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + MiddleNameDbColumn.MiddleName + " TEXT"
                + ");";
        String createLastNameTable = "CREATE TABLE " + Tables.LastName + " ("
                + LastNameDbColumn.keyId + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + LastNameDbColumn.LastName + " TEXT"
                + ");";
        db.execSQL(createFirstNameTable);
        db.execSQL(createMiddleNameTable);
        db.execSQL(createLastNameTable);
        db.execSQL(createGoogleAccountTable);
    }
    public int InsertGoogleAccountTable(GoogleAccountDTO googleaccount)
    {
       // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(GoogleAccountDbColumn.FirstName,googleaccount.FirstName);
        values.put(GoogleAccountDbColumn.LastName,googleaccount.LastName);
        values.put(GoogleAccountDbColumn.emailAddress,googleaccount.emailAddress);
        values.put(GoogleAccountDbColumn.password,googleaccount.password);
        values.put(GoogleAccountDbColumn.birthday_day,googleaccount.birthday_day);
        values.put(GoogleAccountDbColumn.birthday_month,googleaccount.birthday_month);
        values.put(GoogleAccountDbColumn.birthday_year,googleaccount.birthday_year);
        values.put(GoogleAccountDbColumn.sex,googleaccount.sex);
        values.put(GoogleAccountDbColumn.phoneNumber,googleaccount.phoneNumber);
        values.put(GoogleAccountDbColumn.currentEmail,googleaccount.currentEmail);
        values.put(GoogleAccountDbColumn.phoneNumber,googleaccount.phoneNumber);
        values.put(GoogleAccountDbColumn.skipVerification,googleaccount.skipVerification);
        values.put(GoogleAccountDbColumn.insertText,googleaccount.insertText);
        values.put(GoogleAccountDbColumn.loginSuccess,googleaccount.loginSuccess);
        return(int) db.insert(Tables.GoogleAccount,null,values);
    }

    public int InsertFirstName(String FirstName)
    {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FirstNameDbColumn.FirstName,FirstName);
        return(int) db.insert(Tables.FirstName,null,values);
    }
    public int InsertMiddleName(String MiddleName)
    {
       // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MiddleNameDbColumn.MiddleName,MiddleName);
        return(int) db.insert(Tables.MiddleName,null,values);
    }
    public int InsertLastName(String LastName)
    {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LastNameDbColumn.LastName,LastName);
        return(int) db.insert(Tables.LastName,null,values);
    }
    public ArrayList<String> GetFirstName(){
        String selectQuery = "Select * from " +
                Tables.FirstName ;
        //SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<String> FirstNameList = new ArrayList<String>();
        String name;
        if(cursor != null){
            if(cursor.moveToFirst()){
                while (cursor.isAfterLast() == false) {
                    name = cursor.getString(cursor
                            .getColumnIndex(FirstNameDbColumn.FirstName));
                    FirstNameList.add(name);
                    cursor.moveToNext();
                }
            }

        }
        cursor.close();
        return FirstNameList;
    }
    public ArrayList<String> GetIdFirstName(){
        String selectQuery = "Select * from " +
                Tables.FirstName ;
        //SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<String> IdFirstNameList = new ArrayList<String>();
        String name;
        if(cursor != null){
            if(cursor.moveToFirst()){
                while (cursor.isAfterLast() == false) {
                    name = cursor.getString(cursor
                            .getColumnIndex(FirstNameDbColumn.keyId));
                    IdFirstNameList.add(name);
                    cursor.moveToNext();
                }
            }

        }
        cursor.close();
        return IdFirstNameList;
    }
    public ArrayList<String> GetMiddleName(){

        String selectQuery = "Select * from " +
                Tables.MiddleName ;
        //SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<String> MiddleNameList = new ArrayList<String>();
        String name;
        if(cursor != null){
            if(cursor.moveToFirst()){
                while (cursor.isAfterLast() == false) {
                    name = cursor.getString(cursor
                            .getColumnIndex(MiddleNameDbColumn.MiddleName));
                    MiddleNameList.add(name);
                    cursor.moveToNext();
                }
            }

        }
        cursor.close();
        return MiddleNameList;
    }
    public ArrayList<String> GetIdMiddleName(){
        String selectQuery = "Select * from " +
                Tables.MiddleName ;
        //SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<String> IdFirstNameList = new ArrayList<String>();
        String name;
        if(cursor != null){
            if(cursor.moveToFirst()){
                while (cursor.isAfterLast() == false) {
                    name = cursor.getString(cursor
                            .getColumnIndex(FirstNameDbColumn.keyId));
                    IdFirstNameList.add(name);
                    cursor.moveToNext();
                }
            }

        }
        cursor.close();
        return IdFirstNameList;
    }
    public ArrayList<String> GetLastName(){

        String selectQuery = "Select * from " +
                Tables.LastName ;
        //SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<String> LastNameList = new ArrayList<String>();
        String name;
        if(cursor != null){
            if(cursor.moveToFirst()){
                while (cursor.isAfterLast() == false) {
                    name = cursor.getString(cursor
                            .getColumnIndex(LastNameDbColumn.LastName));
                    LastNameList.add(name);
                    cursor.moveToNext();
                }
            }

        }
        cursor.close();
        return LastNameList;
    }
    public ArrayList<String> GetIdLastName(){
        String selectQuery = "Select * from " +
                Tables.LastName ;
        //SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        ArrayList<String> IdFirstNameList = new ArrayList<String>();
        String name;
        if(cursor != null){
            if(cursor.moveToFirst()){
                while (cursor.isAfterLast() == false) {
                    name = cursor.getString(cursor
                            .getColumnIndex(FirstNameDbColumn.keyId));
                    IdFirstNameList.add(name);
                    cursor.moveToNext();
                }
            }

        }
        cursor.close();
        return IdFirstNameList;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        int oldVersion;
    }
}
