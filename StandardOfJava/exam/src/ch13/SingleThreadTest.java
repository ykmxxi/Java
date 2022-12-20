package ch13;

public class SingleThreadTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.print("A");
        }

        for (int i = 0; i < 100; i++) {
            System.out.print("B");
        }
        System.out.println("소요시간: " + (System.currentTimeMillis() - startTime));

    }
}
