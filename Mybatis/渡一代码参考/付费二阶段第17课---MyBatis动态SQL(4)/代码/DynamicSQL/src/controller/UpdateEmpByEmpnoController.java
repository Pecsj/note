package controller;

import service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateEmpByEmpno")
public class UpdateEmpByEmpnoController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("这是更新的controller");
        //1.获取表单中全部的勾选empno
        String[] empnos = request.getParameterValues("empno");
        //2.调用业务层的方法 处理批量更新
        new EmpService().updateEmp(empnos);
        //3.转发去展示
        request.getRequestDispatcher("update.html").forward(request,response);
    }
}
