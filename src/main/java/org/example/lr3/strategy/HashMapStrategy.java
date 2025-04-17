package org.example.lr3.strategy;

import java.util.HashMap;
import java.util.Map;

public class HashMapStrategy implements CountingStrategy {

    @Override
    public void count(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println("HashMap:");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
