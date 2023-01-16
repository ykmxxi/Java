package ch06.최대값과최소값검색;

import static ch06.Dish.menu;

import ch06.Dish;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchingMaxAndMin {
    public static void main(String[] args) {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDish = menu.stream()
                .collect(Collectors.maxBy(dishCaloriesComparator));

        Optional<Dish> leastCalorieDish = menu.stream()
                .collect(Collectors.minBy(dishCaloriesComparator));

        System.out.println("칼로리가 가장 높은 음식: " + mostCalorieDish);
        System.out.println("칼로리가 가장 낮은 음식: " + leastCalorieDish);

    }
}
