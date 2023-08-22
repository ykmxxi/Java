package ch12;

import java.time.Instant;

public class InstantExample {

	public static void main(String[] args) {
		Instant instant = Instant.ofEpochSecond(3); // 에포크 기준 3초 뒤
		System.out.println("instant = " + instant); // 1970-01-01T00:00:03Z

		Instant instant1 = Instant.ofEpochSecond(3, 0);
		System.out.println("instant1 = " + instant1);

		// 에포크 기준 2초 뒤 + 1억 나노초 뒤 = 에포크 기준 3초 뒤
		Instant instant2 = Instant.ofEpochSecond(2, 1_000_000_000);
		System.out.println("instant2 = " + instant2);

		Instant now = Instant.now();
		System.out.println("now = " + now);

		// UnsupportedTemporalTypeException 발생
		// int day = Instant.now().get(ChronoField.DAY_OF_MONTH);
		// System.out.println("day = " + day);
	}

}
