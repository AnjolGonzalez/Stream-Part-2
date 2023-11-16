package com.pluralsight.streams;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Jake", "Arnett", 25));
        personList.add(new Person("Joshua", "Ramos", 21));
        personList.add(new Person("Randy", "Lopez", 23));
        personList.add(new Person("Christian", "Crites", 18));
        personList.add(new Person("Sing", "Tuttanon", 19));
        personList.add(new Person("Clancy", "Long", 26));
        personList.add(new Person("Abigiel Woldegerima", " ", 21));
        personList.add(new Person("Aleksandr", "Nikitin", 20));
        personList.add(new Person("Caleb", "Howard", 24));
        personList.add(new Person("Desi", "Rorie", 25));
        personList.add(new Person("Ivan", "Taverez", 23));
        personList.add(new Person("Rickey", "Glover", 22));

        List<Person> matching = personList.stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(person.firstName) || person.getLastName().equalsIgnoreCase(person.lastName))
                .collect(Collectors.toList());

        matching.forEach(person -> {
            System.out.println(person.getFirstName() + " " + person.getLastName() + " " + person.getAge());
        });

        int averageAge = (int) personList.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
        System.out.println("The Average age: " + averageAge);

        int oldestAge = personList.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElse(0);

        int youngestAge = personList.stream()
                .mapToInt(Person::getAge)
                .min()
                .orElse(0);
        System.out.println("The oldest age: " + oldestAge +
                "\nThe youngest age: " + youngestAge);

    }
}
