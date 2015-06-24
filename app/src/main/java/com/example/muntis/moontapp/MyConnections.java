package com.example.muntis.moontapp;

import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * Created by Muntis on 2015.06.24..
 */
public class MyConnections {
    public static BufferedReader inStream;
    public static PrintWriter outStream;

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

    public void sendOut(String msg) {
        outStream.println("MESSAGE FROM ANDROID: " + msg.toString());
    }


}
