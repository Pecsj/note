<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <%--<%--%>
    <%--Cookie testCookie1 = new Cookie("test1","testValue1");--%>
    <%--Cookie testCookie2 = new Cookie("test2","testValue2");--%>
    <%--response.addCookie(testCookie1);--%>
    <%--response.addCookie(testCookie2);--%>
  <%--%>--%>
  <%--<body>--%>
    <%--<a href="test?param=paramValue">点我呀</a>--%>
  <%--</body>--%>

  <%
    Cookie[] cookies = request.getCookies();
    if(cookies!=null && cookies.length>1){
      request.getRequestDispatcher("login").forward(request,response);
    }
  %>
  <body>
    <form action="login" method="post">
      账号:<input type="text" name="uname" value=""><br>
      密码:<input type="password" name="upass" value=""><br>
      <input type="checkbox" name="flag" value="true">7日内免登录<br>
      <input type="submit" value="登录"><br>
    </form>
  </body>
</html>
