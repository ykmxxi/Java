package ch07.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCounterSpliterator implements Spliterator<Character> {

	private final String string;
	private int currentChar = 0;

	public WordCounterSpliterator(String string) {
		this.string = string;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Character> action) {
		action.accept(string.charAt(currentChar++)); // 현재 문자를 소비
		return currentChar < string.length(); // 소비할 문자가 남아있으면 true 반환
	}

	@Override
	public Spliterator<Character> trySplit() {
		int currentSize = string.length() - currentChar;

		// 파싱할 문자열을 순차 처리할 수 있을 만큼 충분히 작으면 null 반환
		if (currentSize < 10) {
			return null;
		}

		int start = currentSize / 2 + currentChar;
		for (int splitPos = start; splitPos < string.length(); splitPos++) {
			if (Character.isWhitespace(string.charAt(splitPos))) {
				// 문자열을 파싱할 새로운 WordCounterSpliterator 생성
				Spliterator<Character> spliterator =
					new WordCounterSpliterator(string.substring(currentChar, splitPos));
				currentChar = splitPos; // 시작 위치를 분할 위치로 설정
				return spliterator; // 공백을 찾았고 문자열을 분리했으니 루프를 종료
			}
		}
		return null;
	}

	@Override
	public long estimateSize() {
		return string.length() - currentChar;
	}

	@Override
	public int characteristics() {
		return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
	}

	public static void main(String[] args) {
		final String SENETENCE = "Nel mezzo del cammin di nostra vita "
			+ "mi ritrovai per una selva oscura "
			+ "ch  la diritta via era smarrita ";

		Spliterator<Character> spliterator = new WordCounterSpliterator(SENETENCE);
		Stream<Character> stream = StreamSupport.stream(spliterator, true); // 두 번째 인수가 true인 경우 병렬 스트림 생성
		WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
			WordCounter::accumulate,
			WordCounter::combine);

		int parallelCount = wordCounter.getCounter();
		System.out.println("parallelCount = " + parallelCount); // 19 -> Correct Answer
	}

}
