package com.tang.proxy.jdk;

/**
 * @Description
 * @Author RLY
 * @Date 2018/11/27 11:00
 * @Version 1.0
 **/
public class JdkTest {

    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy();
        UserService userService = (UserService) jdkProxy.bind(new UserServiceImpl());
        userService.show();
    }
}
