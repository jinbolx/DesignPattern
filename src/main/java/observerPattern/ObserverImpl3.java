package observerPattern;

public class ObserverImpl3 implements Observer{

    @Override
    public void update() {
        System.out.println("observerImpl3 : 观察到了变化");
    }
}
