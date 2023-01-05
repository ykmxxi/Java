package ch03.람다_메서드참조활용;

import static java.util.Comparator.comparing;

import ch01.Apple;
import java.util.Arrays;
import java.util.List;

public class SortingApple {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(160, "RED", "KR"),
                new Apple(200, "GREEN", "KR"),
                new Apple(200, "GREEN", "US"),
                new Apple(130, "GREEN", "KR"),
                new Apple(50, "RED", "US")
        );

        // Apple을 weight별로 비교해서 inventory를 sort하라.
        inventory.sort(comparing(Apple::getWeight)); // 오름차순

        for (Apple apple : inventory) {
            System.out.println(apple);
        }

        System.out.println();
        inventory.sort(comparing(Apple::getWeight)
                .reversed() // 내림차순
                .thenComparing(Apple::getCountry)); // 두 사과의 무게가 같으면, 국가를 비교해 정렬

        for (Apple apple : inventory) {
            System.out.println(apple);
        }
    }
}
