package ch03.함수형인터페이스사용;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Predicate<T> {
    boolean test(T t);
}

public class PredicateTest {
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();

        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        List<String> emptyOfStrings = new ArrayList<>();
        List<String> listOfStrings = new ArrayList<>(List.of("Hi", "Hello", "World"));

        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> empty = filter(emptyOfStrings, nonEmptyStringPredicate);
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);

        System.out.println(empty);
        System.out.println(nonEmpty);
    }
}
