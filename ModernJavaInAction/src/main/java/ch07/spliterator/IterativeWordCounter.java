package ch07.spliterator;

public class IterativeWordCounter {

	public static int countWordsIteratively(String s) {
		int counter = 0;
		boolean lastSpace = true;

		for (char c : s.toCharArray()) {
			if (Character.isWhitespace(c)) {
				lastSpace = true;
			} else {
				if (lastSpace) { // 공백 문자를 만나면
					counter++; // 지금까지 탐색한 문자를 단어로 간주해 단어 수를 증가
				}
				lastSpace = false;
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		String sentence = "Hello Modern Java In Action"; // 5개의 단어
		int iterativelyResult = countWordsIteratively(sentence);
		System.out.println("iterativelyResult = " + iterativelyResult);
	}

}
