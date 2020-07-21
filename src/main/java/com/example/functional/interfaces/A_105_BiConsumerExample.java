package com.example.functional.interfaces;

import java.util.function.BiConsumer;

public class A_105_BiConsumerExample {

    public static void main(String[] args) {
        Customer customer = new Customer("Bob", "9999123");

        // Imperative: 1 sum of the values
        System.out.println("Following is the output of Imperative approach");
        greetCustomer("1", customer);

        // Declarative: 1 sum of the values
        System.out.println("Following is the output of Declarative approach");
        customerConsumer.accept("1", customer);

    }

    static void greetCustomer(String id, Customer customer) {
        System.out.println(("Hello " + customer.getName() + " and id " + id + ", Thanks for registering with phone number " + customer.getPhoneNumber()));
    }

    static BiConsumer<String, Customer> customerConsumer = (id, customer) -> System.out.println("Hello " + customer.getName() + " and id " + id + ", Thanks for registering with phone number " + customer.getPhoneNumber());

    //Consumer<>
    static class Customer {
        private final String name;
        private final String phoneNumber;

        Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }
    }

}
