package ch04;

public class FlowEx18 {

    public static void main(String[] args) {

//        for (int i = 2; i < 10; i++) {
//            for (int j = 1; j < 10; j++) {
//                System.out.printf("%d x %d = %d\n", i, j, i * j);
//            }
//        }

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.printf("[%d, %d]", i, j);
            }
            System.out.println();
        }

    }
}
