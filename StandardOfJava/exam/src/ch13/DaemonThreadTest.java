package ch13;

public class DaemonThreadTest implements Runnable {
    public static boolean autoSave = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonThreadTest());
        thread.setDaemon(true);
        thread.start();

        for (int i = 1; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);

            if (i == 5) {
                autoSave = true;
            }
        }
        System.out.println("프로그램 종료.");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (autoSave) {
                autoSave();
            }
        }
    }

    public void autoSave() {
        System.out.println("자동저장");
    }
}
