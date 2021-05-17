<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <script type="text/javascript">
            window.onload = function () {
                document.getElementById("countrySelect").onchange = function () {
                    //发送一个异步请求
                    //1.创建一个对象
                    var xmlhttp = new XMLHttpRequest();
                    //2.打开一个AJAX连接 模拟一个异步请求
                    xmlhttp.open("post","selectAreaByCid?cid="+this.value,true);
                    //3.发送请求
                    xmlhttp.send();
                    //4.一直观察着响应的状态 状态为4的时候 处理响应信息
                    xmlhttp.onreadystatechange = function () {
                        if(xmlhttp.readyState==4 && xmlhttp.status==200){
                            //处理信息
                            //找到地区的那个span标签
                            var areaSpanEle = document.getElementById("areaSpan");
                            //将响应信息放入这个标签内即可
                            areaSpanEle.innerHTML = xmlhttp.responseText;
                        }
                    }
                }
            }
        </script>
    </head>
    <body>
        <form action="" method="post">
            账号:<input type="text" name="name" value=""><br>
            密码:<input type="text" name="name" value=""><br>
            确认:<input type="text" name="name" value=""><br>
            性别:
            <input type="radio" name="sex" value="男">男
            <input type="radio" name="sex" value="女">女
            <br>
            国家:
            <select id="countrySelect">
                <option>==请选择==</option>
                <c:forEach var="country" items="${requestScope.countryList}">
                    <option value="${country.cid}">${country.cname}</option>
                </c:forEach>
            </select>
            地区:
            <span id="areaSpan">
                <select>
                    <option>==请选择==</option>
                </select>
            </span>
            城市:
            <select>
                <option>==请选择==</option>
            </select>
            <br>
            电话:<input type="text" name="name" value=""><br>
            邮箱:<input type="text" name="name" value=""><br>
            <input type="submit" value="注册">
            <input type="reset" value="重置">
        </form>
    </body>
</html>
