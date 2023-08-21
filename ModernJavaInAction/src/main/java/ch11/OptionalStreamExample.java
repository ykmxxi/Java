package ch11;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class OptionalStreamExample {

	public static Set<String> getCarInsuranceNames(List<Person> persons) {
		return persons.stream()
			.map(Person::getCar) // 사람 목록을 각 사람이 보유한 자동차의 Optional<Car> 스트림으로 변환
			.map(optCar -> optCar.flatMap(Car::getInsurance)) // flatMpa()으로 Optional<Insurance>로 변환
			.map(optIns -> optIns.map(Insurance::getName)) // Optional<Insurance>를 Optional<String>으로 매핑
			.flatMap(Optional::stream) // Stream<String>으로 변환
			.collect(Collectors.toSet()); // 결과 문자열을 Set으로 수집
	}

}
