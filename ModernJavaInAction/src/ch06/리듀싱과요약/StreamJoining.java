package ch06.리듀싱과요약;

import static ch06.Dish.*;

import java.util.stream.Collectors;

import ch06.Dish;

public class StreamJoining {

	public static void main(String[] args) {
		String menus = menu.stream()
			.map(Dish::getName)
			.collect(Collectors.joining());
		System.out.println(menus);
		// porkbeefchickenfrench friesriceseason fruitpizzaprawnssalmon

		String menusWithDelimiter = menu.stream()
			.map(Dish::getName)
			.collect(Collectors.joining(", "));
		System.out.println(menusWithDelimiter);
		// pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon
	}

}
