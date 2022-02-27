package com.designpattern.abstractfactorypattern.step5;

import com.designpattern.abstractfactorypattern.step3.Color;
import com.designpattern.factorypattern.step1.Shape;

/**
 * @author created by zhangyong
 * @Time 2019/7/13 12:47
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
