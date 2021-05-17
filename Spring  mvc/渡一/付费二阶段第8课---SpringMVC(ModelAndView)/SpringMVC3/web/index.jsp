<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    ${requestScope.result}
    <form action="login.do" method="post">
      <input type="text" name="username" value=""><br>
      <input type="text" name="password" value=""><br>
      <input type="submit" value="login"><br>
    </form>
  </body>
</html>
