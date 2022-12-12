package ch14.스트림;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamReduceTest {
    public static void main(String[] args) {
        String[] strArray = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "OptionalInt", "OptionalLong",
                "count", "sum", "average", "max", "min", ""
        };

        Optional<String> startWithO = Stream.of(strArray)
                .filter(s -> s.charAt(0) == 'O')
                .findFirst();
        System.out.println(startWithO.get());

        int count = Stream.of(strArray)
                .mapToInt(String::length)
                .reduce(0, (a, b) -> a + 1);

        int sum = Stream.of(strArray)
                .mapToInt(String::length)
                .reduce(0, Integer::sum);

        int max = Stream.of(strArray)
                .mapToInt(String::length)
                .reduce(Integer::max)
                .getAsInt();

        int min = Stream.of(strArray)
                .mapToInt(String::length)
                .reduce(Integer::min)
                .getAsInt();

        System.out.println("count: " + count);
        System.out.println("sum: " + sum);
        System.out.println("max: " + max);
        System.out.println("min: " + min);
    }
}
