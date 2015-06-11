package com.example.nevertry.auto_register;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import AccountDataBase.AccountSQLiteHelper;
import android.widget.AdapterView;
import android.widget.ListView;

public class FirstName extends ActionBarActivity {
    private AccountSQLiteHelper accHelper;
    private ArrayList<String> FirstNameList;
    private ArrayList<String> IdFirstNameList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_name);
        accHelper = new AccountSQLiteHelper(this);
        FirstNameList = accHelper.GetFirstName();
        IdFirstNameList = accHelper.GetIdFirstName();
        NameAdapter disadpt = new NameAdapter(FirstName.this,IdFirstNameList,FirstNameList);
        ListView lv = (ListView) findViewById(R.id.FN_listview);
        lv.setAdapter(disadpt);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_name, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.FN_setting) {
            Intent it = new Intent(this.getApplicationContext(),AddName.class);
            it.putExtra("type",-1);
            startActivity(it);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
