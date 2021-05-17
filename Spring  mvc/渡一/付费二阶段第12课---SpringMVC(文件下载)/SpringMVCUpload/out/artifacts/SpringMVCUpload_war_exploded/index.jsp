<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <a href="test.do">测试一下</a><br>

    <hr>

    <form action="upload.do" method="post" enctype="multipart/form-data">
      <input type="text" name="text" value=""><br>
      <input type="file" name="upload"><br>
      <input type="submit" value="upload">
    </form>

    <hr>

    <a href="download.do?fileName=mybatis-3.5.3.rar">文件下载</a>

  </body>
</html>
