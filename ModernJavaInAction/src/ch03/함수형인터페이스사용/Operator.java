package ch03.함수형인터페이스사용;

import static ch03.함수형인터페이스사용.Operator.*;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
	PLUS("+", (a, b) -> a + b),
	MINUS("-", (a, b) -> a - b),
	MULTIPLY("*", (a, b) -> a * b),
	DIVIDE("/", (a, b) -> a / b);

	private final String sign;
	private final BiFunction<Long, Long, Long> bi;

	Operator(String sign, BiFunction<Long, Long, Long> bi) {
		this.sign = sign;
		this.bi = bi;
	}

	public static long calculate(long a, long b, String sign) {
		Operator operator = Arrays.stream(values())
			.filter(v -> v.sign.equals(sign))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);

		return operator.bi.apply(a, b);
	}

}

class Main {

	public static void main(String[] args) {
		String example = "9*7";
		String[] split = example.split("");

		long before = Long.parseLong(split[0]);
		long after = Long.parseLong(split[2]);

		System.out.println(example + "=" + calculate(before, after, split[1]));
	}

}
