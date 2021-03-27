package com.hust.soict.tranthaiduong.client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum.replaceAll("\\s+",""));
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 9696);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//            System.out.println(in.readLine());
            Scanner scanner = new Scanner(System.in);
            String message = "";
            while (true) {
                message = scanner.nextLine();
                if (!isNumeric(message)) {
                    if (message.equalsIgnoreCase("empty")) break;
                    System.out.println("input is not a number. Enter again...");
                    continue;
                }
                // send msg to server
                out.println(message);
                // display received msg from server
                System.out.println(in.readLine());
            }
            socket.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
