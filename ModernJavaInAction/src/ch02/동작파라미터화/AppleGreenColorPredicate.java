package ch02.동작파라미터화;

import static ch02.동작파라미터화.Color.*;

import ch01.Apple;

public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test(Apple apple) {
        return GREEN.getColor().equals(apple.getColor());
    }
}
