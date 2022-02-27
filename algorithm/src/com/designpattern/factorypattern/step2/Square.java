package com.designpattern.factorypattern.step2;

import com.designpattern.factorypattern.step1.Shape;

/**
 * @author created by zhangyong
 * @Time 2019/7/12 21:03
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square");
    }
}
