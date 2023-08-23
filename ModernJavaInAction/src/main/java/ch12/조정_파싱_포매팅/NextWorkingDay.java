package ch12.조정_파싱_포매팅;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * 커스텀 TemporalAdjuster 구현
 * 날짜를 하루씩 다음날로 바꿈
 * 토요일과 일요일은 건너뜀
 * 월 -> 화 -> ... -> 금 -> 월
 */
public class NextWorkingDay implements TemporalAdjuster {

	@Override public Temporal adjustInto(Temporal temporal) {
		DayOfWeek of = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK)); // 현재 날짜 읽기

		int dayToAdd = 1; // 보통은 하루 추가
		if (of == DayOfWeek.FRIDAY) {
			dayToAdd = 3;
		} else if (of == DayOfWeek.SATURDAY) {
			dayToAdd = 2;
		}
		return temporal.plus(dayToAdd, ChronoUnit.DAYS);
	}

	public static void main(String[] args) {
		LocalDate workingDay = LocalDate.now();
		NextWorkingDay adjuster = new NextWorkingDay();

		for (int day = 7; day > 0; day--) { // 내일 부터 7일 동안 출근
			workingDay = workingDay.with(adjuster);
			System.out.println("workingDay = " + workingDay + ", " + workingDay.getDayOfWeek());

		}
	}

}
