package ch10.time패키지;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

public class JavaTimeNowEx {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();
		ZonedDateTime zonedDateTime = ZonedDateTime.now();

		System.out.println(date);
		System.out.println(time);
		System.out.println(dateTime);
		System.out.println(zonedDateTime);
		System.out.println();
	}
}
