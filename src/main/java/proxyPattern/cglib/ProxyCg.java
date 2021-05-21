package proxyPattern.cglib;

import java.lang.reflect.Method;
import java.util.Arrays;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ProxyCg implements MethodInterceptor {
    private Object target;

    public ProxyCg(Object target) {
        this.target = target;
    }
    public Object getInstance(){
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(target.getClass().getSimpleName()+" startInvoke: "+method.getName());
        Object returnValue = method.invoke(target, objects);
        System.out.println(target.getClass().getSimpleName()+" endInvoke: "+method.getName()+" params: "+ Arrays
                .toString(objects));
        return returnValue;
    }
}
