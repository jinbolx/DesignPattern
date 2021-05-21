package singletonPattern;

/**
 * 懒汉式，线程安全
 */
public class SingletonLazyThreadSafety extends SingletonParent {

    private static SingletonLazyThreadSafety instance;

    private SingletonLazyThreadSafety() {
        setMessage("懒汉式，线程安全");
    }

    public static synchronized SingletonLazyThreadSafety getInstance() {
        if (instance == null) {
            instance = new SingletonLazyThreadSafety();
        }
        return instance;
    }
}
