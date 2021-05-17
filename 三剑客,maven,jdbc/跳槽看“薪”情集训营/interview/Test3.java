package com.duyi.interview;

public class Test3 {

    public static void main(String[] args) {

        int a = 1,b = 2,c = 3;
        if(a > b && c++ > b){
        }
        // 3  4
        System.out.println(c);

        int aa = 1,bb = 2,cc = 3;
        if(aa > bb & cc++ > bb){
        }
        // 3  4
        System.out.println(cc);


        // A 3 3
        // B 4 4
        // C 3 4
        // D 4 3


        // 逻辑运算符
        //  &&   ||    !   短路与  短路或
        //   &    |        逻辑与  逻辑或

    }
}
