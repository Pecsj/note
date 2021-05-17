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
    </script>
  </head>
  <body>
    <form action="" method="post">
      账号:<input id="uname" type="text" name="uname" value=""><span id="showSpan"></span><br>
      密码:<input type="text" name="upassword" value=""><br>
      确认:<input type="text" name="ucheckpassword" value=""><br>
      电话:<input type="text" name="utel" value=""><br>
      国籍:
      <select>
        <option>==请选择==</option>
        <option>中国</option>
        <option>德国</option>
        <option>巴西</option>
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
