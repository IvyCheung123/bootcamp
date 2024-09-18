package com.bootcamp.demo;

public class App {
    // Unit test
    public static int sum(int x, int y) {
        return x + y;
    }

    // Unit test
    public static int subtract(int x, int y) {
        return x - y;
    }

    // Unit test
    public static int combine(int x, int y) {
        if (x >= 10 && y >=3)
            return subtract(x, y);
        return sum(x, y);
    }

    public static double divide(int x, int y) {
        return x / y;
    }
}
