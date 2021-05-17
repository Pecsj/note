<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <%--<script type="text/javascript">--%>
            <%--window.onload = function(){--%>
                <%--var cookieObject = document.cookie;--%>
                <%--//  String类型的   k1=v1;k2=v2--%>
                <%--alert(cookieObject);--%>
                <%--var cookieMessage = cookieObject.split(";");//[k1=v1,k2=v2]--%>
                <%--for(var i=0;i<cookieMessage.length;i++){--%>
                    <%--var kv = cookieMessage[i].split("=");//[k1,v1]  [k2,v2]--%>
                    <%--alert(kv[0]+"---"+kv[1]);--%>
                <%--}--%>
            <%--}--%>
        <%--</script>--%>
    </head>
    <body>
        ${cookie.uname.value}
        我是welcome资源信息
    </body>
</html>
