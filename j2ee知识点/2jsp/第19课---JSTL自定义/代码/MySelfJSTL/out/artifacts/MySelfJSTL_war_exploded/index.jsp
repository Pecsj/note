<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.duyiedu.com/myFn" prefix="myFn"%>
<%@ taglib uri="http://www.duyiedu.com/myTag" prefix="myTag"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    这是我自己定义的JSTL函数<br>
    它可以计算两个整数的和<br>
    不相信你用一下试试看<br>
    函数执行的结果为:${myFn:add(3,4)}<br>
    <hr>
    <myTag:out value="你们听懂了吗？">
      我是标签的body
    </myTag:out>
      我是标签之后的page
  </body>
</html>
