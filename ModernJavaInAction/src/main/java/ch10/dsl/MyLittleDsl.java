package ch10.dsl;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyLittleDsl {

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		for (int age = 20; age < 30; age++) {
			persons.add(new Person(age, "user" + age));
		}

		// 무명 내부 클래스 이용
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
		});

		// 람다 표현식 이용
		Collections.sort(persons, (p1, p2) -> p1.getAge() - p2.getAge());

		// 정적 유틸리티 메서드와 메서드 참조를 이용해 가독성 높이기
		Collections.sort(persons, comparing(Person::getAge));

		// reversed 메서드를 이용해 역순 정렬하기
		Collections.sort(persons, comparing(Person::getAge).reversed());

		// 추가로 정렬이 가능하다: 나이를 먼저 정렬하고 같은 나이의 사람들을 알파벳 순으로 정렬
		Collections.sort(persons, comparing(Person::getAge).thenComparing(Person::getName));

		// List 인터페이스의 sort 메서드
		persons.sort(comparing(Person::getAge).thenComparing(Person::getName));
	}

}
