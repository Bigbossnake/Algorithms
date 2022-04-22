package com.apple.interviews;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Person {
    int id;
    String name;
    float grade;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    public Person(int id, String name, float grade) {
        this.id    = id;
        this.name  = name;
        this.grade = grade;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public float getGrade() {
        return this.grade;
    }
};

public class Interview02 {

    public static void main(String args[]) {
        Interview02 interview02 = new Interview02();

        List<Person> persons = new ArrayList<>();
        persons.add(new Person(10, "Max", 10.4f));
        persons.add(new Person(1, "Mir", 4.4f));
        persons.add(new Person(5, "Mir", 5.4f));
        persons.add(new Person(20, "Autum", 13.4f));
        persons.add(new Person(12, "Ian", 11.4f));

        Comparator<Person> comparePerson = Comparator
                .comparing(Person::getGrade, Comparator.reverseOrder())
                .thenComparing(Person::getName)
                .thenComparing(Person::getId);

        persons.sort(comparePerson);
        persons.forEach( person -> System.out.println(person + " "));
    }
}
