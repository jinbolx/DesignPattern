package proxyPattern.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {

    private final Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }


    public static <T> T get(T proxyInterface) {
        return new ProxyFactory(proxyInterface).getProxyInstance();
    }

    public static <T> T get(T proxyInterface, InvocationInterface invocationInterface) {
        if (invocationInterface == null) {
            invocationInterface = new InvocationInterface() {
                @Override
                public void beforeInvoke(Object proxy, Method method, Object[] args) {
                    System.out.println(proxyInterface.getClass().getSimpleName() + " startInvoke: " + method.getName());
                }

                @Override
                public void afterInvoke(Object proxy, Method method, Object[] args, Object returnValue) {
                    System.out.println(
                            proxyInterface.getClass().getSimpleName() + " endInvoke: " + method.getName() + " params: "
                                    + Arrays
                                    .toString(args));
                }
            };
        }
        return new ProxyFactory(proxyInterface).getProxyInstance(invocationInterface);
    }

    public static <T> T getByHandler(T proxyInterface, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            invocationHandler = new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println(proxyInterface.getClass().getSimpleName() + " startInvoke: " + method.getName());
                    Object returnValue = method.invoke(proxyInterface, args);
                    System.out.println(
                            proxyInterface.getClass().getSimpleName() + " endInvoke: " + method.getName() + " params: "
                                    + Arrays
                                    .toString(args));
                    return returnValue;
                }
            };
        }
        return new ProxyFactory(proxyInterface).getProxyInstance(invocationHandler);
    }

    @SuppressWarnings("unchecked")
    private  <T> T getProxyInstance() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println(target.getClass().getSimpleName() + " startInvoke: " + method.getName());
                    Object returnValue = method.invoke(target, args);
                    System.out.println(
                            target.getClass().getSimpleName() + " endInvoke: " + method.getName() + " params: " + Arrays
                                    .toString(args));
                    return returnValue;
                });
    }

    @SuppressWarnings("unchecked")
    private  <T> T getProxyInstance(InvocationHandler invocationHandler) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                invocationHandler);
    }

    @SuppressWarnings("unchecked")
    private  <T> T getProxyInstance(InvocationInterface invocationInterface) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    if (invocationInterface != null) {
                        invocationInterface.beforeInvoke(proxy, method, args);
                    }
                    Object returnValue = method.invoke(target, args);
                    if (invocationInterface != null) {
                        invocationInterface.afterInvoke(proxy, method, args, returnValue);
                    }
                    return returnValue;
                });
    }
}
