package ch05.매핑;

import static ch05.Dish.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import ch05.Dish;

public class StreamMapping {
    public static void main(String[] args) {
        List<String> dishNames = menu.stream()
                .map(Dish::getName) // Stream<String> 반환
                .collect(Collectors.toList());
        System.out.println(dishNames);

        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(dishNameLengths);

        List<String> words = Arrays.asList("Hello", "World");
        words.stream()
                .map(word -> word.split("")) // 각 단어를 개별 문자열 배열로 변환
                .distinct() // Stream<String[]>
                .forEach(System.out::print);
        System.out.println();

        words.stream()
                .map(word -> word.split("")) // 각 단어를 개별 문자열 배열로 변환
                .map(Arrays::stream) // 각 배열을 별도의 스트림으로 생성
                .distinct() // Stream<Stream<String>>
                .forEach(System.out::print);

        System.out.println();
        words.stream()
                .map(word -> word.split("")) // 각 단어를 개별 문자열 배열로 변환
                .flatMap(Arrays::stream) // 생성된 스트림을 하나의 스트림으로 평면화
                .distinct() // Stream<String>
                .forEach(System.out::print);
    }
}
