package ch08.컬렉션팩토리;

import static java.util.Map.*;

import java.util.Map;

public class MapFactoryExample {

	public static void main(String[] args) {
		Map<String, Integer> ageOfFriends1 = Map.of("A", 20, "B", 21, "C", 22);
		System.out.println("ageOfFriends1 = " + ageOfFriends1); // {A=20, C=22, B=21}

		Map<String, Integer> ageOfFriends2 =
			Map.ofEntries(entry("A", 20), entry("B", 21), entry("C", 22));
		System.out.println("ageOfFriends2 = " + ageOfFriends2); // {A=20, C=22, B=21}
	}

}
