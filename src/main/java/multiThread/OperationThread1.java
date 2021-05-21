package multiThread;

public class OperationThread1 extends Thread {

    private Balance balance;

    public OperationThread1(Balance balance) {
        this.balance = balance;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 30; i++) {
            //未使用同步锁,开启多个线程时结果往往不是所预想的
           // balance.saveMoney(1);
            //同步锁锁定的方法中如果有耗时操作会非常消耗性能
            balance.saveMoneyThreadSafety(1);
            //balance.saveVolatileMoney(1);
        }

    }
}
