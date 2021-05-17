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

                            //1.控制层利用另一个JSP帮忙拼接响应
                            //控制层直接转发 比较简单
                            //JSP中利用JSTL循环拼接 稍微好写一点点
                            //JSP需要编译 性能不好
                            //找到地区的那个span标签
                            //var areaSpanEle = document.getElementById("areaSpan");
                            //将响应信息放入这个标签内即可
                            //areaSpanEle.innerHTML = xmlhttp.responseText;//JSP里面拼接的响应信息


                            //2.控制层利用自己拼接字符串的方式回来的响应
                            //控制层没有利用其他的JSP 不需要编译 性能好一些
                            //控制层自己通过循环拼接了字符串 相比较而言麻烦了一些

                            //找到span
                            //创建新的select
                            //select设置属性
                            //新的select添加默认请选择
                            //正常循环添加新的option
                            // var areaSelectEle = document.getElementById("areaSelect");
                            // areaSelectEle.options.length = 0;//将select中的所有option删掉了
                            // var defaultOption = document.createElement("option");
                            // defaultOption.innerHTML = "==请选择==";
                            // areaSelectEle.appendChild(defaultOption);
                            //
                            //
                            // //[{aid:1,aname:北方};{aid:2,aname:南方}]
                            // var responseText = xmlhttp.responseText;//String
                            // //解析响应回来的字符串 显示在下拉列表中
                            // //1.最外层两个中括号去掉{aid:1,aname:北方};{aid:2,aname:南方}
                            // responseText = responseText.substring(1,responseText.length-1);
                            // //2.按照分号将每一组对象拆分
                            // var objects = responseText.split(";");
                            // //3.循环处理每一个"对象"
                            // for(var i=0;i<objects.length;i++){
                            //     //{aid:1,aname:北方}  {aid:2,aname:南方}
                            //     //每一个obj是不包含大括号的信息  aid:1,aname:北方
                            //     var obj = objects[i].substring(1,objects[i].length-1);
                            //     //解析每一个obj对象中的每一个属性
                            //     var kv = obj.split(",");// aid:1    aname:北方
                            //     var aid = kv[0].split(":")[1];
                            //     var aname = kv[1].split(":")[1];
                            //     //解析出来的所有数据  创建一个option组件 包装起来
                            //     //  <option value="aid">aname</option>
                            //     var newOptionEle = document.createElement("option");
                            //     newOptionEle.setAttribute("value",aid);
                            //     newOptionEle.innerHTML = aname;
                            //     //将newOption组件对象添加至下拉列表组件中
                            //     areaSelectEle.appendChild(newOptionEle);
                            // }


                            //JSON
                            var areaSelectEle = document.getElementById("areaSelect");
                            areaSelectEle.options.length = 0;
                            var defaultOptionEle = document.createElement("option");
                            defaultOptionEle.innerHTML = "==请选择==";
                            areaSelectEle.appendChild(defaultOptionEle);

                            var responseText = xmlhttp.responseText;//String json格式
                            var jsonObject = JSON.parse(responseText);//JS对象---->与Java中的JSONObject对应的对象
                            var areaList = jsonObject.areaList;//JS对象---->与Java中ArrayList<Area>
                            for(var i=0;i<areaList.length;i++){
                                var area = areaList[i];
                                var newOptionEle = document.createElement("option");
                                newOptionEle.setAttribute("value",area.aid);
                                newOptionEle.innerHTML = area.aname;
                                areaSelectEle.appendChild(newOptionEle);
                            }

                            //var jsonObject = JSON.parse(String)   方法 数组 List Set 对象    Map
                            //var testMap = jsonObject.xxx;
                            //var keys = Object.keys(testMap);//获取testMap全部的key
                            //Object.values(testMap);//全部的value
                            //Object.entries();
                            //  Map<String,Area>
                            //  {{1:{aid:1,aname:东北}},{2:{}}}
                            // for(var i=0;i<keys.length;i++){
                            //     var key = keys[i];
                            //     var value = values[i];
                            //     value.aid;
                            // }
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
                <select id="areaSelect">
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
