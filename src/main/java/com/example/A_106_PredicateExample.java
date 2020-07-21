package com.example;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class A_106_PredicateExample {

    static Predicate<String> phoneNumberStartsWith91Predicate = val -> val.startsWith("+91");
    static Predicate<String> phoneNumberStartsWith01Predicate = val -> val.startsWith("+01");
    static Predicate<String> phoneNumberSizePredicate = val -> val.length() > 7;
    static Predicate<String> phoneNumberPredicate = phoneNumberStartsWith91Predicate
            .or(phoneNumberStartsWith01Predicate)
            .and(phoneNumberSizePredicate);
    static BiPredicate<String, String> biPredicate = (val1, val2) -> val1.length() > 10 && val2.length() > 10;

    public static void main(String[] args) {
        final String phoneNumber1 = "00123";
        final String phoneNumber2 = "+91512525125";
        final String phoneNumber3 = "+11512525125";
        final String phoneNumber4 = "+01512525125";

        // Imperative: Check phone number is valid
        System.out.println("Following is the output of Imperative approach");
        System.out.println("phoneNumber1 " + phoneNumber1 + " is " + (isPhoneNumberValid(phoneNumber1) ? "Valid" : "Invalid"));
        System.out.println("phoneNumber2 " + phoneNumber2 + " is " + (isPhoneNumberValid(phoneNumber2) ? "Valid" : "Invalid"));
        System.out.println("phoneNumber3 " + phoneNumber3 + " is " + (isPhoneNumberValid(phoneNumber3) ? "Valid" : "Invalid"));
        System.out.println("phoneNumber4 " + phoneNumber4 + " is " + (isPhoneNumberValid(phoneNumber4) ? "Valid" : "Invalid"));

        // Declarative: Check phone number is valid
        System.out.println("\nFollowing is the output of Declarative approach");
        System.out.println("phoneNumber1 " + phoneNumber1 + " is " + (phoneNumberPredicate.test(phoneNumber1) ? "Valid" : "Invalid"));
        System.out.println("phoneNumber2 " + phoneNumber2 + " is " + (phoneNumberPredicate.test(phoneNumber2) ? "Valid" : "Invalid"));
        System.out.println("phoneNumber3 " + phoneNumber3 + " is " + (phoneNumberPredicate.test(phoneNumber3) ? "Valid" : "Invalid"));
        System.out.println("phoneNumber4 " + phoneNumber4 + " is " + (phoneNumberPredicate.test(phoneNumber4) ? "Valid" : "Invalid"));

        System.out.println("\nBiPredicate example");
        System.out.println("check if both string size is greater than 10 " + biPredicate.test("12345678901234", "43210987654321"));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return (phoneNumber.startsWith("+91") || phoneNumber.startsWith("+01"))
                && phoneNumber.length() > 7;
    }
}
