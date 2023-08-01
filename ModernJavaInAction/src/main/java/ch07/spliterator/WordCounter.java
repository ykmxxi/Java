package ch07.spliterator;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WordCounter {

	private final int counter;
	private final boolean lastSpace;

	public WordCounter(int counter, boolean lastSpace) {
		this.counter = counter;
		this.lastSpace = lastSpace;
	}

	public WordCounter accumulate(Character c) {
		if (Character.isWhitespace(c)) {
			return lastSpace ? this : new WordCounter(counter, true);
		} else {
			return lastSpace ? new WordCounter(counter + 1, false) : this;
		}
	}

	public WordCounter combine(WordCounter wordCounter) {
		return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
	}

	public int getCounter() {
		return counter;
	}

	public static void main(String[] args) {
		final String SENETENCE = "Nel mezzo del cammin di nostra vita "
			+ "mi ritrovai per una selva oscura "
			+ "ch  la diritta via era smarrita ";

		Stream<Character> stream = IntStream.range(0, SENETENCE.length())
			.mapToObj(SENETENCE::charAt);
		WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
			WordCounter::accumulate,
			WordCounter::combine);

		int count = wordCounter.getCounter();
		System.out.println("count = " + count); // 19 -> Correct Answer
	}

}
