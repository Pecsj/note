<%@ page import="domain.Commodity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <style type="text/css">
            td{
                text-align : center;
            }
        </style>
    </head>
    <body>
        <table border="1" align="center" width="60%" height="60%">
            <tr>
                <th>商品名称</th><th>商品单价</th>
            </tr>
            <c:forEach var="commodity" items="${sessionScope.shoppingCar}">
                <tr>
                    <td>${commodity.cname}</td>
                    <td>${commodity.cprice}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="2">总计:${requestScope.sumPrice}</td>
            </tr>
        </table>
    </body>
</html>
