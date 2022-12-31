package ch02;

import static ch02.Color.GREEN;

import ch01.Apple;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
