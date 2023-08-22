package ch12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateAndLocalTime {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2023, 8, 22);
		System.out.println("date = " + date); // 2023-08-22

		int year = date.getYear();
		System.out.println("year = " + year); // 2023
		Month month = date.getMonth();
		System.out.println("month = " + month); // AUGUST
		int dayOfMonth = date.getDayOfMonth();
		System.out.println("dayOfMonth = " + dayOfMonth); // 22

		DayOfWeek dayOfWeek = date.getDayOfWeek();
		System.out.println("dayOfWeek = " + dayOfWeek); // TUESDAY(화요일)
		int length = date.lengthOfMonth(); // 해당 월의 수 (30 or 31 or 28)
		System.out.println("length = " + length); // 31
		boolean leapYear = date.isLeapYear(); // 윤년 여부
		System.out.println("leapYear = " + leapYear); // false

		LocalDate now = LocalDate.now();
		System.out.println("now = " + now);
		System.out.println();

		// 정적 팩토리 메서드 of()의 두 가지 오버로드 버전을 제공
		LocalTime timeWithoutSec = LocalTime.of(15, 46);
		LocalTime timeWithSec = LocalTime.of(15, 46, 33);

		int hour = timeWithSec.getHour(); // 15
		int minute = timeWithSec.getMinute(); // 46
		int second = timeWithSec.getSecond(); // 33
		// int second1 = timeWithoutSec.getSecond(); // 초가 없으면 0을 반환

		// parse() 정적 메서드: 지정한 문자열로 인스턴스 생성
		LocalDate parseDate = LocalDate.parse("2023-12-12");
		LocalTime parseTime = LocalTime.parse("11:22:33");

	}

}
