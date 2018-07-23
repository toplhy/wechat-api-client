package wechat.api.client.proxy;

import wechat.api.client.exception.WeChatException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FacadeProxy implements InvocationHandler {

    private Object target;

    public FacadeProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Object obj = method.invoke(target, args);
        return obj;
    }

    public static <T> T newMapperProxy(Class<T> mapperInterface, String className) {
        ClassLoader classLoader = mapperInterface.getClassLoader();
        Class<?>[] interfaces = new Class[]{mapperInterface};
        Object obj = null;
        try {
            obj = Class.forName(className).newInstance();
        } catch (Exception e) {
           throw new WeChatException(e);
        }
        FacadeProxy proxy = new FacadeProxy(obj);
        return (T) Proxy.newProxyInstance(classLoader, interfaces, proxy);
    }
}
