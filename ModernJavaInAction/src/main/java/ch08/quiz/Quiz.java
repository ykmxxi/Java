package ch08.quiz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Quiz {

	public static void main(String[] args) {
		Map<String, Integer> movies = new HashMap<>();
		movies.put("JamesBond", 20);
		movies.put("Matrix", 15);
		movies.put("Avatar", 5);

		// 아래 메서드를 단순화
		Iterator<Map.Entry<String, Integer>> iterator = movies.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			if (entry.getValue() < 10) {
				iterator.remove();
			}
		}

		// 코드 단순화
		movies.entrySet()
			.removeIf(entry -> entry.getValue() < 10);

	}

}
