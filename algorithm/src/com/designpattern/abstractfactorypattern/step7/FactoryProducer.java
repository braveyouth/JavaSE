package com.designpattern.abstractfactorypattern.step7;

import com.designpattern.abstractfactorypattern.step5.AbstractFactory;
import com.designpattern.abstractfactorypattern.step6.ColorFactory;
import com.designpattern.abstractfactorypattern.step6.ShapeFactory;

/**
 * @author created by zhangyong
 * @Time 2019/7/13 13:03
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        }
        if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
