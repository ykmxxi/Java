package ch07.병렬스트림;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreamEx {

	/**
	 * 순차 스트림을 이용한 메서드
	 */
	public static long sequentialSum(long n) {
		return Stream.iterate(1L, i -> i + 1) // 무한 자연수 스트림 생성
			.limit(n) // n개 이하로 제한
			.reduce(0L, Long::sum); // 모든 숫자를 더한 스트림 BinaryOperator 리듀싱 연산
	}

	/**
	 * 병렬 스트림을 이용한 메서드
	 */
	public static long parallelSum(long n) {
		return Stream.iterate(1L, i -> i + 1)
			.limit(n)
			.parallel() // 스트림을 병렬 스트림으로 변환
			.reduce(0L, Long::sum);
	}

	/**
	 * 병렬 합계 연산 최적화
	 * LongStream.rangeClose() 사용
	 */
	public static long rangedSum(long n) {
		return LongStream.rangeClosed(1, n)
			.parallel()
			.reduce(0L, Long::sum);
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long sequentialSum = sequentialSum(100000000L);
		long end = System.currentTimeMillis();
		System.out.println("sequentialSum = " + sequentialSum);
		long resultTime = end - start;
		System.out.println("resultTime = " + resultTime + "ms"); // 1400ms

		start = System.currentTimeMillis();
		long parallelSum = parallelSum(10000000L);
		end = System.currentTimeMillis();
		System.out.println("parallelSum = " + parallelSum);
		resultTime = end - start;
		System.out.println("resultTime = " + resultTime + "ms"); // 385ms

		start = System.currentTimeMillis();
		long rangedSum = rangedSum(10000000L);
		end = System.currentTimeMillis();
		System.out.println("rangedSum = " + rangedSum);
		resultTime = end - start;
		System.out.println("rangedSum parallel resultTime = " + resultTime + "ms"); // 22ms
	}

}
