package ch06.분할;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PartitionPrimeNumber {

	public static boolean isPrime(int candidate) {
		return IntStream.rangeClosed(2, (int)Math.sqrt(candidate))
			.noneMatch(i -> candidate % i == 0);
	}

	public static Map<Boolean, List<Integer>> getPartitionPrimes(int n) {
		return IntStream.rangeClosed(2, n)
			.boxed()
			.collect(Collectors.partitioningBy(PartitionPrimeNumber::isPrime));
	}

	public static void main(String[] args) {
		List<Integer> primeNumbers = getPartitionPrimes(100).get(true);
		List<Integer> nonePrimeNumbers = getPartitionPrimes(100).get(false);

		System.out.println(primeNumbers);
		System.out.println(nonePrimeNumbers);
	}

}
