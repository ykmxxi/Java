package ch11.HashSet;

import java.util.Objects;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return name.equals(person.name) && age == person.age;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " : " + age + "살";
    }
}
