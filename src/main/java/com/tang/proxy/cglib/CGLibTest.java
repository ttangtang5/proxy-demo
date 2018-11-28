package com.tang.proxy.cglib;

/**
 * @Description
 * @Author RLY
 * @Date 2018/11/27 15:26
 * @Version 1.0
 **/
public class CGLibTest {

    public static void main(String[] args) {
        CGLibProxy cgLibProxy = new CGLibProxy();
        UserServiceImpl userService = (UserServiceImpl) cgLibProxy.bind(UserServiceImpl.class);
        userService.show();
    }
}
