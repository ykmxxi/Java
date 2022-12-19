package ch05.ch0501;

/*
    p.197 최대값과 최소값
    - 배열의 요소 중에서 제일 큰 값과 제일 작은 값을 찾기

 */

public class ArrayEx6 {

    public static void main(String[] args) {

        int[] score = {89, 19, 394, 183, 94, 88, 13, 15};

        int max = score[0];
        int min = score[0];

        for (int i = 0; i < score.length; i++) {
            if (score[i] > max) {
                max = score[i];
            } else if (score[i] < min) {
                min = score[i];
            }
        }

        System.out.printf("최대값 : %d\n", max);
        System.out.printf("최소값 : %d\n", min);

    }
}
