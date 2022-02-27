package com.dto.polymorphic;

/**
 * @author zhangy
 * @Time 2021-07-18 14:05
 * @Description: 定义键盘类
 */
public class KeyBoard implements Usb{
    @Override
    public void open() {
        System.out.println("键盘开启，绿灯闪一闪");
    }

    @Override
    public void close() {
        System.out.println("键盘关闭，绿灯熄灭");
    }

    public void type(){
        System.out.println("键盘打字");
    }

}
