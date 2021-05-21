package multiThread;

public class Balance {

    private int balance = 1000;
    private int syncBalance = 1000;
    private volatile int volaBalance=1000;
    public void saveMoney(int amount) {
        balance += amount;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getBalance() {
        return balance;
    }

    public int getSyncBalance() {
        return syncBalance;
    }

    public synchronized void saveMoneyThreadSafety(int amount) {
        syncBalance += amount;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void saveVolatileMoney(int amount){
        volaBalance+=amount;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getVolaBalance() {
        return volaBalance;
    }

    public void setVolaBalance(int volaBalance) {
        this.volaBalance = volaBalance;
    }

    public void takeMoney(int amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            printBalance("没钱了");
        }
        printBalance("取之后");
    }

    private void printBalance(String tag) {
        System.out.println("当前余额: " + tag + balance);
    }
}
