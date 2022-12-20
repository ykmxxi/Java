package ch13;

public class ThreadPriorityTest {
    public static void main(String[] args) {
        ImportantThread importantThread = new ImportantThread();
        NotImportantThread notImportantThread = new NotImportantThread();

        importantThread.setPriority(7);

        System.out.println("importantThread's Priority: " + importantThread.getPriority());
        System.out.println("notImportantThread's Priority: " + notImportantThread.getPriority());

        importantThread.start();
        notImportantThread.start();

    }
}

class ImportantThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.print("I");
        }
    }
}

class NotImportantThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.print("N");
        }
    }
}
