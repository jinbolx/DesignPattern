package strategyPattern;

public class StrategyImpl1 implements StrategyInterface {

    @Override
    public void doProcess() {
        System.out.println("Strategy: impl1");
    }
}
