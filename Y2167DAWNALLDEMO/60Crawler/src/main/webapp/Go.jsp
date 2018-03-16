<%--
  Created by IntelliJ IDEA.
  User: Dawn
  Date: 2018/3/9
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        function findbg(){
            var pageIndex=$("#t1").val();
            $.ajax({
                /*/80WDKBigDateEngineExamSystem*/
                url:"${pageContext.request.contextPath}/BgServlet",
                type:"post",
                data:{
                    pageIndex:pageIndex,
                    oper:"find"
                },
                success:function (date) {
                    var html=[];
                    html[0]="<tr><td>博客名称</td><td>博客地址</td></tr>";
                    $.each(eval("("+date+")"), function(i,item){
                        html[i+1]="<tr><td>"+item.bgtitle+"</td><td><a href='"+item.bgpath+"'>"+item.bgpath+"</a></td></tr>";
                    });
                    $("#tableall").html(html);
                }
            })
        }

        function savebg(){
            $.ajax({
                /*/80WDKBigDateEngineExamSystem*/
                url:"${pageContext.request.contextPath}/BgServlet",
                type:"post",
                data:{
                    oper:"save"
                },
                success:function (date) {
                    alert(date)
                }
            })
        }
    </script>
</head>
<body>
    <p style="text-align: center">请输入你想爬下来的博客园推荐博客的页码<input type="text" id="t1"><input type="button" onclick="findbg()" value="开始爬"></p>
    <table id="tableall" border="1px" style="margin: 0 auto"></table>
    <p style="text-align: center"><input type="button" onclick="savebg()" value="保存"></p>
</body>
</html>
