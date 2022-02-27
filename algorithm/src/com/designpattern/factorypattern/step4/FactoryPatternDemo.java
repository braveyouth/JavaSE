package com.designpattern.factorypattern.step4;

import com.designpattern.factorypattern.step1.Shape;
import com.designpattern.factorypattern.step3.ShapeFactory;

/**
 * @author created by zhangyong
 * @Time 2019/7/13 11:38
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        //获取Circle的对象，并调用它的draw方法
        Shape shape = shapeFactory.getShape("CIRCLE");
        shape.draw();
        //获取Rectangle的对象，并调用它的draw方法
        Shape shape1 = shapeFactory.getShape("RECTANGLE");
        shape1.draw();
        //获取Square的对象，并调用它的draw方法
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();
    }
}
