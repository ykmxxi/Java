package ch13.해석규칙;

public class C implements B, A {

	@Override public void hello() {
		B.super.hello(); // 명시적으로 인터페이스 B의 메서드를 선택
	}

	public static void main(String[] args) {
		new C().hello();
	}

}
