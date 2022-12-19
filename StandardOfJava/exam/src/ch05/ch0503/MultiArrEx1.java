package ch05.ch0503;

/*
    * 좌표에 X표 하기 (p.221)
        입력한 2차원 좌표의 위치에 X를 표시
 */

import java.util.*;

public class MultiArrEx1 {

    public static void main(String[] args) {
        final int SIZE = 10;
        int x = 0, y = 0;

        Scanner sc = new Scanner(System.in);

        char[][] board = new char[SIZE][SIZE];
        byte[][] shipBoard = {

                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 1, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 0}
        };

        for (int i = 1; i < SIZE; i++) {
            board[0][i] = board[i][0] = (char) (i + '0');
        }

        while (true) {
            System.out.printf("좌표를 입력하세요. (종료는 00) >>> ");
            String input = sc.nextLine();

            if (input.length() == 2) {
                x = input.charAt(0) - '0';
                y = input.charAt(1) - '0';

                if (x == 0 && y == 0)
                    break;
            }

            if (input.length() != 2 || x <= 0 || x >= SIZE || y <= 0 || y >= SIZE) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                continue;
            }

            board[x][y] = shipBoard[x - 1][y - 1] == 1 ? 'O' : 'X';

            for (int i = 0; i < SIZE; i++) {
                System.out.println(board[i]); // 참조변수 board[i] 는 board[i][0] ~ board[i][board[i].length-1] 을 가리킴
            }
            System.out.println();

        }

    }
}
