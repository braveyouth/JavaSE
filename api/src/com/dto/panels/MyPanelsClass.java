package com.dto.panels;

/**
 * @author zhangy
 * @date 2021-09-10 15:55
 * @apiNote: 含有泛型的类
 * 定义格式: 修饰符 class 类名<代表泛型的变量> { }
 */
public class MyPanelsClass<MP> {

    /**
     * 没有MP类型，在这里代表一种未知数据类型，
     * 未来传递什么就是什么类型
     */
    private MP mp;

    public MP getMp() {
        return mp;
    }

    public void setMp(MP mp) {
        this.mp = mp;
    }
}
