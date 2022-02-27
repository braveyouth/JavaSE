package com.designpattern.abstractfactorypattern.step8;

import com.designpattern.abstractfactorypattern.step3.Color;
import com.designpattern.abstractfactorypattern.step5.AbstractFactory;
import com.designpattern.abstractfactorypattern.step7.FactoryProducer;
import com.designpattern.factorypattern.step1.Shape;

/**
 * @author created by zhangyong
 * @Time 2019/7/13 13:07
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {

        AbstractFactory factory = FactoryProducer.getFactory("SHAPE");
        Shape shape = factory.getShape("CIRCLE");
        shape.draw();
        Shape shape1 = factory.getShape("RECTANGLE");
        shape1.draw();
        Shape shape2 = factory.getShape("SQUARE");
        shape2.draw();

        AbstractFactory factory1 = FactoryProducer.getFactory("COLOR");
        Color color = factory1.getColor("RED");
        color.fill();
        Color color1 = factory1.getColor("GREEN");
        color1.fill();
        Color color2 = factory1.getColor("BLUE");
        color2.fill();
    }
}
