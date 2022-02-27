package com.base;

import com.dto.polymorphic.KeyBoard;
import com.dto.polymorphic.Laptop;
import com.dto.polymorphic.Mouse;
import com.dto.polymorphic.Usb;

/**
 * @author zhangy
 * @Time 2021-07-18 13:58
 * @Description: 综合案例:进行描述笔记本类，实现笔记本使用USB鼠标、USB键盘
 * USB接口，包含开启功能、关闭功能
 * 笔记本类，包含运行功能、关机功能、使用USB设备功能
 * 鼠标类，要实现USB接口，并具备点击的方法
 * 键盘类，要实现USB接口，具备敲击的方法
 */
public class Polymorphic {
    public static void main(String[] args) {
        // 创建笔记本实体对象
        Laptop lt = new Laptop();
        // 笔记本开启
        lt.run();
        // 创建鼠标实体对象
        Usb u = new Mouse();
        // 笔记本使用鼠标
        lt.useUSB(u);
        // 创建键盘实体对象
//        KeyBoard kb = new KeyBoard();
        Usb usb = new KeyBoard();
        // 笔记本使用键盘
        lt.useUSB(usb);
        // 笔记本关闭
        lt.shutDown();
    }
}
