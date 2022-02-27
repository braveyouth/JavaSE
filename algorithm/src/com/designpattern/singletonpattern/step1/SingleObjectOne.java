package com.designpattern.singletonpattern.step1;

/**
 * @author created by zhangyong
 * @Time 2019/7/14 15:30
 */
public class SingleObjectOne {

    //创建SingleObject的一个对象
    private static SingleObjectOne instance=new SingleObjectOne();

    //让构造函数为private，这样该类就不会被实例化
    private SingleObjectOne() {
    }

    //获取唯一可用的对象
    public static SingleObjectOne getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }


}
