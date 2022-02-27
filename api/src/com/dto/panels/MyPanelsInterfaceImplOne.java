package com.dto.panels;

/**
 * @author zhangy
 * @date 2021-09-10 17:13
 * @apiNote: 定义接口实现类时确定泛型的类型
 */
public class MyPanelsInterfaceImplOne implements MyPanelsInterface<String>{

    private String s;

    @Override
    public void add(String s) {
        this.s = s;
    }

    @Override
    public String get() {
        return s;
    }
}
