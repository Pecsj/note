<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript">
      function Person(){}

      window.onload = function () {
          //找到按钮DOM对象 绑定单击事件
          document.getElementById("button").onclick = function () {
              //1.创建一个AJAX对象用于发送
              var xhr = new XMLHttpRequest();
              //2.打开一个通道 模拟一个请求  ("请求方式","请求URL",是否为异步true)
              xhr.open("POST","testAJAX.do",true);
              //  2.1如果想要发送的是json形式 告知浏览器解析的时候规则
              xhr.setRequestHeader("Content-type","application/json;charset=UTF-8")
              //3.发送后 时刻监听者服务端的状态   回调机制
              xhr.onreadystatechange = function () {
                  if(xhr.readyState==4 && xhr.status==200){
                      //接收响应信息啦
                      alert(xhr.responseText);
                      //接收以后 需要处理 展示在浏览器中的某个组件里
                  }
              }
              //4.发送请求
              xhr.send('{"sid":1,"sname":"张三"}');
          }
      }
    </script>
  </head>
  <body>
    <%--<a href="testOne.do?user=zzt">测试一</a><br>--%>
    <%--<a href="testTwo.do">测试二</a><br>--%>
    <%--<a href="testThree.do">测试三</a><br>--%>

    <a href="testParam1.do?name=zzt&age=18&sex=男">参数传递测试</a><br>

    <form action="login.do" method="post">
      <input type="text" name="username" value=""><br>
      <input type="text" name="password" value=""><br>
      <input type="submit" name="login" value="login"><br>

      <%--name:<input type="text" name="name" value=""><br>--%>
      <%--age:<input type="text" name="age" value=""><br>--%>
      <%--sex:<input type="text" name="sex" value=""><br>--%>
      <%--birthday:<input type="text" name="birthday" value=""><br>--%>

      <%--wallet1-color:<input type="text" name="list[0].color" value=""><br>--%>
      <%--wallet1-money:<input type="text" name="list[0].money" value=""><br>--%>
      <%--wallet2-color:<input type="text" name="list[1].color" value=""><br>--%>
      <%--wallet2-money:<input type="text" name="list[1].money" value=""><br>--%>
      <%--<input type="submit" value="submit">--%>
    </form>

    <br>
    <input id="button" type="button" value="测试JSON形式">

  </body>
</html>
