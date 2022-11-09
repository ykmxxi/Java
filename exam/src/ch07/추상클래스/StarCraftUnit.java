package ch07.추상클래스;

import java.util.ArrayList;
import java.util.List;

abstract class Unit {
    int x;
    int y;

    /**
     * 지정된 위치로 이동하는 메서드
     * @param x
     * @param y
     */
    abstract void move(int x, int y);

    void stop() {
        System.out.println("현재 위치에 STOP!");
    }
}

class Marine extends Unit {
    @Override
    void move(int x, int y) {
        System.out.println("마린이 지정된 위치로 움직입니다." + "(" + x + ", " + y + ")");
    }

    void stimPack() {
        System.out.println("마린이 체력 10을 사용해 스팀팩을 사용합니다.");
    }
}

class Tank extends Unit {
    @Override
    void move(int x, int y) {
        System.out.println("탱크가 지정된 위치로 움직입니다." + "(" + x + ", " + y + ")");
    }

    void changeMode() {
        System.out.println("탱크가 공격 모드를 전환합니다.");
    }
}

class Dropship extends Unit {
    @Override
    void move(int x, int y) {
        System.out.println("드랍쉽이 지정된 위치로 움직입니다." + "(" + x + ", " + y + ")");
    }

    void load() {
        System.out.println("드랍쉽이 유닛을 태웁니다.");
    }

    void unload() {
        System.out.println("드랍쉽이 유닛을 내립니다.");
    }
}
public class StarCraftUnit {
    public static void main(String[] args) {
        List<Unit> group = new ArrayList<>();
        group.add(0, new Marine());
        group.add(1, new Tank());
        group.add(2, new Dropship());

        for (Unit unit : group) {
            unit.move(200, 300);
        }
    }
}
