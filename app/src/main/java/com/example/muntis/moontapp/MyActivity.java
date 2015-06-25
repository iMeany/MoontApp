package com.example.muntis.moontapp;

import com.example.muntis.moontapp.MyConnections;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

import android.app.Notification;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyActivity extends Activity {

    TextView textResponse;
    EditText editTextAddress, editTextPort, editTextNick;
    Button buttonConnect, buttonClear;
    Activity curActiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        curActiv = this;

        editTextAddress = (EditText) findViewById(R.id.address);
        editTextPort = (EditText) findViewById(R.id.port);
        editTextNick = (EditText) findViewById(R.id.nick);
        buttonConnect = (Button) findViewById(R.id.connect);
        buttonClear = (Button) findViewById(R.id.clear);
        textResponse = (TextView) findViewById(R.id.response);

        buttonConnect.setOnClickListener(buttonConnectOnClickListener);

        buttonClear.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                textResponse.setText("");
            }
        });
    }

    OnClickListener buttonConnectOnClickListener =
            new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    MyClientTask myClientTask = new MyClientTask(editTextAddress.getText().toString(), Integer.parseInt(editTextPort.getText().toString()), curActiv);
                    myClientTask.execute();
                }
            };

    public class MyClientTask extends AsyncTask<Void, Intent, Void> {

        String dstAddress;
        int dstPort;
        String response = "";
        Activity curActiv;

        MyClientTask(String addr, int port, Activity a) {
            dstAddress = addr;
            dstPort = port;
            curActiv = a;
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            Socket mysocket = null;

            try {
                //creating socket and streams for server
                mysocket = new Socket(dstAddress, dstPort);

                BufferedReader inStream = new BufferedReader(new InputStreamReader(mysocket.getInputStream()));
                PrintWriter outStream = new PrintWriter(mysocket.getOutputStream(), true);;

                MyConnections conn = new MyConnections();
                conn.setInput(inStream);
                conn.setOutput(outStream);
                conn.setSocket(mysocket);

                String nickAnon = "Anonymous";
                while(true) {
                    String line = inStream.readLine();

                    if (line.startsWith("SUBMITNAME")) {
                        // if server wants nick -> grab it and send
                        nickAnon = ((EditText) curActiv.findViewById(R.id.nick)).getText().toString();
                        if (nickAnon.equals("") || nickAnon.equals("Anonymous")) {
                            Random r = new Random();
                            nickAnon = "Anonymous"+r.nextInt(9999);
                        }
                        outStream.println(nickAnon);

                    } else if (line.startsWith("NAMEACCEPTED")) {
                        // if server accepted nick -> join the game
                        // @todo check if there are 2 players and make game for them
                        editTextNick = (EditText) findViewById(R.id.nick);
                        Intent gameIntent = new Intent(MyActivity.this, gameActivity.class);
                        gameIntent.putExtra("nick", nickAnon);
                        publishProgress(gameIntent);

                    } else if (line.startsWith("MESSAGE")) {
                        // @todo game messages later here
                        //messageArea.append(line.substring(8) + "\n");

                    } else if (line.startsWith("GAMESTARTED")) {
                        MyConnections.outStream.println("pls work");


                    } else {

                        // @todo game moves here
                    }
                }

            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                response = "UnknownHostException: " + e.toString();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                response = "IOException: " + e.toString();
            } finally {
                textResponse.setText(response);
                if (mysocket != null) {
                    try {
                        mysocket.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Intent... progress) {
            startActivity(progress[0]);
        }

        @Override
        protected void onPostExecute(Void result) {
            textResponse.setText(response);
            super.onPostExecute(result);
        }

    }


}