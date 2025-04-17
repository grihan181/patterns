package org.example.lr3.strategy;

public class BruteForceStrategy implements CountingStrategy {

    @Override
    public void count(int[] array) {
        boolean[] visited = new boolean[array.length];
        System.out.println("Brute:");
        for (int i = 0; i < array.length; i++) {
            if (!visited[i]) {
                int count = 1;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        visited[j] = true;
                        count++;
                    }
                }
                System.out.println(array[i] + " => " + count);
            }
        }
    }
}