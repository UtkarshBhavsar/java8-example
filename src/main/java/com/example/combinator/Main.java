package com.example.combinator;

import java.time.LocalDate;

import static com.example.combinator.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer(
                "Utkarsh",
                "utkarsh@gmail.com",
                "+10000",
                LocalDate.of(1990, 01, 01)
        );
        // Imperative approach for validation
        boolean validCustomer = new CustomerValidatorService().isValidCustomer(customer1);
        System.out.println("Customer 1 is " + (validCustomer ? "valid" : "invalid"));

        // Declarative approach for validation using combinator pattern
        ValidationMessage result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer1); // Lazy initialization

        System.out.println("Customer 1 validation :" + result);

    }
}
