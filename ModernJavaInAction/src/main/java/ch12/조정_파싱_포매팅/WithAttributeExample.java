package ch12.조정_파싱_포매팅;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class WithAttributeExample {

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.of(2023, 8, 22);

		// 절대적인 방식
		LocalDate date2 = date1.withYear(2000); // 2000-08-22
		LocalDate date3 = date1.withMonth(1); // 2023-01-22
		LocalDate date4 = date1.withDayOfMonth(11); // 2023-08-11

		LocalDate date5 = date1.with(ChronoField.MONTH_OF_YEAR, 1); // 2023-01-22

		// 상대(선언)적인 방식
		LocalDate date6 = date1.plusWeeks(1); // 2023-08-29
		LocalDate date7 = date1.minusDays(10); // 2023-08-12

		LocalDate date8 = date1.minus(6, ChronoUnit.MONTHS); // 2023-02-22
	}

}
