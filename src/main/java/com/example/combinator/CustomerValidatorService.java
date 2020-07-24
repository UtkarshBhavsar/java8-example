package com.example.combinator;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isEmailValid(String emailAddress) {
        return emailAddress.contains("@");
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("+1");
    }

    private boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() > 16;
    }

    public boolean isValidCustomer(Customer customer) {
        return isEmailValid(customer.getEmail())
                && isPhoneNumberValid(customer.getPhoneNumber())
                && isAdult(customer.getDob());
    }
}
