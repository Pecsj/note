package com.duyi.interview;

public class Test4 {

    public static void main(String[] args) {

        String str1 = 'a' + 3 + "Hello";
        String str2 = "Hello" + 'a' + 3;

        System.out.println('a' + 3);
        System.out.println(str1);
        System.out.println(str2);


        //  A a3Hello   Helloa3
        //  B 100Hello  Helloa3
        //  C 973Hello  Helloa3
        //  D 其他


        // 字符 char   a - 97   ASCII码表
        //  字符和整数相加  会输出ASCII码和整数的运算结果
        //  字符串和其他类型相加  都是字符串
    }
}
