package ch02;

import ch01.Apple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleFilter {
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(160, "RED", "KR"),
                new Apple(200, "GREEN", "KR"),
                new Apple(80, "GREEN", "US"),
                new Apple(130, "GREEN", "KR"),
                new Apple(50, "RED", "US")
        );

        System.out.println(filterApples(inventory, new AppleHeavyWeightPredicate()));
        System.out.println(filterApples(inventory, new AppleGreenColorPredicate()));
        System.out.println();
        prettyPrintApple(inventory, new AppleCountryFormatter());
        System.out.println();
        prettyPrintApple(inventory, new AppleFancyFormatter());
    }
}
