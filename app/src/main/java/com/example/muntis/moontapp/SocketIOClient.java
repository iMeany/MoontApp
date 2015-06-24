package com.example.muntis.moontapp;


import android.app.Activity;
/*
import java.net.MalformedURLException;


public class SocketIOClient {
    private static final String serverUrl = "http://example-socket-server.jit.su";
    private static SocketIO socket;
    private static SocketIOClient instance;
    private static Activity act;
    private static String id;

    public SocketIOClient() {
    }

    public static void initInstance(String uid) throws MalformedURLException {
        if (instance == null) {
            instance = new SocketIOClient();
            instance.initID(uid);
            if (SocketIOClient.getSocket() == null) {
                SocketIOClient.setSocket(new SocketIO());
            }
            SocketIOClient.connectIO();
        }
    }

    public static void setActivity(Activity a) {
        SocketIOClient.act = a;
    }

    public static SocketIO getSocket() {
        return socket;
    }

    public static void setSocket(SocketIO socket) {
        SocketIOClient.socket = socket;
    }

    public String getId() {
        return id;
    }

    private void initID(String uid) {
        if (SocketIOClient.id == null) {
            SocketIOClient.id = uid;
        }
    }

    public static void connectIO() throws MalformedURLException {
        try {
            SocketIO.setDefaultSSLSocketFactory(SSLContext.getDefault());
        } catch (NoSuchAlgorithmException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        SocketIOClient.getSocket().connect(serverUrl, new IOCallback() {
            @Override
            public void onMessage(JSONObject json, IOAcknowledge ack) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onMessage(String data, IOAcknowledge ack) {

            }

            @Override
            public void onError(SocketIOException socketIOException) {
            }

            @Override
            public void onDisconnect() {
                // TODO Auto-generated method stub

            }

            @Override
            public void onConnect() {

            }

            @Override
            public void on(String event, IOAcknowledge ack, Object... args) {

            }
        });
    }

    public static void emit(String event, Object args)
            throws MalformedURLException {
        if (SocketIOClient.getSocket().isConnected() == false) {
            SocketIOClient.getSocket().reconnect();
        }
        SocketIOClient.getSocket().emit(event, args);
    }

    public static void emitWithAcknowledge(String event, Object args)
            throws MalformedURLException {
        if (SocketIOClient.getSocket().isConnected() == false) {
            SocketIOClient.getSocket().reconnect();
        }
        SocketIOClient.getSocket().emit(event, new IOAcknowledge() {

            @Override
            public void ack(Object... args) {
                // TODO Auto-generated method stub

            }
        }, args);
    }

}
*/