package controller;

import domain.Country;
import service.CountryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectAllCountry")
public class SelectAllCountryController extends HttpServlet {

    //service对象作为属性
    private CountryService service = new CountryService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取值
        //调用
        ArrayList<Country> countryList = service.selectAllCountry();
        //将查询的信息存入request作用域就可以啦
        request.setAttribute("countryList",countryList);
        //转发给regist.jsp拼接响应信息
        request.getRequestDispatcher("regist.jsp").forward(request,response);
    }
}
