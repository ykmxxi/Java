package ch06;

/*
 * 인스턴스의 생성과 사용

 */

class TvTest {

    public static void main(String[] args) {

        Tv tv;
         /*
            1. Tv 클래스 타입의 참조변수 tv를 선언
                * 메모리에 참조변수 tv를 위한 공간 마련
                * 아직 인스턴스 생선 전
         */

        tv = new Tv();
        /*
            2. Tv 클래스의 인스턴스가 메모리의 빈 공간에 생성
                * new 키워드를 통해 주소가 생성되고, 멤버변수는 각 자료형의 기본값으로 초기화
                * 대입연산자에 의해 생성된 인스턴스의 주소값이 참조변수 tv에 저장
                * 참조변수 tv를 통해 인스턴스에 접근 가능
         */

        tv.channel = 7;
        tv.channelUp();
        /*
            3. Tv 인스턴스의 멤버변수 channel 에 값을 저장, 메서드 호출
                * 멤버변수는 참조변수.멤버변수 를 통해 접근 가능
                * 메서드도 멤버변수와 똑같이 참조변수.메서드()를 통해 호출
         */

        System.out.printf("현재 채널은 %d번 입니다.\n", tv.channel);
    }
}
