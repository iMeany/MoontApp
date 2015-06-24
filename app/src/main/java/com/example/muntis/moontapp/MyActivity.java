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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

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
                    MyClientTask myClientTask = new MyClientTask(editTextAddress.getText().toString(), Integer.parseInt(editTextPort.getText().toString()));
                    myClientTask.execute();
                }
            };

    public class MyClientTask extends AsyncTask<Void, Void, Void> {

        String dstAddress;
        int dstPort;
        String response = "";

        MyClientTask(String addr, int port) {
            dstAddress = addr;
            dstPort = port;
        }

        @Override
        protected Void doInBackground(Void... arg0) {

            Socket socket = null;

            try {
                //creating socket and streams for server
                socket = new Socket(dstAddress, dstPort);
                MyConnections conn = new MyConnections();
                conn.setInput(new BufferedReader(new InputStreamReader(socket.getInputStream())));
                conn.setOutput(new PrintWriter(socket.getOutputStream(), true));

                BufferedReader inStream = conn.getInput();
                PrintWriter outStream = conn.getOutput();
                while(true) {
                    String line = inStream.readLine();
                    if (line.startsWith("SUBMITNAME")) {
                        // if server wants nick -> grab it and send
                        editTextNick = (EditText) findViewById(R.id.nick);
                        outStream.println(editTextNick.getText().toString());

                    } else if (line.startsWith("NAMEACCEPTED")) {
                        // if server accepted nick -> join the game
                        // @todo check if there are 2 players and make game for them
                        editTextNick = (EditText) findViewById(R.id.nick);
                        Intent gameIntent = new Intent(MyActivity.this, gameActivity.class);
                        gameIntent.putExtra("nick", editTextNick.getText().toString());
                        startActivity(gameIntent);


                    } else if (line.startsWith("MESSAGE")) {
                        // @todo game messages later here
                        //messageArea.append(line.substring(8) + "\n");
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
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            textResponse.setText(response);
            super.onPostExecute(result);
        }

    }


}