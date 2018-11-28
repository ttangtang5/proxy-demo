package com.tang.proxy.interceptor;

/**
 * @Description 自定义拦截器
 * @Author RLY
 * @Date 2018/11/27 15:39
 * @Version 1.0
 **/
public interface Interceptor {

    /**
     * true则调用真实对象 false则around
     * @return
     */
    boolean before();

    Object around();

    void after();

    void afterThrows();
}
