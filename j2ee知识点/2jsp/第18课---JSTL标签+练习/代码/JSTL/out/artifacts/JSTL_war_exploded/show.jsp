<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
    <body>

        <fmt:formatDate value="${requestScope.date}" pattern="yyyy-MM-dd kk:mm:ss"></fmt:formatDate>

        <hr>

        ${fn:length(requestScope.user.uname)}<br>
        ${requestScope.strValue}<br>
        ${fn:length(requestScope.strValue)}<br>
        ${fn:contains(requestScope.strValue,"c")}<br>
        ${fn:indexOf(requestScope.strValue,"c")}<br>
        ${fn:replace(requestScope.strValue,"c","Z")}<br>


        <hr>

        ${requestScope.user}<br>
        ${requestScope.user.uname}---${requestScope.user.upassword}<br>

        <c:out value="${requestScope.user.uname}"></c:out><br>
        duyi is good<br>
        <c:if test="${3>2}">
            满足条件
        </c:if><br>

        <c:choose>
            <c:when test="${requestScope.day == 1}">
                monday
            </c:when>
            <c:when test="${requestScope.day == 2}">
                tuesday
            </c:when>
            <c:when test="${requestScope.day == 3}">
                wednesday
            </c:when>
            <c:otherwise>
                error
            </c:otherwise>
        </c:choose>

        <hr>

        <c:forEach begin="1" end="5" step="1" varStatus="i">
            ${i.index}<br>
        </c:forEach><br>

        <c:forEach var="user" items="${requestScope.userList}">
            ${user.uname}--${user.upassword}<br>
        </c:forEach>

        <hr>

        <c:forTokens var="value" items="${requestScope.str}" delims="-">
            ${value}
        </c:forTokens>



    </body>
</html>
