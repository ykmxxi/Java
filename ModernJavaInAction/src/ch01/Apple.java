package ch01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Apple {
    private final int weight;
    private final String color;
    private final String country;

    public Apple(int weight, String color, String country) {
        this.weight = weight;
        this.color = color;
        this.country = country;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String getCountry() {
        return country;
    }

    public static boolean isGreenApple(Apple apple) {
        return "Green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static boolean isLightApple(Apple apple) {
        return apple.getWeight() <= 150;
    }

    public static boolean isKRApple(Apple apple) {
        return "KR".equals(apple.getCountry());
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    @SuppressWarnings("boxing")
    @Override
    public String toString() {
        return String.format("Apple{color = '%s', weight = %d, country = '%s'}", color, weight, country);
    }
}
