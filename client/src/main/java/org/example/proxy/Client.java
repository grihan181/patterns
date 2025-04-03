package org.example.proxy;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        Scanner sc = new Scanner(System.in);
        boolean isWorking = true;
        while (isWorking) {
            System.out.println("Что вы хотите сделать?:\n1) умножение\n2) выход");
            int action = sc.nextInt();
            switch (action) {
                case 1:
                    System.out.println("Введите 2 значения: ");
                    System.out.print("1:\t");
                    double a = sc.nextDouble();
                    System.out.print("2:\t");
                    double b = sc.nextDouble();
                    double result = proxy.multiply(a, b);
                    System.out.println("Результат:\t" + result);
                    break;

                case 2:
                    isWorking = false;

                default:
                    break;
            }
        }
        sc.close();
    }
}