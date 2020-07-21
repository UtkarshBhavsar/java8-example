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
                new Person("Maria", FEMALE)
//                new Person("Kelly", OTHER)
        );
        /*personList.stream()
                .map(Person::getName)
                .mapToInt(String::length)
                .forEach(System.out::println);*/
        boolean allMatchFemales = personList.stream().allMatch(person -> person.getGender() == FEMALE);
        System.out.println(allMatchFemales);
        boolean anyMatchFemales = personList.stream().anyMatch(person -> person.getGender() == FEMALE);
        System.out.println(anyMatchFemales);
        boolean noneMatchFemales = personList.stream().noneMatch(person -> person.getGender() == OTHER);
        System.out.println(noneMatchFemales);

        personList.stream()
                .takeWhile(person -> person.getGender() == MALE)
                .filter(person -> person.getName().startsWith("BAA"))
                .findAny()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Data not found"));

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
