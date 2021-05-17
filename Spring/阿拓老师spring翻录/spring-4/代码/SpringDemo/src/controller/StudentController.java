package controller;

import service.StudentService;

public class StudentController {

    private StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }

    public void login(){
        System.out.println("controller层接收请求信息");
        //获取请求发送过来的信息
        //调用service去处理业务---->
        service.login();
        //根据service处理的结果 给予响应
        System.out.println("controller层给予响应");
    }
}
