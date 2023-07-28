package ch07.병렬스트림;

import java.util.stream.LongStream;

public class ParallelStreamProblem {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			long result = sideEffectSum(1000L);
			long parallelSum = sideEffectParallelSum(1000L);
			System.out.println("result = " + result + ", parallelSum = " + parallelSum);
		}

	}

	/**
	 * 병렬화 X: 아직 문제가 없음
	 */
	public static long sideEffectSum(long n) {
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(1, n)
			.forEach(accumulator::add);
		return accumulator.total;
	}

	/**
	 * 병렬화 O: 문제 발생
	 */
	public static long sideEffectParallelSum(long n) {
		Accumulator accumulator = new Accumulator();
		LongStream.rangeClosed(1, n)
			.parallel()
			.forEach(accumulator::add);
		return accumulator.total;
	}

	static class Accumulator {

		public long total = 0;

		public void add(long value) {
			total += value;
		}

	}

}
