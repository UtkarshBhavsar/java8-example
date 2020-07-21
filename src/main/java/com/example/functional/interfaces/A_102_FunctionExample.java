package com.example.functional.interfaces;

import java.util.function.Function;

public class A_102_FunctionExample {

    public static void main(String[] args) {
        // Imperative: 1 increment the value
        System.out.println("Following is the output of Imperative approach");
        System.out.println(increment(0));

        // Declarative: 1 Function example & chaining
        System.out.println("Following is the output of Declarative approach");
        int value = 2;
        System.out.println("Initial value = " + value);
        System.out.println("Incremented by 1 = " + incrementFunction.apply(value));
        System.out.println("Incremented by 1 and square = " + incrementFunction
                .andThen(squareFunction)
                .apply(value));
        System.out.println("Incremented by 1 and square and square root = " + incrementFunction
                .andThen(squareFunction)
                .andThen(squareRootFunction)
                .apply(value));
        System.out.println("Incremented by 1 and square and square root and decrement by 1 =  "
                + incrementFunction
                .andThen(squareFunction)
                .andThen(squareRootFunction)
                .andThen(decrementFunction)
                .apply(value));
    }

    static Function<Integer, Integer> incrementFunction = val -> val + 1;
    static Function<Integer, Integer> decrementFunction = val -> val - 1;
    static Function<Integer, Integer> squareFunction = val -> val * val;
    static Function<Integer, Integer> squareRootFunction = val -> (int) Math.sqrt((double) val);

    static int increment(int increment) {
        return increment + 1;
    }
}
