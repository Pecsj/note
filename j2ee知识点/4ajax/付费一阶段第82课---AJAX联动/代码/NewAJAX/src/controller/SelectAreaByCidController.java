package controller;

import domain.Area;
import service.AreaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectAreaByCid")
public class SelectAreaByCidController extends HttpServlet {

    private AreaService service = new AreaService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收参数
        Integer cid = Integer.parseInt(request.getParameter("cid"));
        //找寻业务层做事
        ArrayList<Area> areaList = service.selectAreaByCid(cid);

        //查询的结果响应回浏览器
        //1.转发----JSP(服务于我们的 帮我们做拼接的 内容是响应)
        request.setAttribute("areaList",areaList);
        request.getRequestDispatcher("handleAreaList.jsp").forward(request,response);
        //中间利用了一个JSP帮我们处理响应信息的拼接
        //JSP多了一个文件 JSP底层需要解析 性能不好啦


        //2.自己拼接响应
        //  集合里面的内容处理一下 将整个信息相应回去
        //  areaList集合---->写入一个文件XML---->传递给AJAX---->AJAX读取XML文件内容---->展示
        //  AJAX    异步--发送和处理都需要JavaScript XML数据的存储和传输
        //  areaList集合---->String---->AJAX接收---->JS处理(解析JSON)---->展示
        //                   JSON
        //                  JavaScript Object Notation
    }
}
