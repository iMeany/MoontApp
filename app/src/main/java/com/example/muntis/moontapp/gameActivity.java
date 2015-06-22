package com.example.muntis.moontapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;


public class gameActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);

        // getting data from passed intent
        Intent intent = getIntent();


        //connecting to server
        //@todo konekcija uz serveri

        String serverIP = intent.getStringExtra("serverIP");

        // setting nickname

        String nicktxt = intent.getStringExtra("nick");
        if (nicktxt.equals("")) {
            nicktxt = "Anonymous";
        }


        TextView ttt = (TextView) findViewById(R.id.topText);
        ttt.setText(nicktxt + " vs " + "other_nick_here");
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
