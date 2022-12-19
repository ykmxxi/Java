package ch06;

class Tv {

    String color;
    boolean power;
    int channel;

    void power() {
        power = !power;
    }

    void channelUp() {
        ++channel;
    }

    void chanelDown() {
        --channel;
    }

}
