package com.tang.proxy.cglib;


/**
 * @Description
 * @Author RLY
 * @Date 2018/11/28 8:49
 * @Version 1.0
 **/
public class CGLibInterceptorProxyTest {

    public static void main(String[] args) {
        CGLibInterceptorProxy cgLibInterceptorProxy = new CGLibInterceptorProxy(new UserServiceImpl(), "com.tang.proxy.interceptor.InterceptorImpl");
        UserServiceImpl userService = (UserServiceImpl) cgLibInterceptorProxy.bind();
        userService.show();
    }
}
