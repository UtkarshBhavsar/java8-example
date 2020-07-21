package com.example.stream;

import java.util.List;

import static com.example.stream.B_101_StreamExample.Gender.*;


public class B_101_StreamExample {

    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Bob", MALE),
                new Person("Marley", MALE),
                new Person("Sara", FEMALE),
                new Person("James", MALE),
                new Person("Maria", FEMALE),
                new Person("Kelly", OTHER)
        );
        personList.stream()
//                .map(Person::getGender)
                .map(Person::getName)
                .mapToInt(String::length)
//                .distinct()
                .forEach(System.out::println);
    }


    enum Gender {
        MALE,
        FEMALE,
        OTHER
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

}
