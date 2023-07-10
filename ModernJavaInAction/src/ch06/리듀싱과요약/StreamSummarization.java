package ch06.리듀싱과요약;

import static ch06.Dish.*;

import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

import ch06.Dish;

public class StreamSummarization {

	public static void main(String[] args) {

		int totalCalories = menu.stream()
			.collect(Collectors.summingInt(Dish::getCalories));
		System.out.println("모든 메뉴의 칼로리 합: " + totalCalories + "Kcal");

		double averageCalories = menu.stream()
			.collect(Collectors.averagingDouble(Dish::getCalories));
		System.out.println("메뉴의 칼로리 평균: " + averageCalories + "Kcal");

		IntSummaryStatistics menuStatistics = menu.stream()
			.collect(Collectors.summarizingInt(Dish::getCalories));

		System.out.println(menuStatistics);
	}

}
