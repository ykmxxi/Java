package ch05.ch0503;

/*
    * 단어 맞추기
        영어 단어를 보여주고, 뜻을 맞추는 게임
        ex) chair 의 뜻은? 의자 입력 시 정답, 아닐 시 틀렸습니다.
 */

import java.util.Scanner;

public class MultiArrEx4 {

    public static void main(String[] args) {

        String[][] words = {
                {"chair", "의자"},
                {"computer", "컴퓨터"},
                {"integer", "정수"}
        };

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < words.length; i++) {
            System.out.printf("Q%d. %s의 뜻은? ", i + 1, words[i][0]);

            String input = scanner.nextLine();

            if (input.equals(words[i][1])) {
                System.out.println("졍댭입니다. \n");
            }

            if (!(input.equals(words[i][1]))) {
                System.out.println("틀렸습니다. \n");
            }
        }
    }
}
