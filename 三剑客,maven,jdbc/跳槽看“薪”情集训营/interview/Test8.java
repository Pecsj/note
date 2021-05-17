package com.duyi.interview;

public class Test8 {

    //  数据类型
    //    int i = 0;   i是对象吗？
    //  JAVA世界中 "万物皆对象"

    // 拆箱装箱

    public static void main(String[] args) {
        // 自动装箱和拆箱
//        int i = 0;
//        Integer i1 = new Integer(0);
        Integer i2 = 10;   //  装箱
        int j = i2;    // 拆箱

        // 装箱 就是将基本数据类型  转化为包装器类型
        // 拆箱  就是将包装器类型  转化为基本数据类型


        Integer a = new Integer(1);
        Integer b = 1;  // 自动装箱  new Integer(1)
        int c = 1;


        System.out.println(a == b);
        // a和b是两次new 出来的对象  比较的是地址
        System.out.println(a == c);
        // a自动拆箱成int类型   然后再和c比较   比较的是数值本身

        // A true  true
        // B false  false
        // C true  false
        // D false  true


        System.out.println("==============================");
        // 当数值在-128——127之间时   使用缓存对象
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);

        // A true  true
        // B false  false
        // C true  false
        // D false  true

        // 装箱的本质是  调用Integer.valueOf()  方法
        Integer.valueOf(100);

        System.out.println("=============================");

        Integer h1 = 1;
        Integer h2 = 2;
        Integer h3 = 3;
        Long h4 = 3L;
        // + 是算术运算 触发拆箱   得到 int 3  然后h3也拆箱  比较的是数值本身
//        System.out.println(h3 == 3);   相当于这样比较
        System.out.println(h3 == (h1 + h2));
        // 类似 ==比较的是对象地址  equals更加比较的是数值本身
        System.out.println(h3.equals(h1 + h2));

        // Long  -> long  变成long 和 int 比较  触发类型晋升
        System.out.println(h4 == (h1 + h2));
        // h1 + h2 = 3   ->  int的3   -> 再装箱成Integer对象  传入equals方法中
        System.out.println(h4.equals(h1 + h2));


        //        A  true  true  false  false
        //        B  true  false  false  true
        //        C  true  true  true  false
        //        D  true  false  true  false



    }

}
