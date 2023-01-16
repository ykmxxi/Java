package ch06.그룹화;

import static ch06.Dish.dishTags;
import static ch06.Dish.menu;

import ch06.Dish;
import ch06.Dish.Type;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class MenuGrouping {

    public enum CaloricLevel {DIET, NORMAL, FAT}

    public static void main(String[] args) {
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishesByType.toString());

        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream()
                .collect(Collectors.groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                }));
        System.out.println(dishesByCaloricLevel.toString());

        Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.filtering(dish -> dish.getCalories() > 500, Collectors.toList())));
        System.out.println(caloricDishesByType.toString());

        Map<Dish.Type, Set<String>> dishNamesByType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        Collectors.flatMapping(dish -> dishTags.get(dish.getName()).stream(),
                                Collectors.toSet())
                ));
        System.out.println(dishNamesByType.toString());

        Map<Dish.Type, List<String>> names = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(Dish::getName, Collectors.toList())));
        System.out.println(names.toString());

        // 두 수준으로 그룹화
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, // 첫 번째 수준의 분류 함수, [FISH, MEAT, OTHER]
                                Collectors.groupingBy(dish -> { // 두 번째 수준의 분류 함수, [DIET, NORMAL, FAT]
                                    if (dish.getCalories() <= 400) {
                                        return CaloricLevel.DIET;
                                    } else if (dish.getCalories() <= 700) {
                                        return CaloricLevel.NORMAL;
                                    } else {
                                        return CaloricLevel.FAT;
                                    }
                                })
                        )
                );
        System.out.println(dishesByTypeCaloricLevel.toString());

        // 두 번째 인수로 counting 컬렉터를 전달해 요리의 수를 종류별로 계산할 수 있다.
        Map<Dish.Type, Long> typesCount = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
        System.out.println(typesCount.toString());

        Map<Type, Dish> mostCaloricByType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, // 분류 함수
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), // 감싸진 컬렉터
                                Optional::get // 반환 함수
                        )
                ));
        System.out.println(mostCaloricByType.toString());

        // 각 그룹별 총 칼로리
        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories)));
        System.out.println(totalCaloriesByType.toString());

        Map<Type, HashSet<CaloricLevel>> caloricLevelsByType = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        }, Collectors.toCollection(HashSet::new)) // 원하는 형식으로 결과를 제어
                ));
        System.out.println(caloricLevelsByType.toString());

    }
}
