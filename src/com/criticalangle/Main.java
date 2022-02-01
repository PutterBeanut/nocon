package com.criticalangle;

import com.criticalangle.connection.Connection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Creates connection and scanner.
        Connection connection = new Connection(9527);
        String username = Username.promptUsername();

        // Printed after the username and text to avoid X box error.
        String whiteSpaces = "                                                         ";

        // Announces the user has entered.
        connection.sendBroadcast(username + " has entered the chat." + whiteSpaces);

        // While loop for continuous texting.
        while (true) {

            // User's msg.
            String line = scanner.nextLine();

            // If the user wants to leave, break the loop.
            if (line.equals("@leave")) {

                // Announces user's departure and breaks loop.
                connection.sendBroadcast(username + " has left the chat." + whiteSpaces);
                break;
            }

            // Send the message.
            connection.sendBroadcast(username + ": " + line + whiteSpaces);
        }

        connection.closeReceiver();
    }
}
