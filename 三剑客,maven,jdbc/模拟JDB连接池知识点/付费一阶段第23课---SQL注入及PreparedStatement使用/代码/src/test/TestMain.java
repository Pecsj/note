package test;

import service.AtmService;

import java.util.Scanner;

public class TestMain {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入账号:");
        String aname = input.nextLine();
        System.out.println("请输入密码:");
        String apassword = input.nextLine();
        AtmService t = new AtmService();
        String result = t.login(aname,apassword);
        if(result.equals("登录成功")){
            System.out.println("欢迎进入阿拓系统");
            System.out.println("请输入操作选项");
            System.out.println("查询请输入1，存款请输入2，转账请输入3。。。。");
        }else{
            System.out.println(result);
        }
    }
}
