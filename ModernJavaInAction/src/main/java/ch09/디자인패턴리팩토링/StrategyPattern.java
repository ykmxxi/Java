package ch09.디자인패턴리팩토링;

public class StrategyPattern {

	public static void main(String[] args) {
		Validator numericValidator = new Validator(new IsNumeric());
		String a = "aaaa";
		if (numericValidator.validate(a)) {
			System.out.println("숫자 입니다.");
		} else {
			System.out.println("숫자가 아닙니다.");
		}

		Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
		if (lowerCaseValidator.validate(a)) {
			System.out.println("모두 소문자 입니다.");
		} else {
			System.out.println("모두 소문자가 아닙니다.");
		}

		// 람다로 리팩토링: 람다 표현식을 직접 전달해 불필요한 코드를 줄일 수 있음
		// 아래 IsNumeric, IsAllLowerCase 클래스를 구현할 필요가 없어짐
		numericValidator = new Validator((String s) -> s.matches("\\d+"));
		lowerCaseValidator = new Validator((String s) -> s.matches("[a-z]+"));
	}

}

/**
 * 알고리즘을 나타내는 전략 인터페이스
 */
interface ValidationStrategy {

	boolean execute(String s);

}

// 구현체 1: 모두 소문자인지 검사
class IsAllLowerCase implements ValidationStrategy {

	@Override
	public boolean execute(String s) {
		return s.matches("[a-z]+");
	}

}

// 구현체 2: 숫자인지 검사
class IsNumeric implements ValidationStrategy {

	@Override
	public boolean execute(String s) {
		return s.matches("\\d+");
	}

}

// 전략 객체를 사용하는 클라이언트
class Validator {

	private final ValidationStrategy strategy;

	Validator(ValidationStrategy strategy) {
		this.strategy = strategy;
	}

	public boolean validate(String s) {
		return strategy.execute(s);
	}

}
