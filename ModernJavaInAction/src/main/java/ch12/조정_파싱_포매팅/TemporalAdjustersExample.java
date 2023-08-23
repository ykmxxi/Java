package ch12.조정_파싱_포매팅;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class TemporalAdjustersExample {

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.of(2023, 8, 23);
		System.out.println("date1 = " + date1); // 2023-08-23 수요일

		LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
		System.out.println("date2 = " + date2); // 2023-08-27 일요일

		LocalDate date3 = date2.with(lastDayOfMonth());
		System.out.println("date3 = " + date3); // 2023-08-31
	}

}
