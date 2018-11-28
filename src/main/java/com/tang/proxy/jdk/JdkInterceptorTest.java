package com.tang.proxy.jdk;

/**
 * @Description
 * @Author RLY
 * @Date 2018/11/27 16:12
 * @Version 1.0
 **/
public class JdkInterceptorTest {

    public static void main(String[] args) {
        JDKInterceptorProxy jdkInterceptorProxy = new JDKInterceptorProxy();
        String cls = "com.tang.proxy.interceptor.InterceptorImpl";
        UserService userService = (UserService) jdkInterceptorProxy.bind(new UserServiceImpl(), cls);
        userService.show();
    }
}
