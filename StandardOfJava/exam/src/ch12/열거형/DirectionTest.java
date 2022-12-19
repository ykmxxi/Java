package ch12.열거형;

public class DirectionTest {
    public static void main(String[] args) {
        for (Direction direction : Direction.values()) {
            System.out.printf("%s = %d%n", direction.name(), direction.getValue());
        }

        Direction direction1 = Direction.EAST;
        Direction direction2 = Direction.of(1);

        System.out.printf("direction1 = %s, %d%n", direction1.name(), direction1.getValue());
        System.out.printf("direction2 = %s, %d%n", direction2.name(), direction2.getValue());

        System.out.println(Direction.EAST.rotate(1));
        System.out.println(Direction.EAST.rotate(2));
        System.out.println(Direction.EAST.rotate(-1));
        System.out.println(Direction.EAST.rotate(-2));
    }
}
