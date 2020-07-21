package com.example.functional.interfaces;

import java.util.function.Supplier;

public class A_107_SupplierExample {

    public static void main(String[] args) {
        // Imperative: Check phone number is valid
        System.out.println("Following is the output of Imperative approach");
        System.out.println(getDBUrl());

        // Declarative: Check phone number is valid
        System.out.println("\nFollowing is the output of Declarative approach");
        System.out.println(getDbUrlSupplier.get());
    }

    static String getDBUrl() {
        return "jdbc://localhost:3306/user";
    }

    static Supplier<String> getDbUrlSupplier = () -> "jdbc://localhost:3306/user";
}
