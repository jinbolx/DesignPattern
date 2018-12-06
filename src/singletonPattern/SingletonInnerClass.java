package singletonPattern;

/**
 * 静态内部类，类似于饿汉式线程安全，同时SingletonInnerclass被装载时不会装载singletonHoler,显式调用getInstance时才会装载
 * 从而实现了懒加载
 */
public class SingletonInnerClass {

    private SingletonInnerClass() {
    }

    public static class SingletonHolder {
        static final SingletonInnerClass instance = new SingletonInnerClass();
    }


    public static SingletonInnerClass getInstance() {
        return SingletonHolder.instance;
    }
}
