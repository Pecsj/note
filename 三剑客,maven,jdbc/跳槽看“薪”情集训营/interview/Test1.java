package com.duyi.interview;

import java.math.BigDecimal;

public class Test1 {

    // 用JAVA程序写出当你在超市购物花费1.1元时，你给收银员2元钱，
    // 收银员找你0.9元的过程；
    public static void main(String[] args) {
        double total = 2.0;
        double used = 1.1;
        double result = total - used;
        System.out.println("result : " + result);


        // 基本数据类型
        //  byte  short  int  long
        //  float  double
        //  boolean  char

        BigDecimal total1 = new BigDecimal("2.0");
        BigDecimal used1 = new BigDecimal("1.1");
        System.out.println( total1.subtract(used1));
    }
}
