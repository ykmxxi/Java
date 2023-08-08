package ch09.refactoring;

public class AnonymousClassToLambda {

	public static void main(String[] args) {
		// before: 익명 클래스 사용
		Runnable anonymous = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello World");
			}
		};

		// refactoring: 람다 표현식 이용
		Runnable lambda = () -> System.out.println("Hello World");
	}

	// shadow variable 문제
	static class Problem {

		public static void main(String[] args) {
			int a = 10;

			Runnable anonymous = new Runnable() {
				@Override
				public void run() {
					int a = 2;
					System.out.println("a = " + a);
				}
			};
			anonymous.run(); // a = 2

			Runnable lambda = () -> {
				// int a = 2; // 컴파일 에러
				System.out.println("a = " + a);
			};
			lambda.run(); // a = 10;
		}

	}

}
