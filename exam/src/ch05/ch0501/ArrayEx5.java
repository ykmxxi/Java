package ch05.ch0501;

/*
    배열을 이용한 총합과 평균
*/
public class ArrayEx5 {

    public static void main(String[] args) {

        int sum = 0;
        double avg = 0.0;

        int[] score = {100, 31, 93, 87, 53};

        for (int i = 0; i < score.length; i++) {
            sum += score[i];
        }

        avg = sum / (double) score.length;

        System.out.printf("총점 = %d\n", sum);
        System.out.printf("평균 = %f\n", avg);

    }
}
