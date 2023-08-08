package ch09.디자인패턴리팩토링;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class TemplateMethodPattern {

	public static void main(String[] args) {
		OnlineBanking bank = new SeoulBank();
		bank.processString(1);

		// 람다 이용
		new OnlineBankingLambda().processString(1, (String c) -> System.out.println("Hello " + c));
	}

}

abstract class OnlineBanking {

	private static final Map<Integer, String> storage = new HashMap<>();

	public void processString(int id) {
		storage.put(1, "userA");
		String c = storage.get(id);
		makeStringHappy(c);
	}

	abstract void makeStringHappy(String c);

}

class SeoulBank extends OnlineBanking {

	@Override
	void makeStringHappy(String c) {
		System.out.println("Hello " + c);
	}

}

class OnlineBankingLambda {

	private static final Map<Integer, String> storage = new HashMap<>();

	public void processString(int id, Consumer<String> makeStringHappy) {
		storage.put(1, "userA");
		String c = storage.get(id);
		makeStringHappy.accept(c);
	}

}
