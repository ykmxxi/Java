package ch09.유용한클래스;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObjectsTest {
    public static void main(String[] args) {
        List<List<String>> a = new ArrayList<>();
        a.add(List.of("123"));
        a.add(List.of("AAA"));

        List<List<String>> b = new ArrayList<>();
        b.add(List.of("123"));
        b.add(List.of("AAA"));

        System.out.println(Objects.deepEquals(a, b)); // true

    }
}
