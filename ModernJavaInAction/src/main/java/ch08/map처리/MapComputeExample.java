package ch08.map처리;

import java.util.HashMap;
import java.util.Map;

public class MapComputeExample {

	public static void main(String[] args) {
		Map<String, String> favoriteMovies = new HashMap<>();
		favoriteMovies.put("A", "Star Wars");
		favoriteMovies.put("B", null);

		favoriteMovies.computeIfAbsent("B", value -> "Avengers");
		favoriteMovies.computeIfAbsent("C", value -> "Avatar");
		favoriteMovies.forEach((k, v) -> System.out.println("name = " + k + ", movie = " + v));
		System.out.println();

		favoriteMovies.computeIfPresent("A", (k, v) -> "Iron Man");
		favoriteMovies.computeIfPresent("B", (k, v) -> "Dark Knight");
		favoriteMovies.forEach((k, v) -> System.out.println("name = " + k + ", movie = " + v));
		System.out.println();

		favoriteMovies.compute("D", (k, v) -> "Joker");
		favoriteMovies.forEach((k, v) -> System.out.println("name = " + k + ", movie = " + v));
	}

}
