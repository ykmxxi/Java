package ch12.시간대_캘린더;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneExample {

	public static void main(String[] args) {
		ZoneId seoulZone = ZoneId.of("Asia/Seoul");
		LocalDate date = LocalDate.of(2023, 8, 23);
		ZonedDateTime seoulDate = date.atStartOfDay(seoulZone); // 2023-08-23T00:00+09:00[Asia/Seoul]

		System.out.println("seoulDate = " + seoulDate);

		Instant now = Instant.now();
		LocalDateTime nowSeoul = LocalDateTime.ofInstant(now, seoulZone);
		System.out.println("nowSeoul = " + nowSeoul); // 2023-08-23T14:56:08.011375
	}

}
