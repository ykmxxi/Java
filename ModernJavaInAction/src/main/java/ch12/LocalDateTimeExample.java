package ch12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeExample {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2023, 8, 22);
		LocalTime time = LocalTime.of(11, 22, 33);

		LocalDateTime dateTime = LocalDateTime.of(date, time);
		System.out.println("dateTime = " + dateTime);

		LocalDateTime dateTime1 = date.atTime(time);
		System.out.println("dateTime1 = " + dateTime1);
		LocalDateTime dateTime2 = date.atTime(11, 22, 33);
		System.out.println("dateTime2 = " + dateTime2);
		LocalDateTime dateTime3 = time.atDate(date);
		System.out.println("dateTime3 = " + dateTime3);

		LocalDateTime now = LocalDateTime.now();
		System.out.println("now = " + now);

		LocalDate localDate = dateTime.toLocalDate(); // 2023-08-22
		LocalTime localTime = dateTime.toLocalTime(); // 11-22-33

	}

}
