package com.criticalangle.connection;

import java.net.DatagramSocket;

public class Connection {
    public DatagramSocket socket;

    public Connection(int port) {
        try {
            this.socket = new DatagramSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
