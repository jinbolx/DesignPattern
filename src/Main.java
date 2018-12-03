import observerPattern.Observable;
import observerPattern.ObservableImpl;
import observerPattern.ObservableImpl2;
import observerPattern.Observer;
import observerPattern.ObserverImpl1;
import observerPattern.ObserverImpl2;
import observerPattern.ObserverImpl3;

public class Main {

    public static void main(String[] args) {
        observerPatternTest();
    }

    /**
     * 定义被观察者的基类observable,观察者的基类observer.被观察者有2个实现类observableImpl1,
     * observableImpl2;observableImpl1的观察者为observableImpl2;observerImpl2的观察者为
     * observerImpl1,observerImpl2,observerImpl3;observableImpl1变化时通知其观察者observableImpl2,
     * observerImpl2收到更新通知之后再通知他的观察者进行变化
     *
     */
    private static void observerPatternTest() {
        Observable observable = new ObservableImpl();
        ObservableImpl2 observable1=new ObservableImpl2();
        observable.addObserver(observable1);
        Observer observer0 = new ObserverImpl1();
        Observer observer1 = new ObserverImpl2();
        Observer observer2 = new ObserverImpl3();
        observable1.addObserver(observer0);
        observable1.addObserver(observer1);
        observable1.addObserver(observer2);
        observable.notifyObserver();
    }
}
