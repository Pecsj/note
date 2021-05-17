<%@ page import="domain.Kind" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <script type="text/javascript">
            window.onload = function(){
                var kindSelect = document.getElementById("kindSelect");
                kindSelect.onchange = function(){
                    //window.alert(this.value);
                    window.location.href = "selectCommodity?kid="+this.value;
                }
            }
        </script>
    </head>
    <body>
        本山寨购物系统有商品种类如下，请下拉选择<br>
        <select id="kindSelect" name="kid">
            <option>==请选择==</option>
            <c:forEach var="kind" items="${requestScope.kindList}">
                <option value="${kind.kid}">${kind.kname}</option>
            </c:forEach>
        </select>
    </body>
</html>
