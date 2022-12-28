package ch10.형식화;

import java.text.ChoiceFormat;

public class ChoiceFormatTest {
    public static void main(String[] args) {
        // limits, grades간 순서와 개수가 일치해야 함.
        double[] limits = {60, 70, 80, 90};
        String[] grades = {"D", "C", "B", "A"};

        int[] scores = {100, 90, 93, 80, 46, 70, 61, 74, 82};

        ChoiceFormat form = new ChoiceFormat(limits, grades);

        for (int score : scores) {
            System.out.println(score + ": " + form.format(score));
        }

        System.out.println();

        String pattern = "60#D|70<C|80#B|90#A";
        form = new ChoiceFormat(pattern);

        for (int score : scores) {
            System.out.println(score + ": " + form.format(score));
        }

    }
}
