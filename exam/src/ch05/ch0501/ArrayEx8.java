package ch05.ch0501;

/*
    배열 섞기 (shuffle)
    - 배열의 요소의 순서를 반복해서 바꾸어 로또 번호(6 개)를 생성
 */
public class ArrayEx8 {

    public static void main(String[] args) {

        int[] ball = new int[45];

        for (int i = 0; i < ball.length; i++) {
            ball[i] = i + 1;
        }

        int temp = 0; // swap 임시 저장 변수
        int j = 0; // 순서 변경을 위해 사용할 변수

        for (int i = 0; i < 6; i++) {
            j = (int) (Math.random() * 45); // 0 ~ 44 범위의 임의의 값 생성
            temp = ball[i];
            ball[i] = ball[j];
            ball[j] = temp;
        }

        for (int i = 0; i < 6; i++) {
            System.out.printf("%d 번째 당첨번호는 %d 입니다.\n", i+1, ball[i]);
        }
    }
}
