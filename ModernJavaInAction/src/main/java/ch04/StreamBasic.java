package ch04;

import static ch04.Dish.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBasic {

	public static void main(String[] args) {
		System.out.println(lowCaloricDishesJava7(menu));
		System.out.println(lowCaloricDishesJava8(menu));

	}

	public static List<String> lowCaloricDishesJava7(List<Dish> menu) {
		List<Dish> lowCaloricDishes = new ArrayList<>();

		for (Dish dish : menu) {
			if (dish.getCalories() < 400) {
				lowCaloricDishes.add(dish);
			}
		}

		// 칼로리 기준 정렬
		Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
			@Override
			public int compare(Dish o1, Dish o2) {
				return Integer.compare(o1.getCalories(), o2.getCalories());
			}
		});

		List<String> lowCaloricDishesName = new ArrayList<>();
		for (Dish dish : lowCaloricDishes) {
			lowCaloricDishesName.add(dish.getName());
		}

		return lowCaloricDishesName;
	}

	public static List<String> lowCaloricDishesJava8(List<Dish> menu) {
		return menu.parallelStream()
			.filter(d -> d.getCalories() < 400) // 400칼로리 이하 요리 선택
			.sorted(Comparator.comparing(Dish::getCalories)) // 칼로리로 요리 정렬
			.map(Dish::getName) // 요리명 추출
			.collect(Collectors.toList()); // 요리명을 리스트로 저장
	}

}
