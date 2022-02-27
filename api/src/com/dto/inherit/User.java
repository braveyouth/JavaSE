package com.dto.inherit;

/**
 * @author zhangy
 * @Time 2021-07-16 15:44
 * @Description: 定义用户类
 */
public class User {
    // 成员变量
    // 用户名
    private String userName;
    // 余额
    private double leftMoney;

    //构造方法
    public User() {
    }

    public User(String userName, double leftMoney) {
        this.userName = userName;
        this.leftMoney = leftMoney;
    }

    // get/set方法

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getLeftMoney() {
        return leftMoney;
    }

    public void setLeftMoney(double leftMoney) {
        this.leftMoney = leftMoney;
    }

    // 展示信息的方法
    public void show() {
        System.out.println("用户名:"+ userName +" , 余额为:" + leftMoney + "元");
    }
}
