package ch07.포크_조인_프레임워크;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

	public static final long THRESHOLD = 10_000; // 이 값 이하의 서브태스크는 더 이상 분할 X
	private final long[] numbers; // 더할 숫자 배열
	private final int start; // 서브태스크에서 처리할 배열의 초기 위치
	private final int end; // 서브태스크에서 처리할 최종 위치

	public ForkJoinSumCalculator(long[] numbers) {
		this(numbers, 0, numbers.length);
	}

	public ForkJoinSumCalculator(long[] numbers, int start, int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		int length = end - start;
		if (length <= THRESHOLD) {
			return computeSequentially(); // 기준값보다 작거나 같으면 순차적으로 결과를 계산
		}

		ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
		leftTask.fork(); // 다른 스레드로 새로 생성한 태스크를 비동기로 실행

		ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
		Long rightResult = rightTask.compute();
		Long leftResult = leftTask.join();
		return leftResult + rightResult;
	}

	private long computeSequentially() {
		long sum = 0;
		for (int i = start; i < end; i++) {
			sum += numbers[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long forkJoinResult = forkJoinSum(10_000_000);
		long end = System.currentTimeMillis();
		long resultTime = end - start;
		System.out.println("forkJoinResult = " + forkJoinResult);
		System.out.println("실행 시간 = " + resultTime + "ms");
	}

	private static long forkJoinSum(long n) {
		long[] numbers = LongStream.rangeClosed(1, n)
			.toArray();
		ForkJoinSumCalculator task = new ForkJoinSumCalculator(numbers);
		return new ForkJoinPool().invoke(task);
	}

}
