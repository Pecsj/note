package com.duyi.interview;

public class Test6 {


    public static void main(String[] args) {
        int num = Integer.MIN_VALUE;

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(Math.abs(Integer.MIN_VALUE));

        if (num < 0 && num == Math.abs(num)) {
            System.out.println("Hello World!");
        }
    }

}
