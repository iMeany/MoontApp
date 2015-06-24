package com.example.muntis.moontapp;

import com.example.muntis.moontapp.MyActivity;
import com.example.muntis.moontapp.MyConnections;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;


public class gameActivity extends ActionBarActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // getting data from passed intent
        Intent intent = getIntent();
        String nickTxt = intent.getStringExtra("nick");
        if (nickTxt.equals("")) {
            nickTxt = "Anonymous";
        }

        TextView topTxt = (TextView) findViewById(R.id.topText);
        // @todo get other nick
        topTxt.setText(nickTxt + " vs " + "other_nick_here");

        GameClientTask gameTask = new GameClientTask();
        gameTask.execute();


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


    public void onClick(View v) {

        Button b = (Button) v;
        TextView dbgTxt = (TextView) findViewById(R.id.debugTxt);
        dbgTxt.setText("Button pressed: " + b.getText().toString());

        Intent intent = getIntent();
        MyConnections.outStream.println("MOVE FROM " + intent.getStringExtra("nick") + " ANDROID: " + b.getText().toString());
    }

    public class GameClientTask extends AsyncTask<Void, Void, Void> {

        //int a = 1/0;
        public PrintWriter outStream;
        GameClientTask() {
            return;
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            try {
                outStream.println("????????????????????????????????????");
            } finally {
                return null;
            }

        }

        @Override
        protected void onPostExecute(Void result) {
            // @todo when the game ends?
            //textResponse.setText(response);
            super.onPostExecute(result);
        }

    }
}
