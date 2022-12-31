package ch02.동작파라미터화;

import ch01.Apple;

public class AppleSimpleFormatter implements AppleFormatter {
    /**
     * @param apple
     * @return 무게 정보만 포함한 간단한 문자열
     */
    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
