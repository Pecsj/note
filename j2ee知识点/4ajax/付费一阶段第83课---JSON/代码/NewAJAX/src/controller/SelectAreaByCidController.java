package controller;

import com.alibaba.fastjson.JSONObject;
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

        //2.自己拼接响应
        //  集合里面的内容处理一下 将整个信息相应回去
        //  areaList集合---->写入一个文件XML---->传递给AJAX---->AJAX读取XML文件内容---->展示
        //  AJAX    异步--发送和处理都需要JavaScript XML数据的存储和传输
        //  areaList集合---->String---->AJAX接收---->JS处理(解析JSON)---->展示
        //                   JSON
        //                  JavaScript Object Notation

        //  fastjson-1.2.9.jar
        JSONObject jsonObject = new JSONObject();//是一个容器
        jsonObject.put("areaList",areaList);
        //put进入JSONObject中的对象
        //  String  int  Integer    很少见
        //  数组[]   集合  List   Set   Map   对象
        System.out.println(jsonObject.toJSONString());
        //[{"aid":1,"aname":"北方","country":{"cid":1}},{"aid":2,"aname":"南方","country":{"cid":1}}]
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonObject.toJSONString());





        //原来的方式  ArrayList<Area>------>String-----响应回去
        //  [{aid:1,aname:东北};{aid:2,aname:西北};{aid:3,aname:东南}]
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//        for(Area area : areaList){
//            sb.append("{");
//            sb.append("aid");
//            sb.append(":");
//            sb.append(area.getAid());
//            sb.append(",");
//            sb.append("aname");
//            sb.append(":");
//            sb.append(area.getAname());
//            sb.append("}");
//            sb.append(";");
//        }
//        sb.delete(sb.length()-1,sb.length());
//        sb.append("]");
//        System.out.println(sb.toString());
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(sb.toString());






        //查询的结果响应回浏览器
        //1.转发----JSP(服务于我们的 帮我们做拼接的 内容是响应)
//        request.setAttribute("areaList",areaList);
//        request.getRequestDispatcher("handleAreaList.jsp").forward(request,response);
        //中间利用了一个JSP帮我们处理响应信息的拼接
        //JSP多了一个文件 JSP底层需要解析 性能不好啦






    }
}
