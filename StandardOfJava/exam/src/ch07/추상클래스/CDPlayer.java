package ch07.추상클래스;

public class CDPlayer extends Player {
    int currentTrack;

    @Override
    void play(int pos) {
        // 구현
    }

    @Override
    void stop() {
        // 구현
    }

    void nextTrack() {
        currentTrack++;
    }

    void preTrack() {
        currentTrack--;
    }
}
