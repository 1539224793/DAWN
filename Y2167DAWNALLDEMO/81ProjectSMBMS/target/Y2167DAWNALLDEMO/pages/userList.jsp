<%@page pageEncoding="utf-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${pager eq null }"><c:redirect url="/UserServlet?oper=pageUser"></c:redirect></c:if>
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
                    <li><a href="providerList.jsp">供应商管理</a></li>
                    <li  id="active"><a href="${pageContext.request.contextPath}/pages/userList.jsp">用户管理</a></li>
                    <li><a href="${pageContext.request.contextPath}/pages/password.jsp">密码修改</a></li>
                    <li><a href="${pageContext.request.contextPath}/pages/login.jsp">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
                <span>用户名：</span>
                <input type="text" placeholder="请输入用户名"/>
                <input type="button" value="查询"/>
                <a href="userAdd.jsp">添加用户</a>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户类型</th>
                    <th width="30%">操作</th>
                </tr>
                <c:if test="${pager!=null}">
                    <c:forEach items="${pager.lists}" var="temp">
                        <tr>
                            <td>${temp.userCode}</td>
                            <td>${temp.userName}</td>
                            <c:if test="${temp.gender==1}">
                                <td>女</td>
                            </c:if>
                            <c:if test="${temp.gender==2}">
                                <td>男</td>
                            </c:if>
                            <td>${temp.age}</td>
                            <td>${temp.phone}</td>
                            <c:if test="${temp.userType==1}">
                                <td>系统管理员</td>
                            </c:if>
                            <c:if test="${temp.userType==2}">
                                <td>经理</td>
                            </c:if>
                            <c:if test="${temp.userType==3}">
                                <td>员工</td>
                            </c:if>
                            <td>
                                <a href="${pageContext.request.contextPath}/pages/userView.jsp"><img src="${pageContext.request.contextPath}/pages/img/read.png" alt="查看" title="查看"/></a>
                                <a href="${pageContext.request.contextPath}/pages/userUpdate.jsp"><img src="${pageContext.request.contextPath}/pages/img/xiugai.png" alt="修改" title="修改"/></a>
                                <a href="#" class="removeUser"><img src="${pageContext.request.contextPath}/pages/img/schu.png" alt="删除" title="删除"/></a>
                            </td>
                        </tr>
                    </c:forEach>

                </c:if>
                
            </table>
            <%@ include file="/pages/pagerBar.jsp" %>
        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

    <footer class="footer">
        版权归北大青鸟
    </footer>

<script src="${pageContext.request.contextPath}/pages/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/pages/js/js.js"></script>
<script src="${pageContext.request.contextPath}/pages/js/time.js"></script>

</body>
</html>