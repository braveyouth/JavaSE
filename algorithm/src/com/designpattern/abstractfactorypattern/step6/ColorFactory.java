package com.designpattern.abstractfactorypattern.step6;

import com.designpattern.abstractfactorypattern.step3.Color;
import com.designpattern.abstractfactorypattern.step4.Blue;
import com.designpattern.abstractfactorypattern.step4.Green;
import com.designpattern.abstractfactorypattern.step4.Red;
import com.designpattern.abstractfactorypattern.step5.AbstractFactory;
import com.designpattern.factorypattern.step1.Shape;

/**
 * @author created by zhangyong
 * @Time 2019/7/13 12:58
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if(color==null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        }
        if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        }
        if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
