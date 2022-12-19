package ch05.ch0503;

/*
    * 빙고
        빙고판(5 X 5)을 만들고 입력된 숫자가 빙고판에 존재하면 0으로 바꾼다

        * 추가 기능
          - 1줄 빙고 발생시 종료 (가로, 세로, 대각선)
 */

import java.util.*;

public class MultiArrEx2 {
    static final int SIZE = 5;

    static int[][] rotate(int[][] arr) {
        int n, m;
        n = m = SIZE;
        int[][] rotate = new int[m][n];

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = arr[n - 1 - j][i];
            }
        }
        return rotate;
    }

    public static void main(String[] args) {

        int x = 0, y = 0, num = 0;

        String[] checkRow = new String[SIZE];
        String[] checkColumn = new String[SIZE];
        boolean flag = true;

        int[][] bingo = new int[SIZE][SIZE];
        int[][] rotatedBingo = new int[SIZE][SIZE];

        Scanner sc = new Scanner(System.in);

        // 1 ~ 25 생성
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                bingo[i][j] = i * SIZE + j + 1;
            }
        }


        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                x = (int) (Math.random() * SIZE);
                y = (int) (Math.random() * SIZE);

                int tmp = bingo[i][j];
                bingo[i][j] = bingo[x][y];
                bingo[x][y] = tmp;
            }
        }

        do {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.printf("%2d ", bingo[i][j]);
                }
                System.out.println();
            }
            System.out.print("1 ~ 25 사이의 숫자를 입력하시오. (종료 : 0) >>> ");
            String tmp = sc.nextLine();
            num = Integer.parseInt(tmp);

            // 2중 반복문 outer
            outer:
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (num == bingo[i][j]) {
                        bingo[i][j] = 0;
                        rotatedBingo = rotate(bingo);
                        break outer;
                    }
                }
            }

            int rCount = 0;
            int lCount = 0;

            // 빙고 check
            for (int i = 0; i < SIZE; i++) {
                checkRow[i] = Arrays.toString(bingo[i]).replaceAll("[^0-9]", "");
                checkColumn[i] = Arrays.toString(rotatedBingo[i]).replaceAll("[^0-9]", "");

                if (checkRow[i].equals("00000")) {
                    flag = false;
                    System.out.printf("%d행 에서 빙고!!!%n", i + 1);
                    break;
                }

                if (checkColumn[i].equals("00000")) {
                    flag = false;
                    System.out.printf("%d열 에서 빙고!!!%n", i + 1);
                    break;
                }

                if (bingo[i][i] == 0) {
                    rCount++;
                }

                if (bingo[i][SIZE - i - 1] == 0) {
                    lCount++;
                }

                if (rCount == 5 || lCount == 5) {
                    flag = false;
                    System.out.println("대각선 빙고!!!");
                }

            }

        } while (num != 0 && flag);
        System.out.println("프로그램을 종료합니다.");

    }
}
