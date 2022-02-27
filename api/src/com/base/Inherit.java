package com.base;

import com.dto.inherit.Member;
import com.dto.inherit.QunZhu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author zhangy
 * @Time 2021-07-16 15:41
 * @Description: 综合案例：群主发普通红包
 * 群主发普通红包。某群有多名成员，群主给成员发普通红包。普通红包的规则：
 * 1. 群主的一笔金额，从群主余额中扣除，平均分成n等份，让成员领取。
 * 2. 成员领取红包后，保存到成员余额中。
 * 请根据描述，完成案例中所有类的定义以及指定类之间的继承关系，并完成发红包的操作。
 */
public class Inherit {

    public static void main(String[] args) {
        // 创建一个群主对象
        QunZhu qz = new QunZhu("群主" , 200);
        // 创建一个键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入金额:");
        int money = sc.nextInt();
        System.out.println("请输入个数:");
        int count = sc.nextInt();
        // 发送红包
        ArrayList<Double> sendList = qz.send(money,count);
        // 判断,如果余额不足
        if(sendList == null){
            System.out.println(" 余额不足...");
            return;
        }
        // 创建三个成员
        Member m = new Member("成员1", 0);
        Member m2 = new Member("成员2", 0);
        Member m3 = new Member("成员3", 0);
        // 打开红包
        m.openHongbao(sendList);
        m2.openHongbao(sendList);
        m3.openHongbao(sendList);
        // 展示信息
        qz.show();
        m.show();
        m2.show();
        m3.show();
    }
}
