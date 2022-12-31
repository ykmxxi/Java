package ch02;

import ch01.Apple;

public class AppleCountryFormatter implements AppleFormatter{
    @Override
    public String accept(Apple apple) {
        return "This apple is made in " + apple.getCountry();
    }
}
