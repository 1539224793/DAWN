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
        <a href="${pageContext.request.contextPath}/pages/login.jsp">退出</a>
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
                <li><a href="${pageContext.request.contextPath}/pages/billList.jsp">账单管理</a></li>
                <li ><a href="${pageContext.request.contextPath}/pages/providerList.jsp">供应商管理</a></li>
                <li id="active"><a href="${pageContext.request.contextPath}/pages/userList.jsp">用户管理</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/password.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath}/pages/login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="#">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="userId">用户编码：</label>
                    <input type="text" name="userId" id="userId"/>
                    <span>*请输入用户编码，且不能重复</span>
                </div>
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName"/>
                    <span >*请输入用户名称</span>
                </div>
                <div>
                    <label for="userpassword">用户密码：</label>
                    <input type="text" name="userpassword" id="userpassword"/>
                    <span>*密码长度必须大于6位小于20位</span>

                </div>
                <div>
                    <label for="userRemi">确认密码：</label>
                    <input type="text" name="userRemi" id="userRemi"/>
                    <span>*请输入确认密码</span>
                </div>
                <div>
                    <label >用户性别：</label>

                    <select name="">
                        <option value="man">男</option>
                        <option value="woman">女</option>
                    </select>
                    <span></span>
                </div>
                <div>
                    <label for="data">出生日期：</label>
                    <input type="text" name="data" id="data"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="userphone" id="userphone"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="userAddress" id="userAddress"/>
                </div>
                <div>
                    <label >用户类别：</label>
                    <input type="radio" name="userlei"/>管理员
                    <input type="radio" name="userlei"/>经理
                    <input type="radio" name="userlei"/>普通用户

                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.jsp">返回</a>-->
                    <input type="button" value="保存" onclick="history.back(-1)"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
    版权归北大青鸟
</footer>
<script src="${pageContext.request.contextPath}/pages/js/time.js"></script>

</body>
</html>