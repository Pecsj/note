<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%--<a href="testOne.do?user=zzt">测试一</a><br>--%>
    <%--<a href="testTwo.do">测试二</a><br>--%>
    <%--<a href="testThree.do">测试三</a><br>--%>

    <a href="testParam1.do?name=zzt&age=18&sex=男">参数传递测试</a><br>

    <form action="testParam1.do" method="post">
      name:<input type="text" name="name" value=""><br>
      age:<input type="text" name="age" value=""><br>
      sex:<input type="text" name="sex" value=""><br>
      birthday:<input type="text" name="birthday" value=""><br>
      <%--wallet1-color:<input type="text" name="list[0].color" value=""><br>--%>
      <%--wallet1-money:<input type="text" name="list[0].money" value=""><br>--%>
      <%--wallet2-color:<input type="text" name="list[1].color" value=""><br>--%>
      <%--wallet2-money:<input type="text" name="list[1].money" value=""><br>--%>
      <input type="submit" value="submit">
    </form>

  </body>
</html>
