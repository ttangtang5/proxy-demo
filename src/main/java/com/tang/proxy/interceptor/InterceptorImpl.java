package com.tang.proxy.interceptor;

/**
 * @Description 拦截器的实现
 * @Author RLY
 * @Date 2018/11/27 15:41
 * @Version 1.0
 **/
public class InterceptorImpl implements Interceptor {

    @Override
    public boolean before() {
        System.out.println("before method");
        return false;
    }

    @Override
    public Object around() {
        System.out.println("around method");
        return null;
    }

    @Override
    public void after() {
        System.out.println("after method");
    }

    @Override
    public void afterThrows() {
        System.out.println("afterThrows method");
    }
}
