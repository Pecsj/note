<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        ${requestScope.value mod 2}<br>
        ${requestScope.strValue + "10"}<br>
        ${requestScope.value >= 10}<br>
        ${requestScope.value < 10}<br>
        ${requestScope.value ge 10}<br>
        ${requestScope.value ne 10}<br>
        <hr>
        ${param.testName}<br>
        <hr>
        ${requestScope.user}<br>
        ${requestScope.user.uname}<br>
        ${requestScope.user.upassword}<br>
        ${requestScope.user.testGetValue()}<br>
        <hr>
        ${sessionScope.intArray}<br>
        ${sessionScope.intArray[0]}--${sessionScope.intArray[1]}--${sessionScope.intArray[2]}<br>
        ${sessionScope.intArray[10]}<br>
        ${requestScope.userArray}<br>
        ${requestScope.userArray[0].uname}--${requestScope.userArray[1].upassword}<br>
        ${requestScope.strDoubleArray[0][0]}--${requestScope.strDoubleArray[0][1]}<br>
        <hr>
        ${requestScope.floatList.size()}<br>
        ${requestScope.floatList.get(0)}<br>
        ${requestScope.userList.get(0).uname}--${requestScope.userList.get(0).upassword}<br>
        <hr>
        ${requestScope.userSet}<br>
        ${requestScope.userSet.size()}<br>
        <hr>
        ${requestScope.strMap}<br>
        ${requestScope.strMap.size()}<br>
        ${requestScope.strMap.get("aaa")}--${requestScope.strMap.get("bbb")};
    </body>
</html>
