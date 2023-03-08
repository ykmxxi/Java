package ch10.time패키지;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class JavaTimeOfEx {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2023, 3, 8);
		LocalTime time = LocalTime.of(8, 11, 22);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, ZoneId.of("Asia/Seoul"));

		System.out.println(date);
		System.out.println(time);
		System.out.println(dateTime);
		System.out.println(zonedDateTime);
	}
}
