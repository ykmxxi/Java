package ch07.추상클래스;

public abstract class Player {
    boolean pause;
    int currentPos;

    /**
     * 추상 클래스도 생성자가 있어야 한다
     */
    public Player() {
        pause = false;
        currentPos = 0;
    }

    /**
     * 지정된 위치(pos)에서 재생을 시작하는 기능이 수행하도록 작성되어야 함
     *
     * @param pos
     */
    abstract void play(int pos);

    /**
     * 재생을 즉시 멈추는 기능을 수행하도록 작성되어야 함
     */
    abstract void stop();

    void play() {
        play(currentPos);
    }

    void pause() {
        if (pause) {
            pause = false;
            play(currentPos);
        }
        if (!pause) {
            pause = true;
            stop();
        }
    }
}
