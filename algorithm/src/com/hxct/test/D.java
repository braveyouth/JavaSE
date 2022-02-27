package com.hxct.test;

/**
 * @author created by zhangyong
 * @Time 2019/7/1 15:40
 */
public class D {
    public static void main(String[] args) {
        A a = new A("zhangsan");
//        A a = new A();
//        a.setName("zhangsan");
        B b = new B(18);
        C c = new C();
        c.setA(a);
        c.setB(b);
        System.out.println(c.getA().getName()+c.getB().getAge());
    }
}
