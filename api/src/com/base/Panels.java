package com.base;

import com.dto.panels.MyPanelsClass;
import com.dto.panels.MyPanelsInterfaceImplOne;
import com.dto.panels.MyPanelsInterfaceImplTwo;
import com.dto.panels.MyPanelsMethod;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author zhangy
 * @date 2021-09-10 15:53
 * @apiNote:
 */
public class Panels {

    public static void main(String[] args) {
        // 含有泛型的类
        // 创建一个泛型为String的类
        MyPanelsClass<String> stringMyPanelsClass = new MyPanelsClass<>();
        MyPanelsClass<Integer> integerMyPanelsClass = new MyPanelsClass<>();
        // 调用setMVP
        stringMyPanelsClass.setMp("泛型类字符串");
        integerMyPanelsClass.setMp(1);
        // 调用getMVP
        System.out.println(stringMyPanelsClass.getMp());
        System.out.println(integerMyPanelsClass.getMp());

        // 含有泛型的方法
        MyPanelsMethod myPanelsMethod = new MyPanelsMethod();
        myPanelsMethod.showOne("泛型方法字符串");
        myPanelsMethod.showOne(2);
        System.out.println(myPanelsMethod.showTwo(true));

        // 含有泛型的接口
        // 定义接口实现类时确定泛型的类型
        MyPanelsInterfaceImplOne myPanelsInterfaceImplOne = new MyPanelsInterfaceImplOne();
        myPanelsInterfaceImplOne.add("泛型接口字符串");
        System.out.println(myPanelsInterfaceImplOne.get());
        // 定义接口实现类时不确定泛型的类型
        MyPanelsInterfaceImplTwo<Integer> interfaceImplTwo = new MyPanelsInterfaceImplTwo<>();
        interfaceImplTwo.add(3);
        System.out.println(interfaceImplTwo.get());

        //泛型通配符
        Collection<Integer> list1 = new ArrayList<Integer>();
        Collection<String> list2 = new ArrayList<String>();
        Collection<Number> list3 = new ArrayList<Number>();
        Collection<Object> list4 = new ArrayList<Object>();
        getElement1(list1);
        //报错
        //getElement1(list2);
        getElement1(list3);
        //报错
        //getElement1(list4);
        //报错
        //getElement2(list1);
        //报错
        //getElement2(list2);
        getElement2(list3);
        getElement2(list4);

    }

    /**
     * 泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
     */

    public static void getElement1(Collection<? extends Number> coll){}

    /**
     * 泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
     */
    public static void getElement2(Collection<? super Number> coll){}

}
