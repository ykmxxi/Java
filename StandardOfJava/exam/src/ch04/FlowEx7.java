package ch04;

import java.util.Scanner;

public class FlowEx7 {

    public static void main(String[] args) {

        System.out.print("가위(1) 바위(2) 보(3) 중 하나를 입력하세요. >>>");

        Scanner sc = new Scanner(System.in);
        int user = sc.nextInt();
        int com = (int) (Math.random() * 3) + 1;

        System.out.println("당신은 " + user + " 입니다.");
        System.out.println("컴퓨터는 " + com + " 입니다.");

        switch (user - com) {
            case 2:
            case -1:
                System.out.println("당신이 패배 하였습니다.");
                break;
            case -2:
            case 1:
                System.out.println("당신이 승리 하였습니다.");
                break;
            case 0:
                System.out.println("비겼습니다.");
        }
    }
}
