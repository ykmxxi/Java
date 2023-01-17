package ch06.분할;

import static ch06.Dish.menu;
import static java.util.stream.Collectors.*;

import ch06.Dish;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class Partition {
    public static void main(String[] args) {
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian));

        List<Dish> forVegetarianDishes = partitionedMenu.get(true); // 프레디케이트로 필터링한 다음 리스트로 반환해도 똑같음.
        System.out.println(forVegetarianDishes.toString());

        // 컬렉터를 두 번째 인수로 받는 partitioningBy
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));
        System.out.println(vegetarianDishesByType.toString());

        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = menu.stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)
                ));
        System.out.println(mostCaloricPartitionedByVegetarian);

    }
}
