package ch05.스트림만들기;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildingStream {

	public static void main(String[] args) {

		Stream<String> stream = Stream.of("Modern ", "Java ", "In ", "Action");
		stream.map(String::toUpperCase).forEach(System.out::println);

		int[] numbers = {2, 3, 5, 7, 11, 13};
		int sum = Arrays.stream(numbers)
			.sum();
		System.out.println(sum);

		// 파일로 스트림 만들기
		long uniqueWordCount = 0L;
		try (Stream<String> lines =
				 Files.lines(
					 Paths.get("/Users/ykm/Desktop/projects/Java/ModernJavaInAction/src/ch05/스트림만들기/data.txt"),
					 Charset.defaultCharset())) {
			uniqueWordCount = lines.flatMap(line -> Arrays.stream(line.split(", ")))
				.distinct()
				.count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(
			"data.txt에 존재하는 고유 단어 개수: " + uniqueWordCount); // 7: Hi, Hello, World, Modern, Java, In, Action

		// 짝수 스트림 10개 생성
		Stream.iterate(0, n -> n + 2)
			.limit(10)
			.forEach(System.out::println);

		// 피보나치 수열
		Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]})
			.limit(20)
			.map(t -> t[0] + ", ")
			.forEach(System.out::print);
		System.out.println();

		IntStream.iterate(0, n -> n < 100, n -> n + 4)
			.mapToObj(t -> t + ", ")
			.forEach(System.out::print);
		System.out.println();

		// generate 메서드를 사용한 비포나치 수열: 람다로 함수형 인터페이스의 인스턴스를 만들어 전달
		IntSupplier fib = new IntSupplier() {
			private int previous = 0;
			private int current = 1;

			@Override
			public int getAsInt() {
				int oldPrevious = this.previous;
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				return oldPrevious;
			}
		};

		IntStream.generate(fib)
			.limit(10)
			.mapToObj(t -> t + ", ")
			.forEach(System.out::print);

	}

}
