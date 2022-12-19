package ch04;

import java.util.Scanner;

public class FlowEx8 {

    public static void main(String[] args) {

        System.out.print("주민 번호 입력 ex)111111-1111111 >>> ");

        Scanner sc = new Scanner(System.in);
        String regNo = sc.nextLine();

        char gender = regNo.charAt(7);

        switch (gender) {
            case '1':
            case '3':
                switch (gender) {
                    case '1':
                        System.out.println("당신은 2000년 이전 출생한 남자");
                        break;
                    case '3':
                        System.out.println("당신은 2000년 이후 출생한 남자");
                        break;
                }
                break;
            case '2':
            case '4':
                switch (gender) {
                    case '2':
                        System.out.println("당신은 2000년 이전 출생한 여자");
                        break;
                    case '4':
                        System.out.println("당신은 2000년 이후 출생한 여자");
                        break;
                }
                break;
            default:
                System.out.println("유효하지 않은 주민번호 입니다.");
        }


    }
}
