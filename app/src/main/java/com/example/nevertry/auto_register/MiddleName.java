package com.example.nevertry.auto_register;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import AccountDataBase.AccountSQLiteHelper;


public class MiddleName extends ActionBarActivity {
    private AccountSQLiteHelper accHelper;
    private ArrayList<String> MiddleNameList;
    private ArrayList<String> IdMiddleNameList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle_name);
        MiddleNameList = accHelper.GetMiddleName();
        IdMiddleNameList = accHelper.GetIdFirstName();
        NameAdapter disadpt = new NameAdapter(MiddleName.this,IdMiddleNameList,MiddleNameList);
        ListView lv = (ListView) findViewById(R.id.FN_listview);
        lv.setAdapter(disadpt);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_middle_name, menu);
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
