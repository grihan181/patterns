package org.example.lr3.strategy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GenerateFile {

    public static void main(String[] args) {
        int[] data = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 1, 0, 4};
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("input.dat"))) {
            oos.writeObject(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
