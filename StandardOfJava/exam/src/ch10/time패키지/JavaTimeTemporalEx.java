package ch10.time패키지;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class JavaTimeTemporalEx {
	public static void main(String[] args) {

		LocalTime now = LocalTime.now();
		int hour = now.getHour();
		int minute = now.get(ChronoField.MINUTE_OF_HOUR); // now.getMinute();
		int sec = now.getSecond(); // now.get(ChronoField.SECOND_OF_MINUTE);

		System.out.println(hour + ":" + minute + ":" + sec);

		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		LocalDate afterTomorrow = today.plusDays(2);
		today.minus

		System.out.println(today);
		System.out.println(tomorrow);
		System.out.println(afterTomorrow);

	}
}
