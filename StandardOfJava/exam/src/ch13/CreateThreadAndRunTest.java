package ch13;

class ThreadByInheritance extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName()); // 조상 쓰레드의 getName() 호출
        }
    }
}

class ThreadByInterface implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            // currentThread(): 현재 실행중인 쓰레드를 반환
            System.out.println(Thread.currentThread().getName());
        }
    }
}

public class CreateThreadAndRunTest {
    public static void main(String[] args) {
        // Thread 클래스를 상속받아 구현한 쓰레드
        ThreadByInheritance myThread1 = new ThreadByInheritance();

        // Runnable 인터페이스를 구현한 쓰레드
        Runnable runnable = new ThreadByInterface();
        Thread myThread2 = new Thread(runnable);

        myThread1.start();
        myThread2.start();
    }
}
