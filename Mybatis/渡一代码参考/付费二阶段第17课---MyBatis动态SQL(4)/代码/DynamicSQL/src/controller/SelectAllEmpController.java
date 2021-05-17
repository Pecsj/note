package controller;

import com.alibaba.fastjson.JSONObject;
import service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectAllEmp")
public class SelectAllEmpController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject json = new JSONObject();
        json.put("empList",new EmpService().selectAllEmp());
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toJSONString());
    }
}
