package ch13;

public class MyGarbageCollector {
    public static void main(String[] args) {
        GCThread gcThread = new GCThread();
        gcThread.setDaemon(true);
        gcThread.start();

        int requiredMemory = 0;
        for (int i = 0; i < 20; i++) {
            requiredMemory = (int) (Math.random() * 10) * 20;

            // 메모리가 사용할 수 있는 양보다 크거나 전체 메모리의 60%이상 사용 시 interrupt()
            if (gcThread.freeMemory() < requiredMemory || gcThread.freeMemory() < gcThread.totalMemory() * 0.4) {
                gcThread.interrupt();
                try {
                    gcThread.join(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            gcThread.usedMemory += requiredMemory;
            System.out.println("usedMemory: " + gcThread.usedMemory);
        }

    }
}

class GCThread extends Thread {
    final static int MAX_MONEY = 1000;

    int usedMemory = 0;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                System.out.println("Awaken by interrupt()");
            }

            garbageCollector();
            System.out.println("Garbage Collected. Free Memory : " + freeMemory());
        }
    }

    public void garbageCollector() {
        usedMemory -= 300;
        if (usedMemory < 0) {
            usedMemory = 0;
        }
    }

    public int totalMemory() {
        return MAX_MONEY;
    }

    public int freeMemory() {
        return MAX_MONEY - usedMemory;
    }
}
