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
                new Apple(80, "GREEN", "US"),
                new Apple(130, "GREEN", "KR"),
                new Apple(50, "RED", "US")
        );

        // Apple을 weight별로 비교해서 inventory를 sort하라.
        inventory.sort(comparing(Apple::getWeight));

        for (Apple apple : inventory) {
            System.out.println(apple);
        }
    }
}
