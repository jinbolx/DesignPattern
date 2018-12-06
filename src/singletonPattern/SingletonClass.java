package singletonPattern;

/**
 * 饿汉式
 */
public class SingletonClass extends SingletonParent {

    private static SingletonClass ourInstance = new SingletonClass();

    public static SingletonClass getInstance() {
        return ourInstance;
    }

    private SingletonClass() {
        setMessage("饿汉式,线程安全，类加载时就初始化没有实现懒加载，没有加锁执行效率高");
    }

}
