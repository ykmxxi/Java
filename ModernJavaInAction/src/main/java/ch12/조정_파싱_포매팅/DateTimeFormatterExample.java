package ch12.조정_파싱_포매팅;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterExample {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2023, 8, 23);

		String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE); // 20230823
		String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE); // 2023-08-23

		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);

		// parse()를 이용해 문자열을 날짜 객체로도 만들 수 있음
		LocalDate date1 = LocalDate.parse("20230823", DateTimeFormatter.BASIC_ISO_DATE);
		LocalDate date2 = LocalDate.parse("2023-08-23", DateTimeFormatter.ISO_LOCAL_DATE);

		System.out.println("date1 = " + date1);
		System.out.println("date2 = " + date2);

		// 패턴으로 날짜 생성
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy:MM:dd");
		String formattedDate = date.format(pattern);
		LocalDate date3 = LocalDate.parse(formattedDate, pattern);

		System.out.println("formattedDate = " + formattedDate); // 2023:08:23
		System.out.println("date3 = " + date3); // 2023-08-23

		// Locale 정보로 포매터 생성
		DateTimeFormatter koreaFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일", Locale.KOREA);
		String koreaDate = date.format(koreaFormatter);
		System.out.println("koreaDate = " + koreaDate); // 2023년 08월 23일

	}

}
