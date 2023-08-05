package ch08.map처리;

import java.util.HashMap;
import java.util.Map;

public class MapReplaceExample {

	public static void main(String[] args) {
		Map<String, String> favoriteMovies = new HashMap<>();
		favoriteMovies.put("A", "Star Wars");
		favoriteMovies.put("B", "Avengers");
		favoriteMovies.forEach((k, v) -> System.out.println("name = " + k + ", movie = " + v));
		System.out.println();

		// value 모두 대문자로 변경
		favoriteMovies.replaceAll((k, v) -> v.toUpperCase());
		favoriteMovies.forEach((k, v) -> System.out.println("name = " + k + ", movie = " + v));
		System.out.println();

		// A 값을 교체
		favoriteMovies.replace("A", "Dark Knight");
		// B 값이 Avengers 이면 교체, 아니면 그대로
		favoriteMovies.replace("B", "Avengers", "Iron Man");
		favoriteMovies.forEach((k, v) -> System.out.println("name = " + k + ", movie = " + v));
	}

}
