package org.example.client;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        Scanner sc = new Scanner(System.in);
        boolean isWorking = true;

        while (isWorking) {
            System.out.println("Action:\n1) multiply\n2) exit");
            try {
                int action = sc.nextInt();
                switch (action) {
                    case 1 -> multiply(sc, proxy);
                    case 2 -> isWorking = false;
                    default -> System.out.println("Incorrect action");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                sc.next();
            }
        }

        sc.close();
    }

    private static void multiply(Scanner sc, Proxy proxy) {
        System.out.print("First value:\t");
        double a = sc.nextDouble();
        System.out.print("Second value:\t");
        double b = sc.nextDouble();
        double result = proxy.multiply(a, b);
        System.out.println("Result:\t" + result);
    }
}