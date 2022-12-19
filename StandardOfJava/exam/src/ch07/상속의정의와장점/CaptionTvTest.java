package ch07.상속의정의와장점;

class Tv {

    boolean power = false;
    int channel;

    void power() {
        power = !power;
    }

    void channelUp() {
        ++channel;
    }

    void channelDown() {
        --channel;
    }

}

class CaptionTv extends Tv {

    boolean caption;    // Caption State

    void displayCaption(String text) {

        if (caption) {
            System.out.println(text);
        }
    }
}

class CaptionTvTest {

    public static void main(String[] args) {

        CaptionTv captionTv = new CaptionTv();
        captionTv.channel = 10;
        captionTv.channelUp();

        System.out.println(captionTv.channel);

        captionTv.displayCaption("Definition of Inheritance");
        captionTv.caption = true;
        captionTv.displayCaption("Definition of Inheritance");

    }
}
