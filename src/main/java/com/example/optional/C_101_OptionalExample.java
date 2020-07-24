package com.example.optional;

import java.util.Optional;

public class C_101_OptionalExample {

    public static void main(String[] args) {
        Optional.ofNullable("default value").ifPresentOrElse(val -> System.out.println("value is present"), () -> System.out.println("value is absent"));
        Optional.ofNullable(null).ifPresentOrElse(val -> System.out.println("value is present"), () -> System.out.println("value is absent"));
        Object value = Optional.ofNullable(null).orElseThrow(() -> new IllegalStateException("Value not present"));

    }
}
