package ch02.동작파라미터화;

import ch01.Apple;

public class AppleFancyFormatter implements AppleFormatter {

	/**
	 * @param apple
	 * @return 문자열, 150g 초과는 heavy, 150g 이하는 light
	 */
	@Override
	public String accept(Apple apple) {
		String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
		return "A " + characteristic + " " + apple.getColor() + " apple";
	}

}
