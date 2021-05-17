<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <script type="text/javascript">
      // window.onload = function() {
      //   document.getElementById("uname").onblur = function () {
      //     //1.找到用来展示的那个span组件
      //     var spanEle = document.getElementById("showSpan");
      //     //2.找到账号文本框那个组件---组件里面的value属性
      //     var unameEleValue = this.value;
      //     //3.判断unameEleValue的字符长度
      //     if(unameEleValue.length>=6 && unameEleValue.length<=10){//长度合法
      //         spanEle.innerHTML = "字符长度合法";
      //     }else{
      //         spanEle.innerHTML = "字符长度不合法";
      //     }
      //   }
      // }

      window.onload = function () {
          //1.找到账号的文本框  绑定一个失去焦点的事件
          document.getElementById("uname").onblur = function () {
              //2.获取当前文本框中的value属性
              var unameEleValue = this.value;
              //3.发送一个AJAX异步请求  需要一个XMLHttpRequest对象
              //以前的方式  为了控制版本不兼容带来的问题 很多严谨的判断
              // var xmlHttp;
              // try {
              //     //浏览器早些年前有兼容问题  除了IE以外
              //     xmlHttp = new XMLHttpRequest();
              // }catch(e){
              //     //IE
              //     try {
              //         xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");//4
              //     }catch(e){
              //         xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");//5
              //     }
              // }

              //3.1创建一个AJAX对象
              var xmlHttp = new XMLHttpRequest();
              //3.2打开一个管道(用来与服务器进行通信)
              //  三个参数
              //  1.String类型参数  请求的方式 get/post
              //  2.String类型参数  请求的名字 可以拼接?作为参数
              //  3.boolean类型参数 是否为异步请求 默认true
              xmlHttp.open("get","checkName?uname="+unameEleValue,true);
              //3.3发送请求
              xmlHttp.send();
              //xmlHttp对象 有一个属性 readyState  是一个int的数字
              //    监测服务器的处理状态
              //  0-4
              //  0: 请求未初始化
              //  1: 服务器连接已建立
              //  2: 请求已接收
              //  3: 请求处理中
              //  4: 请求已完成，且响应已就绪
              //4.等待回来的响应信息---处理  展示在span标签内
              xmlHttp.onreadystatechange = function() {
                  if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                      //接收回来的响应信息
                      var result = xmlHttp.responseText;
                      //将信息展示在span标签内
                      var spanEle = document.getElementById("showSpan");
                      spanEle.innerHTML = result;
                  }
              }
          }
      }
    </script>
  </head>
  <body>
    <form action="" method="post">
      账号:<input id="uname" type="text" name="uname" value=""><span id="showSpan"></span><br>
      密码:<input type="text" name="upassword" value=""><br>
      确认:<input type="text" name="ucheckpassword" value=""><br>
      电话:<input type="text" name="utel" value=""><br>
      国家:
      <select>
        <option>==请选择==</option>
        <option>中国</option>
        <option>德国</option>
        <option>巴西</option>
      </select>
      地区:
      <select>
        <option>==请选择==</option>
        <option>东北</option>
        <option>西北</option>
        <option>华北</option>
      </select>
      城市:
      <select>
        <option>==请选择==</option>
        <option>哈尔滨</option>
        <option>北京</option>
        <option>铁岭</option>
      </select>
      <br>
      爱好:
      <input type="checkbox" name="hobby" value="足球">足球
      <input type="checkbox" name="hobby" value="篮球">篮球
      <input type="checkbox" name="hobby" value="排球">排球
      <br>
      <input type="submit" value="注册"><br>
    </form>
  </body>
</html>
