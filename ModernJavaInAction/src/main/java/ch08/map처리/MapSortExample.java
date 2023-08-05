package ch08.map처리;

import static java.util.Map.entry;

import java.util.Map;
import java.util.Map.Entry;

public class MapSortExample {

	public static void main(String[] args) {
		Map<String, String> favoriteMovies = Map.ofEntries(
			entry("C", "Avatar"),
			entry("B", "God Father"),
			entry("A", "Star Wars")
		);

		favoriteMovies.entrySet()
			.stream()
			.sorted(Entry.comparingByValue()) // 영화 이름을 알파벳 순으로 스트림 요소를 처리
			.forEachOrdered(System.out::println);
	}

}
