package com.example;

import java.util.function.BiFunction;

public class A_103_BiFunctionExample {

    public static void main(String[] args) {
        final int a = 10, b = 15;

        // Imperative: 1 sum of the values
        System.out.println("Following is the output of Imperative approach");
        System.out.println("sum of " + a + " and " + b + " is " + sum(a, b));

        // Declarative: 1 sum of the values
        System.out.println("Following is the output of Declarative approach");
        System.out.println("sum of " + a + " and " + b + " is " + sumBiFunction.apply(a, b));
    }

    static BiFunction<Integer, Integer, Integer> sumBiFunction = Integer::sum;

    static int sum(int val1, int val2) {
        return val1 + val2;
    }
}
