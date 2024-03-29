package ch05.슬라이싱;

import static ch05.Dish.*;

import java.util.List;
import java.util.stream.Collectors;

import ch05.Dish;

public class StreamSlicing {

	public static void main(String[] args) {
		List<Dish> lowCaloricDishes = specialMenu.stream()
			.takeWhile(dish -> dish.getCalories() < 320)
			.collect(Collectors.toList());

		List<Dish> highCaloricDishes = specialMenu.stream()
			.dropWhile(dish -> dish.getCalories() < 320)
			.collect(Collectors.toList());

		List<Dish> highestCaloricDish = specialMenu.stream()
			.filter(dish -> dish.getCalories() > 320)
			.skip(2)
			.collect(Collectors.toList());

		List<Dish> twoMeatDishes = menu.stream()
			.filter(dish -> dish.getType().equals(Type.MEAT))
			.limit(2)
			.collect(Collectors.toList());

		System.out.println(lowCaloricDishes);
		System.out.println(highCaloricDishes);
		System.out.println(highestCaloricDish);
		System.out.println(twoMeatDishes);
	}

}
