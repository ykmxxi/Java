package ch03.함수형인터페이스사용;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

public class ApplyFunction {

	public static String processFile(Function<BufferedReader, String> f) throws IOException {
		try (BufferedReader br =
				 new BufferedReader(new FileReader(
					 "/Users/ykm/Desktop/projects/modernjavainaction/src/ch03/함수형인터페이스사용/data.txt"))) {
			return f.apply(br); // BufferedReader 객체 처리
		}
	}

	public static void main(String[] args) throws IOException {
		Function<BufferedReader, String> f1 = (BufferedReader b) -> {
			try {
				return b.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		};

		Function<BufferedReader, String> f2 = (BufferedReader b) -> {
			try {
				return b.readLine() + b.readLine();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		};

		String oneLine = processFile(f1);
		String twoLine = processFile(f2);

		System.out.println("Read one line: " + oneLine);
		System.out.println("Read two line: " + twoLine);
	}

}
