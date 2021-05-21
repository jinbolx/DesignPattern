package proxyPattern.stat;

import proxyPattern.ProxyInterface;

public class Target implements ProxyInterface {

    @Override
    public boolean doSome(String param) {
        System.out.println("target==== doSome:"+param);
        return true;
    }

    @Override
    public void doElse() {
        System.out.println("target==== doElse");
    }
}
