package ch04;

import java.util.*;

public class FlowEx28 {

    public static void main(String[] args) {
        int input = 0;
        int answer;

        answer = (int) (Math.random() * 100) + 1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1 ~ 100 정수를 입력 >>> ");
            input = sc.nextInt();

            if(input < answer) {
                System.out.println("더 큰 수를 입력하세요.");
            } else if(input > answer) {
                System.out.println("더 작은 수를 입력하세요.");
            }
        } while(input != answer);

        System.out.println("정답!!!");

    }
}
