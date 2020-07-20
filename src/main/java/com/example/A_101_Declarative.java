package com.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.A_101_Declarative.Gender.*;

public class A_101_Declarative {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Bob", MALE),
                new Person("Marley", MALE),
                new Person("Sara", FEMALE),
                new Person("James", MALE),
                new Person("Maria", FEMALE)
        );

        // Imperative: 1 find number of person who is female
        int count = 0;
        for (Person person : personList) {
            if (person.getGender() == FEMALE) {
                count++;
            }
        }
        System.out.println(String.format(" %s are Female (Imperative approach)", count));

        // Declarative: 1 find number of person who is female

        long femaleCount = personList.stream().filter(person -> person.getGender() == FEMALE).count();
        System.out.println(String.format(" %s are Female (Declarative approach)", femaleCount));

        // Imperative:  2 find person who is female
        List<Person> females = new ArrayList<>();
        for (Person person : personList) {
            if (person.getGender() == FEMALE) {
                females.add(person);
            }
        }
        System.out.println("Following persons are Female (Imperative approach)");
        for (Person female : females) {
            System.out.println(female);
        }
        // Imperative:  2 find person who is female

        System.out.println("Following persons are Female (Declarative approach)");
        personList.stream().filter(person -> person.getGender() == FEMALE).forEach(System.out::println);


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

    enum Gender {
        MALE,
        FEMALE
    }
}
