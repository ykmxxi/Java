package ch03.메서드참조;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import ch01.Apple;

// 무게, 색, 국가. 총 3개의 속성을 갖는 함수형 인터페이스를 정의해 사용.
@FunctionalInterface
interface TriFunction<T, U, V, R> {

	R apply(T t, U u, V v);

}

public class GetApples {

	public static void main(String[] args) {
		List<Integer> weights = Arrays.asList(100, 150, 200, 300, 160);
		List<String> colors = Arrays.asList("Green", "Red", "Green", "Red", "Green");
		List<String> countries = Arrays.asList("KR", "KR", "US", "US", "KR");

		//        List<Apple> apples1 = map1(weights, colors, Apple::new);
		//        for (Apple apple : apples1) {
		//            System.out.println(apple);
		//        }

		System.out.println();

		List<Apple> apples2 = map2(weights, colors, countries, Apple::new);
		for (Apple apple : apples2) {
			System.out.println(apple);
		}
	}

	public static List<Apple> map1(List<Integer> weights, List<String> colors, BiFunction<Integer, String, Apple> f) {
		List<Apple> result = new ArrayList<>();

		for (int i = 0; i < weights.size(); i++) {
			result.add(f.apply(weights.get(i), colors.get(i)));
		}
		return result;
	}

	public static List<Apple> map2(List<Integer> weights, List<String> colors, List<String> countries,
		TriFunction<Integer, String, String, Apple> f) {
		List<Apple> result = new ArrayList<>();

		for (int i = 0; i < weights.size(); i++) {
			result.add(f.apply(weights.get(i), colors.get(i), countries.get(i)));
		}
		return result;
	}

}
