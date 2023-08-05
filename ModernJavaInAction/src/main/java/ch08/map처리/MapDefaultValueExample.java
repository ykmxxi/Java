package ch08.map처리;

import static java.util.Map.entry;

import java.util.Map;

public class MapDefaultValueExample {

	public static void main(String[] args) {
		Map<String, String> favoriteMovies = Map.ofEntries(
			entry("C", "Avatar"),
			entry("B", "God Father"),
			entry("A", "Star Wars")
		);

		System.out.println(favoriteMovies.getOrDefault("A", "좋아하는 영화 없음"));
		System.out.println(favoriteMovies.getOrDefault("D", "좋아하는 영화 없음")); // key 없음
	}

}
