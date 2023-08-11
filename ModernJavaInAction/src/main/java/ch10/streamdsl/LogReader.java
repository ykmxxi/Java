package ch10.streamdsl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 반복 형식으로 예제 로그 파일에서 여러 행을 읽는 코드
 * 함수형으로 로그 파일의 에러 행을 읽는 코드
 */
public class LogReader {

	private static final String FILE_NAME = "data.txt";

	public static void main(String[] args) throws IOException {
		// 반복 형식으로 예제 로그 파일에서 여러 행을 읽는 코드
		List<String> errors = new ArrayList<>();
		int errorCount = 0;
		BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
		String line = br.readLine();

		while (errorCount < 40 && line != null) {
			if (line.startsWith("ERROR")) {
				errors.add(line);
				errorCount++;
			}
			line = br.readLine();
		}

		// 스트림 이용하기
		errors = Files.lines(Paths.get(FILE_NAME)) // 파일을 열어 문자열 스트림 생성
			.filter(l -> l.startsWith("ERROR")) // ERROR 필터링
			.limit(40) // 결과를 첫 40행으로 제한
			.collect(Collectors.toList()); // 결과 문자열을 리스트로 수집
	}

}
