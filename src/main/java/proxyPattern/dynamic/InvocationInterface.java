package proxyPattern.dynamic;

import java.lang.reflect.Method;

public interface InvocationInterface {
    void beforeInvoke(Object proxy, Method method, Object[] args);
    void afterInvoke(Object proxy, Method method, Object[] args,Object returnValue);
}
