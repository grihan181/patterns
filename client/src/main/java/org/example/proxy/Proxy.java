package org.example.proxy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Proxy {

    public double multiply(double a, double b) {
        try (Socket socket = new Socket("localhost", 5001);
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             DataInputStream in = new DataInputStream(socket.getInputStream())) {

            out.writeDouble(a);
            out.writeDouble(b);
            out.flush();

            return in.readDouble();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка связи с сервером", e);
        }
    }
}