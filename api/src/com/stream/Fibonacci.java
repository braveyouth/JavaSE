package com.stream;

/**
 * @author zhangy
 * @Time 2021-07-05 11:11
 * @Description:
 */
public class Fibonacci {
    public static long fibonacci(long num) {
        if ((num == 0) || (num == 1))
            return num;
        else
            return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++){
            System.out.println("Fibonacci of "+i+" is: "+fibonacci(i));
        }
    }
}
