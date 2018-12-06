package singletonPattern;

/**
 * 实现了懒加载，但是线程不安全
 */
public class SingletonLazy extends SingletonParent {

    private static SingletonLazy instance;

    private SingletonLazy() {
        setMessage("懒汉式，线程不安全");
    }

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

}
