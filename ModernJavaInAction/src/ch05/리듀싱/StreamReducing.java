package ch05.리듀싱;

import static ch05.Dish.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReducing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        System.out.println(result);

        int sum = numbers.stream().reduce(0, Integer::sum);
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(sum);
        System.out.println(product);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> min = numbers.stream().reduce(Integer::min);

        System.out.println(max + ", " + min);

        // 퀴즈. map과 reduce를 이용해서 스트림의 요리 개수를 계산
        // map-reduce 패턴: 쉽게 병렬화하는 특징 덕분에 구글이 웹 검색에 적용한 패턴
        int countMenu = menu.stream()
                .map(d -> 1)
                .reduce(0, Integer::sum);
        // long countMenu = menu.stream().count();
        System.out.println("메뉴에 포함된 요리의 개수: " + countMenu);
    }
}
