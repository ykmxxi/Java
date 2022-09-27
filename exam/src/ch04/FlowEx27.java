package ch04;

// p.172 숫자를 반복해 입력 받다가 0이 입력되면 입력을 마치고 총 합을 출력

import java.util.Scanner;

public class FlowEx27 {

    public static void main(String[] args) {

        int num;
        int sum = 0;
        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        while (flag) {
            System.out.println("숫자를 입력하시오. >>> ");
            String tmp = sc.nextLine();
            num = Integer.parseInt(tmp);

            if (num != 0) {
                sum += num;
            } else {
                flag = false;
            }

        }

        System.out.println("입력한 수의 총합 : " + sum);
    }
}
