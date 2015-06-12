package com.example.nevertry.auto_register;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import AccountDataBase.AccountSQLiteHelper;
import AccountProcessing.GoogleAccount;





public class MainMenu extends ActionBarActivity {
    public GoogleAccount mGgAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //ggAccount = new GoogleAccount();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Manage_FirstName) {
            Intent it = new Intent(getApplicationContext(),FirstName.class);
            startActivity(it);
            return true;
        }
        if (id == R.id.action_Manage_LastName) {
            Intent it = new Intent(getApplicationContext(),LastName.class);
            startActivity(it);
            return true;
        }
        if (id == R.id.Manage_MiddleName) {
            Intent it = new Intent(getApplicationContext(),MiddleName.class);
            startActivity(it);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
    public void StartRegister(View e){
        e.setClickable(false);
        new Thread(new Runnable() {
            public void run() {

            }
        }).start();
    }
}
