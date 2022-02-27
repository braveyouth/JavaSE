package com.stream;

/**
 * @author zhangy
 * @Time 2021-07-05 11:20
 * @Description:
 */
public class StringApi {

    String str=new String("good");
    char[] ch={'a','b','c'};

    public static void main(String[] args) {
//        String str = "welcome to Innovation works.";
//        str = new StringBuffer(str).reverse().toString();
//        System.out.println(str);

        int a=8;
//        int b=10;
//        int c=(a++)+(+b)+a*b;
//        System.out.println(c);
        StringApi stringApi=new StringApi();
        stringApi.change(stringApi.str,stringApi.ch);
        System.out.print(stringApi.str + " and ");
        System.out.print(stringApi.ch);
    }

    public void change(String str, char[] ch) {
        str="test ok";
        ch[0]='g';
    }

}
