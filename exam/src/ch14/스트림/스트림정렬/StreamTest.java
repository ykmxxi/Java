package ch14.스트림.스트림정렬;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("김", 3, 150),
                new Student("나", 1, 250),
                new Student("박", 1, 300),
                new Student("이", 2, 220),
                new Student("최", 3, 110),
                new Student("손", 3, 40),
                new Student("윤", 2, 270)
        );

        studentStream.sorted(Comparator.comparing(Student::getClassNumber)
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
    }
}
