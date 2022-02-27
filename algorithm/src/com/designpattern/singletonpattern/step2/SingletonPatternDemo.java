package com.designpattern.singletonpattern.step2;

import com.designpattern.singletonpattern.step1.SingleObjectOne;
import com.designpattern.singletonpattern.step1.SingleObjectTwo;

/**
 * @author created by zhangyong
 * @Time 2019/7/14 15:38
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {

        SingleObjectOne singleObjectOne = SingleObjectOne.getInstance();
        singleObjectOne.showMessage();


        SingleObjectTwo singleObjectTwo = SingleObjectTwo.getInstance();
        singleObjectTwo.showMessage();


    }
}
