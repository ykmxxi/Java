package ch13;

public class MultiThreadTest {
    public static long startTime = 0L;

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        startTime = System.currentTimeMillis();
        myThread1.start();
        myThread2.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("A");
        }
        System.out.print("쓰레드1 소요시간: " + (System.currentTimeMillis() - MultiThreadTest.startTime) + " ");
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("B");
        }
        System.out.print("쓰레드2 소요시간: " + (System.currentTimeMillis() - MultiThreadTest.startTime) + " ");
    }
}