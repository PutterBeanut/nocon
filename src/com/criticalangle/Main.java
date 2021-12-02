package com.criticalangle;

import com.criticalangle.connection.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = new Connection(Integer.parseInt(args[0]));
        connection.sendBroadcast(args[1]);
    }
}
