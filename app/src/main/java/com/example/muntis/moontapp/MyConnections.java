package com.example.muntis.moontapp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Muntis on 2015.06.24..
 */

public class MyConnections {
    public static BufferedReader inStream;
    public static PrintWriter outStream;
    public static Socket socket;

    public BufferedReader getInput() {
        return inStream;
    }

    public PrintWriter getOutput() {
        return outStream;
    }

    public void setInput(BufferedReader BR) {
        inStream = BR;
    }

    public void setOutput(PrintWriter BR) {
        outStream = BR;
    }

    public void setSocket(Socket S) {socket = S;}

    public void sendOut(String msg) {
        outStream.println("MESSAGE FROM ANDROID: " + msg.toString());
    }


}
