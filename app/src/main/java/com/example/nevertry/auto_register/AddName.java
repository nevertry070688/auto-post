package com.example.nevertry.auto_register;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import AccountDataBase.AccountSQLiteHelper;


public class AddName extends ActionBarActivity {
    private AccountSQLiteHelper accHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);
        accHelper = AccountSQLiteHelper.getInstance(getApplicationContext());
        Button bt = (Button) findViewById(R.id.bt_add);
        bt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
               EditText tv = (EditText) findViewById(R.id.et_Name);
               String name = tv.getText().toString();

            int type = getIntent().getIntExtra("type",0);
            int result;
            switch(type)
            {
                case -1:
                    result = accHelper.InsertFirstName(name);
                    Toast.makeText(getApplicationContext(),"result is " + result,Toast.LENGTH_LONG).show();
                    break;
                case 0:
                    result = accHelper.InsertMiddleName(name);
                    Toast.makeText(getApplicationContext(),"result is " + result,Toast.LENGTH_LONG).show();
                    break;
                case 1:
                    result = accHelper.InsertLastName(name);
                    Toast.makeText(getApplicationContext(),"result is " + result,Toast.LENGTH_LONG).show();
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
