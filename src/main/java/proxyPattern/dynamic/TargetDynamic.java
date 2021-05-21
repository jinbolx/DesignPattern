package proxyPattern.dynamic;

import proxyPattern.ProxyInterface;

public class TargetDynamic implements ProxyInterface {

    @Override
    public boolean doSome(String param) {
        System.out.println("TargetDynamic:====doSome:"+param);
        return false;
    }

    @Override
    public void doElse() {
        System.out.println("TargetDynamic:====doElse");
    }

}
