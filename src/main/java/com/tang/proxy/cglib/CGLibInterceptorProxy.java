package com.tang.proxy.cglib;

import com.tang.proxy.interceptor.Interceptor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description
 * @Author RLY
 * @Date 2018/11/27 17:12
 * @Version 1.0
 **/
public class CGLibInterceptorProxy implements MethodInterceptor{

    private Object target;

    private String interceptorCls;

    public CGLibInterceptorProxy(){}

    public CGLibInterceptorProxy(Object target, String interceptorCls){
        this.target = target;
        this.interceptorCls = interceptorCls;
    }

    public Object bind(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;

        Class cls = Class.forName(interceptorCls);
        Interceptor interceptor = (Interceptor) cls.newInstance();

        if(interceptor.before()){
            result = methodProxy.invokeSuper(o, objects);
        }else{
            result = interceptor.around();
        }
        interceptor.after();

        return result;
    }
}
