package ch13;

public class ThreadYieldTest {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("*");
        MyThread thread2 = new MyThread("**");
        MyThread thread3 = new MyThread("***");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(2000);
            thread1.suspend();
            Thread.sleep(2000);
            thread2.suspend();
            Thread.sleep(3000);
            thread1.resume();
            Thread.sleep(3000);
            thread1.stop();
            thread2.stop();
            Thread.sleep(2000);
            thread3.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread implements Runnable {
    boolean suspended = false;
    boolean stopped = false;

    Thread thread;

    public MyThread(String name) {
        thread = new Thread(this, name);
    }

    @Override
    public void run() {
        String name = thread.getName();

        while (!stopped) {
            if (!suspended) {
                System.out.println(name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(name + " - interrupted.");
                }
            } else {
                Thread.yield(); // 남은 실행시간을 다음 쓰레드에게 양보
            }
        }
        System.out.println(name + " - stopped.");
    }

    public void suspend() {
        suspended = true;
        thread.interrupt();
        System.out.println(thread.getName() + " - interrupt() by suspend()");
    }

    public void stop() {
        stopped = true;
        thread.interrupt();
        System.out.println(thread.getName() + " - interrupt() by stop()");
    }

    public void resume() {
        suspended = false;
    }

    public void start() {
        thread.start();
    }
}
