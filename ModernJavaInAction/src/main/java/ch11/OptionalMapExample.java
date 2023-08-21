package ch11;

import java.util.Optional;

public class OptionalMapExample {

	public static void main(String[] args) {
		Insurance insurance1 = new Insurance("AIA");
		Insurance insurance2 = new Insurance(null);
		Optional<Insurance> existOptional = Optional.ofNullable(insurance1);
		Optional<Insurance> nullOptional = Optional.ofNullable(insurance2);

		Optional<String> result1 = existOptional.map(Insurance::getName);
		System.out.println("result1 = " + result1); // Optional[AIA]

		Optional<String> result2 = nullOptional.map(Insurance::getName);
		System.out.println("result2 = " + result2); // Optional.empty
	}

}
