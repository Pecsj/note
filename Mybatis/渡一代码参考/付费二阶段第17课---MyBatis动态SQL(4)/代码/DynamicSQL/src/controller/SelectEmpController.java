package controller;

import com.alibaba.fastjson.JSONObject;
import domain.Emp;
import service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectEmp")
public class SelectEmpController extends HttpServlet {

    private EmpService service = new EmpService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求传递的参数
        String deptno = request.getParameter("deptno");
        String job = request.getParameter("job");
        String orderFlag = request.getParameter("orderFlag");

        System.out.println(deptno+"---"+job+"---"+orderFlag);

        //2.找寻业务层的方法执行查询
        List<Emp> empList = service.selectEmp(deptno,job,orderFlag);
        //3.通过json将empList带走
        JSONObject json = new JSONObject();
        json.put("empList",empList);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toJSONString());
    }
}
