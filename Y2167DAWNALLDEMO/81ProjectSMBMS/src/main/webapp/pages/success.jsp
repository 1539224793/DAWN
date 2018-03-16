<%@page pageEncoding="utf-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>

<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/pages/css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>超市账单管理系统</h1>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${user.userName}</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath}/UserServlet?oper=cancel">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="${pageContext.request.contextPath}/pages/billList.jsp">账单管理</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/providerList.jsp">供应商管理</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/userList.jsp">用户管理</a></li>
                <li id="active"><a href="${pageContext.request.contextPath}/pages/password.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>成功页面</span>
        </div>
        <div class="providerAdd">
            <h1 style="text-align: center;color: red">成功</h1>
        </div>
    </div>
</section>
<footer class="footer">
    版权归北大青鸟
</footer>
<script src="${pageContext.request.contextPath}/pages/js/time.js"></script>

</body>
</html>