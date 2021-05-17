package test;

import domain.Student;
import service.StudentService;

import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) {
        //当作执行的头  请求--控制--业务
        Scanner input = new Scanner(System.in);
        System.out.println("填写注册信息");
        System.out.println("sid");
        String sid = input.nextLine();
        System.out.println("sname");
        String sname = input.nextLine();
        System.out.println("ssex");
        String ssex = input.nextLine();
        System.out.println("sage");
        String sage = input.nextLine();
        //填写完毕相当于 以前的页面资源 填写了表单 点击按钮提交表单
        //点击按钮 发送请求---找到控制层
        //  1.接受请求信息  request.getParameter("key");
        //  2.将接受信息包装成一个VO对象
        Student student = new Student(Integer.parseInt(sid),sname,ssex,Integer.parseInt(sage));
        //  3.找寻业务做事
        StudentService service = new StudentService();
        service.insertStudent(student);
    }
}
