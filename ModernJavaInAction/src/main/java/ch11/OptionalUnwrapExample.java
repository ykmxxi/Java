package ch11;

import java.util.Optional;

public class OptionalUnwrapExample {

	public static void main(String[] args) {
		Optional<Insurance> emptyInsurance = Optional.of(new Insurance(null));
		Optional<Insurance> existInsurance = Optional.of(new Insurance("AIA"));

		String emptyOrElse = emptyInsurance.map(Insurance::getName)
			.orElse("Unknown");
		String existOrElse = existInsurance.map(Insurance::getName)
			.orElse(("Unknown"));

		System.out.println("emptyOrElse = " + emptyOrElse);
		System.out.println("existOrElse = " + existOrElse);

		String emptyOrElseThrow = emptyInsurance.map(Insurance::getName)
			.orElseThrow(() -> new NoInsuranceException("가입한 보험이 없습니다."));
		String existOrElseThrow = existInsurance.map(Insurance::getName)
			.orElseThrow(() -> new NoInsuranceException("가입한 보험이 없습니다."));
		System.out.println("emptyOrElseThrow = " + emptyOrElseThrow);
		System.out.println("existOrElseThrow = " + existOrElseThrow);
	}

	static class NoInsuranceException extends RuntimeException {

		public NoInsuranceException(String message) {
			super(message);
		}

	}

}
