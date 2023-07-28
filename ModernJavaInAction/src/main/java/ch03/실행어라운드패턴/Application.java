package ch03.실행어라운드패턴;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@FunctionalInterface
interface BufferedReaderProcessor {

	String process(BufferedReader b) throws IOException;

}

public class Application {

	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br =
				 new BufferedReader(new FileReader(
					 "/Users/ykm/Desktop/projects/modernjavainaction/src/ch03/실행어라운드패턴/data.txt"))) {
			return p.process(br); // BufferedReader 객체 처리
		}
	}

	public static void main(String[] args) throws IOException {
		String oneLine = processFile((BufferedReader br) -> br.readLine());
		String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());

		System.out.println("Read one line: " + oneLine);
		System.out.println("Read two line: " + twoLine);

	}

}
