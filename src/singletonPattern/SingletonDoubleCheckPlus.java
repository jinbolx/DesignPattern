package singletonPattern;

public class SingletonDoubleCheckPlus {

    private static volatile SingletonDoubleCheckPlus instance;

    private SingletonDoubleCheckPlus() {
    }

    public static SingletonDoubleCheckPlus getInstance() {
        SingletonDoubleCheckPlus tempInstance = instance;
        if (tempInstance == null) {
            synchronized (SingletonDoubleCheckPlus.class) {
                tempInstance = instance;
                if (tempInstance == null) {
                    instance = tempInstance = new SingletonDoubleCheckPlus();
                }
            }
        }
        return tempInstance;
    }
}
