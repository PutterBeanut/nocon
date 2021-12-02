package com.criticalangle;

import com.criticalangle.connection.Connection;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = new Connection(9527);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();

            if (line.equals("@leave"))
                break;

            connection.sendBroadcast(line);
        }

        connection.closeReceiver();
    }
}
