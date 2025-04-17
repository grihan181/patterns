package org.example.lr3.strategy;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Strategy {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Use: java Main <файл> <strategy: map|brute>");
            return;
        }

        String filename = args[0];
        String strategyName = args[1];

        int[] array;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            array = (int[]) ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        ArrayProcessor processor = new ArrayProcessor();
        if (strategyName.equalsIgnoreCase("map")) {
            processor.setStrategy(new HashMapStrategy());
        } else if (strategyName.equalsIgnoreCase("brute")) {
            processor.setStrategy(new BruteForceStrategy());
        } else {
            System.out.println("Incorrect strategy. Use: map or brute");
            return;
        }
        processor.execute(array);
    }
}
