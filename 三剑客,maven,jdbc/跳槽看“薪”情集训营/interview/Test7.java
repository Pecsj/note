package com.duyi.interview;

public class Test7 {

    // 只在if的括号中填写代码  同时输出 ab  怎么办？
    public static void main(String[] args) {
//        if (___________) {
        // 在空格处  填写一定会执行的逻辑
        if (true){ System.out.println("a");} if(false) {
            // 保证这段代码不执行
            System.out.println("a");
        } else {
            // 倒推出这段代码一定执行
            System.out.println("b");
        }

//        if (true) {
//            System.out.println("a");
//        }
//        if (false) {
//            // 保证这段代码不执行
//            System.out.println("a");
//        } else {
//            // 倒推出这段代码一定执行
//            System.out.println("b");
//        }


        // 注入   提供给用户去填写数据时  用户填写的是代码
        //   以此来窃取敏感数据或删除重要数据

        // 一种黑客手段


    }
}
