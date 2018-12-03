package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class ObservableImpl2 implements Observable ,Observer{
    private List<Observer> observerList=new ArrayList<>();
    public void addObserver(Observer observer){
        observerList.add(observer);
    }
    public void removeObserver(Observer observer){
        observerList.remove(observer);
    }
    public void notifyObserver(){
        for (Observer observer : observerList) {
            observer.update();
        }
    }

    @Override
    public void update() {
        System.out.println("ObservableImpl2: 观察到了变化");
       notifyObserver();
    }
}
