package ch13.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinTest {
    static final ForkJoinPool pool = new ForkJoinPool();

    public static void main(String[] args) {
        long from = 1L; // start inclusive
        long to = 100_000_000L; // end inclusive

        SumTask task = new SumTask(from, to);

        long start = System.currentTimeMillis();
        Long result = pool.invoke(task);

        System.out.println("fork & join프레임웍을 이용한 덧셈 시간: " + (System.currentTimeMillis() - start));
        System.out.println("Result: " + result);
        System.out.println();

        result = 0L; // 초기화
        start = System.currentTimeMillis();
        for (long i = from; i <= to; i++) {
            result += i;
        }

        System.out.println("for문을 이용한 덧셈 시간: " + (System.currentTimeMillis() - start));
        System.out.println("Result: " + result);
        System.out.println();
    }
}
