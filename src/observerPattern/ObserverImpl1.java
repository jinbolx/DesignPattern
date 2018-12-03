package observerPattern;

public class ObserverImpl1 implements Observer {

    @Override
    public void update() {
        System.out.println("observerImpl1 : 观察到了变化");
    }
}
