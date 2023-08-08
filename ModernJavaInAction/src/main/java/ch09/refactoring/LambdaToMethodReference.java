package ch09.refactoring;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch06.그룹화.MenuGrouping.CaloricLevel;

public class LambdaToMethodReference {

	public static void main(String[] args) {

		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Dish.menu.stream()
			.collect(
				groupingBy(dish -> {
					if (dish.getCalories() <= 400) {

						return CaloricLevel.DIET;
					} else if (dish.getCalories() <= 700) {
						return CaloricLevel.NORMAL;
					} else
						return CaloricLevel.FAT;
				})
			);

		Map<CaloricLevel, List<Dish>> dishesByCaloricLevel2 = Dish.menu.stream()
			.collect(groupingBy(Dish::getCaloricLevel));
	}

}

class Dish {

	public static final List<Dish> menu = asList(
		new Dish("pork", false, 800, Type.MEAT),
		new Dish("beef", false, 700, Type.MEAT),
		new Dish("chicken", false, 400, Type.MEAT),
		new Dish("french fries", true, 530, Type.OTHER),
		new Dish("rice", true, 350, Type.OTHER),
		new Dish("season fruit", true, 120, Type.OTHER),
		new Dish("pizza", true, 550, Type.OTHER),
		new Dish("prawns", false, 400, Type.FISH),
		new Dish("salmon", false, 450, Type.FISH)
	);
	public static final Map<String, List<String>> dishTags = new HashMap<>();

	static {
		dishTags.put("pork", asList("greasy", "salty"));
		dishTags.put("beef", asList("salty", "roasted"));
		dishTags.put("chicken", asList("fried", "crisp"));
		dishTags.put("french fries", asList("greasy", "fried"));
		dishTags.put("rice", asList("light", "natural"));
		dishTags.put("season fruit", asList("fresh", "natural"));
		dishTags.put("pizza", asList("tasty", "salty"));
		dishTags.put("prawns", asList("tasty", "roasted"));
		dishTags.put("salmon", asList("delicious", "fresh"));
	}

	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;

	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return name;
	}

	public CaloricLevel getCaloricLevel() {
		if (this.getCalories() <= 400) {
			return CaloricLevel.DIET;
		} else if (this.getCalories() <= 700) {
			return CaloricLevel.NORMAL;
		} else {
			return CaloricLevel.FAT;
		}
	}

	public enum Type {
		MEAT,
		FISH,
		OTHER
	}

}
