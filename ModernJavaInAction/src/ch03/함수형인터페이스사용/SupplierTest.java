package ch03.함수형인터페이스사용;

import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		Supplier<Member> memberSupplier = () -> new Member(1, "Kim");

		Member member = memberSupplier.get();
		System.out.println("member.getUsername() = " + member.getUsername());
		System.out.println("member.getId() = " + member.getId());
	}

	static class Member {

		private final int id;
		private final String username;

		public Member(int id, String username) {
			this.id = id;
			this.username = username;
		}

		public int getId() {
			return id;
		}

		public String getUsername() {
			return username;
		}

	}

}
