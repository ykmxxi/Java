package ch06;

// 클래스 멤버와 인스턴스 멤버간의 참조와 호출

public class MemberCall {

    int instanceVariable = 10;
    static int classVariable = 20;

    int iv = instanceVariable;
    // static int cv = iv;      // Error. 클래스변수는 인스턴스변수를 사용할 수 없음
    static MemberCall memberCall = new MemberCall();
    static int cv = memberCall.instanceVariable;  // 객체를 생성해야 사용 가능

    static void staticMethod1() {
        System.out.println(classVariable);
        // System.out.println(instanceVariable);    // Error. 클래스메서드는 인스턴스변수를 사용할 수 없음
        System.out.println(memberCall.instanceVariable);
    }

    void instanceMethod1() {
        System.out.println(instanceVariable);
        System.out.println(classVariable);
    }

    static void staticMethod2() {
        staticMethod1();
        // instanceMethod1();   // Error. 클래스메서드는 인스턴스메서드 호출 불가
        memberCall.instanceMethod1();
    }

    void instanceMethod2() {
        staticMethod1();
        instanceMethod1();
    }
}
