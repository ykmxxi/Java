package ch12;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;

public class DurationAndPeriod {

	public static void main(String[] args) {
		LocalTime time1 = LocalTime.of(11, 22, 33);
		LocalTime time2 = LocalTime.of(11, 22, 44);
		Duration between1 = Duration.between(time1, time2);
		System.out.println("between1 = " + between1);

		LocalDateTime dateTime1 = LocalDateTime.now();
		LocalDateTime dateTime2 = LocalDateTime.now(ZoneId.systemDefault());
		Duration between2 = Duration.between(dateTime1, dateTime2);
		System.out.println("between2 = " + between2);

		Period tenDays = Period.between(LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 11));
		System.out.println("tenDays = " + tenDays); // P10D

		Period threeDays = Period.ofDays(3);
		System.out.println("threeDays = " + threeDays); // P3D
		Period threeWeeks = Period.ofWeeks(3);
		System.out.println("threeWeeks = " + threeWeeks); // P21D
		Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
		System.out.println("twoYearsSixMonthsOneDay = " + twoYearsSixMonthsOneDay); // P2Y6M1D
	}

}
