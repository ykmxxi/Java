package ch07.다형성;

class Parent {
    int x = 100;

    void method() {
        System.out.println("Parent Method");
    }
}

class Child extends Parent {
    int x = 200;

    @Override
    void method() {
        System.out.println("Child Method");
        System.out.println("x = " + x);
        System.out.println("super.x = " + super.x);
        System.out.println("this.x = " + this.x);
    }
}

public class BindingTest {
    public static void main(String[] args) {
        Parent parent = new Child();
        Child child = new Child();

        System.out.println("parent.x = " + parent.x);   // 참조변수의 타입인 Parent 클래스의 멤버변수
        parent.method();    // 실제 인스턴스의 타입인 Child 클래스에 정의된 메서드 호출
        System.out.println("========================");
        System.out.println("child.x = " + child.x);     // 참조변수의 타입인 Child 클래스의 멤버변수
        child.method();     // 실제 인스턴스의 타입인 Child 클래스에 정의된 메서드 호출
    }
}
