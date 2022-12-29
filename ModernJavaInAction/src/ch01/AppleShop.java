package ch01;

import java.util.Arrays;
import java.util.List;

public class AppleShop {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(160, "Red", "KR"),
                new Apple(200, "Green", "KR"),
                new Apple(80, "Green", "US"),
                new Apple(130, "Green", "KR"),
                new Apple(50, "Red", "US")
        );

        System.out.println(Apple.filterApples(inventory, Apple::isGreenApple));
        System.out.println(Apple.filterApples(inventory, (Apple a) -> "Red".equals(a.getColor())));
        System.out.println(Apple.filterApples(inventory, Apple::isHeavyApple));
        System.out.println(Apple.filterApples(inventory, Apple::isLightApple));
        System.out.println(Apple.filterApples(inventory, Apple::isKRApple));
        System.out.println(Apple.filterApples(inventory, (Apple a) -> "US".equals(a.getCountry())));
    }
}
