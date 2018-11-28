package com.tang.proxy.jdk;

import com.tang.proxy.interceptor.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author RLY
 * @Date 2018/11/27 15:50
 * @Version 1.0
 **/
public class JDKInterceptorProxy implements InvocationHandler {

    private Object target;

    private String interceptorCls;

    public Object bind(Object obj, String cls){
        this.target = obj;
        this.interceptorCls = cls;
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("");
        //判断是否存在拦截器
        if(interceptorCls == null || "".equals(interceptorCls.trim())){
            //不存在拦截器
            result = method.invoke(target, args);
        }else {
            Class cls = Class.forName(interceptorCls);
            Interceptor jdkInterceptor = (Interceptor) cls.newInstance();

            if(jdkInterceptor.before()){
                result = method.invoke(target, args);
            }else{
                result = jdkInterceptor.around();
            }
            jdkInterceptor.after();
        }

        return result;
    }
}
