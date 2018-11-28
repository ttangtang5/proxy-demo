package com.tang.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description jdk动态代理 jdk代理通过实现invocationHandler接口 真实对象必须实现接口
 * 1、绑定代理对象
 * 2、实现代理逻辑
 * @Author RLY
 * @Date 2018/11/27 10:46
 * @Version 1.0
 **/
public class JDKProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object obj){
        this.target = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(" invoke method before of target object ");
        Object result = method.invoke(target, args);
        System.out.println(" invoke method after of target object ");
        return result;
    }
}
