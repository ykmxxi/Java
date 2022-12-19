package ch11.HashSet;

import java.util.HashSet;

public class HashSetAddTest {
    public static void main(String[] args) {
        HashSet<Person> persons = new HashSet<>();
        persons.add(new Person("David", 15));
        persons.add(new Person("David", 15));
        persons.add(new Person("David", 19));
        persons.add(new Person("Tom", 15));

        System.out.println(persons.toString());

    }
}
