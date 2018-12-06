package strategyPattern;

public class Context {
    private StrategyInterface strategyInterface;
    public Context() {
        strategyInterface=new StrategyImpl1();
    }

    public StrategyInterface getStrategyInterface() {
        return strategyInterface;
    }

    public void setStrategyInterface(StrategyInterface strategyInterface) {
        this.strategyInterface = strategyInterface;
    }
    public void execute(){
        strategyInterface.doProcess();
    }
}
