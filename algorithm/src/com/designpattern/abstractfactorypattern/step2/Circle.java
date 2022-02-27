package com.designpattern.abstractfactorypattern.step2;

import com.designpattern.abstractfactorypattern.step1.Shape;

/**
 * @author created by zhangyong
 * @Time 2019/7/12 21:03
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
