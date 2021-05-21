package multiThread;

public class OperationThread2 implements Runnable {
    private Balance balance;

    public OperationThread2(Balance balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            balance.saveMoney(50);
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
