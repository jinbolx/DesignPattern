import java.util.ArrayList;
import java.util.List;
import multiThread.Balance;
import multiThread.OperationThread1;
import observerPattern.Observable;
import observerPattern.ObservableImpl;
import observerPattern.ObservableImpl2;
import observerPattern.Observer;
import observerPattern.ObserverImpl1;
import observerPattern.ObserverImpl2;
import observerPattern.ObserverImpl3;
import proxyPattern.ProxyInterface;
import proxyPattern.cglib.ProxyCg;
import proxyPattern.cglib.TargetCg;
import proxyPattern.dynamic.ProxyDynamic;
import proxyPattern.dynamic.TargetDynamic;
import proxyPattern.stat.ProxyForTarget;
import proxyPattern.stat.Target;
import singletonPattern.SingletonClass;
import singletonPattern.SingletonEnumClass;
import singletonPattern.SingletonLazy;
import singletonPattern.SingletonLazyThreadSafety;
import singletonPattern.SingletonParent;
import strategyPattern.Context;
import strategyPattern.StrategyImpl2;

public class Main {

    public static void main(String[] args) {
//        observerPatternTest();
//        singletonPatternTest();
//        multiThread();
//        strategyPatternTest();
//        Animal animal=new Dog();
//        System.out.println("----------------");
//        animal.display();
//        System.out.println((animal.age));
        staticProxy();
        dynamicProxy();
        cgProxy();
    }

    /**
     * 定义被观察者的基类observable,观察者的基类observer.被观察者有2个实现类observableImpl1, observableImpl2;observableImpl1的观察者为observableImpl2;observerImpl2的观察者为
     * observerImpl1,observerImpl2,observerImpl3;observableImpl1变化时通知其观察者observableImpl2,
     * observerImpl2收到更新通知之后再通知他的观察者进行变化
     */
    private static void observerPatternTest() {
        Observable observable = new ObservableImpl();
        ObservableImpl2 observable1 = new ObservableImpl2();
        observable.addObserver(observable1);
        Observer observer0 = new ObserverImpl1();
        Observer observer1 = new ObserverImpl2();
        Observer observer2 = new ObserverImpl3();
        observable1.addObserver(observer0);
        observable1.addObserver(observer1);
        observable1.addObserver(observer2);
        observable.notifyObserver();
    }

    private static void singletonPatternTest() {
        SingletonParent singletonParent0 = SingletonClass.getInstance();
        singletonParent0.printMessage();
        SingletonParent singletonParent1 = SingletonLazy.getInstance();
        singletonParent1.printMessage();
        SingletonParent singletonParent2 = SingletonLazyThreadSafety.getInstance();
        singletonParent2.printMessage();
        SingletonEnumClass enumClass = SingletonEnumClass.getInstance();
        enumClass.doSomething();
    }

    private static void multiThread() {
        Balance balance = new Balance();
        List<Thread> threads = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 4; i++) {
            OperationThread1 operationThread1 = new OperationThread1(balance);
            threads.add(operationThread1);
            operationThread1.start();
        }
        while (true) {
            if (isAllThreadFinish(threads)) {
                long endTime = System.currentTimeMillis();
                printDuringTime(endTime - startTime);
                System.out.println("balance: " + balance.getBalance() + " syncBalance: " + balance.getSyncBalance()
                        + " volatileBalance: " + balance.getVolaBalance());
                break;
            }
        }

//        OperationThread2 operationThread2=new OperationThread2(balance);
//        Thread thread=new Thread(operationThread2);
//        thread.start();
    }

    public static boolean isAllThreadFinish(List<Thread> list) {
        int finishCount = 0;
        for (Thread thread : list) {
            if (!thread.isAlive()) {
                finishCount++;
            }
        }
        return finishCount == list.size();
    }

    private static void printDuringTime(long during) {
        System.out.println("操作耗时: " + during);
    }

    public static void strategyPatternTest() {
        Context context = new Context();
        context.execute();
        context.setStrategyInterface(new StrategyImpl2());
        context.execute();
    }

    public static void staticProxy() {
        ProxyInterface proxyInterface = new Target();
        ProxyForTarget proxyForTarget = new ProxyForTarget(proxyInterface);
        proxyForTarget.doSome("111");
        proxyForTarget.doElse();
    }

    public static void dynamicProxy() {
        ProxyInterface targetDynamic = new TargetDynamic();
        ProxyInterface proxyInterface = (ProxyInterface) new ProxyDynamic(targetDynamic).getProxyInstance();
        System.out.println("dynamicProxy=====: "+proxyInterface.doSome("222"));
        proxyInterface.doElse();
    }
    public static void cgProxy(){
        TargetCg targetCg= ((TargetCg) new ProxyCg(new TargetCg()).getInstance());
        System.out.println("cgProxy------"+targetCg.doSome());
    }
}
