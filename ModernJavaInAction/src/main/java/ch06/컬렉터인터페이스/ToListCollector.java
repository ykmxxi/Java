package ch06.컬렉터인터페이스;

import static ch06.Dish.*;
import static java.util.stream.Collector.Characteristics.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import ch06.Dish;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

	public static void main(String[] args) {
		// 사용자 정의 컬렉터 사용
		List<Dish> vegetarianDishes = menu.stream()
			.filter(Dish::isVegetarian)
			.collect(new ToListCollector<>()); // 기존의 팩토리 메서드인 toList()와 달리 new로 인스턴스화함.
		System.out.println(vegetarianDishes);

		// 컬렉터를 구현하지 않고 사용자 정의 수집이 가능
		List<Dish> dishes = menu.stream()
			.collect(
				ArrayList::new, // 발행
				List::add, // 누적
				List::addAll // 병합
			);
		System.out.println(dishes);
	}

	@Override
	public Supplier<List<T>> supplier() {
		return ArrayList::new;
	}

	@Override
	public BiConsumer<List<T>, T> accumulator() {
		return List::add;
	}

	@Override
	public Function<List<T>, List<T>> finisher() {
		// return i -> i;
		return Function.identity();
	}

	@Override
	public BinaryOperator<List<T>> combiner() {
		return (list1, list2) -> {
			list1.addAll(list2);
			return list1;
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH, CONCURRENT));
	}

}
