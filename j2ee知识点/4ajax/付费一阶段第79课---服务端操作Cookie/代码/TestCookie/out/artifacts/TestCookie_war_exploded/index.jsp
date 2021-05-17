<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <%
    Cookie testCookie = new Cookie("test","testValue");
    testCookie.setMaxAge(3600*24);
    response.addCookie(testCookie);
  %>
  <body>
    <a href="test?param=paramValue">点我呀</a>
  </body>
</html>
