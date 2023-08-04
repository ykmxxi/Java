package ch08.컬렉션팩토리;

import java.util.List;

class Member {

	private final String name;
	private final int age;
	private String address;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Member(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public String getAddress() {
		return address;
	}

}

public class ListFactoryExample {

	public static void main(String[] args) {
		Member a = new Member("A", 20, "Seoul");
		Member b = new Member("B", 20, "Busan");
		List<Member> members = List.of(a, b);
		System.out.println(b);
		System.out.println(members.get(1));

		b.setAddress("Seoul"); // 객체의 참조 주소가 변하지 않으니 수정이 가능하다
		System.out.println(members.get(1).getAddress());
		System.out.println(b);
		System.out.println(members.get(1));

		members.set(1, new Member("C", 21)); // UnsupportedOperationException 발생
	}

}
