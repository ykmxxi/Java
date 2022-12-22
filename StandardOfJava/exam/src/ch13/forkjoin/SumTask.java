package ch13.forkjoin;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
    long from;
    long to;

    public SumTask(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long compute() {
        long size = to - from + 1;

        if (size <= 5) {
            return sum();
        }

        long half = (from + to) / 2;

        SumTask leftSum = new SumTask(from, half);
        SumTask rightSum = new SumTask(half + 1, to);

        leftSum.fork();

        return rightSum.compute() + leftSum.join();
    }

    Long sum() {
        long tmp = 0L;

        for (long i = from; i <= to; i++) {
            tmp += i;
        }

        return tmp;
    }
}
