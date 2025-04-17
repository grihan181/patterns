package org.example.lr3.strategy;

import lombok.Setter;

@Setter
public class ArrayProcessor {

    private CountingStrategy strategy;

    public void execute(int[] array) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not installed");
        }
        strategy.count(array);
    }
}