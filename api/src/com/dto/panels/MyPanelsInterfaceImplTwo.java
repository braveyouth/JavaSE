package com.dto.panels;

/**
 * @author zhangy
 * @date 2021-09-10 17:20
 * @apiNote: 定义接口实现类时不确定泛型的类型:创建对象时，确定泛型的类型
 */
public class MyPanelsInterfaceImplTwo<T> implements MyPanelsInterface<T>{

    private T t;

    @Override
    public void add(T t) {
        this.t = t;
    }

    @Override
    public T get() {
        return t;
    }
}
