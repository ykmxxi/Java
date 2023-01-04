package ch03.함수형인터페이스사용;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Function<T, R> {
    R apply(T t);
}

public class FunctionTest {
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> results = new ArrayList<>();

        for (T t : list) {
            results.add(f.apply(t));
        }
        return results;
    }

    public static void main(String[] args) {
        List<Integer> length = map(
                Arrays.asList("Modern", "Java", "In", "Action"),
                (String s) -> s.length()
        );

        System.out.println(length);
    }
}