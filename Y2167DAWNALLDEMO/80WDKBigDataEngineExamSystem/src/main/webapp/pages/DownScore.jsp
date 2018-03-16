<%--
  Created by IntelliJ IDEA.
  User: Dawn
  Date: 2018/2/2
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>下载成绩</title>
</head>
<body>
    <form action="/RecordScoreServlet" method="post">
        <p style="text-align: center">请输入你要下载的班级编号<input type="text" name="classId"><input type="submit"></p>
    </form>
</body>
</html>
