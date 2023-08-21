package ch11;

import java.util.Optional;

public class OptionalUtility {

	/**
	 * 문자열을 정수로 반환하는 유틸리티 메서드
	 * 변환 가능할 때: Integer.parseInt()로 변환해 반환
	 * 변환 불가능할 때: 빈 Optional 객체를 반환
	 */
	public static Optional<Integer> stringToInt(String s) {
		try {
			return Optional.of(Integer.parseInt(s));
		} catch (NumberFormatException e) {
			return Optional.empty();
		}
	}

}
