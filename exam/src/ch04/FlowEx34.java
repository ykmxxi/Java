package ch04;

import java.util.*;

public class FlowEx34 {

    public static void main(String[] args) {
        int menu = 0, num = 0;
        Scanner sc = new Scanner(System.in);

        outer:
        while (true) {
            System.out.println("(1). square");
            System.out.println("(2). square root");
            System.out.println("(3). log");
            System.out.print("원하는 메뉴 (1~3)를 선택. (종료 : 0) >>>");

            String tmp = sc.nextLine();
            menu = Integer.parseInt(tmp);

            if (menu == 0) {
                System.out.println("프로그램 종료...");
                break; // 메뉴 선택 종료, while 문 종료
            } else if (!(1 <= menu && menu <= 3)) {
                System.out.println("메뉴를 잘못 선택... (종료를 원하시면 0 을 눌러주세요.)");
                continue; // for 문을 생략하고 다시 while 문의 조건식으로 돌아가 true 이므로 처음부터 다시 실행
            }

            for (; ; ) {
                System.out.println("계산할 값을 입력. (계산 종료 : 0, 전체 종료 : 99) >>> ");
                tmp = sc.nextLine();
                num = Integer.parseInt(tmp);

                if (num == 0)
                    break;  // for 문 종료
                if (num == 99)
                    break outer; // 전체 종료

                switch (menu) {
                    case 1:
                        System.out.println("result = " + num * num);
                        break;
                    case 2:
                        System.out.println("result = " + Math.sqrt(num));
                        break;
                    case 3:
                        System.out.println("result = " + Math.log(num));
                }
            }

        }
    }
}
