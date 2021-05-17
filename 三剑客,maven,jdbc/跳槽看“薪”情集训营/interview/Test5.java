package com.duyi.interview;

public class Test5 {

    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        method(a, b);
        // 需要在method方法被调用之后，
        // 仅打印出a=100,b=200,请写出method方法的代码
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }


    public static void method(int a,int b){
        a = a * 10;
        b = b * 20;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        // 终止程序  不执行后续语句
        System.exit(0);
    }

}
