<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        welcome<br>
        param:${param.username}
        request:${requestScope.username}
        session:${sessionScope.username}
    </body>
</html>
