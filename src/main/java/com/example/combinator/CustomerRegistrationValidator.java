package com.example.combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static com.example.combinator.CustomerRegistrationValidator.ValidationMessage;
import static com.example.combinator.CustomerRegistrationValidator.ValidationMessage.*;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationMessage> {

    enum ValidationMessage {
        SUCCESS,
        EMAIL_INVALID,
        PHONE_INVALID,
        DOB_INVALID
    }

    static CustomerRegistrationValidator isEmailValid() {
        return customer -> customer.getEmail().contains("@") ? SUCCESS : EMAIL_INVALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid() {
        return customer -> customer.getPhoneNumber().startsWith("+1") ? SUCCESS : PHONE_INVALID;
    }

    static CustomerRegistrationValidator isAdult() {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ? SUCCESS : DOB_INVALID;
    }

    default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
        return customer -> {
            ValidationMessage result = this.apply(customer);
            return result == SUCCESS ? other.apply(customer) : result;
        };
    }
}
