package ch13;

public class ThreadGroupTest {
    public static void main(String[] args) {
        ThreadGroup main = Thread.currentThread().getThreadGroup();
        ThreadGroup group1 = new ThreadGroup("Group1");
        ThreadGroup group2 = new ThreadGroup("Group2");

        ThreadGroup subGroup1 = new ThreadGroup(group1, "SubGroup1");
        ThreadGroup subGroup2 = new ThreadGroup(group2, "SubGroup2");

        group1.setMaxPriority(3); // Group1의 최대 우선순위를 3으로 변경, Group1에 속한 쓰레드와 하위 그룹이 영향을 받음

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000); // 정보 출력 전 종료 방지 위해 쓰레드를 1초간 멈춤
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(group1, runnable, "thread1").start();
        new Thread(subGroup1, runnable, "thread2").start();
        new Thread(group2, runnable, "thread3").start();
        new Thread(subGroup2, runnable, "thread4").start();

        System.out.println("List of ThreadGroup: " + main.getName()
                + ", Active ThreadGroup: " + main.activeGroupCount()
                + ", Active Thread: " + main.activeCount());

        main.list(); // main그룹에 속한 쓰레드와 하위 쓰레드 그룹 정보 출력
    }
}
