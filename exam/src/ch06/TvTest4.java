package ch06;

class TvTest4 {

    public static void main(String[] args) {

        Tv[] tvArray = new Tv[3];

        for (int i = 0; i < tvArray.length; i++) {
            tvArray[i] = new Tv();
            tvArray[i].channel = (int)(Math.random() * 99) + 1;
        }

        for (int i = 0; i < tvArray.length; i++) {
            System.out.printf("tvArray[%d]의 채널은 %d 입니다.%n", i, tvArray[i].channel);
            tvArray[i].channelUp();
            System.out.printf("모든 tv의 채널이 +1 되었습니다. tvArray[%d]의 채널은 %d 입니다.%n", i, tvArray[i].channel);
        }
    }
}
