package ch05.검색과매칭;

import static ch05.Dish.menu;

import ch05.Dish;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamSearchAndMatching {
    public static void main(String[] args) {
        // anyMatch
        if (menu.stream()
                .anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu includes dishes for vegetarians.");
        } else {
            System.out.println("Nothing for vegetarians.");
        }

        // allMatch
        if (menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000)) {
            System.out.println("All dishes are healthy.");
        }

        // noneMatch
        if (menu.stream()
                .noneMatch(dish -> dish.getCalories() >= 1000)) {
            System.out.println("All dishes are healthy.");
        }

        // Optional, findAny
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish -> System.out.println(dish.getName())); // 값이 있으면 출력, 없으면 아무 일도 일어나지 않음

        // findFirst
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree = numbers.stream()
                .map(i -> i * i)
                .filter(i -> i % 3 == 0)
                .findFirst();
        System.out.println(firstSquareDivisibleByThree);
    }
}
