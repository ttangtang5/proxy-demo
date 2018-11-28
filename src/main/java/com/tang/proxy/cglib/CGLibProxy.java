package com.tang.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description cglib 为第三方支持动态代理。cglib 通过实现MethodInterceptor
 * 1、绑定关系 通过Enhancer增强类  绑定关系
 * 2、实现重写interceptor方法
 * @Author RLY
 * @Date 2018/11/27 15:02
 * @Version 1.0
 **/
public class CGLibProxy implements MethodInterceptor {

    public Object bind(Class objCls){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(objCls);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(" invoke target method before");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println(" invoke target method after");
        return result;
    }
}
