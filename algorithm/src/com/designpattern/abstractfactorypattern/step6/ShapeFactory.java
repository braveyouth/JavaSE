package com.designpattern.abstractfactorypattern.step6;

import com.designpattern.abstractfactorypattern.step3.Color;
import com.designpattern.abstractfactorypattern.step5.AbstractFactory;
import com.designpattern.factorypattern.step1.Shape;
import com.designpattern.factorypattern.step2.Circle;
import com.designpattern.factorypattern.step2.Rectangle;
import com.designpattern.factorypattern.step2.Square;

/**
 * @author created by zhangyong
 * @Time 2019/7/13 12:49
 */
public class ShapeFactory extends AbstractFactory {


    @Override
    public Shape getShape(String shape) {
        if(shape==null){
            return null;
        }
        if(shape.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }
        if(shape.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        if(shape.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }


}
