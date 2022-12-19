package ch14.스트림.컬렉터;

import java.util.Arrays;
import java.util.stream.Stream;

public class ConcatCollectorTest {
    public static void main(String[] args) {
        String[] words = {"STANDARD", "OF", "JAVA"};
        Stream<String> stringStream = Stream.of(words);

        System.out.println(Arrays.toString(words));
        System.out.print("Concat Result: ");
        System.out.println(stringStream.collect(new ConcatCollector()));
    }
}
