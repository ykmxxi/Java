package ch04;

import static ch04.Dish.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPipeline {
    public static void main(String[] args) {
        // 외부 반복
        List<String> threeHighCaloricDishNamesByIterator = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();

        while (iterator.hasNext()) {
            Dish dish = iterator.next();
            if (dish.getCalories() > 300) {
                threeHighCaloricDishNamesByIterator.add(dish.getName());
            }
            if (threeHighCaloricDishNamesByIterator.size() == 3) {
                break;
            }
        }
        System.out.println(threeHighCaloricDishNamesByIterator);

        // 내부 반복
        List<String> threeHighCaloricDishNames = menu.stream() // 메뉴의 스트림을 얻는다.
                .filter(dish -> dish.getCalories() > 300) // 300 칼로리 초과로 필터링
                .map(Dish::getName) // 요리명을 추출
                .limit(3) // 그 중 3개 선착순 제한
                .collect(Collectors.toList()); // 결과를 리스트로 저장

        System.out.println(threeHighCaloricDishNames);
    }
}
