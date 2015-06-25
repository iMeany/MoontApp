package com.example.muntis.moontapp;

import com.example.muntis.moontapp.MyActivity;
import com.example.muntis.moontapp.MyConnections;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Random;


public class gameActivity extends ActionBarActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // getting data from passed intent
        Intent intent = getIntent();
        String nickTxt = intent.getStringExtra("nick");

        GameClientTask gameTask = new GameClientTask(MyConnections.inStream, MyConnections.outStream, this, nickTxt);

        // @todo set api level
        //if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.HONEYCOMB) {
            gameTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        //}
        //else {
        //    gameTask.execute();
        //}


        TextView topTxt = (TextView) findViewById(R.id.topText);
        // @todo get other nick
        topTxt.setText(nickTxt + " vs " + "other_nick_here");

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
        //TextView dbgTxt = (TextView) findViewById(R.id.debugTxt);
        //dbgTxt.setText("Button pressed: " + b.getText().toString());

        Intent intent = getIntent();
        MyConnections.outStream.println("MOVE|" + intent.getStringExtra("nick") + "|" + b.getText().toString());


    }

    public class GameClientTask extends AsyncTask<Integer, String, Integer> {

        GameClientTask(BufferedReader in, PrintWriter out, gameActivity ga, String n) {
            outStrm = out;
            inStrm = in;
            myActivity = ga;
            playerNick = n;
        }

        public PrintWriter outStrm;
        public BufferedReader inStrm;

        public gameActivity myActivity;
        public String playerNick;

        @Override
        protected Integer doInBackground(Integer... params) {

            BufferedReader serverData = null;
            Boolean boardGet = false;

            try {
                inStrm = new BufferedReader(new InputStreamReader(MyConnections.socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Boolean connected = true;
                while(connected) {
                    String line;
                    line = MyConnections.inStream.readLine();
                    MyConnections.outStream.print("Received " + line);

                }
            } finally {
                return 1;
            }

        }

        @Override
        protected void onProgressUpdate(String... progress) {
            //setContentView(R.layout.activity_game);
            //MoontGame curGame = new MoontGame(myActivity);

            //TextView a = (TextView) myActivity.findViewById(R.id.a2);
            //a.setText("111");

            //curGame.setA1(777);
        }


        @Override
        protected void onPostExecute(Integer result) {
            // @todo when the game ends?
            //textResponse.setText(result);
            //super.onPostExecute(result);
            return;
        }


    }
}
