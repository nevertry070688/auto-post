package com.example.nevertry.auto_register;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import AccountDataBase.AccountSQLiteHelper;


public class LastName extends ActionBarActivity {
    private AccountSQLiteHelper accHelper;
    private ArrayList<String> LastNameList;
    private ArrayList<String> IdLastNameList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_name);
        LastNameList = accHelper.GetFirstName();
        IdLastNameList = accHelper.GetIdFirstName();
        NameAdapter disadpt = new NameAdapter(LastName.this,IdLastNameList,LastNameList);
        ListView lv = (ListView) findViewById(R.id.FN_listview);
        lv.setAdapter(disadpt);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_last_name, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
