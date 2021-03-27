package com.hust.soict.tranthaiduong.client_server;

import com.hust.soict.tranthaiduong.helper.SelectionSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("The Sorter Server is running!");
        int clientNumber = 0;
        try (ServerSocket listener = new ServerSocket(9696)) {
            while (true) {
                new Sorter(listener.accept(), clientNumber++).start();
            }
        }
    }
}