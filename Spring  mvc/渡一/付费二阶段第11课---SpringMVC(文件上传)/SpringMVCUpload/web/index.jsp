<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <a href="test.do">测试一下</a><br>

    <form action="upload.do" method="post" enctype="multipart/form-data">
      <input type="text" name="text" value=""><br>
      <input type="file" name="upload"><br>
      <input type="submit" value="upload">
    </form>

  </body>
</html>
