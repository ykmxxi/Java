package ch05;

import static ch05.Dish.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExternalAndInternalIteration {
    public static void main(String[] args) {
        List<Dish> vegetarianDishesByExternal = new ArrayList<>();
        List<Dish> vegetarianDishesByInternal = new ArrayList<>();

        for (Dish dish : menu) {
            if (dish.isVegetarian()) {
                vegetarianDishesByExternal.add(dish);
            }
        }
        System.out.println("외부 반복: " + vegetarianDishesByExternal);

        vegetarianDishesByInternal = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
        System.out.println("내부 반복: " + vegetarianDishesByInternal);

    }
}
