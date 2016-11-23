package com.epam.training.console.operations;

public class Multiplication implements Operation {
    @Override
    public int calculate(int first, int second) {
        return first * second;
    }
}
