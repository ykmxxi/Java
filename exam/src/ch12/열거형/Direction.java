package ch12.열거형;

public enum Direction {
    EAST(1, ">"),
    SOUTH(2, "V"),
    WEST(3, "<"),
    NORTH(4, "^");

    private static final Direction[] DIR_ARR = Direction.values();

    private final int value;
    private final String symbol;

    Direction(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Direction of(int dir) {
        if (dir < 1 || dir > 4) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다: " + dir);
        }
        return DIR_ARR[dir - 1];
    }

    /**
     * 방향 회전 메서드, num의 값만큼 90도씩 시계방향 회전
     * @param num
     * @return
     */
    public Direction rotate(int num) {
        num %= 4;

        if (num < 0) {
            num += 4;
        }
        return DIR_ARR[(value - 1 + num) % 4];
    }

    @Override
    public String toString() {
        return name() + ", " +getSymbol();
    }
}