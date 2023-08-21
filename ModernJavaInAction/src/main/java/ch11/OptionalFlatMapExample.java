package ch11;

import java.util.Optional;

public class OptionalFlatMapExample {

	public static void main(String[] args) {
		Optional<Person> optPerson = Optional.ofNullable(new Person());

		/* 컴파일 에러 발생: 중첩된 Optional 객체 구조 반환하기 때문에 map()을 사용할 수 없음
		Optional<String> name = optPerson.map(Person::getCar)
			.map(Car::getInsurance)
			.map(Insurance::getName);
		 */

	}

	public static String getCarInsuranceName(Optional<Person> person) {
		return person.flatMap(Person::getCar)
			.flatMap(Car::getInsurance)
			.map(Insurance::getName)
			.orElse("Unknown"); // 연산 결과 Optional이 비어있으면 기본값을 반환
	}

}
