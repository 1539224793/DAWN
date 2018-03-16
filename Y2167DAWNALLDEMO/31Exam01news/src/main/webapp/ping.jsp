<%--
  Created by IntelliJ IDEA.
  User: Dawn
  Date: 2018/3/1
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>内容</title>
</head>
<body>
    <h1 style="text-align: center">${news.newstitle}</h1>
    <p style="text-align: center">${news.newscontent}</p>
    <table style="margin: 0 auto">
        <tr><td>评论</td><td>评论时间</td></tr>
        <c:if test="${news.talks!=null}">
            <c:forEach items="${news.talks}" var="item">
                <tr><td>${item.content}</td><td>${item.ttime}</td></tr>
            </c:forEach>
        </c:if>
    </table>
    <p style="text-align: center">
        <form method="post" action="${pageContext.request.contextPath}/NewsServlet">
            <p style="text-align: center">
                <input type="hidden" name="oper" value="insertPing">
                <input type="hidden" name="nid" value="${news.newsid}">
                <textarea name="content" style="width: 500px;height: 350px"></textarea>
            </p>
            <p style="text-align: center">
                <input type="submit">
            </p>
        </form>
    </p>
</body>
</html>
