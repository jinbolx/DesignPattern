package proxyPattern.stat;

import proxyPattern.ProxyInterface;

public class ProxyForTarget implements ProxyInterface {
    private final ProxyInterface target;

    public ProxyForTarget(ProxyInterface target) {
        this.target = target;
    }

    @Override
    public boolean doSome(String param) {
        System.out.println("ProxyForTarget====doSome:"+param);
        target.doSome(param);
        return true;
    }

    @Override
    public void doElse() {
        System.out.println("ProxyForTarget====doElse");
        target.doElse();
    }
}
