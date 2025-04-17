package org.example.lr2.proxy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static org.example.constant.PatternsConst.PORT;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server starting..");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                     DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {
                    System.out.println("Client: " + clientSocket);

                    double num1 = in.readDouble();
                    double num2 = in.readDouble();
                    double result = num1 * num2;
                    System.out.println("Result: " + num1 + " * " + num2 + " = " + result);

                    out.writeDouble(result);
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}