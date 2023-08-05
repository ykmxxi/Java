package ch08.map처리;

import java.util.HashMap;
import java.util.Map;

public class MapMergeExample {

	public static void main(String[] args) {
		Map<String, String> family = new HashMap<>();
		family.put("A", "Star Wars");
		family.put("B", "Avatar");

		Map<String, String> friends = new HashMap<>();
		friends.put("A", "Dark Knight");
		friends.put("C", "Iron Man");

		Map<String, String> everyone = new HashMap<>(family);
		friends.forEach((k, v) -> everyone.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2));
		System.out.println("everyone = " + everyone);
	}

}
