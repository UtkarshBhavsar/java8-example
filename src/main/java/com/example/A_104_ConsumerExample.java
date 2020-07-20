package com.example;

import java.util.function.Consumer;

public class A_104_ConsumerExample {

    public static void main(String[] args) {
        Customer customer = new Customer("Bob", "9999123");

        // Imperative: 1 sum of the values
        System.out.println("Following is the output of Imperative approach");
        greetCustomer(customer);

        // Declarative: 1 sum of the values
        System.out.println("Following is the output of Declarative approach");
        customerConsumer.accept(customer);

    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.getName() + ", Thanks for registering with phone number " + customer.getPhoneNumber());
    }

    static Consumer<Customer> customerConsumer = customer -> System.out.println("Hello " + customer.getName() + ", Thanks for registering with phone number " + customer.getPhoneNumber());

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
