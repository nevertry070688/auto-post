package com.example.nevertry.auto_register;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import AccountDataBase.AccountSQLiteHelper;


public class AddName extends ActionBarActivity {
    private AccountSQLiteHelper accHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);
        Button bt = (Button) findViewById(R.id.bt_add);
        bt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
               TextView tv = (TextView) findViewById(R.id.tv_name);
               String name = tv.toString();

            int type = Integer.parseInt(getIntent().getExtras().getString("type"));
            switch(type)
            {
                case -1:
                    accHelper.InsertFirstName(name);
                    break;
                case 0:
                    accHelper.InsertMiddleName(name);
                    break;
                case 1:
                    accHelper.InsertLastName(name);
                    break;
            }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_name, menu);
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
