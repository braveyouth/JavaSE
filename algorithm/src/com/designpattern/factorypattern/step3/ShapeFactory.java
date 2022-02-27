package com.designpattern.factorypattern.step3;

import com.designpattern.factorypattern.step1.Shape;
import com.designpattern.factorypattern.step2.Circle;
import com.designpattern.factorypattern.step2.Rectangle;
import com.designpattern.factorypattern.step2.Square;

/**
 * @author created by zhangyong
 * @Time 2019/7/12 21:06
 */
public class ShapeFactory {

    //使用getShape方法获取形状类型的对象
    public Shape getShape(String shpaeType){
        if(shpaeType==null){
            return null;
        }
        if(shpaeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }
        if(shpaeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        if(shpaeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

}
