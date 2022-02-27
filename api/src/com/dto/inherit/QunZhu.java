package com.dto.inherit;

import java.util.ArrayList;

/**
 * @author zhangy
 * @Time 2021-07-16 15:47
 * @Description: 定义群主类
 */
public class QunZhu extends User{
    // 添加构造方法
    public QunZhu() {
    }

    public QunZhu(String userName, double leftMoney) {
        // 通过super调用父类构造方法
        super(userName, leftMoney);
    }

    public ArrayList<Double> send(int money, int count) {
        // 获取群主余额
        double leftMoney = getLeftMoney();
        if(money > leftMoney) {
            return null;
        }
        // 修改群主余额的
        setLeftMoney(leftMoney - money);
        // 创建一个集合,保存等份金额
        ArrayList<Double> list = new ArrayList<>();
        // 扩大100倍,相当于折算成'分'为单位,避免小数运算损失精度的问题
        money = money * 100;
        // 每份的金额
        int m = money / count;
        // 不能整除的余数
        int l = money % count;
        // 无论是否整除,n‐1份,都是每份的等额金额
        for (int i = 0; i < count - 1; i++) {
        // 缩小100倍,折算成 '元'
            list.add(m / 100.0);
        }
        // 判断是否整除
        if (l == 0) {
        // 能整除, 最后一份金额,与之前每份金额一致
            list.add(m / 100.0);
        } else {
        // 不能整除, 最后一份的金额,是之前每份金额+余数金额
            list.add((m + l) / 100.00);
        }
        // 返回集合
        return list;
    }
}
