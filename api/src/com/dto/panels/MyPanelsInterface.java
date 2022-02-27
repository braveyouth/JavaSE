package com.dto.panels;

/**
 * @author zhangy
 * @Time 2021-09-10 17:08
 * @Description: 含有泛型的接口
 * 定义格式: 修饰符 interface 接口名<代表泛型的变量> { }
 */
public interface MyPanelsInterface<T> {
    public abstract void add(T t);
    public abstract T get();
}
