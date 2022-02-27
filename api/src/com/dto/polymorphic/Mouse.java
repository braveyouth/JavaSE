package com.dto.polymorphic;

/**
 * @author zhangy
 * @Time 2021-07-18 14:04
 * @Description: 定义鼠标类
 */
public class Mouse implements Usb{
    @Override
    public void open() {
        System.out.println("鼠标开启，红灯闪一闪");
    }

    @Override
    public void close() {
        System.out.println("鼠标关闭，红灯熄灭");
    }

    public void click(){
        System.out.println("鼠标单击");
    }
}
