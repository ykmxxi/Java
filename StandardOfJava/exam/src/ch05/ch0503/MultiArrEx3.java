package ch05.ch0503;

/*
    * 행렬의 곱셈
        두 행렬(matrix)을 곱한 결과를 출력
 */

public class MultiArrEx3 {

    public static void main(String[] args) {

        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] matrix2 = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        final int ROW = matrix1.length;
        final int COL = matrix2[0].length;
        final int MATRIX2_ROW = matrix2.length;

        int[][] matrix3 = new int[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                for (int k = 0; k < MATRIX2_ROW; k++) {
                    matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                }

            }
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.printf("%3d ", matrix3[i][j]);
            }
            System.out.println();
        }

    }
}
