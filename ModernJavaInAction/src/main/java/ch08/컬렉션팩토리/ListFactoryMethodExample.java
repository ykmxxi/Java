package ch08.컬렉션팩토리;

import java.util.Arrays;
import java.util.List;

public class ListFactoryMethodExample {

	public static void main(String[] args) {
		List<String> friends = Arrays.asList("A", "B", "C"); // Arrays.asList(): 고정 크기의 리스트 생성

		try {
			friends.set(0, "a"); // 성공
			friends.add("D"); // 예외 발생
		} catch (UnsupportedOperationException e) {
			System.out.println("friends = " + friends); // ["a", "B", "C"]
			e.printStackTrace();
		}

	}

}
