package observerPattern;

public class ObserverImpl2 implements Observer {

    @Override
    public void update() {
        System.out.println("observerImpl2 : 观察到了变化");
    }
}
