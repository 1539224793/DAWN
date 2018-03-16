<%--
  Created by IntelliJ IDEA.
  User: Dawn
  Date: 2018/2/1
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>老师录入答案系统</title>
</head>
<body>
<form action="/TrueAnswerServlet" method="post">
    <p style="text-align: center;"><textarea name="answer" style="width: 500px;height: 500px;"></textarea> </p>
    <p style="text-align: center;">请输入这个班级的id(不加SY编号，例：2167)<input type="text" name="classId"></p>
    <p style="text-align: center;"><input type="submit" value="录入正确答案"></p>
</form>
</body>
</html>
