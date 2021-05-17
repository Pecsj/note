package controller;

import com.alibaba.fastjson.JSONObject;
import service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectDeptnoAndJob")
public class SelectDeptnoAndJobController extends HttpServlet {

    private EmpService service = new EmpService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //控制层的目的是为了查询deptno和job的
        List<Integer> deptnoList = service.selectAllDeptno();
        List<String> jobList = service.selectAllJob();
        //将查询到的两个集合响应回浏览器   JSON
        JSONObject json = new JSONObject();//可以理解为json是一个容器
        json.put("deptnoList",deptnoList);
        json.put("jobList",jobList);
        //给予响应
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toJSONString());
    }
}
