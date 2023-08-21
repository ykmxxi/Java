package ch11;

import java.util.Optional;

public class OptionalClassExample {

	public static void main(String[] args) {
		// 빈 Optional
		Optional<Car> optCar1 = Optional.empty();

		// null이 아닌 값으로 Optional 만들기
		// null을 넣으면 NullPointerException 발생
		Optional<Car> optCar2 = Optional.of(new Car());
		// Optional<Car> optCar2 = Optional.of(null);

		// null 값으로 Optional 생성
		Optional<Car> optCar3 = Optional.ofNullable(null);
	}

}
