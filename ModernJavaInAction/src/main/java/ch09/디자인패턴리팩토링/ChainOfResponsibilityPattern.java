package ch09.디자인패턴리팩토링;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainOfResponsibilityPattern {

	public static void main(String[] args) {
		ProcessingObject<String> p1 = new HeaderTextProcessing();
		SpellCheckerProcessing p2 = new SpellCheckerProcessing();
		p1.setSuccessor(p2); // 두 작업 처리 객체를 연결

		String input = "Aren't labdas really cool?";
		String result = p1.handle(input);
		System.out.println("result = " + result);

		// 람다 표현식 사용
		// 첫 번째 작업 처리 객체
		UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;
		// 두 번째 작업 처리 객체
		UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");

		Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);
		result = pipeline.apply(input);
		System.out.println("result = " + result);
	}

}

abstract class ProcessingObject<T> {

	protected ProcessingObject<T> successor;

	public void setSuccessor(ProcessingObject<T> successor) {
		this.successor = successor;
	}

	/**
	 * 일부 작업을 어떻게 처리해야 할지 전체적으로 기술
	 */
	public T handle(T input) {
		T t = handleWork(input);
		if (successor != null) {
			return successor.handle(t);
		}
		return t;
	}

	abstract protected T handleWork(T input);

}

class HeaderTextProcessing extends ProcessingObject<String> {

	@Override
	protected String handleWork(String input) {
		return "From Raoul, Mario and Alan: " + input;
	}

}

class SpellCheckerProcessing extends ProcessingObject<String> {

	@Override
	protected String handleWork(String input) {
		return input.replaceAll("labda", "lambda");
	}

}
