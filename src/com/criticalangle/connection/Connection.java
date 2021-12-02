package com.criticalangle.connection;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Connection {
    public DatagramSocket socket;

    public Connection(int port) {
        try {
            this.socket = new DatagramSocket(port);
            this.openReceiver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openReceiver() {
        new Thread(() -> {
            byte[] buffer = new byte[Constants.MAX_BUFFER_SIZE];
            DatagramPacket packet = new DatagramPacket(buffer, Constants.MAX_BUFFER_SIZE);

            while (socket != null) {
                try {
                    socket.receive(packet);
                    System.out.println(new String(buffer));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void sendBroadcast(String text) {
        if (socket != null) {
            try {
                byte[] buffer = text.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("255.255.255.255"), 9527);
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
