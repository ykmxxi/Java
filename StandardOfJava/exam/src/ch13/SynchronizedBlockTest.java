package ch13;

public class SynchronizedBlockTest {
    public static void main(String[] args) {
        Runnable runnable = new RunnableAccount();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}

class Account {
    private int balance = 1000;

    public Account() {
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int money) {
        synchronized (this) {
            if (balance >= money) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance -= money;
            }
        }

    }
}

class RunnableAccount implements Runnable {
    Account account = new Account();

    @Override
    public void run() {
        while (account.getBalance() > 0) {
            int money = (int) (Math.random() * 3 + 1) * 100;
            account.withdraw(money);
            System.out.println("balance: " + account.getBalance());
        }
    }
}