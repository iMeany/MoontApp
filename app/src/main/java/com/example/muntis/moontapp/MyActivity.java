package com.example.muntis.moontapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;


public class MyActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_my, menu);

        MenuInflater myinflater = getMenuInflater();
        myinflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // @todo izmantot shiis pogas
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_search:
                //openSearch();
                return true;
            case R.id.action_settings:
                //openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    //@todo muntis

    public void connectToServer(View view) {
        // when pressing connect on main screen
        Intent intent = new Intent(this, gameActivity.class);

        // grabbing data from fields into hashmap
        intent.putExtra("nick", ((EditText) findViewById(R.id.nick)).getText().toString());
        intent.putExtra("serverIP", ((EditText) findViewById(R.id.server_ip)).getText().toString());

        //starting next activity
        startActivity(intent);

    }

}




