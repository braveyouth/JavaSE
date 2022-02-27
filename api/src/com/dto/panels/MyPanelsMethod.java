package com.dto.panels;

/**
 * @author zhangy
 * @date 2021-09-10 16:20
 * @apiNote: 含有泛型的方法
 * 定义格式: 修饰符 <代表泛型的变量> 返回值类型 方法名(参数){ }
 */
public class MyPanelsMethod {

    public <E> void showOne(E e){
        System.out.println(e);
    }

    public <E> E showTwo(E e){
        return e;
    }

}
