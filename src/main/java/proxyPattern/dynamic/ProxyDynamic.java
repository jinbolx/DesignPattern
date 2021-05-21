package proxyPattern.dynamic;

import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyDynamic {

    private final Object target;

    public ProxyDynamic(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println(target.getClass().getSimpleName()+" startInvoke: "+method.getName());
                    Object returnValue = method.invoke(target, args);
                    System.out.println(target.getClass().getSimpleName()+" endInvoke: "+method.getName()+" params: "+ Arrays
                            .toString(args));
                    return returnValue;
                });
    }
}
