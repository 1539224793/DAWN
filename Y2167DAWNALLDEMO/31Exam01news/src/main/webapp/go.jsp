<%--
  Created by IntelliJ IDEA.
  User: Dawn
  Date: 2018/3/1
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="utf-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:if test="${NewsCount eq null }"><c:redirect url="/NewsServlet?oper=pageNewsG"></c:redirect></c:if>

<html>
<head>
    <title>首页</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script>
        var Pindex=1;
        var zong=${NewsCount/3};

        function shuaxin(Pindex) {
            $.ajax({
                url:"/news/NewsServlet",
                type:"post",
                data:{
                    oper:"pageNews",
                    pageIndex:Pindex
                },
                success:function (jsonstr) {
                    var html=[];
                    html[0]="<tr><td>编号</td><td>标题</td><td>访问次数</td><td>评论数</td></tr>"
                    var json=eval('('+jsonstr+')');
                    $.each(json,function (i, item) {
                        html[i+1]="<tr><td>"+item.newsid+"</td><td><a href='${pageContext.request.contextPath}/NewsServlet?oper=dian&newsid="+item.newsid+"'>"+item.newstitle+"</a></td><td>"+item.clickcount+"</td><td>"+item.talks.length+"</td></tr>"
                    });
                    $("#t1").html(html);
                }
            })
        }

        function add(){
            if(Pindex<zong) {
                Pindex++;
                $("#ye").html(Pindex);
                shuaxin(Pindex);
            }

        }
        function sub() {
            if (Pindex > 1) {
                Pindex--;
                $("#ye").html(Pindex);
                shuaxin(Pindex);

            }
        }

    </script>
</head>
<body>
    <table id="t1" border="1px" style="margin: 0 auto">
        <tr><td>编号</td><td>标题</td><td>访问次数</td><td>评论数</td></tr>
        <c:forEach items="${lists}" var="item">
            <tr><td>${item.newsid}</td><td><a href='${pageContext.request.contextPath}/NewsServlet?oper=dian&newsid=${item.newsid}'>${item.newstitle}</a></td><td>${item.clickcount}</td><td>${item.talks.size()}</td></tr>
        </c:forEach>
    </table>
    <p style="text-align: center"><span id="ye"></span>&nbsp;&nbsp;&nbsp;<a onclick="sub()">上一页</a>  <a onclick="add()">下一页</a></p>

</body>
</html>
