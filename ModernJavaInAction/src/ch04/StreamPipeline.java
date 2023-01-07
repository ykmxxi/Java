package ch04;

import static ch04.Dish.menu;

import java.util.List;
import java.util.stream.Collectors;

public class StreamPipeline {
    public static void main(String[] args) {
        List<String> threeHighCaloricDishNames = menu.stream() // 메뉴의 스트림을 얻는다.
                .filter(dish -> dish.getCalories() > 300) // 300 칼로리 초과로 필터링
                .map(Dish::getName) // 요리명을 추출
                .limit(3) // 그 중 3개 선착순 제한
                .collect(Collectors.toList()); // 결과를 리스트로 저장

        System.out.println(threeHighCaloricDishNames);
    }
}
