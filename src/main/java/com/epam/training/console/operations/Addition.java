package com.epam.training.console.operations;

public class Addition implements Operation {
    @Override
    public int calculate(int first, int second) {
        return first + second;
    }
}
