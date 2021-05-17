package test;

import java.util.Scanner;

public class TestMain {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        TestAtm ta = new TestAtm();
        System.out.println("请输入用户名");
        String aname = input.nextLine();
        System.out.println("请输入密码");
        String apassword = input.nextLine();
        String result = ta.login(aname,apassword);
        if(result.equals("登录成功")){
            System.out.println("欢迎"+aname+"进入阿拓银行系统");
            System.out.println("请输入操作选项");
            System.out.println("查询请输入1,存款请输入2,取款请输入3,转账请输入4。。。。");
            String option = input.nextLine();
            switch(option){
                case "1":
                    float abalance = ta.cha(aname);
                    System.out.println("尊敬的"+aname+"用户,您的可用余额为:"+abalance);
                    break;
            }
        }else{
            System.out.println(result);
        }
    }
}
