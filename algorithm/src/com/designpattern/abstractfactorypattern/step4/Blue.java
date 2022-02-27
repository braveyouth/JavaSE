package com.designpattern.abstractfactorypattern.step4;

import com.designpattern.abstractfactorypattern.step3.Color;

/**
 * @author created by zhangyong
 * @Time 2019/7/13 12:45
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Blue");
    }
}
